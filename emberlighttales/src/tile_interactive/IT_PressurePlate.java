package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.emberlight.GamePanel;

public class IT_PressurePlate extends InteractiveTile{
	
	GamePanel gp;
	public static final String itName = "Pressure Plate";
	public BufferedImage[] animatedFrames = new BufferedImage[59];
	public int animatedPlateCounter = 0;

	public IT_PressurePlate(GamePanel gp, int col, int row) {
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
		
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/dungeon_pressure_plate/plate_on_" + i, 1, 1);
	    }
	}

    public void update() {
        animatedPlateCounter++;
        if(animatedPlateCounter > 3) { // Adjust speed of animation
            if(activated) {
                // Increment until reaching the last frame
                if(spriteNum < animatedFrames.length - 1) {
                    spriteNum++;
                }
            } else {
                // Decrement until reaching the first frame
                if(spriteNum > 0) {
                    spriteNum--;
                }
            }
            animatedPlateCounter = 0;
        }
    }

	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
	    int screenY = worldY - gp.player.worldY + gp.player.screenY + gp.tileSize; //Adjusted for detecting dungeon rock

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



