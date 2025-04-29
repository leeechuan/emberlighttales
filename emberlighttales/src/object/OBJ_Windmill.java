package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Windmill extends Entity{
	
	GamePanel gp;
    public BufferedImage[] animatedFrames = new BufferedImage[4];
    public int animatedCounter = 0;
	public static final String objName = "Windmill";
	
	public OBJ_Windmill(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		for (int i = 0; i < animatedFrames.length; i++) {
			animatedFrames[i] = setup("/animated_object/windmill_" + i, 7, 4);
	    }
		collision = true;
		solidArea.x = (int) (gp.tileSize * 0.75);
		solidArea.y = (int) (gp.tileSize * 1.5);
		solidArea.width = gp.tileSize*12/5;
		solidArea.height = gp.tileSize*9/2;
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

        // Optimization for rendering on screen - 7 tileSize buffer
        if (worldX + 7*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 7*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 7*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 7*gp.tileSize < gp.player.worldY + gp.player.screenY) {
        	
        	
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
