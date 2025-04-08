package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Tent extends InteractiveTile{

	GamePanel gp;
	
	public IT_Tent(GamePanel gp, int col, int row, int tent_color, int tent_type) {
		super(gp, col, row);
		this.gp = gp;
		
		//Type:
		//0 -> Armory
		//1 -> Medical
		//2 -> General
		//3 -> Small
		
		//Color:
		//0 -> Beige
		//1 -> Blue
		//2 -> Green
		//3 -> Red
		//4 -> Yellow

		if(tent_type == 0 || tent_type == 1 || tent_type == 2) {
			this.worldX = gp.tileSize * col;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.75);
			solidArea.y = -gp.tileSize * 2;
			solidArea.width = (int) (gp.tileSize * 3.5);
			solidArea.height = (int) (gp.tileSize * 2.5);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 4;
			tileWidth = 5;
			
			image1 = setup("/camp_object/tent_" + tent_color + "_" + tent_type, tileHeight + 2, tileWidth);
		}
		else if(tent_type == 3) {
			this.worldX = gp.tileSize * col;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.8);
			solidArea.y = -(int) (gp.tileSize * 1.25);
			solidArea.width = (int) (gp.tileSize * 2.3);
			solidArea.height = (int) (gp.tileSize * 1.5);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 4;
			tileWidth = 4;
			
			image1 = setup("/camp_object/tent_" + tent_color + "_" + tent_type, tileHeight + 2 , tileWidth);
		}
	}
	
}
