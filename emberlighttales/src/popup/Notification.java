package popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class Notification {
    private String message;
    private final int speed = 4;
    private boolean movingIn = true;
    private boolean fadingOut = false;
    private long timerStart;
    private static final long DISPLAY_TIME = 2000; // Notification stays visible for 2 seconds
    private float opacity = 0f; // Opacity for fade effect (0.0 to 1.0)
    private GamePanel gp;

    public Notification(String message, GamePanel gp) {
        this.message = message;
        this.gp = gp;
    }

    public void update() {
        long currentTime = System.currentTimeMillis();
        
        // Fade-in behavior
        if (movingIn) {
            opacity += 0.05f; // Gradually increase opacity
            if (opacity >= 1f) {
                opacity = 1f;
                movingIn = false; // Stop moving in
                timerStart = currentTime; // Start the timer once fully visible
            }
        }
        
        // After 2 seconds, start fading out
        if (!movingIn && !fadingOut && currentTime - timerStart >= DISPLAY_TIME) {
            fadingOut = true;
        }

        // Fade-out behavior
        if (fadingOut) {
            opacity -= 0.05f; // Gradually decrease opacity
            if (opacity <= 0f) {
                opacity = 0f;
            }
        }
    }

    public boolean isExpired() {
        // The notification expires when its opacity is 0 (completely faded out)
        return opacity == 0f;
    }

    public void draw(Graphics2D g2, int screenWidth) {
    	g2.setFont(g2.getFont().deriveFont(Font.BOLD, 13f));
    	
        // Set the composite for opacity only for the popup/notification, not the game world
        if (opacity > 0) {
            g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, opacity));
        }

        // Calculate the width of the text and add padding
        int textWidth = g2.getFontMetrics().stringWidth(message);
        int padding = 20;
        int signWidth = textWidth + (padding * 2);
        int signHeight = 50; // Fixed height for the sign
        int signX = gp.screenWidth - signWidth - padding;
        int signY = padding;

        // Draw the background (subwindow) of the popup/notification with the opacity
        gp.ui.drawSubWindow(signX, signY, signWidth, signHeight);

        // Calculate the position to center the text inside the sign
        int textX = signX + (signWidth - textWidth) / 2;
        int textY = signY + (signHeight + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2;

        // Draw the message text (always white for visibility)
        g2.setColor(Color.WHITE);
        g2.drawString(message, textX, textY + 2);

        // Reset the composite after drawing
        g2.setComposite(java.awt.AlphaComposite.getInstance(java.awt.AlphaComposite.SRC_OVER, 1f));  // Reset to normal
    }
}