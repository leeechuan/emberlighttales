package tile_interactive;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class InteractiveTile extends Entity{

	GamePanel gp;
	public boolean destructible = false;
	public boolean activated = false;
	public int tileWidth;
	public int tileHeight;
	
	public InteractiveTile(GamePanel gp, int col, int row) {
		super(gp);
		this.gp = gp;
	}
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		return isCorrectItem;
	}
	public void playSE() {
		
	}
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = null;
		return tile;
	}
	public void update() {
		
		if(invincible == true) {
			invincibleCounter++;
			if(invincibleCounter > 20) {
				invincible = false;
				invincibleCounter = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2) {
		

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Optimization for rendering on screen - 7 tileSize buffer
        if (worldX + 8*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 8*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 8*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 8*gp.tileSize < gp.player.worldY + gp.player.screenY) {
		
        	g2.drawImage(image1, screenX, screenY - (gp.tileSize * tileHeight), null);
        }
        
        if(gp.keyH.showDebugText) {
        	//Debug: Entity Collision
	        g2.setColor(Color.red);
	        g2.setStroke(new BasicStroke(1));
	        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);	
	        g2.setStroke(new BasicStroke());
        }
	}

}
