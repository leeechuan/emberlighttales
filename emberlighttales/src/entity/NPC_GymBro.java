package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import data.Progress;
import main.emberlight.GamePanel;

public class NPC_GymBro extends Entity {
	
	public static final String npcName = "Bran Iron-Hands";
	
	public NPC_GymBro(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;	
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
		
    	homeWorldX = 50;
    	homeWorldY = 51;
    	outsideWorldX = 87;
    	outsideWorldY = 61;
    	homeMapNum = 9;
    	townNum = 1;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_gymbro/gymbro_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_gymbro/gymbro_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_gymbro/gymbro_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_gymbro/gymbro_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_gymbro/gymbro_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_gymbro/gymbro_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/gymbro_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "They were lucky I was a sleep...\nelse I would have smashed their skulls in!";	
			dialogues[0][1] = null;
			dialogues[0][2] = null;
			dialogues[0][3] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				Progress.gameStage > Progress.STAGE_BRIDGE_RUBBLE_REMOVED &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Yo! You look like you can throw down.";
			dialogues[0][1] = "My daily run zone...south beach has been\noverrun by bandits!";
			dialogues[0][2] = "How am I supposed to keep these calves\ncarved when I can't even sprint\nin peace?";
			dialogues[0][3] = "Help me out, will ya? Clear those guys\nout, and I'll owe you one.";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				!areBanditsRemaining()&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Trail's clear? You're a legend!";
			dialogues[0][1] = "I’m talkin’ sprints, lunges, full\nbeast mode! Brans' BACK!";
			dialogues[0][2] = "Here, take this! It’s no protein bar,\nbut it’s all I’ve got. Thanks,\nchamp.";
			dialogues[0][3] = null;
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				areBanditsRemaining()&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "You been to the south trail yet?";
			dialogues[0][1] = "Still crawling with those bandit\nclowns, huh?";
			dialogues[0][2] = "Can’t exactly do hill sprints through\na sword fight.";
			dialogues[0][3] = "Come on, champ! I’m countin’\non you!";
		}
		else {
			dialogues[0][0] = "Just hit my PR yesterday...";		
			dialogues[0][1] = "Carried 10 chickens at once!";
			dialogues[0][2] = null;
			dialogues[0][3] = null;
		}
	}
	public void setAction() {
		
		actionLockCounter++;
        
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; //pick number from 1 to 100
			
			if(i <= 20) {
				direction = "up";
				isWalking = true;
				speed = defaultSpeed;
			}
			if(i > 20 && i <= 40) {
				direction = "down";
				isWalking = true;
				speed = defaultSpeed;
			}
			if(i > 40 && i <= 60) {
				direction = "left";
				isWalking = true;
				speed = defaultSpeed;
			}
			if(i > 60 && i <= 80) {
				direction = "right";
				isWalking = true;
				speed = defaultSpeed;
			}
			if(i > 80 && i <= 100) {
				speed = 0;
				isWalking = false;
			}
			
			actionLockCounter = 0;
		}	

	}
	
	public void speak() {
		
		setDialogue();
		facePlayer();
		startDialogue(this, dialogueSet);
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				Progress.gameStage > Progress.STAGE_BRIDGE_RUBBLE_REMOVED &&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
				!areBanditsRemaining() &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("No Rest for the Wicked");
			gp.qManager.progressQuest("No Rest for the Wicked"); //Just in case player already has in inventory
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"));
			gp.player.finishQuest(25, 50);
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}

}
