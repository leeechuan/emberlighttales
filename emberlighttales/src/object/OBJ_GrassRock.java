package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_GrassRock extends Entity{
	
	GamePanel gp;
	public static final String objName = "Grass Rock";
	
	public OBJ_GrassRock(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_backdrop;
		name = objName;
		
		
		image1 = setup("/flora/grassrock_" + deco_type, 1, 1);

		
		solidArea.x = gp.tileSize*3/10;
		solidArea.y = gp.tileSize*3/10;
		solidArea.width = gp.tileSize*2/5;
		solidArea.height = gp.tileSize*2/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
		
	}

	
	
}
