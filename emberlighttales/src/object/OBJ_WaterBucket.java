package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_WaterBucket extends Entity {

	GamePanel gp;
	public static final String objName = "Water Bucket";

	public OBJ_WaterBucket(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		image1 = setup("/resource_icons/water_bucket", 1, 1);
		image2 = setup("/resource_icons/water_bucket", 1, 1);
		description = "[" + name + "]" + "\nWater from well\nin a bucket";
		stackable = false;
		price = 10;
		isQuestItem = true;
		
		setDialogue();
	}

}
