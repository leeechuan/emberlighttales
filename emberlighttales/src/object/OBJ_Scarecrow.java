package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Scarecrow extends Entity{
	
	GamePanel gp;
    private BufferedImage[] animatedFrames = new BufferedImage[8];
    private int animatedCounter = 0;
	public static final String objName = "Scarecrow";
	
	public OBJ_Scarecrow(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/animated_object/scarecrow_" + i, 3, 2);
	    }
		solidArea.x = (int) (gp.tileSize * 0.9);
		solidArea.y = (int) (gp.tileSize * 1.7);
		solidArea.width = gp.tileSize*1/5;
		solidArea.height = gp.tileSize*3/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
		
		
	}
	public void update() {
		animatedCounter++;
        
        if (animatedCounter > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedCounter = 0;
        }
    }
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Optimization for rendering on screen - 5 tileSize buffer
        if (worldX + 5*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 5*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 5*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 5*gp.tileSize < gp.player.worldY + gp.player.screenY) {
        	
        	
        	image = animatedFrames[spriteNum];
            
            g2.drawImage(image, screenX, screenY, null);       	
          
            if(gp.keyH.showDebugText) {
                //Debug: Entity Collision
                g2.setColor(Color.red);
                g2.setStroke(new BasicStroke(1));
                g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);	
                g2.setStroke(new BasicStroke());
            }
        }
	}
	
	
}
