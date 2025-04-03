package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_BridgeRubble extends Entity{
	
	GamePanel gp;
	public static final String objName = "Bridge Rubble";
	
	public OBJ_BridgeRubble(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		image1 = setup("/decoration/bridge_rubble", 6 , 6);
		solidArea.x = -gp.tileSize;
		solidArea.y = 0;
		solidArea.width = gp.tileSize*4;
		solidArea.height = gp.tileSize*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;

	}
	
	public void update() {
		if (Progress.gameStage > Progress.STAGE_TRANSFORMATION) {
			collision = false;
			solidArea.width = 0;
			solidArea.height = 0;
			image1 = null;
		}
	}
}
