package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Palisade extends Entity{
	
	GamePanel gp;
	public static final String objName = "Palisade";
    public int animatedGateCounter = 0;
    public BufferedImage[] openinganimatedFrames = new BufferedImage[4];
	
	public OBJ_Palisade(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		
		
		for (int i = 0; i < openinganimatedFrames.length; i++) {
			openinganimatedFrames[i] = setup("/animated_object/palisade_" + i, 4, 3);
	    }


		collision = true;
		solidArea.x = 0;
		solidArea.y = gp.tileSize*5/4;
		solidArea.width = gp.tileSize * 3;
		solidArea.height = gp.tileSize * 5/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		// Start fully closed (frame 0)
        spriteNum = 0;
	}
	public void interact() {
		
	    if (!isAnimating) {
	        gp.playSE(13);
	        isAnimating = true;
	        animationCounter = 0;
	        
	        // Toggle gate
	        gate_open_state = !gate_open_state;
	        
	        if (gate_open_state) {
	            spriteNum = 0;
	        } else {
	            spriteNum = openinganimatedFrames.length - 1;
	        }
	    }
	}

	public void update() {
        animatedGateCounter++;
        if(animatedGateCounter > 3) {
            if(gate_open_state) {
                if(spriteNum < openinganimatedFrames.length - 1) {
                    spriteNum++;
                }
            }
            else {
                if(spriteNum > 0) {
                    spriteNum--;
                }
            }
            animatedGateCounter = 0;
        }
        if(spriteNum > 2) {
        	collision = false;
        }
        else {
        	collision = true;
        }
        // Reset the animation flag once the animation finishes
        if (gate_open_state && spriteNum == openinganimatedFrames.length - 1) {
            isAnimating = false;
        } else if (!gate_open_state && spriteNum == 0) {
            isAnimating = false;
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
        	
        	
        	image = openinganimatedFrames[spriteNum];
            
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
