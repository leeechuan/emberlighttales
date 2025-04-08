package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_CampDeco extends Entity{
	
	GamePanel gp;
	public static final String objName = "Camp Deco";
	
	public OBJ_CampDeco(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		if(deco_type == 0) {
			image1 = setup("/camp_object/archery_target", 2, 2);
		}
		
		else if(deco_type == 1) {
			image1 = setup("/camp_object/barrier_horizontal", 3, 2);
		}
		else if(deco_type == 2) {
			image1 = setup("/camp_object/barrier_vertical", 3, 2);
		}
		else if(deco_type == 3) {
			image1 = setup("/camp_object/cannon_0", 2, 2);
		}
		else if(deco_type == 4) {
			image1 = setup("/camp_object/cannon_1", 2, 2);
		}
		else if(deco_type == 5) {
			image1 = setup("/camp_object/catapult_0", 3, 3);
		}
		else if(deco_type == 6) {
			image1 = setup("/camp_object/catapult_1", 3, 3);
		}
		else if(deco_type == 7) {
			image1 = setup("/camp_object/manlet_0", 3, 2);
		}
		else if(deco_type == 8) {
			image1 = setup("/camp_object/manlet_1", 3, 2);
		}
		else if(deco_type == 9) {
			image1 = setup("/camp_object/manlet_2", 3, 2);
		}
		else if(deco_type == 10) {
			image1 = setup("/camp_object/manlet_3", 3, 2);
		}
		else if(deco_type == 11) {
			image1 = setup("/camp_object/training_dummy_0", 3, 2);
		}
		else if(deco_type == 12) {
			image1 = setup("/camp_object/training_dummy_1", 3, 2);
		}
		else if(deco_type > 12) {
			image1 = setup("/camp_object/weapon_stand_" + (deco_type - 13), 2, 2);
		}
		
		
//		Dungeon deco types:
//		0 -> archery target
//		1 -> barrier horizontal
//		2 -> barrier vertical
//		3 -> cannon horizontal
//		4 -> cannon vertical
//		5 -> catapult horizontal
//		6 -> cataput vertical
//		7 -> manlet diagonal
//		8 -> manlet 2 diagonal
//		9 -> manlet forward
//		10 -> manlet 2 forward
//		11 -> training dummy 1
//		12 -> training dummy 2
//		13 -> weapon stand 0
//		14 -> weapon stand 1
//		15 -> weapon stand 2
//		16 -> weapon stand 3
//		17 -> weapon stand 4
//		18 -> weapon stand 5
//		19 -> weapon stand 6
//		20 -> weapon stand 7
//		21 -> weapon stand 8
		
		if(deco_type == 0) {
			solidArea.x = gp.tileSize*1/4;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*5/5;
			solidArea.height = gp.tileSize*4/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 1) {
			solidArea.x = gp.tileSize*0/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*8/5;
			solidArea.height = gp.tileSize*4/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 2) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*5/5;
			solidArea.height = gp.tileSize*6/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 3) {
			solidArea.x = gp.tileSize*0/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*8/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 4) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*5/5;
			solidArea.height = gp.tileSize*6/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 5) {
			solidArea.x = gp.tileSize*-2/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*11/5;
			solidArea.height = gp.tileSize*4/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 6) {
			solidArea.x = gp.tileSize*1/10;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*7/5;
			solidArea.height = gp.tileSize*6/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 7 || deco_type == 8) {
			solidArea.x = gp.tileSize*2/10;
			solidArea.y = gp.tileSize*1/10;
			solidArea.width = gp.tileSize*5/5;
			solidArea.height = gp.tileSize*6/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 9 || deco_type == 10) {
			solidArea.x = gp.tileSize*4/10;
			solidArea.y = gp.tileSize*6/10;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*4/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type == 11 || deco_type == 12) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*5/10;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*5/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		if(deco_type > 12) {
			solidArea.x = gp.tileSize*0/10;
			solidArea.y = gp.tileSize*7/10;
			solidArea.width = gp.tileSize*7/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

		
	}

	
	
}
