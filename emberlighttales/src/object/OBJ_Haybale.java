package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Haybale extends Entity{
	
	GamePanel gp;
	public static final String objName = "Haybale";
	
	public OBJ_Haybale(GamePanel gp, int haybale_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		
		if(haybale_type == 0) {
			image1 = setup("/decoration/haybale_0", 1 , 1);
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize*4/5;
			solidArea.width = gp.tileSize*1/5;
			solidArea.height = gp.tileSize*1/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
			
			
			
		}
		else if (haybale_type == 1) {
			image1 = setup("/decoration/haybale_1", 1 , 2);
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*1/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

	}

}
