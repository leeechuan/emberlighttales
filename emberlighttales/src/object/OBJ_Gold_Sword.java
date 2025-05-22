package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Gold_Sword extends Entity{
	
	public static final String objName = "Gold Sword";
	
	public OBJ_Gold_Sword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = objName;
        image1 = setup("/objects/gold_sword", 1, 1);
        attackValue = 10;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]" + "\nA lavish sword made\nof gold. Highly effective,\nbut not very durable.";
        price = 200;
        knockBackPower = 3;
        motion1_duration = 5;
        motion2_duration = 12;
        motion3_duration = 16;
        motion4_duration = 20;
        maxDurability = 10;
        durability = 10;
	}

}
