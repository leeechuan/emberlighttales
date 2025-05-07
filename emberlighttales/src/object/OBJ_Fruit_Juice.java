package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Fruit_Juice extends Entity{
	
	GamePanel gp;
	public static final String objName = "Fruit Juice";
	
	public OBJ_Fruit_Juice(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_consumable;
		name = objName;
		value = 10;
		image1 = setup("/objects/fruit_juice", 1, 1);
		attackValue = 1;
		description = "[" + name + "]" + "\nYum yum!\nHeals by " + value + ".";
		price = 7;
		stackable = true;
		
	}
    public void setDialogue() {
    	
		dialogues[0][0] = "You drank some juice! \n" + "You restored " + value + " health!";
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
