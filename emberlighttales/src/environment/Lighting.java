package environment;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint;
import java.awt.RadialGradientPaint;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import main.emberlight.GamePanel;

public class Lighting {

    GamePanel gp;
    BufferedImage darknessFilter;
    public int dayCounter;
    public float filterAlpha = 0f;

    // Day states
    public final int day = 0;
    public final int dusk = 1;
    public final int night = 2;
    public final int dawn = 3;
    public int dayState = day;
    public float timeOfDay = 8.0f; // Start at 8:00 AM
    public int hours = 6;
    public int minutes = 0;
    public float timeSpeed = 1 / 1200.0f;
    

    public Lighting(GamePanel gp) {
        this.gp = gp;
        gp.ui.lightSources = new ArrayList<>();
        
        gp.ui.initWorldLightSources();

        setLightSource();
    }

    public void setLightSource() {
        // Create a new darkness filter image.
        darknessFilter = new BufferedImage(gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = darknessFilter.createGraphics();

        // Fill the whole screen with darkness.
        if (gp.currentArea == gp.dungeon) {
        	g2.setColor(new Color(0, 0, 0, 0.85f));
        }
        else {
        	 g2.setColor(new Color(0, 0, 0, filterAlpha));
        }
       
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // Use DST_OUT to subtract the light areas from the darkness.
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_OUT, 1f));

        // Draw the player's light, if available.
        if (gp.player.currentLight != null) {
            int playerCenterX = gp.player.screenX + gp.tileSize / 2;
            int playerCenterY = gp.player.screenY + gp.tileSize / 2;
            drawLight(g2, playerCenterX, playerCenterY, gp.player.currentLight.lightRadius);
        }

     // Draw additional light sources managed directly in this class.
        for (LightSource ls : gp.ui.lightSources) {
            // Convert light source's world coordinates to screen coordinates.
            int lightScreenX = ls.x - gp.player.worldX + gp.player.screenX;
            int lightScreenY = ls.y - gp.player.worldY + gp.player.screenY;
            drawLight(g2, lightScreenX, lightScreenY, ls.radius);
        }

        g2.dispose();
    }

    /**
     * Draws a light “hole” using a radial gradient.
     *
     * @param g2      Graphics2D context.
     * @param centerX Center x-coordinate of the light.
     * @param centerY Center y-coordinate of the light.
     * @param radius  Radius of the light.
     */
    private void drawLight(Graphics2D g2, int centerX, int centerY, int radius) {
    	float[] fractions = {
    		    0f, 0.2f, 0.35f, 0.45f, 0.55f, 0.6f, 0.65f, 0.7f, 0.75f, 0.8f, 0.85f, 0.9f, 0.95f, 1f
    		};

    		Color[] colors = {
    		    new Color(0, 0, 0.1f, 0.85f),  // Center: most light
    		    new Color(0, 0, 0.1f, 0.78f),
    		    new Color(0, 0, 0.1f, 0.72f),
    		    new Color(0, 0, 0.1f, 0.65f),
    		    new Color(0, 0, 0.1f, 0.55f),
    		    new Color(0, 0, 0.1f, 0.48f),
    		    new Color(0, 0, 0.1f, 0.41f),
    		    new Color(0, 0, 0.1f, 0.33f),
    		    new Color(0, 0, 0.1f, 0.25f),
    		    new Color(0, 0, 0.1f, 0.18f),
    		    new Color(0, 0, 0.1f, 0.12f),
    		    new Color(0, 0, 0.1f, 0.06f),
    		    new Color(0, 0, 0.1f, 0.02f),
    		    new Color(0, 0, 0.1f, 0f)  // Outer edge: very soft transition to darkness
    		};
        RadialGradientPaint rgp = new RadialGradientPaint(centerX, centerY, radius, fractions, colors, MultipleGradientPaint.CycleMethod.NO_CYCLE);
        g2.setPaint(rgp);
        g2.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    public void resetDay() {
        dayState = day;
        filterAlpha = 0f;
    }

    public void update() {
        // Always update the darkness filter to reflect changes in the camera/player position.
        setLightSource();

        // Advance time
        timeOfDay += timeSpeed;
        
        // Convert timeOfDay to hours and minutes
        hours = (int) timeOfDay;
        minutes = (int) ((timeOfDay - hours) * 60);

        if (timeOfDay >= 24) {
            timeOfDay = 0; // Reset to the beginning of a new day
            hours = 0;
            minutes = 0;
        }

        // Adjust filterAlpha based on the time of day
        if (hours >= 8 && hours < 18) { // Daytime
            dayState = day;
            filterAlpha = 0f;
        } else if (hours >= 18 && hours < 20) { // Dusk
            dayState = dusk;
            filterAlpha = ((hours - 18) * 60 + minutes) / 120.0f * 0.85f; // Gradual increase
        } else if (hours >= 20 || hours < 6) { // Nighttime
            dayState = night;
            filterAlpha = 0.85f;
        } else if (hours >= 6 && hours < 8) { // Dawn
            dayState = dawn;
            filterAlpha = 0.85f - (((hours - 6) * 60 + minutes) / 120.0f * 0.85f); // Gradual decrease
        }
        
    }
    public String getTimeString() {
        return String.format("%02d:%02d", hours, minutes);
    }
    private String getDayStateString() {
        switch (dayState) {
            case day: return "Day";
            case dusk: return "Dusk";
            case night: return "Night";
            case dawn: return "Dawn";
            default: return "";
        }
    }
    public void draw(Graphics2D g2) {
        if (gp.currentArea == gp.outside) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, filterAlpha));
        }
        if (gp.currentArea == gp.outside || gp.currentArea == gp.dungeon) {
            g2.drawImage(darknessFilter, 0, 0, null);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        
     // Define UI position (bottom-right, less intrusive)
        int x = gp.screenWidth - gp.tileSize * 7/2;
        int y = gp.screenHeight - gp.tileSize * 3/2;

        // Semi-transparent background strip
        g2.setColor(new Color(55, 35, 20, 210)); 
        g2.fillRoundRect(x - 20, y - 40, 120, 60, 20, 20); 

        // Text styling
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16f));

        // Shadow effect for better contrast
        g2.setColor(new Color(0, 0, 0, 150));
        g2.drawString(getTimeString(), x + 2, y + 2);
//        g2.drawString(getDayStateString(), x + 2, y + 25);

        // Main text color (soft beige)
        g2.setColor(new Color(230, 215, 190));
        g2.drawString(getTimeString(), x, y);
//        g2.drawString(getDayStateString(), x, y + 25);
        
    }
}