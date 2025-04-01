package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Planter extends InteractiveTile{

	GamePanel gp;
	
	public IT_Planter(GamePanel gp, int col, int row, int planter_type, int planter_design) {
		super(gp, col, row);
		this.gp = gp;
		
		if(planter_type == 0) {
			this.worldX = gp.tileSize * col ;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.75);
			solidArea.y = gp.tileSize/2;
			solidArea.width = (int) (gp.tileSize * 1.5);
			solidArea.height = gp.tileSize/8;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			image1 = setup("/flora/planter_0_" + planter_design, 1, 3);
		}
		else if(planter_type == 1) {
			this.worldX = gp.tileSize * col ;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 1);
			solidArea.y = gp.tileSize/2;
			solidArea.width = (int) (gp.tileSize * 1);
			solidArea.height = gp.tileSize/8;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			image1 = setup("/flora/planter_1_" + planter_design, 1 , 3);
		}
		else if(planter_type == 2){
			this.worldX = gp.tileSize * col ;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.7);
			solidArea.y = gp.tileSize;
			solidArea.width = (int) (gp.tileSize * 1.5);
			solidArea.height = gp.tileSize/8;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			image1 = setup("/flora/planter_2_" + planter_design, 2 , 3);
		}
		else if(planter_type == 3) {
			this.worldX = gp.tileSize * col ;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.9);
			solidArea.y = gp.tileSize;
			solidArea.width = (int) (gp.tileSize * 1);
			solidArea.height = gp.tileSize/8;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			
			image1 = setup("/flora/planter_3_" + planter_design, 2, 3);
		}
		

	}
	
}
