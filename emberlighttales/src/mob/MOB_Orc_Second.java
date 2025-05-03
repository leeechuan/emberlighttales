package mob;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Spike_Gate;

public class MOB_Orc_Second extends Entity {
	
	GamePanel gp;
	public static final String mobName = "Orc Second-In-Command Zulgar Ironheart";
	
	public MOB_Orc_Second(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_mob;
		boss = true;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 130;
		life = maxLife;
		attack = 26;
		defense = 15;
		exp = 36;
		knockBackPower = 5;
		name = mobName;
		direction = "down";
		sleep = true;
		
	    shadowWidth = 64;
	    shadowHeight = 14;
	    shadowXOffset = 2;
	    shadowYOffset = 88;
		
		
		solidArea.x = gp.tileSize;
		solidArea.y = gp.tileSize;
		solidArea.width = gp.tileSize*3/2;
		solidArea.height = gp.tileSize*3/2;
		
//		attackArea.width = 48;
//		attackArea.height = 48;
		
		attackArea.width = gp.tileSize * 2;
		attackArea.height = gp.tileSize * 2;
		
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
             frontStanding[i] = setup("/enemy_orc_second/orc_second_down_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightStanding[i] = setup("/enemy_orc_second/orc_second_right_" +i, 1.5f*multiplier, 1.5f*multiplier);
             backStanding[i] = setup("/enemy_orc_second/orc_second_up_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontWalking[i] = setup("/enemy_orc_second/orc_second_movedown_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightWalking[i] = setup("/enemy_orc_second/orc_second_moveright_" + i, 1.5f*multiplier, 1.5f*multiplier);
             backWalking[i] = setup("/enemy_orc_second/orc_second_moveup_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontAttacking[i] = setup("/enemy_orc_second/orc_second_attackdown_" + i, 3f*multiplier, 3f*multiplier);
             rightAttacking[i] = setup("/enemy_orc_second/orc_second_attackright_" +i, 3f*multiplier, 3f*multiplier);
             backAttacking[i] = setup("/enemy_orc_second/orc_second_attackup_" + i, 3f*multiplier, 3f*multiplier);
         	}
	     for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
             leftAttacking[i] = invertImage(rightAttacking[i]);
       		}
	}
    public void getDeathImage() {
    	int multiplier = 2;
    	
	     for (int i = 0; i < 6; i++) {
            frontDeath[i] = setup("/enemy_orc_second/orc_second_death_" + i, 1.5f*multiplier, 1.5f*multiplier);
	     }
   }
    public void setDialogue() {
    	
    	dialogues[0][0] = "The little gremlin from Emberville....";
    	dialogues[0][1] = "(He snorts, cracking his neck.)";
    	dialogues[0][2] = "You’ve been making trouble. Slaughtering\ngood men. Stirring up old wounds.";
    	dialogues[0][3] = "You think you’re ready to face\nChief Ghorath?";
    	dialogues[0][4] = "You’re not. Because he carries more\nthan strength. He carries truth.\nAnd you lot aren’t ready for that.";
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
		gp.bossBattleOn = false;
		Progress.updateStage(Progress.STAGE_ORC_SECONDINCOMMAND_DEFEATED);
		gp.qManager.progressQuest("Second's Fall");
		gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Second's Fall"));
		gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"));
		gp.pManager.addNotification("Journal Updated");
		
		//Restore previous music
		gp.stopMusic();
		gp.playMusic(0);
		

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

