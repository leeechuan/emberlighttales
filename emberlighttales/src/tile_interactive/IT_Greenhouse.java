package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Greenhouse extends InteractiveTile{

	GamePanel gp;
	
	public IT_Greenhouse(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 1.2);
		solidArea.y = -(int) (gp.tileSize * 3.5);
		solidArea.width = (int) (gp.tileSize * 4);
		solidArea.height = (int) (gp.tileSize * 4);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 6;
		tileWidth = 6;
		
		image1 = setup("/tiles_interactive/greenhouse", tileHeight + 2 , tileWidth);
	}
	
}
