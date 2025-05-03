package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Wood_Axe extends Entity{
	
	public static final String objName = "Wood Axe";

	public OBJ_Wood_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = objName;
		image1 = setup("/objects/wood_axe", 1, 1);
		attackValue = 1;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]" + "\nChops wood and\nskulls. Barely.";
		price = 25;
		knockBackPower = 4;
		motion1_duration = 5;
		motion2_duration = 16;
		motion3_duration = 20;
		motion4_duration = 24;
		motion5_duration = 26;
		motion6_duration = 30;
        maxDurability = 18;
        durability = 18;
	}

}
