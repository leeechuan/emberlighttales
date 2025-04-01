package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_GoldenChest extends Entity{
	
	public static final String objName = "Golden Chest";
	
	public OBJ_GoldenChest(GamePanel gp) {
		super(gp);
		
		name = objName;
		frontStanding[0] = setup("/objects/chest_golden", 1, 1);
		frontStanding[1] = setup("/objects/chest_golden", 1, 1);
		frontStanding[2] = setup("/objects/chest_golden", 1, 1);
		frontStanding[3] = setup("/objects/chest_golden", 1, 1);
		frontStanding[4] = setup("/objects/chest_golden", 1, 1);
		frontStanding[5] = setup("/objects/chest_golden", 1, 1);
		
		
		collision = true;
	}
}
