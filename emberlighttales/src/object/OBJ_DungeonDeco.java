package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_DungeonDeco extends Entity{
	
	GamePanel gp;
	public static final String objName = "Dungeon Deco";
	
	public OBJ_DungeonDeco(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		
		if(deco_type < 20) {
			image1 = setup("/dungeon_objects/dungeon_deco_" + deco_type, 2, 1);
		}
		else if(deco_type == 20) {
			image1 = setup("/dungeon_objects/dungeon_deco_" + deco_type, 2, 3);
		}
		else if(deco_type == 21) {
			image1 = setup("/dungeon_objects/dungeon_deco_" + deco_type, 1, 2);
		}
		
		
//		Dungeon deco types:
//		0 -> box side
//		1 -> box front
//		2 -> pot
//		3 -> cobweb
//		4 -> cobweb side
//		5 -> grave 1
//		6 -> grave 2
//		7 -> brown pot
//		8 -> pot
//		9 -> big light
//		10 -> medium light
//		11 -> small light
//		12 -> small white dust
//		13 -> 2 small white dust
//		14 -> brown pot
//		15 -> pot
//		16 -> brick
//		17 -> small brick
//		18 -> 2 brick
//		19 -> small box
//		20 -> statue
//		21 -> coffin
		
		

		if(deco_type == 0 || deco_type == 1 || deco_type == 2 || deco_type == 6 || deco_type == 7 || deco_type == 8 || deco_type == 14 || deco_type == 15) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*1/2;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
		if(deco_type == 20) {
			solidArea.x = gp.tileSize*2/10;
			solidArea.y = gp.tileSize*4/5;
			solidArea.width = gp.tileSize;
			solidArea.height = gp.tileSize*3/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

		if(deco_type == 21) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize*2/5;
			solidArea.width = gp.tileSize;
			solidArea.height = gp.tileSize*1/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}
		
		
	}

	
	
}
