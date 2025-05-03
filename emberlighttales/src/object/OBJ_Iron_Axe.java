package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Iron_Axe extends Entity{
	
	public static final String objName = "Iron Axe";

	public OBJ_Iron_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = objName;
		image1 = setup("/objects/iron_axe", 1, 1);
		attackValue = 3;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]" + "\nBalanced, old-style\ncraftsmanship.";
		price = 80;
		knockBackPower = 8;
		motion1_duration = 5;
		motion2_duration = 16;
		motion3_duration = 20;
		motion4_duration = 24;
		motion5_duration = 26;
		motion6_duration = 30;
        maxDurability = 35;
        durability = 35;
	}

}
