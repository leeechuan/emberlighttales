package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Well extends Entity{
	
	GamePanel gp;
	public static final String objName = "Well";
	
	public OBJ_Well(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;

			image1 = setup("/decoration/well", 3 , 2);
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize*4/5;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*3/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;

	}

}

