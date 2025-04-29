package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Log extends Entity{
	
	GamePanel gp;
	public static final String objName = "Log";
	
	public OBJ_Log(GamePanel gp, int deco_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		
		image1 = setup("/flora/log_" + deco_type, 1, 2);

		
		solidArea.x = gp.tileSize*3/10;
		solidArea.y = gp.tileSize*6/10;
		solidArea.width = gp.tileSize*3/5;
		solidArea.height = gp.tileSize*1/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;
		
	}

	
	
}
