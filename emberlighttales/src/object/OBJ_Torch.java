package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Torch extends Entity{
	
	public static final String objName = "Torch";

	public OBJ_Torch(GamePanel gp) {
		
		super(gp);
		
		type = type_light;
		name = objName;
		image1 = setup("/objects/torch", 1, 1);
		description = "[Torch]\nEmits small light";
		price = 200;
		lightRadius = 150;
	}
}
