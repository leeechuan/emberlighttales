package main.emberlight;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import object.OBJ_PlantedCrop;

public class CollisionChecker implements Serializable{
	
	private static final long serialVersionUID = 1711574900829871507L;
	GamePanel gp;
	
	public CollisionChecker (GamePanel gp){
		this.gp = gp;
	}
	
	public int checkTile(Entity entity) {

	    int entityLeftWorldX = entity.worldX + entity.solidArea.x;
	    int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
	    int entityTopWorldY = entity.worldY + entity.solidArea.y;
	    int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

	    int entityLeftCol = entityLeftWorldX / gp.tileSize;
	    int entityRightCol = entityRightWorldX / gp.tileSize;
	    int entityTopRow = entityTopWorldY / gp.tileSize;
	    int entityBottomRow = entityBottomWorldY / gp.tileSize;

	    int tileNum1 = -1;
	    int tileNum2 = -1;

	    // Use a temp direction when it's being knockbacked
	    String direction = entity.direction;
	    if (entity.knockBack) {
	        direction = entity.knockBackDirection;
	    }

	    switch (direction) {
	        case "up":
	            entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
	            if (isValidTile(entityLeftCol, entityTopRow) && isValidTile(entityRightCol, entityTopRow)) {
	                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
	                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
	                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
	                    entity.collisionOn = true;
	                }
	            }
	            break;

	        case "down":
	            entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
	            if (isValidTile(entityLeftCol, entityBottomRow) && isValidTile(entityRightCol, entityBottomRow)) {
	                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
	                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
	                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
	                    entity.collisionOn = true;
	                }
	            }
	            break;

	        case "left":
	            entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
	            if (isValidTile(entityLeftCol, entityTopRow) && isValidTile(entityLeftCol, entityBottomRow)) {
	                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityTopRow];
	                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityLeftCol][entityBottomRow];
	                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
	                    entity.collisionOn = true;
	                }
	            }
	            break;

	        case "right":
	            entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
	            if (isValidTile(entityRightCol, entityTopRow) && isValidTile(entityRightCol, entityBottomRow)) {
	                tileNum1 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityTopRow];
	                tileNum2 = gp.tileM.mapTileNum[gp.currentMap][entityRightCol][entityBottomRow];
	                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
	                    entity.collisionOn = true;
	                }
	            }
	            break;
	    }

	    return tileNum1;
	}
	private boolean isValidTile(int col, int row) {
	    return col >= 0 && col < gp.maxWorldCol && row >= 0 && row < gp.maxWorldRow;
	}
	public Point getCurrentTilePosition(Entity entity) {
	    int centerX = entity.worldX + entity.solidArea.x + entity.solidArea.width / 2;
	    int centerY = entity.worldY + entity.solidArea.y + entity.solidArea.height / 2;

	    int col = centerX / gp.tileSize;
	    int row = centerY / gp.tileSize;

	    return new Point(col, row);
	}

	public int getCurrentTileIndex(Entity entity) {
	    Point tile = getCurrentTilePosition(entity);
	    if (isValidTile(tile.x, tile.y)) {
	        return gp.tileM.mapTileNum[gp.currentMap][tile.x][tile.y];
	    } else {
	        return -1;
	    }
	}
	public int checkObject(Entity entity, boolean player) {
		
		int index = 999;
		
		//Use a temp direction when its being knockbacked
		String direction = entity.direction;
		if(entity.knockBack == true) {
			direction = entity.knockBackDirection;
		}
		
		for(int i = 0; i < gp.obj[1].length; i++) {
			
			if(gp.obj[gp.currentMap][i] != null) {
				
				//Get entity solid area position;
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get object solid area position
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].worldX + gp.obj[gp.currentMap][i].solidArea.x;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].worldY + gp.obj[gp.currentMap][i].solidArea.y;
				
				switch(direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;

					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				
				if(entity.solidArea.intersects(gp.obj[gp.currentMap][i].solidArea)) {
					if(gp.obj[gp.currentMap][i].collision == true) {
						entity.collisionOn = true;
					}
					if(player == true) {
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				gp.obj[gp.currentMap][i].solidArea.x = gp.obj[gp.currentMap][i].solidAreaDefaultX;
				gp.obj[gp.currentMap][i].solidArea.y = gp.obj[gp.currentMap][i].solidAreaDefaultY;
				
			}

		}
		
		return index;
	}
	
	//NPC OR MONSTER COLLISION 
	public int checkEntity(Entity entity, Entity[][] target) {
		
		int index = 999;
		
		//Use a temp direction when its being knockbacked
		String direction = entity.direction;
		if(entity.knockBack == true) {
			direction = entity.knockBackDirection;
		}
		
		for(int i = 0; i < target[1].length; i++) {
			
			if(target[gp.currentMap][i] != null) {
				
				//Get entity solid area position;
				entity.solidArea.x = entity.worldX + entity.solidArea.x;
				entity.solidArea.y = entity.worldY + entity.solidArea.y;
				
				//Get object solid area position
				target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].worldX + target[gp.currentMap][i].solidArea.x;
				target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].worldY + target[gp.currentMap][i].solidArea.y;
				
				switch(direction) {
				case "up":
					entity.solidArea.y -= entity.speed;
					break;
				case "down":
					entity.solidArea.y += entity.speed;
					break;
				case "left":
					entity.solidArea.x -= entity.speed;
					break;
				case "right":
					entity.solidArea.x += entity.speed;
					break;
				}
				
				if(entity.solidArea.intersects(target[gp.currentMap][i].solidArea)) {
					if(target[gp.currentMap][i] != entity) {
						entity.collisionOn = true;
						index = i;
					}
				}
				
				entity.solidArea.x = entity.solidAreaDefaultX;
				entity.solidArea.y = entity.solidAreaDefaultY;
				target[gp.currentMap][i].solidArea.x = target[gp.currentMap][i].solidAreaDefaultX;
				target[gp.currentMap][i].solidArea.y = target[gp.currentMap][i].solidAreaDefaultY;
				
			}

		}
		
		return index;
	}
	public int checkCrop(Entity player, ArrayList<OBJ_PlantedCrop> plantedCrops) {
	    int index = 999;  // Default to no crop interaction

	    // Iterate through each crop
	    for (int i = 0; i < plantedCrops.size(); i++) {
	        Entity crop = plantedCrops.get(i);

	        if (crop != null && crop.type == crop.type_crop) {
	            // Get player's solid area position
	            player.solidArea.x = player.worldX + player.solidArea.x;
	            player.solidArea.y = player.worldY + player.solidArea.y;

	            // Get crop solid area position
	            crop.solidArea.x = crop.worldX + crop.solidArea.x;
	            crop.solidArea.y = crop.worldY + crop.solidArea.y;

	            // Check for intersection (i.e., is the player touching the crop?)
	            if (player.solidArea.intersects(crop.solidArea)) {
	                index = i;  // Track the index of the crop
	                break;  // Stop after the first crop interaction (optional)
	            }

	            // Reset areas to default
	            player.solidArea.x = player.solidAreaDefaultX;
	            player.solidArea.y = player.solidAreaDefaultY;
	            crop.solidArea.x = crop.solidAreaDefaultX;
	            crop.solidArea.y = crop.solidAreaDefaultY;
	        }
	    }

	    return index;  // Return the index of the first crop interacted with, or 999 if none
	}
	public boolean checkPlayer(Entity entity) {
		
		boolean contactPlayer = false;
		
		//Get entity solid area position;
		entity.solidArea.x = entity.worldX + entity.solidArea.x;
		entity.solidArea.y = entity.worldY + entity.solidArea.y;
		
		//Get object solid area position
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		
		switch(entity.direction) {
		case "up":
			entity.solidArea.y -= entity.speed;
			break;
		case "down":
			entity.solidArea.y += entity.speed;
			break;
		case "left":
			entity.solidArea.x -= entity.speed;
			break;
		case "right":
			entity.solidArea.x += entity.speed;
			break;
		}
		
		if(entity.solidArea.intersects(gp.player.solidArea)) {
			entity.collisionOn = true;
			contactPlayer = true;
		}
		
		entity.solidArea.x = entity.solidAreaDefaultX;
		entity.solidArea.y = entity.solidAreaDefaultY;
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		
		return contactPlayer;
		
	}
}
