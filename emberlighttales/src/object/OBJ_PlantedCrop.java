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
    
    private static final int BASE_GROWTH_TIME = 3000;
    private static final int RANDOM_GROWTH_VARIATION = 500;

    private int cropId; // The ID to define which crop this is (e.g., 0 for wheat, 1 for tomato, etc.)
    
    // Constructor
    public OBJ_PlantedCrop(int tileX, int tileY, int cropId, GamePanel gp) {
    	
        super(gp);
        this.cropId = cropId;
        this.type = type_crop;
        this.worldX = tileX * gp.tileSize;
        this.worldY = tileY * gp.tileSize;
        this.maxGrowthTicks = BASE_GROWTH_TIME + (int)(Math.random() * RANDOM_GROWTH_VARIATION);
        
        name = objName;
        
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
    	
		dialogues[0][0] = "You harvested";
		dialogues[1][0] = "It is not ripe yet";
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
                    maxGrowthTicks = BASE_GROWTH_TIME + (int) (Math.random() * RANDOM_GROWTH_VARIATION);
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
            // Give the player the harvested fruit (you can implement this however you want)
			gp.player.canObtainItem(new OBJ_Fruit(gp, cropId)); // Add the harvested fruit to player's inventory
            // Remove the planted crop
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