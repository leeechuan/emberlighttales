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
	
	public OBJ_WoodBridge(GamePanel gp, boolean rotate) {
	    
	    super(gp);
	    this.gp = gp;
	    
	    type = type_obstacle;
	    name = objName;

	    
	    if (rotate) {
	    	image1 = setup("/dungeon_objects/wood_bridge_0", 1, 5);
	    } else {
	    	image1 = setup("/dungeon_objects/wood_bridge_1", 5, 1);
	    }
	    
	    collision = false;
	}

}
