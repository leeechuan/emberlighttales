package tile_interactive;

import java.awt.Color;

import entity.Entity;
import main.emberlight.GamePanel;

public class IT_Tree extends InteractiveTile{

	GamePanel gp;
	private int tree_type;
	
	public IT_Tree(GamePanel gp, int col, int row, int tree_type) {
		super(gp, col, row);
		this.gp = gp;
		this.tree_type = tree_type;
		
		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		
		
		if (tree_type == 0) {
			solidArea.x = (int) (gp.tileSize * 0.85);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 1) {
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 3;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 2) {
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 3) {
			solidArea.x = (int) (gp.tileSize * 0.8);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 4) {
			solidArea.x = (int) (gp.tileSize * 1.75);
			solidArea.y = (int) (gp.tileSize * 0);
			solidArea.width = (int) (gp.tileSize * 0.5);
			solidArea.height = (int) (gp.tileSize * 0.7);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 3;
			tileWidth = 4;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 5) {
			
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 6) {
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 2;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 7) {
			solidArea.x = (int) (gp.tileSize * 1.75);
			solidArea.y = (int) (gp.tileSize * 0);
			solidArea.width = (int) (gp.tileSize * 0.5);
			solidArea.height = (int) (gp.tileSize * 0.5);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 3;
			tileWidth = 4;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 8) {
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 9) {
			solidArea.x = (int) (gp.tileSize * 1.5);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 2;
			tileWidth = 3;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}
		else if (tree_type == 10) {
			solidArea.x = (int) (gp.tileSize * 0.87);
			solidArea.y = (int) (gp.tileSize * 0.25);
			solidArea.width = (int) (gp.tileSize * 0.25);
			solidArea.height = (int) (gp.tileSize * 0.25);
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			tileHeight = 1;
			tileWidth = 2;
			image1 = setup("/tiles_interactive/tree_" + tree_type + "_1", tileHeight + 2, tileWidth);
			destructible = false;
			life = 3;
		}

	}
	public boolean isCorrectItem(Entity entity) {
		boolean isCorrectItem = false;
		
		if(entity.currentWeapon.type == type_axe) {
			isCorrectItem = true;
		}
		return isCorrectItem;
	}
	public void playSE() {
		gp.playSE(8);
	}
	public InteractiveTile getDestroyedForm() {
		InteractiveTile tile = new IT_Tree_Trunk(gp, worldX/gp.tileSize, worldY/gp.tileSize, tree_type);
		return tile;
	}
	public Color getParticleColor() {
		Color color = new Color(65, 50 ,30);
		return color;
	}
	public int getParticleSize() {
		int size = 6;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
}
