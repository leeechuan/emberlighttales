package tile_interactive;

import entity.Entity;
import main.emberlight.GamePanel;

public class IT_Tree_Trunk extends InteractiveTile{
	
	GamePanel gp;
	
	public IT_Tree_Trunk(GamePanel gp, int col, int row, int tree_type) {
		super(gp, col, row);
		this.gp = gp;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		solidArea.x = 0;
		solidArea.y = 0;
		solidArea.width = 0;
		solidArea.height = 0;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		if (tree_type == 0) {
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 1) {
			tileHeight = 3;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 2) {
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 3) {
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 4) {
			tileHeight = 3;
			tileWidth = 4;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 5) {
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 6) {
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 7) {
			tileHeight = 3;
			tileWidth = 4;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
		else if (tree_type == 8) {
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_0", tileHeight + 2, tileWidth);
		}
	}
}
