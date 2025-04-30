package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Desert_Temple extends InteractiveTile{

	GamePanel gp;
	
	public IT_Desert_Temple(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = gp.tileSize*2/5;
		solidArea.y = -gp.tileSize*12/5;
		solidArea.width = gp.tileSize*35/5;
		solidArea.height = gp.tileSize*18/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 6;
		tileWidth = 8;
		
		image1 = setup("/desert_objects/Desert_Temple", tileHeight + 2 , tileWidth);
		
	}
	
}
