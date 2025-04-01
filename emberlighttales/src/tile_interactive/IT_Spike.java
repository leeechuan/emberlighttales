package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.emberlight.GamePanel;

public class IT_Spike extends InteractiveTile{
	
	GamePanel gp;
	public static final String itName = "Spike";
	public BufferedImage[] animatedFrames = new BufferedImage[8];
	public int animatedCounter = 0;

	public IT_Spike(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		name = itName;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = false;
		
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/dungeon_spike/spike_" + i, 1, 1);
	    }
		
		activated = true;
	}

    public void update() {

		animatedCounter++;
        
        if (animatedCounter > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedCounter = 0;
        }

        // Damage player if they touch the spike in dangerous frames
        if (spriteNum >= 4 && spriteNum <= 6) {
        	
        	int playerCenterX = gp.player.worldX + gp.tileSize / 2;
        	int playerCenterY = gp.player.worldY + gp.tileSize / 2;
            if (playerCenterX >= worldX && playerCenterX < worldX + gp.tileSize &&
            	    playerCenterY >= worldY + gp.tileSize && playerCenterY < worldY + gp.tileSize*2) { //Adjusted;
        		if(gp.player.invincible == false) {
        			gp.playSE(3);
        			gp.player.life -= 1;
    				gp.player.transparent = true;
        			gp.player.invincible = true;
        		}
            }
        }
    }

	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
	    int screenY = worldY - gp.player.worldY + gp.player.screenY + gp.tileSize; //Adjusted;

	    // Optimization for rendering on screen - 5 tileSize buffer
	    if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
	    	
	    	
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



