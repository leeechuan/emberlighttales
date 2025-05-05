package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;
import object.OBJ_Suspicious_Juice;

public class NPC_Punk extends Entity {
	
	public static final String npcName = "Vex Cragstone";
	
	public NPC_Punk(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		name = npcName;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
		
    	homeWorldX = 50;
    	homeWorldY = 51;
    	outsideWorldX = 84;
    	outsideWorldY = 73;
    	homeMapNum = 8;
    	townNum = 1;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_punk/punk_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_punk/punk_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_punk/punk_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_punk/punk_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_punk/punk_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_punk/punk_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/punk_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "So what now?";
			dialogues[0][1] = "Just stand around while our home\ncrumbles?";
			dialogues[0][2] = "Pathetic... If nobody else is gonna do\nsomething, maybe I will.";
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Hey, you there! Fancy a sip of the\nfreshest, tastiest juice in Emberville?";
			dialogues[0][1] = "Name’s Vex. Purveyor of miracles in a\nbottle. Only for small price of 50 gold! ";
			dialogues[0][2] = "Let me know if you will be interested!\nYou won’t regret it.";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 0 &&
				gp.player.coin >= 50 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Ha! I knew you had taste... Thanks\nfor the coin!";
			dialogues[0][1] = "Don’t just carry it... drink it!\nIt really opens your mind... hehehe";
			dialogues[0][2] = "Side effects? Pfft. Only enlightenment.";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 0 &&
				gp.player.coin < 50 &&
				!gp.player.isGremlin) {
		    dialogues[0][0] = "Hey now, you’re a few coins short.";
		    dialogues[0][1] = "Juice this potent doesn’t come cheap\nfriend!";
		    dialogues[0][2] = "Come back when you’ve got the gold,\nand your taste buds ready.";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 4 &&
				!gp.player.isGremlin) {
		    dialogues[0][0] = "Alright, alright! No need to shout!";
		    dialogues[0][1] = "Here’s your gold back—and a little extra.\nCall it... hazard pay.";
		    dialogues[0][2] = "No more 'experimental batches'.\nStrictly citrus from now on, promise.";
		}
		else {
			dialogues[0][0] = "What you lookin' at...";		
			dialogues[0][1] = "Leave me alone!";	
			dialogues[0][2] = null;
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 0 &&
				gp.player.coin >= 50 &&
				!gp.player.isGremlin) {
			gp.player.coin -= 50;
			gp.player.inventory.add(new OBJ_Suspicious_Juice(gp));
			gp.qManager.progressQuest("The Suspicious Merchant");
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 4 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("The Suspicious Merchant");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"));
			gp.pManager.addNotification("Quest Completed!");
		}
		
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}

}
