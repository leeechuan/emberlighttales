package mob;

import java.awt.Color;
import java.util.Random;

import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Coin;
import object.OBJ_Heart;
import object.OBJ_ManaCrystal;

public class MOB_PinkSlime extends Entity {
	
	GamePanel gp;

	public MOB_PinkSlime(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_mob;
		name = "Pink Slime";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 30;
		life = maxLife;
		attack = 5;
		defense = 1;
		exp = 4;
		knockBackPower = 2;
		
		solidArea.x = gp.tileSize*3/8;
		solidArea.y = gp.tileSize*3/8;
		solidArea.width = gp.tileSize*3/4;
		solidArea.height = gp.tileSize*3/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		getDeathImage();
	}
	public void getImage() {
		
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/enemy_slime/pink_slime_down_" + i, 1.5f, 1.5f);
             rightStanding[i] = setup("/enemy_slime/pink_slime_down_" +i, 1.5f, 1.5f);
             backStanding[i] = setup("/enemy_slime/pink_slime_down_" + i, 1.5f, 1.5f);
             frontWalking[i] = setup("/enemy_slime/pink_slime_movedown_" + i, 1.5f, 1.5f);
             rightWalking[i] = setup("/enemy_slime/pink_slime_movedown_" + i, 1.5f, 1.5f);
             backWalking[i] = setup("/enemy_slime/pink_slime_movedown_" + i, 1.5f, 1.5f);
         	}
	     for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
       		}
	}
	
    public void getDeathImage() {
	     for (int i = 0; i < 6; i++) {
            frontDeath[i] = setup("/enemy_slime/pink_slime_death_" + i, 1.5f, 1.5f);
	     }
   }
	
	public void setAction() {
    	if(onPath == true) {
    		
    		//Check if it stops chasing
    		checkStopChasingOrNot(gp.player, 15, 100);
        	
        	//Search direction to go
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));

    	}
    	else {
    		
    		//Check if it starts chasing
        	checkStartChasingOrNot(gp.player, 5, 100);
        	
        	//Get a random direction
        	getRandomDirection();

		}
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		onPath = true;
	}
	public void checkDrop() {
		
		//RANDOM NUMBER
		int i = new Random().nextInt(100)+1;
		//SET MONSTER DROP
		if(i < 50) {
			dropItem(new OBJ_Coin(gp));
		}
		if(i >= 50 && i < 75) {
			dropItem(new OBJ_Heart(gp));
		}
		if(i >= 75 && i < 100) {
			dropItem(new OBJ_ManaCrystal(gp));
		}
	}
	public Color getParticleColor() {
		Color color = new Color(255, 0, 255);
		return color;
	}
	public int getParticleSize() {
		int size = 5;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
}
