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
		
		type = type_obstacle;
		name = objName;
		image1 = setup("/dungeon_objects/dungeon_deco_" + deco_type, 2, 1);

		if(deco_type == 0 || deco_type == 1 || deco_type == 2 || deco_type == 6 || deco_type == 7) {
			solidArea.x = gp.tileSize*3/10;
			solidArea.y = gp.tileSize;
			solidArea.width = gp.tileSize*2/5;
			solidArea.height = gp.tileSize*2/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

		
		
	}

	
	
}
