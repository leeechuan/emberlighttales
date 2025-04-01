package tile_interactive;

import main.emberlight.GamePanel;

public class IT_DungeonTintWindows extends InteractiveTile{

	GamePanel gp;
	
	//TYPES:
//	0 -> LEFT PILLAR
//	1 -> LEFT
//	2 -> MIDDLE
//	3 -> RIGHT
//	4 -> RIGHT PILLAR
//	5 -> RED
//	6 -> BLUE
	
	public IT_DungeonTintWindows(GamePanel gp, int col, int row, int window_type) {
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
		solidArea.width = (gp.tileSize * 1);
		solidArea.height = (int)(gp.tileSize * 1.3);
		
		image1 = setup("/dungeon_objects/windowtint_" + window_type, 4, 1);
	}
	
}
