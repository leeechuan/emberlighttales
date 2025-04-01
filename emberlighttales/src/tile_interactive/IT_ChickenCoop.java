package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class IT_ChickenCoop extends InteractiveTile{

	GamePanel gp;
	
	public IT_ChickenCoop(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col ;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.4);
		solidArea.y = (int) (gp.tileSize * 0.75);
		solidArea.width = (int) (gp.tileSize * 2.25);
		solidArea.height = (int) (gp.tileSize * 0.75);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 1;
		tileWidth = 3;
		
		image1 = setup("/tiles_interactive/chicken_coop", (tileHeight + 2) , tileWidth);
	}
	
}
