package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Barn extends InteractiveTile{

	GamePanel gp;
	
	public IT_Barn(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.8);
		solidArea.y = -(int) (gp.tileSize * 1);
		solidArea.width = (int) (gp.tileSize * 7.4);
		solidArea.height = (int) (gp.tileSize * 2);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 6;
		tileWidth = 9;
		
		image1 = setup("/tiles_interactive/barn", tileHeight + 2 , tileWidth);
	}
	
}
