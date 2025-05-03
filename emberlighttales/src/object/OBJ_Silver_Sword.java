package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Silver_Sword extends Entity{
	
	public static final String objName = "Silver Sword";
	
	public OBJ_Silver_Sword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = objName;
        image1 = setup("/objects/silver_sword", 1, 1);
        attackValue = 5;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]" + "\nElegant and light,\nbut poor knockback";
        price = 100;
        knockBackPower = 1;
        motion1_duration = 5;
        motion2_duration = 12;
        motion3_duration = 16;
        motion4_duration = 20;
        maxDurability = 50;
        durability = 50;
	}

}
