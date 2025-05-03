package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Rabbit_Shield_3 extends Entity{
	
	public static final String objName = "Blossom";

	public OBJ_Rabbit_Shield_3(GamePanel gp) {
		super(gp);
		
		type = type_shield;
		name = objName;
		image1 = setup("/objects/rabbit_shield3", 1, 1);
		defenseValue = 3;
		description = "[" + name + "]" + "\nA big bunny";
		price = 80;
        maxDurability = 40;
        durability = 40;
	}
}
