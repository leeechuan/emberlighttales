package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_CampLookoutTower extends Entity{
	
	GamePanel gp;
	public static final String objName = "Camp Lookout Tower";
	
	public OBJ_CampLookoutTower(GamePanel gp, int tower_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		if(tower_type == 0 || tower_type == 2 || tower_type == 4 || tower_type == 5) {
			image1 = setup("/camp_object/lookout_tower_" + tower_type, 8, 5);
		}
		
		else if(tower_type == 1 || tower_type == 3 || tower_type == 5 || tower_type == 7) {
			image1 = setup("/camp_object/lookout_tower_" + tower_type, 8, 4);
		}

		

		
		if(tower_type == 0 || tower_type == 2 || tower_type == 4 || tower_type == 5) {
			solidArea.x = gp.tileSize*-3/4;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*13/5;
			solidArea.height = gp.tileSize*20/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		else if(tower_type == 1 || tower_type == 3 || tower_type == 5 || tower_type == 7) {
			solidArea.x = gp.tileSize*-3/4;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*13/5;
			solidArea.height = gp.tileSize*20/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
	}

	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		image = image1;
		int screenX = worldX - gp.player.worldX + gp.player.screenX - 2*gp.tileSize;
        int screenY = worldY - gp.player.worldY + gp.player.screenY - 3*gp.tileSize;

        // Optimization for rendering on screen - 5 tileSize buffer
        if (worldX + 5*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 5*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 5*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 5*gp.tileSize < gp.player.worldY + gp.player.screenY) {
        	
            
            g2.drawImage(image, screenX, screenY, null);       	
    
            if(gp.keyH.showDebugText) {
            	//Debug: Entity Collision
            	g2.setColor(Color.red);
            	g2.setStroke(new BasicStroke(1));
            	g2.drawRect(screenX + solidArea.x + 2*gp.tileSize, screenY + solidArea.y + 3*gp.tileSize, solidArea.width, solidArea.height);	
            	g2.setStroke(new BasicStroke());
            }

        }
	}
	
}
