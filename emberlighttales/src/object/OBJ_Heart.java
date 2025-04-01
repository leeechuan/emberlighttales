package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Heart extends Entity{
	
	GamePanel gp;
	public static final String objName = "Heart";
	
	public OBJ_Heart(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		value = 2;
		image1 = setup("/objects/heart_full", 1, 1);
		image2 = setup("/objects/heart_half", 1, 1);
		image3 = setup("/objects/heart_empty", 1, 1);
		price = 5;
		
	}
	
	public boolean use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Life +" + value);
		entity.life += value;
		return true;
	}
}
