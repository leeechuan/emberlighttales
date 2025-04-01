package object;

import java.awt.Color;

import entity.Entity;
import entity.Projectile;
import main.emberlight.GamePanel;

public class OBJ_Skeleton_Mage_Projectile extends Projectile {
	
	GamePanel gp;
	public static final String objName = "Skeleton Mage Projectile";

	public OBJ_Skeleton_Mage_Projectile(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		name = objName;
		speed = 8;
		maxLife = 80;
		life = maxLife;
		attack = 4;
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
             frontStanding[i] = setup("/projectile/skeleton_mage_projectile_" + i, 1, 1);
             rightStanding[i] = setup("/projectile/skeleton_mage_projectile_" + i, 1, 1);
             backStanding[i] = setup("/projectile/skeleton_mage_projectile_" + i, 1, 1);
         }
      for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
       	}
	}
	public boolean haveResource(Entity user) {
		
		boolean haveResource = false;
		if(user.ammo >= useCost) {
			haveResource = true;
		}
		return haveResource;
	}
	public void subtractResource(Entity user) {
		user.ammo -= useCost;
	}
	public Color getParticleColor() {
		Color color = new Color(228, 54, 202);
		return color;
	}
	public int getParticleSize() {
		int size = 5;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 3;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
}
