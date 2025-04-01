package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Spike_Gate extends Entity{
	
	GamePanel gp;
    public BufferedImage[] openinganimatedFrames = new BufferedImage[49];
    public int animatedGateCounter = 0;
	public static final String objName = "Spike Gate";
	
	public OBJ_Spike_Gate(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		for (int i = 0; i < openinganimatedFrames.length; i++) {
			openinganimatedFrames[i] = setup("/dungeon_spike_gate/gate_open_" + i, 2, 2);
	    }
		solidArea.x = 0;
		solidArea.y = gp.tileSize*4/5;
		solidArea.width = gp.tileSize*2;
		solidArea.height = gp.tileSize*3/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
		
		// Start fully closed (frame 0)
        spriteNum = 0;
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
        if(spriteNum > 40) {
        	collision = false;
        }
        else {
        	collision = true;
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
