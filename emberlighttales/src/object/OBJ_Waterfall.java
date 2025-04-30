package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Waterfall extends Entity{
	
	GamePanel gp;
    public BufferedImage[] animatedFrames = new BufferedImage[16];
    public int animatedWaterfallCounter = 0;
	public static final String objName = "Waterfall";
	
	public OBJ_Waterfall(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/waterfall/waterfall_" + i, 4, 3);
	    }
		collision = true;
		
		
	}
	public void update() {
        animatedWaterfallCounter++;
        
        if (animatedWaterfallCounter > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedWaterfallCounter = 0;
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
