package object;

import java.awt.Color;

import entity.Entity;
import entity.Projectile;
import main.emberlight.GamePanel;

public class OBJ_Arrow extends Projectile{
	
	GamePanel gp;
	public static final String objName = "Arrow";
	
	public OBJ_Arrow(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = objName;
		speed = 10;
		maxLife = 80;
		life = maxLife;
		attack = 2;
		knockBackPower = 2;
		useCost = 1;
		alive = false;
		
		solidArea.x = gp.tileSize*2/5;
		solidArea.y = gp.tileSize*2/5;
		solidArea.width = gp.tileSize/5;
		solidArea.height = gp.tileSize/5;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
	}
	
	public void getImage() {
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/projectile/arrow_down", 1, 1);
             rightStanding[i] = setup("/projectile/arrow_right", 1, 1);
             backStanding[i] = setup("/projectile/arrow_up", 1, 1);
         }
      for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
       	}
	}
	public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		if(user.mana >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
	public void subtractResource(Entity user) {
		user.mana -= useCost;
	}
}
