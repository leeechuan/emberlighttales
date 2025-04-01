package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Bed extends Entity{
	
	GamePanel gp;
	public static final String objName = "Bed";
	
	public OBJ_Bed(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		image1 = setup("/interior_decor/bed", 2, 1);
		
		collision = true;
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 64;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	
    public void setDialogue() {
		dialogues[0][0] = "You rested til morning.\nHP and mana is restored\n[Progress has been saved]";
    }
	public void interact() {
		setDialogue();
		startDialogue(this, 0);
		gp.eHandler.sleep();
	}
}
