package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Abandon_House_1 extends InteractiveTile{

	GamePanel gp;
	
	public IT_Abandon_House_1(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.75);
		solidArea.y = -(int) (gp.tileSize * 1.25);
		solidArea.width = (int) (gp.tileSize * 3.75);
		solidArea.height = (int) (gp.tileSize * 2.25);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 5;
		tileWidth = 8;
		
		image1 = setup("/tiles_interactive/abandon_house_1", tileHeight + 2 , tileWidth);
	}
	
}
