package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import main.emberlight.GamePanel;

public class SmokeParticle extends Particle {
    private static Random rand = new Random();

    // Constructor tailored for smoke particles
    public SmokeParticle(GamePanel gp, Entity generator) {

        super(gp, 
              generator, 
              new Color(rand.nextInt(61) + 140, rand.nextInt(61) + 140, rand.nextInt(61) + 140, 255),  // Randomized gray
              rand.nextInt(45) + 5,  			
              rand.nextInt(3) + 1,             	
              100,                             	
              rand.nextInt(5) - 2,             	
              rand.nextInt(3) - 1);            	
    }
    @Override
    public void update() {
        // Call the base update (which decrements life and moves the particle)
        super.update();
        
        if(life < maxLife) {
            // Calculate new alpha based on remaining life
            int newAlpha = (int)(255 * (life / (float)maxLife));
            // Create a new color with the updated alpha while keeping the same RGB values
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), newAlpha);
        }
    }
    
    @Override
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        g2.setColor(color);
        g2.fillOval(screenX, screenY, size, size);
    }
}



