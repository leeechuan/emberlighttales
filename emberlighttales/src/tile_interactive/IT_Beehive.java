package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Beehive extends InteractiveTile{

	GamePanel gp;
	
	public IT_Beehive(GamePanel gp, int col, int row, int beehive_type) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.75);
		solidArea.y = (int) (gp.tileSize * 0.75);
		solidArea.width = (int) (gp.tileSize * 0.5);
		solidArea.height = (int) (gp.tileSize * 0.5);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 0;
		tileWidth = 2;
		
		image1 = setup("/tiles_interactive/beehive_" + beehive_type, (tileHeight + 2) , tileWidth);
	}
	
}
