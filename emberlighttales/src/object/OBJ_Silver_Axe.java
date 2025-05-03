package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Silver_Axe extends Entity{
	
	public static final String objName = "Silver Axe";

	public OBJ_Silver_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = objName;
		image1 = setup("/objects/silver_axe", 1, 1);
		attackValue = 7;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]" + "\nBalanced, old-style\ncraftsmanship.";
		price = 135;
		knockBackPower = 4;
		motion1_duration = 5;
		motion2_duration = 16;
		motion3_duration = 20;
		motion4_duration = 24;
		motion5_duration = 26;
		motion6_duration = 30;
        maxDurability = 40;
        durability = 40;
	}

}
