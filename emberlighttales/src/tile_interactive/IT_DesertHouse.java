package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_DesertHouse extends InteractiveTile{

	GamePanel gp;
	
	public IT_DesertHouse(GamePanel gp, int col, int row, int house_type, int house_color) {
		super(gp, col, row);
		this.gp = gp;
		
		//House type:
		//1 -> Small House
		//2 -> Large House
		//3 -> Large House (Inverted)
		//4 -> Medium House
		
		//House color:
		//1 -> Default wood
		//2 -> Red wood
		//3 -> Blue wood
		//4 -> Default stone
		//5 -> Red stone
		//6 -> Blue stone
		//7 -> Yellow wood (only for small and medium house)
		//8 -> Yellow stone (only for small and medium house)

		if(house_type == 0) {
			this.worldX = gp.tileSize * col - 10;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.75);
			solidArea.y = -gp.tileSize * 1;
			solidArea.width = (int) (gp.tileSize * 3.5);
			solidArea.height = gp.tileSize * 2;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 3;
			tileWidth = 5;
			
			image1 = setup("/desert_objects/house_0_" + house_color, tileHeight + 2, tileWidth);
		}
		else if(house_type == 1) {
			this.worldX = gp.tileSize * col - 10;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 0.8);
			solidArea.y = -(int) (gp.tileSize * 1.25);
			solidArea.width = (int) (gp.tileSize * 4.5);
			solidArea.height = (int) (gp.tileSize * 2.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 6;
			tileWidth = 6;
			
			image1 = setup("/desert_objects/house_1_" + house_color, tileHeight + 2 , tileWidth);
		}
		else if(house_type == 2){
			this.worldX = gp.tileSize * col - 10;
			this.worldY = gp.tileSize * row;
			solidArea.x = (int) (gp.tileSize * 1.2);
			solidArea.y = -(int) (gp.tileSize * 1.25);
			solidArea.width = (int) (gp.tileSize * 6);
			solidArea.height = (int) (gp.tileSize * 2.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 5;
			tileWidth = 8;
			
			image1 = setup("/desert_objects/house_2_" + house_color, tileHeight + 2 , tileWidth);
		}
		else if(house_type == 3) {
			this.worldX = gp.tileSize * col - 20;
			this.worldY = gp.tileSize * row - 20;
			solidArea.x = (int) (gp.tileSize * 1.2);
			solidArea.y = (int) (-gp.tileSize * 1.25);
			solidArea.width = (int) (gp.tileSize * 6);
			solidArea.height = gp.tileSize * 2;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 6;
			tileWidth = 9;
			
			image1 = setup("/desert_objects/house_3_" + house_color, tileHeight + 2, tileWidth);
		}
	}
	
}
