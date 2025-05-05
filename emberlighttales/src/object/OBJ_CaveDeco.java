package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_CaveDeco extends Entity{
	
	GamePanel gp;
	public static final String objName = "Cave Deco";
	
	public OBJ_CaveDeco(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		
		image1 = setup("/cave_objects/cave_deco_" + deco_type, 1, 1);
		
		solidArea.x = gp.tileSize*4/10;
		solidArea.y = gp.tileSize/4;
		solidArea.width = gp.tileSize*1/5;
		solidArea.height = gp.tileSize*1/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
		
		
	}

	
	
}
