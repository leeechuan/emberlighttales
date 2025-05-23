package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_WoodCaveEntrance extends InteractiveTile{

	GamePanel gp;
	
	public IT_WoodCaveEntrance(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
//		solidArea.x = (int) (gp.tileSize * 0.75);
//		solidArea.y = -gp.tileSize * 3;
//		solidArea.width = (int) (gp.tileSize * 3);
//		solidArea.height = gp.tileSize * 3;
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
//		tileHeight = 5;
//		tileWidth = 5;
		solidArea.width = (gp.tileSize * 3);
		solidArea.height = (int)(gp.tileSize * 1.3);
		
		image1 = setup("/tiles_interactive/wood_cave_entrance", 3, 3);
	}
	
}
