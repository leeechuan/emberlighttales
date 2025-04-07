package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Boat extends Entity{
	
	GamePanel gp;
	public BufferedImage[] animatedFrames = new BufferedImage[4];
	public int animatedCounter = 0;
	public static final String objName = "Boat";
	
	public OBJ_Boat(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/animated_object/boat_" + i, 3, 3);
	    }
		
		collision = true;
		solidArea.x = 0;
		solidArea.y = gp.tileSize;
		solidArea.width = gp.tileSize*3;
		solidArea.height = gp.tileSize*2;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	public void update() {
		animatedCounter++;
        
        if (animatedCounter > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedCounter = 0;
        }
    }
    public void setDialogue() {
		dialogues[0][0] = "You close your eyes as the boat slowly\ndrifts away from shore.\n[Progress has been saved]";
    }
	public void interact() {
		setDialogue();
		startDialogue(this, 0);
		gp.eHandler.sleep();
		if(gp.currentMap == 0) {
			gp.eHandler.teleport(19, 71, 69, gp.outside);
		}
		else if(gp.currentMap == 19) {
			gp.eHandler.teleport(0, 12, 26, gp.outside);
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
