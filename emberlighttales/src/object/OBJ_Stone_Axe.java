package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Stone_Axe extends Entity{
	
	public static final String objName = "Stone Axe";

	public OBJ_Stone_Axe(GamePanel gp) {
		super(gp);
		
		type = type_axe;
		name = objName;
		image1 = setup("/objects/stone_axe", 1, 1);
		attackValue = 2;
		attackArea.width = 30;
		attackArea.height = 30;
		description = "[" + name + "]" + "\nA heavy hitter.\nSolid and steady.";
		price = 50;
		knockBackPower = 6;
		motion1_duration = 5;
		motion2_duration = 16;
		motion3_duration = 20;
		motion4_duration = 24;
		motion5_duration = 26;
		motion6_duration = 30;
        maxDurability = 26;
        durability = 26;
	}

}
