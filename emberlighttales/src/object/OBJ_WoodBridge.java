package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_WoodBridge extends Entity{
	
	GamePanel gp;
	public static final String objName = "Wood Bridge";
	
	public OBJ_WoodBridge(GamePanel gp) {
	    
	    super(gp);
	    this.gp = gp;
	    
	    type = type_obstacle;
	    name = objName;

	    image1 = setup("/decoration/woodbridge", 3, 3);
		solidArea.x = gp.tileSize*0;
		solidArea.y = gp.tileSize*0;
		solidArea.width = gp.tileSize*0;
		solidArea.height = gp.tileSize*0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;

	}

}
