package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Gold_Axe extends Entity{
	
	public static final String objName = "Gold Axe";

	public OBJ_Gold_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = objName;
		image1 = setup("/objects/gold_axe", 1, 1);
		attackValue = 10;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]" + "\nHeavy, golden, and\nshockingly brutal.";
		price = 250;
		knockBackPower = 6;
		motion1_duration = 5;
		motion2_duration = 16;
		motion3_duration = 20;
		motion4_duration = 24;
		motion5_duration = 26;
		motion6_duration = 30;
        maxDurability = 12;
        durability = 12;
	}

}
