package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import main.emberlight.GamePanel;

public class ParticleMovement extends Particle {
    private static Random rand = new Random();
    private static int gray = 200 + rand.nextInt(56);
    
    public ParticleMovement(GamePanel gp, Entity generator) {



        super(gp, 
              generator, 
              new Color(gray, gray, gray, 180),
              rand.nextInt(8) + 8,  // size
              1,                    // speed
              40,                   // lifespan
              rand.nextInt(3) - 1,  // slight horizontal drift
              1);                   // fixed gentle downward drift   	
        this.worldY += gp.tileSize / 4; // to put at feet
    }
    @Override
    public void update() {
        // Basic constant movement (no gravity effect)
        worldX += xd * speed;
        worldY += yd * speed;

        life--;
        if (life <= 0) {
            alive = false;
        }

        // Fade out as it ages
        int alpha = (int)(255 * (life / (float)maxLife));
        alpha = Math.max(alpha, 0); // avoid negatives
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }
    
    @Override
    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2.setColor(color);
        g2.fillOval(screenX, screenY, size, size);
    }
}



