package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Coin extends Entity{
	
	GamePanel gp;
	public static final String objName = "Coin";
	
	public OBJ_Coin(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_pickupOnly;
		name = objName;
		value = 1;
		image1 = setup("/objects/coin", 1, 1);
	}
	
	public boolean use(Entity entity) {
		
		gp.playSE(1);
		gp.ui.addMessage("Coin +" + value);
		gp.player.coin += value;
		return true;
	}
}
