package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_FenceGate extends Entity{
	
	GamePanel gp;
	public static final String objName = "Fence Gate";
    public int animatedGateCounter = 0;
    public BufferedImage[] openinganimatedFrames = new BufferedImage[5];
	
	public OBJ_FenceGate(GamePanel gp, boolean isTop) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		if(isTop) {
			for (int i = 0; i < openinganimatedFrames.length; i++) {
				openinganimatedFrames[i] = setup("/animated_object/fence_topgate_" + i, 2, 3);
		    }
		}
		else {
			for (int i = 0; i < openinganimatedFrames.length; i++) {
				openinganimatedFrames[i] = setup("/animated_object/fence_bottomgate_" + i, 2, 3);
		    }
		}

		collision = true;
		solidArea.x = 0;
		solidArea.y = gp.tileSize*5/4;
		solidArea.width = gp.tileSize * 3;
		solidArea.height = gp.tileSize/2;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		// Start fully closed (frame 0)
        spriteNum = 0;
	}
    public void setDialogue() {
		dialogues[0][0] = "Hmmm... I should warm up before\nheading out...";
    }
	public void interact() {
		
		if (gp.csManager.sceneNum == gp.csManager.tutorial && !gate_open_state && !(gp.csManager.scenePhase == 12)) {
			setDialogue();
			startDialogue(this, 0);
	        return; // No open of gate during tutorial until end
	    }
		
	    if (!isAnimating) { // Only start animation if not already animating
	        gp.playSE(13);
	        isAnimating = true;
	        animationCounter = 0;
	        
	        // Toggle the gate state
	        gate_open_state = !gate_open_state;
	        
	        // If we're opening, start from frame 0; if closing, start from the final frame.
	        if (gate_open_state) {
	            spriteNum = 0;  // Opening animation starts at frame 0
	        } else {
	            spriteNum = openinganimatedFrames.length - 1;  // Closing animation starts at fully open frame
	        }
	    }
	}

	public void update() {
        animatedGateCounter++;
        if(animatedGateCounter > 3) {  // Adjust speed of animation
            // When the gate should be open, play the opening animation
            if(gate_open_state) {
                if(spriteNum < openinganimatedFrames.length - 1) {
                    spriteNum++;
                }
            }
            // When the gate should be closed, play the closing animation in reverse
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
