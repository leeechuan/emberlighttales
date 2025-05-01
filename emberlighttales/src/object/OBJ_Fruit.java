package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Fruit extends Entity{

	public int cropId; // E.g., "Carrot", "Tomato", etc.
    public int growthTime; // Time (in ticks) it takes to grow
    public static final String objName = "Fruit";

    public OBJ_Fruit(GamePanel gp, int cropId) {
		super(gp);
		
		this.gp = gp;
		this.cropId = cropId;
        this.type = type_seed; // Set the seed type
        
        
        image1 = setup("/crops/crop_" + cropId + "_5", 1, 1);
        
        name = objName;
		description = "[" + name + "]" + "\nSell me!";
		price = 10;
		stackable = true;
    }
    public void setDialogue() {
    	
		dialogues[0][0] = "You harvested a fruit.";
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
