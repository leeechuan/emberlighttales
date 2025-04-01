package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Rabbit_Shield_1 extends Entity{
	
	public static final String objName = "Pablo";
	
	public OBJ_Rabbit_Shield_1(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = objName;
		image1 = setup("/objects/rabbit_shield1", 1, 1);
		defenseValue = 1;
		description = "[" + name + "]" + "\nA bunny plushie\ncalled Pablo.\nIts kinda crusty.\nAlso, it emits\na green stench.";
		price = 20;
	}

}
