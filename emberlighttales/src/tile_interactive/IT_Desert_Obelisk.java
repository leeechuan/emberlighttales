package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_Desert_Obelisk extends InteractiveTile{

	GamePanel gp;
	
	public IT_Desert_Obelisk(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = gp.tileSize*3/5;
		solidArea.y = -gp.tileSize*7/5;
		solidArea.width = gp.tileSize*4/5;
		solidArea.height = gp.tileSize*14/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 3;
		tileWidth = 2;
		
		image1 = setup("/desert_objects/Desert_Obelisk", tileHeight + 2 , tileWidth);
		
	}
	
}
