package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_PlantedCrop extends Entity {
	
	public static final String objName = "Planted Crop";
	private BufferedImage[] stageImages = new BufferedImage[5]; // STAGE_SEED to STAGE_GROWTH_4

	// Crop stages
    private static final int STAGE_SEED = 0;
    private static final int STAGE_GROWTH_1 = 1;
    private static final int STAGE_GROWTH_2 = 2;
    private static final int STAGE_GROWTH_3 = 3;
    private static final int STAGE_GROWTH_4 = 4;
    private static final int STAGE_HARVESTED = 5;

    private int growthStage = STAGE_GROWTH_1;
    private int growthTicks = 0; // Ticks to wait before growing
    private int maxGrowthTicks = 100; // The number of ticks before the crop grows (can be randomized)
    
    // Growth time config per crop ID
    private static final int[] BASE_GROWTH_TIMES = {
        2400, 2800, 2600, 2700, 3800, 5200, 2900, 3100, 4700, 3600,
        3900, 3900, 3900, 5500, 4800, 5000, 3400, 5700, 3300, 3500, 4400, 6000
    };
    private static final int[] GROWTH_VARIATIONS = {
        300, 400, 350, 400, 700, 900, 400, 450, 800, 600,
        650, 650, 650, 1000, 900, 800, 500, 1100, 500, 600, 700, 1200
    };
    public static final String[] CROP_NAMES = {
    	    "Wheat", "Tomato", "Carrot", "Turnip", "Corn", "Tangerine", "Radish", "Lettuce", "Pickle", "Chili",
    	    "Red Pepper", "Orange Pepper", "Green Pepper", "Watermelon", "Sunflower", "Garlic", "Potato",
    	    "Strawberry", "Beetroot", "Onion", "Leek", "Grape"
    	};

    private int cropId; // The ID to define which crop this is (e.g., 0 for wheat, 1 for tomato, etc.)
    
    // Constructor
    public OBJ_PlantedCrop(int tileX, int tileY, int cropId, GamePanel gp) {
    	
        super(gp);
        this.cropId = cropId;
        this.type = type_crop;
        this.worldX = tileX * gp.tileSize;
        this.worldY = tileY * gp.tileSize;
        this.maxGrowthTicks = BASE_GROWTH_TIMES[cropId] + (int)(Math.random() * GROWTH_VARIATIONS[cropId]);
        
        name = CROP_NAMES[cropId];
        
		collision = true;
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
	    loadStageImages();
    }
    public void setDialogue() {
    	
		dialogues[0][0] = "You harvested a " + name;
		dialogues[1][0] = name + " is not ripe yet.\nIt is still at stage " + growthStage;
    }
    private void loadStageImages() {
        for (int i = STAGE_GROWTH_1; i <= STAGE_GROWTH_4; i++) {
            String spriteName = "/crops/crop_" + cropId + "_" + i; // Match naming with stage number
            stageImages[i] = setup(spriteName, 2, 1);
        }
    }
	public void interact() {
		harvest();
	}
    @Override
    public void update() {
        super.update();

        // If it's not the harvested stage, continue to grow
        if (growthStage != STAGE_HARVESTED) {
            growthTicks++;
            if (growthTicks >= maxGrowthTicks) {
                growthTicks = 0;
                // Move to the next stage
                if (growthStage < STAGE_GROWTH_4) {
                    growthStage++;
                    // Re-randomize growth time for the next stage
                    maxGrowthTicks = BASE_GROWTH_TIMES[cropId] + (int)(Math.random() * GROWTH_VARIATIONS[cropId]);
                }
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage cropSprite = getCropImageForStage(growthStage);
        if (cropSprite != null) {
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY - gp.tileSize/2;

            g2.drawImage(cropSprite, screenX, screenY, gp.tileSize, gp.tileSize * 2, null);
        }
    }

    private BufferedImage getCropImageForStage(int stage) {
        if (stage >= 0 && stage < stageImages.length) {
            return stageImages[stage];
        }
        return null;
    }

    // Harvest the crop (turns it into fruit)
    public void harvest() {
        if (growthStage == STAGE_GROWTH_4) {
			setDialogue();
			startDialogue(this, 0);
			gp.player.canObtainItem(new OBJ_Fruit(gp, cropId));
            gp.playSE(30);
			gp.plantedCrops.remove(this);
        }
        else {
			setDialogue();
			startDialogue(this, 1);
        }
    }

    // Check if the crop is ready to harvest
    public boolean isReadyToHarvest() {
        return growthStage == STAGE_GROWTH_4;
    }
	public int getCropId() {
		return cropId;
	}
	public int getGrowthStage() {
		return growthStage;
	}
	public int getGrowthTicks() {
		return growthTicks;
	}
	public void setGrowthStage(int growthStage) {
		this.growthStage = growthStage;
	}
	public void setGrowthTicks(int growthTicks) {
		this.growthTicks = growthTicks;
	}
}