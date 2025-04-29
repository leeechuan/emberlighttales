package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Grass extends Entity{
	
	GamePanel gp;
    public BufferedImage[] animatedFrames = new BufferedImage[8];
    public int animatedFlower = 0;
	public static final String objName = "Grass";
	
	public OBJ_Grass(GamePanel gp, int grassType) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		for (int i = 0; i < animatedFrames.length; i++) {
	        animatedFrames[i] = setup("/flora/grass_" + grassType + "_" + i, 1, 1);
	    }
		collision = false;
		
		
	}
	public void update() {
        animatedFlower++;

        if (animatedFlower > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedFlower = 0;
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

        }
	}
	
	
}
