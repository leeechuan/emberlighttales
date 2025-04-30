package mob;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Spike_Gate;

public class MOB_Orc_Chief extends Entity {
	
	GamePanel gp;
	public static final String mobName = "Orc Chief Ghorath Bloodbane";
	
	public MOB_Orc_Chief(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_mob;
		boss = true;
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 200;
		life = maxLife;
		attack = 28;
		defense = 18;
		exp = 50;
		knockBackPower = 5;
		name = mobName;
		sleep = true;
		
//		solidArea.x = gp.tileSize*3/8;
//		solidArea.y = gp.tileSize*3/8;
//		solidArea.width = gp.tileSize*3/4;
//		solidArea.height = gp.tileSize*3/4;
//		solidAreaDefaultX = solidArea.x;
//		solidAreaDefaultY = solidArea.y;
		
		
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
             frontStanding[i] = setup("/enemy_orc_chief/orc_chief_down_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightStanding[i] = setup("/enemy_orc_chief/orc_chief_right_" +i, 1.5f*multiplier, 1.5f*multiplier);
             backStanding[i] = setup("/enemy_orc_chief/orc_chief_up_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontWalking[i] = setup("/enemy_orc_chief/orc_chief_movedown_" + i, 1.5f*multiplier, 1.5f*multiplier);
             rightWalking[i] = setup("/enemy_orc_chief/orc_chief_moveright_" + i, 1.5f*multiplier, 1.5f*multiplier);
             backWalking[i] = setup("/enemy_orc_chief/orc_chief_moveup_" + i, 1.5f*multiplier, 1.5f*multiplier);
             frontAttacking[i] = setup("/enemy_orc_chief/orc_chief_attackdown_" + i, 3f*multiplier, 3f*multiplier);
             rightAttacking[i] = setup("/enemy_orc_chief/orc_chief_attackright_" +i, 3f*multiplier, 3f*multiplier);
             backAttacking[i] = setup("/enemy_orc_chief/orc_chief_attackup_" + i, 3f*multiplier, 3f*multiplier);
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
            frontDeath[i] = setup("/enemy_orc_chief/orc_chief_death_" + i, 1.5f*multiplier, 1.5f*multiplier);
	     }
   }
    public void setDialogue() {
    	
    	dialogues[0][0] = "So... you made it past the barrier. I\nsuppose Morgra still weaves her tricks.";
    	dialogues[0][1] = "You think you’re here to take back what's\nyours. But you never knew what it\nwas to begin with.";
    	dialogues[0][2] = "(He gestures to the Pearl behind the\ngate. Light more subdued than before.)";
    	dialogues[0][3] = "This... this was ours. Long before\nEmberville grew greedy. Before they\ncalled it a pearl.";
    	dialogues[0][4] = "To us, it was Na’tharin — our heartfire.\nA gift that kept our lands alive.\nBalanced. Pure.";
    	dialogues[0][5] = "Then your people came. Took it. Said\nthey needed it more. Said we were savages.\nBut we weren’t. We were just... different.";
    	dialogues[0][6] = "Morgra led the charge. Back then, she\nwasn’t a witch—she was your mayor.\n";
    	dialogues[0][7] = "She used her cursed serum on our\nvillage head... my mother.";
    	dialogues[0][8] = "Said it would ‘even the odds.’ It twisted\nher... made her strong. But not human.";
    	dialogues[0][9] = "And the rest of us? Born like this.\nBorn monsters. Not by choice. By poison.";
    	dialogues[0][10] = "I stole the Pearl not for war, but hope.\nMaybe with it, I could buy peace.\nForce a cure...";
    	dialogues[0][11] = "So tell me, gremlin-blood. Do you really\nthink you’re so different from me?";
    	dialogues[0][12] = "You can strike me down. Take the Pearl.\nReturn a hero to those who never questioned\nthe stories they were told.";
    	dialogues[0][13] = "Or you can walk away. Leave this place\nknowing the truth—and letting it matter\nmore than vengeance ever could.";
    	dialogues[0][14] = "The choice is yours.";
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
		Progress.updateStage(Progress.STAGE_ORC_CHIEF_DEFEATED);
		
		//Restore previous music
		gp.stopMusic();
		gp.playMusic(21);
		
		//Remove the iron doors
		for(int i = 0; i < gp.obj[1].length; i++) {
			if(gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Spike_Gate.objName)) {
				gp.playSE(18);
				gp.obj[gp.currentMap][i] = null;
			}
		}
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Price of War")) &&
				gp.qManager.getQuestJournal().getQuestByName("The Price of War").getCurrentStageIndex() == 1) {
			gp.qManager.progressQuest("The Price of War");
			gp.pManager.addNotification("Journal Updated");
		}
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

