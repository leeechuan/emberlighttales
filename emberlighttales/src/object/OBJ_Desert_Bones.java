package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Desert_Bones extends Entity{
	
	GamePanel gp;
	public static final String objName = "Desert Bones";
	
	public OBJ_Desert_Bones(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		if(deco_type == 0) {
			image1 = setup("/desert_objects/desert_bones_" + deco_type, 3, 4);
		}
		
		else if(deco_type == 1) {
			image1 = setup("/desert_objects/desert_bones_" + deco_type, 3, 3);
		}
		
		else if(deco_type == 2) {
			image1 = setup("/desert_objects/desert_bones_" + deco_type, 3, 6);
		}

		if(deco_type == 0) {
			solidArea.x = gp.tileSize*14/10;
			solidArea.y = gp.tileSize*14/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

		if(deco_type == 1) {
			solidArea.x = gp.tileSize*12/10;
			solidArea.y = gp.tileSize*10/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
	}

	
	
}
