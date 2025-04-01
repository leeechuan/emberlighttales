package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Bench extends Entity{
	
	GamePanel gp;
	public static final String objName = "Bench";
	
	public OBJ_Bench(GamePanel gp, int bench_type) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;

			image1 = setup("/decoration/bench_" + bench_type, 2 , 2);
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize*2/5;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*1/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;

	}

}
