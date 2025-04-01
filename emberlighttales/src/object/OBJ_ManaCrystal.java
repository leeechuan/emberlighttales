package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_ManaCrystal extends Entity {

	GamePanel gp;
	public static final String objName = "Mana Crystal";

	public OBJ_ManaCrystal(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		value = 1;
		image1 = setup("/objects/mana_full", 1, 1);
		image2 = setup("/objects/mana_empty", 1, 1);
		price = 5;
	}
	
	public boolean use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Mana +" + value);
		entity.mana += value;
		return true;
	}
}
