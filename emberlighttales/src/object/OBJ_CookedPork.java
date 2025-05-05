package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_CookedPork extends Entity{
	
	GamePanel gp;
	public static final String objName = "Cooked Pork";
	
	public OBJ_CookedPork(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		value = 50;
		image1 = setup("/objects/cooked_pork", 1, 1);
		attackValue = 1;
		description = "[" + name + "]" + "\nYum yum\nHeals by " + value + ".";
		price = 35;
		stackable = true;
		
	}
    public void setDialogue() {
    	
		dialogues[0][0] = "You restored " + value + " health!";
    }
	public boolean use(Entity entity) {
		
		setDialogue();
		startDialogue(this, 0);
		entity.life += value;
		if(gp.player.life > gp.player.maxLife) {
			gp.player.life = gp.player.maxLife;
		}
		gp.playSE(1);
		return true;
	}
}
