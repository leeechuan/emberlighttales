package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_EmberlightPearl extends Entity {

	GamePanel gp;
	public static final String objName = "Emberlight Pearl";

	public OBJ_EmberlightPearl(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		value = 99999;
		image1 = setup("/resource_icons/emberlight_pearl", 1, 1);
		image2 = setup("/resource_icons/emberlight_pearl", 1, 1);;
		price = 99999;
		
		setDialogue();
	}
    public void setDialogue() {
    	
        dialogues[0][0] = "You found the Pearl of Emberlight!";
        dialogues[0][1] = "Darkness that once shrouded the land\nhas been eradicated,\nand peace returns to Emberlight.";

    }
    public boolean use(Entity entity) {
    	
    	gp.gameState = gp.cutsceneState;
    	gp.csManager.sceneNum = gp.csManager.ending;
    	return true;
    }

}
