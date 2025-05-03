package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Stone_Sword extends Entity{
	
	public static final String objName = "Stone Sword";
	
	public OBJ_Stone_Sword(GamePanel gp) {
		super(gp);
		
		type = type_sword;
		name = objName;
		image1 = setup("/objects/stone_sword", 1, 1);
		attackValue = 2;
		attackArea.width = 36;
		attackArea.height = 36;
		description = "[" + name + "]" + "\nA little old but\ntrustworthy";
		price = 30;
		knockBackPower = 3;
		motion1_duration = 5;
		motion2_duration = 12;
		motion3_duration = 16;
		motion4_duration = 20;
		maxDurability = 30;
		durability = 30;
	}

}
