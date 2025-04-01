package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Rabbit_Shield_2 extends Entity{
	
	public static final String objName = "Willow";

	public OBJ_Rabbit_Shield_2(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = objName;
		image1 = setup("/objects/rabbit_shield2", 1, 1);
		defenseValue = 2;
		description = "[" + name + "]" + "\nA bunny plushie\ncalled Willow.";
		price = 35;
	}
}
