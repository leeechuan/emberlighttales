package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Iron_Sword extends Entity{
	
	public static final String objName = "Iron Sword";
	
    public OBJ_Iron_Sword(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = objName;
        image1 = setup("/objects/iron_sword", 1, 1);
        attackValue = 3;
        attackArea.width = 36;
        attackArea.height = 36;
        description = "[" + name + "]" + "\nReliable and sharp.\nBuilt for battle.";
        price = 60;
        knockBackPower = 4;
        motion1_duration = 5;
        motion2_duration = 12;
        motion3_duration = 16;
        motion4_duration = 20;
        motion5_duration = 0;
        motion6_duration = 0;
        maxDurability = 40;
        durability = 40;
    }

}
