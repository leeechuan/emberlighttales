package object;

import java.awt.Point;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Seed extends Entity{

	public int cropId; // E.g., "Carrot", "Tomato", etc.
    public int growthTime; // Time (in ticks) it takes to grow
    public static final String objName = "Seed";
    public static final int[] SEED_PRICES = {
    	    10, 20, 15, 18, 25, 50, 16, 17, 45, 30,
    	    32, 32, 32, 55, 48, 52, 22, 60, 20, 24, 35, 70
    	};
    public static final String[] CROP_NAMES = {
    	    "Wheat", "Tomato", "Carrot", "Turnip", "Corn", "Tangerine", "Radish", "Lettuce", "Pickle", "Chili",
    	    "Red Pepper", "Orange Pepper", "Green Pepper", "Watermelon", "Sunflower", "Garlic", "Potato",
    	    "Strawberry", "Beetroot", "Onion", "Leek", "Grape"
    	};
    
    public OBJ_Seed(GamePanel gp, int cropId) {
		super(gp);
		
		this.gp = gp;
        this.type = type_seed;
        this.cropId = cropId;
        
        name = CROP_NAMES[cropId];
        
        image1 = setup("/crops/crop_" + cropId + "_0", 1, 1);
        
		description = "[" + name + "]" + "\nPlant me!";
		price = SEED_PRICES[cropId];
		stackable = true;
    }
    public void setDialogue() {
    	
		dialogues[0][0] = "You planted a " + name + " seed.";
		dialogues[1][0] = "You may only plant on soil.";
		dialogues[2][0] = "You have already planted here.";
    }
    public boolean use(Entity entity) {
        int tileIndex = gp.cChecker.getCurrentTileIndex(gp.player);
        if (tileIndex >= 71 && tileIndex <= 79) {

            Point tile = gp.cChecker.getCurrentTilePosition(gp.player);
            int playerTileX = tile.x;
            int playerTileY = tile.y;

            if (isTileOccupied(playerTileX, playerTileY)) {
                setDialogue();
                startDialogue(this, 2);
                return false;
            }

            plantSeed(playerTileX, playerTileY);
            return true;
        } else {
            setDialogue();
            startDialogue(this, 1);
            return false;
        }
    }

	// Method to check if the tile is occupied
	public boolean isTileOccupied(int tileX, int tileY) {
	    for (Entity entity : gp.plantedCrops) {
	        if (entity instanceof OBJ_PlantedCrop) {
	            OBJ_PlantedCrop plantedCrop = (OBJ_PlantedCrop) entity;
	            if (plantedCrop.worldX == tileX * gp.tileSize && plantedCrop.worldY == tileY * gp.tileSize) {
	                return true; // Tile is occupied
	            }
	        }
	    }
	    return false; // Tile is free
	}

	public void plantSeed(int tileX, int tileY) {
	    if (isTileOccupied(tileX, tileY)) {
	        setDialogue();
	        startDialogue(this, 2);
	    } else {
	        OBJ_PlantedCrop crop = new OBJ_PlantedCrop(tileX, tileY, cropId, gp);
	        gp.plantedCrops.add(crop);
            gp.playSE(31);
	        setDialogue();
	        startDialogue(this, 0);
	        System.out.println("Planted crop ID " + cropId + " at tile (" + tileX + ", " + tileY + ")");
	    }
	}
	
	public int getCropId() {
		return cropId;
	}
    public void setCropId(int cropId) {
        this.cropId = cropId;
    }
}
