package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_LucaJacket extends Entity {

	GamePanel gp;
	public static final String objName = "Luca's Jacket";

	public OBJ_LucaJacket(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		image1 = setup("/resource_icons/luca_jacket", 1, 1);
		image2 = setup("/resource_icons/luca_jacket", 1, 1);
		description = "[" + name + "]" + "\nStylish and smug.";
		stackable = false;
		price = 100;
		isQuestItem = true;
		
		setDialogue();
	}



}
