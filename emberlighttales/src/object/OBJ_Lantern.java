package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Lantern extends Entity{
	
	public static final String objName = "Lantern";

	public OBJ_Lantern(GamePanel gp) {
		
		super(gp);
		
		type = type_light;
		name = objName;
		image1 = setup("/objects/lantern", 1, 1);
		description = "[Lantern]\nEmits moderate light";
		price = 200;
		lightRadius = 250;
	}
}
