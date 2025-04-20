package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_FieldResonator extends Entity {

	GamePanel gp;
	public static final String objName = "Field Resonator";

	public OBJ_FieldResonator(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		image1 = setup("/resource_icons/field_resonator", 1, 1);
		image2 = setup("/resource_icons/field_resonator", 1, 1);
		description = "[" + name + "]" + "\nUnstable, humming,\nsciency device.";
		stackable = false;
		price = 0;
		
		setDialogue();
	}



}
