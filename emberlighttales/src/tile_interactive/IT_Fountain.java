package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Fountain extends InteractiveTile{

	GamePanel gp;
	
	public IT_Fountain(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.5);
		solidArea.y = (int) (gp.tileSize * 0.35);
		solidArea.width = (int) (gp.tileSize * 1);
		solidArea.height = (int) (gp.tileSize * 0.5);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 1;
		tileWidth = 2;
		
		image1 = setup("/tiles_interactive/fountain", tileHeight + 2 , tileWidth);
	}
	
}
