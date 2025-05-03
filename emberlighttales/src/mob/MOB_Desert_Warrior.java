package mob;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Spike_Gate;

public class MOB_Desert_Warrior extends Entity {
	
	GamePanel gp;
	public static final String mobName = "Desert Warrior";
	
	public MOB_Desert_Warrior(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_mob;
		boss = false;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 110;
		life = maxLife;
		attack = 22;
		defense = 11;
		exp = 28;
		knockBackPower = 3;
		name = mobName;
//		sleep = true;

	    shadowWidth = 36;
	    shadowHeight = 10;
	    shadowXOffset = 18;
	    shadowYOffset = 50;
		
		solidArea.x = gp.tileSize*3/8;
		solidArea.y = gp.tileSize*3/8;
		solidArea.width = gp.tileSize*3/4;
		solidArea.height = gp.tileSize*3/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
//		attackArea.width = 48;
//		attackArea.height = 48;
		
		attackArea.width = gp.tileSize * 1;
		attackArea.height = gp.tileSize * 1;
		
		motion1_duration = 15;
		motion2_duration = 30;
		motion3_duration = 35;
		motion4_duration = 40;
		motion5_duration = 45;
		motion6_duration = 50;
		
		getImage();
		getDeathImage();
		setDialogue();
	}
	public void getImage() {
		
		int multiplier = 2;
		
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/enemy_desert_warrior/desert_warrior_down_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightStanding[i] = setup("/enemy_desert_warrior/desert_warrior_right_" +i, 1.5f*multiplier, 1.5f*multiplier);
             backStanding[i] = setup("/enemy_desert_warrior/desert_warrior_up_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontWalking[i] = setup("/enemy_desert_warrior/desert_warrior_movedown_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightWalking[i] = setup("/enemy_desert_warrior/desert_warrior_moveright_" + i, 1.5f*multiplier, 1.5f*multiplier);
             backWalking[i] = setup("/enemy_desert_warrior/desert_warrior_moveup_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontAttacking[i] = setup("/enemy_desert_warrior/desert_warrior_attackdown_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightAttacking[i] = setup("/enemy_desert_warrior/desert_warrior_attackright_" +i, 1.5f*multiplier, 1.5f*multiplier);
             backAttacking[i] = setup("/enemy_desert_warrior/desert_warrior_attackup_" + i, 1.5f*multiplier, 1.5f*multiplier);
         	}
	     for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
             leftAttacking[i] = invertImage(rightAttacking[i]);
       		}
	}
    public void getDeathImage() {
    	int multiplier = 1;
    	
	     for (int i = 0; i < 6; i++) {
            frontDeath[i] = setup("/enemy_desert_warrior/desert_warrior_death_" + i, 1.5f*multiplier, 1.5f*multiplier);
	     }
   }
    public void setDialogue() {
    	
    	dialogues[0][0] = "I have been waiting for you...";
    	dialogues[0][1] = "I'm craving human tonight...";
    }
	public void setAction() {
		
		if(rageState == false && life < maxLife/2) {
			rageState = true;
			defaultSpeed++;
			speed = defaultSpeed;
			attack += 2;
		}
    	
//    	if(onPath == true) {
//    		
//    		//Check if it stops chasing
//    		checkStopChasingOrNot(gp.player, 15, 100);
//        	
//        	//Search direction to go
//			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
//			
//    	}
		if(getTileDistance(gp.player) < 10) {
			
			moveTowardPlayer(60);
		}
    	else {
    		
//    		//Check if it starts chasing
//        	checkStartChasingOrNot(gp.player, 7, 100);
        	
        	//Get a random direction
        	getRandomDirection();
		}
    	
    	//Check if it attacks
    	if(isAttacking == false) {
    		checkAttackOrNot(60, gp.tileSize * 7, gp.tileSize*5);
    	}
		
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
//		direction = gp.player.direction;
//		onPath = true;
	}
	public void checkDrop() {

	}
	public Color getParticleColor() {
		Color color = new Color(25, 0, 50);
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

