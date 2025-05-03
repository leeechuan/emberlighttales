package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Fruit extends Entity{

	public int cropId; // E.g., "Carrot", "Tomato", etc.
    public int growthTime; // Time (in ticks) it takes to grow
    public static final String objName = "Fruit";
    public static final int[] FRUIT_PRICES = {
    	    25, 40, 32, 35, 60, 100, 38, 42, 95, 70,
    	    75, 75, 75, 120, 110, 115, 45, 130, 43, 50, 80, 140
    	};
    public static final String[] CROP_NAMES = {
    	    "Wheat", "Tomato", "Carrot", "Turnip", "Corn", "Tangerine", "Radish", "Lettuce", "Pickle", "Chili",
    	    "Red Pepper", "Orange Pepper", "Green Pepper", "Watermelon", "Sunflower", "Garlic", "Potato",
    	    "Strawberry", "Beetroot", "Onion", "Leek", "Grape"
    	};

    public OBJ_Fruit(GamePanel gp, int cropId) {
		super(gp);
		
		this.gp = gp;
		this.cropId = cropId;
        this.type = type_seed; // Set the seed type
        
        
        image1 = setup("/crops/crop_" + cropId + "_5", 1, 1);
        
        name = CROP_NAMES[cropId];
		description = "[" + name + "]" + "\nSell for profit!";
		price = FRUIT_PRICES[cropId];
		stackable = true;
    }
    public void setDialogue() {
    	
		dialogues[0][0] = "You harvested a " + name;
    }
	public boolean use() {
		
		setDialogue();
		startDialogue(this, 0);
//		gp.playSE(1);
		return true;
	}
	public int getCropId() {
		return cropId;
	}
    public void setCropId(int cropId) {
        this.cropId = cropId;
    }
}
