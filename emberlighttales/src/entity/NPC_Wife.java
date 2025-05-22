package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Wife extends Entity {
	
	public static final String npcName = "Nessa Aldermere";
	
	public NPC_Wife(GamePanel gp) {
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
    	outsideWorldX = 68;
    	outsideWorldY = 87;
    	homeMapNum = 7;
    	townNum = 1;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_girl/girl0_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_girl/girl0_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_girl/girl0_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_girl/girl0_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_girl/girl0_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_girl/girl0_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         
	         portrait = setup("/artwork/wife_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "*gasps*";
			dialogues[0][1] = null;	
			dialogues[0][2] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Ugh, errands. Listen, I was gonna get\nsome stuff done today, but it’s just\nnot happening.";
			dialogues[0][1] = "Think you could help me out? I’ll owe\nyou one big time.";	
			dialogues[0][2] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 1 &&
				gp.player.searchItemInInventory("Water Bucket") != 999 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Oh, perfect! You’re a gem. I was this\nclose to doing it myself... okay, maybe\nnot that close.";
			dialogues[0][1] = "Next up — corn seeds. Ten of them. Crovin\nshould have some. You're the best!";	
			dialogues[0][2] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 3 &&
				gp.player.searchItemInInventory("Corn Seed") != 999 &&
				gp.player.inventory.get(gp.player.searchItemInInventory("Corn Seed")).amount >= 10 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "You got them? Amazing. Honestly, I should\nhire you.";
			dialogues[0][1] = "Heres 300 coin, hope that covers the seeds\nand your time.";
			dialogues[0][2] = "Thanks a bunch! Now... back to bed!";
		}
		else {
			if(gp.player.isGremlin) {
			    dialogues[0][0] = "My stars! You poor soul—stay back!";
				dialogues[0][1] = null;
				dialogues[0][2] = null;
			} else {
				dialogues[0][0] = "Hehe!";		
				dialogues[0][1] = "Good day!";
				dialogues[0][2] = null;
			}

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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("To Do List"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 1 &&
				gp.player.searchItemInInventory("Water Bucket") != 999 &&
				!gp.player.isGremlin) {
			gp.player.inventory.remove(gp.player.searchItemInInventory("Water Bucket"));
			gp.qManager.progressQuest("To Do List");
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 3 &&
				gp.player.searchItemInInventory("Corn Seed") != 999 &&
				gp.player.inventory.get(gp.player.searchItemInInventory("Corn Seed")).amount >= 10 &&
				!gp.player.isGremlin) {
			gp.player.inventory.get(gp.player.searchItemInInventory("Corn Seed")).amount -= 10;
			gp.qManager.progressQuest("To Do List");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("To Do List"));
			gp.player.finishQuest(20, 300);
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

}
