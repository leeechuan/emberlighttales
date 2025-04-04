package tile;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.emberlight.GamePanel;
import tile_interactive.InteractiveTile;

public class Map extends TileManager{
	
	GamePanel gp;
	BufferedImage worldMap[];
	public boolean miniMapOn = false;
	
	public Map(GamePanel gp) {
		super(gp);
		this.gp = gp;
		createWorldMap();
	}
	public void createWorldMap() {
		
		worldMap = new BufferedImage[gp.maxMap];
		int worldMapWidth = gp.tileSize * gp.maxWorldCol;
		int worldMapHeight = gp.tileSize * gp.maxWorldRow;
		
		for(int i = 0; i < gp.maxMap; i++) {
			
			worldMap[i] = new BufferedImage(worldMapWidth, worldMapHeight, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = (Graphics2D)worldMap[i].createGraphics();
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				
				int tileNum = mapTileNum[i][col][row];
				int x = gp.tileSize * col;
				int y = gp.tileSize * row;
				g2.drawImage(tile[tileNum].image, x, y, null);
				
				col++;
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			g2.dispose();
		}
	}
	public void drawFullMapScreen(Graphics2D g2) {
		
		//Background Color
		g2.setColor(Color.black);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		//Draw Map
		int width = 500;
		int height = 500;
		int x = gp.screenWidth/2 - width/2;
		int y = gp.screenHeight/2 - height/2;
		g2.drawImage(worldMap[gp.currentMap], x, y, width, height, null);
		
		//Draw Player
		double scale = (double)(gp.tileSize * gp.maxWorldCol)/width;
		int playerX = (int)(x + gp.player.worldX/scale);
		int playerY = (int)(y + gp.player.worldY/scale);
		int playerSize = (int)(gp.tileSize/2);
		g2.drawImage(gp.player.frontStanding[0], playerX - 8, playerY - 8, playerSize, playerSize, null);
		
	    // Draw Interactive Tiles
	    for (int i = 0; i < gp.iTile[gp.currentMap].length; i++) {
	        InteractiveTile tile = gp.iTile[gp.currentMap][i];
	        if (tile != null) {  // assuming similar property for interactive tiles
	            int tileX = (int)(x + tile.worldX / scale + 10);
	            int tileY = (int)(y + tile.worldY / scale - 3);
	            int tileSize = (int)(gp.tileSize / 2); // adjust size as needed
	            g2.drawImage(tile.image1, tileX - 8, tileY - 8, tileSize, tileSize, null);
	        }
	    }

		
		//Hint
		g2.setFont(gp.ui.pressStart2P.deriveFont(16f));
		g2.setColor(Color.white);
		g2.drawString("Press M to close", 650, 550);
	}
	public void drawMiniMap(Graphics2D g2) {
		
		if(miniMapOn == true) {
			//Draw Map
			int width = 200;
			int height = 200;
			int x = gp.screenWidth - width - 50;
			int y = 50;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
			g2.drawImage(worldMap[gp.currentMap], x, y, width, height, null);
			
			//Draw Player
			double scale = (double)(gp.tileSize * gp.maxWorldCol)/width;
			int playerX = (int)(x + gp.player.worldX/scale);
			int playerY = (int)(y + gp.player.worldY/scale);
			int playerSize = (int)(gp.tileSize/2);
			g2.drawImage(gp.player.frontStanding[0], playerX - 8, playerY - 8, playerSize, playerSize, null);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		}
	}

}
