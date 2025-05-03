package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Wood_Sword extends Entity{
	
	public static final String objName = "Wood Sword";
	
	public OBJ_Wood_Sword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = objName;
        image1 = setup("/objects/wood_sword", 1, 1);
        attackValue = 1;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]" + "\nLight and crude.\nHardly cuts anything.";
        price = 10;
        knockBackPower = 2;
        motion1_duration = 5;
        motion2_duration = 12;
        motion3_duration = 16;
        motion4_duration = 20;
        maxDurability = 20;
        durability = 20;
	}

}
