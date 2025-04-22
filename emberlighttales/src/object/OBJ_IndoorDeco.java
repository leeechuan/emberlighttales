package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_IndoorDeco extends Entity{
	
	GamePanel gp;
	public static final String objName = "Indoor Deco";
	
	public OBJ_IndoorDeco(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		if(deco_type == 0) {
			image1 = setup("/interior_decor/beerkeg", 2, 1);
		}
		else if(deco_type == 1) {
			image1 = setup("/interior_decor/bookshelf", 2, 1);
		}
		else if(deco_type == 2) {
			image1 = setup("/interior_decor/chair_back", 2, 1);
		}
		else if(deco_type == 3) {
			image1 = setup("/interior_decor/chair_front", 2, 1);
		}
		else if(deco_type == 4) {
			image1 = setup("/interior_decor/chair_left", 2, 1);
		}
		else if(deco_type == 5) {
			image1 = setup("/interior_decor/chair_right", 2, 1);
		} 
		else if(deco_type == 6) {
			image1 = setup("/interior_decor/furance", 2, 1);
		}
		else if(deco_type == 7) {
			image1 = setup("/interior_decor/painting", 1, 1);
		}
		else if(deco_type == 8) {
			image1 = setup("/interior_decor/potted_plant_1", 2, 1);
		}
		else if(deco_type == 9) {
			image1 = setup("/interior_decor/potted_plant_2", 2, 1);
		} 
		else if(deco_type == 10) {
			image1 = setup("/interior_decor/potted_plant_3", 2, 1);
		} 
		else if(deco_type == 11) {
			image1 = setup("/interior_decor/potted_plant_4", 2, 1);
		}
		else if(deco_type == 12) {
			image1 = setup("/interior_decor/potted_plant_5", 2, 1);
		}
		else if(deco_type == 13) {
			image1 = setup("/interior_decor/potted_plant_6", 2, 1);
		}
		else if(deco_type == 14) {
			image1 = setup("/interior_decor/potted_plant_7", 2, 1);
		} 
		else if(deco_type == 15) {
			image1 = setup("/interior_decor/table", 2, 1);
		}
		else if(deco_type == 16) {
			image1 = setup("/interior_decor/table_side", 1, 2);
		}
		else if(deco_type == 17) {
			image1 = setup("/interior_decor/table2", 2, 1);
		}
		else if(deco_type == 18) {
			image1 = setup("/interior_decor/table2_side", 1, 2);
		} 
		
		
//		Indoor deco types:
//		0 -> beerkeg
//		1 -> bookshelf
//		2 -> chair back
//		3 -> chair front
//		4 -> chair left
//		5 -> chair right
//		6 -> furance
//		7 -> painting
//		8 -> potted plant 1
//		9 -> potted plant 2
//		10 -> potted plant 3
//		11 -> potted plant 4
//		12 -> potted plant 5
//		13 -> potted plant 6
//		14 -> potted plant 7
//		15 -> table
//		16 -> table side
//		17 -> table2
//		18 -> table2 side
		
		

		if(deco_type == 0 || deco_type == 1) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*3/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*1;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
		if(deco_type == 2 || deco_type == 3 || deco_type == 4 || deco_type == 5) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*7/10;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 8 || deco_type == 9 || deco_type == 10 || deco_type == 11 || deco_type == 12 || deco_type == 13 || deco_type == 14) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*1/2;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
		if(deco_type == 15 || deco_type == 17 ) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*3/10;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*6/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
		if(deco_type == 16 || deco_type == 18 ) {
			solidArea.x = 0;
			solidArea.y = gp.tileSize*5/10;
			solidArea.width = gp.tileSize*8/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
//		if(deco_type == 20) {
//			solidArea.x = gp.tileSize*2/10;
//			solidArea.y = gp.tileSize*4/5;
//			solidArea.width = gp.tileSize;
//			solidArea.height = gp.tileSize*3/5;
//			solidAreaDefaultX = solidArea.x;
//			solidAreaDefaultY = solidArea.y;
//			collision = true;
//		}
//
//		if(deco_type == 21) {
//			solidArea.x = gp.tileSize*3/10;
//			solidArea.y = gp.tileSize*2/5;
//			solidArea.width = gp.tileSize;
//			solidArea.height = gp.tileSize*1/5;
//			solidAreaDefaultX = solidArea.x;
//			solidAreaDefaultY = solidArea.y;
//			collision = true;
//		}
//		
		
	}

	
	
}
