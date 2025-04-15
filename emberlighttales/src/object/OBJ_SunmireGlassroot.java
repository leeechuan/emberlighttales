package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_SunmireGlassroot extends Entity {

	GamePanel gp;
	public static final String objName = "Sunmire Glassroot";

	public OBJ_SunmireGlassroot(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		image1 = setup("/resource_icons/sunmire_glassroot", 1, 1);
		image2 = setup("/resource_icons/sunmire_glassroot", 1, 1);
		description = "[" + name + "]" + "\nGrows only in\nsalt-glass dunes";
		price = 7;
		stackable = false;
		price = 200;
		
		setDialogue();
	}



}
