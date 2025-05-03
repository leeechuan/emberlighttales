package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Suspicious_Juice extends Entity{
	
	GamePanel gp;
	public static final String objName = "Suspicious Juice";
	
	public OBJ_Suspicious_Juice(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		value = 10;
		image1 = setup("/objects/suspicious_juice", 1, 1);
		attackValue = 1;
		description = "[" + name + "]" + "\nIt's radiating\npink.";
		stackable = true;
		
	}
    public void setDialogue() {
    	
//    	dialogues[0][0] = "*The world seems... sideways.";
//    	dialogues[0][1] = "*Was that tree always glowing...";
//    	dialogues[0][2] = "Wait... why is the ground... coming\ncloser";
    }
	public boolean use(Entity entity) {
		
//		setDialogue();
//		startDialogue(this, 0);
		gp.qManager.progressQuest("The Suspicious Merchant");
		gp.pManager.addNotification("Journal Updated");
		gp.csManager.sceneNum = gp.csManager.suspiciousJuice;
		gp.csManager.setDialogue();
    	gp.gameState = gp.cutsceneState;
		return true;
	}
}
