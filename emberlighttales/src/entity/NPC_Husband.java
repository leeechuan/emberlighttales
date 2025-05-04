package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Husband extends Entity {
	
	public static final String npcName = "Luca Aldermere";
	
	public NPC_Husband(GamePanel gp) {
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
    	homeWorldY = 50;
    	outsideWorldX = 69;
    	outsideWorldY = 87;
    	homeMapNum = 7;
    	townNum = 1;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_boy/npc_boy_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_boy/npc_boy_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_boy/npc_boy_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_boy/npc_boy_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_boy/npc_boy_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_boy/npc_boy_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/husband_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Ugh! Can you believe it?! My favourite\nyellow jacket is gone again.";		
			dialogues[0][1] = "I bet it's that theiving rat Cain from\nGildenshore. I've seen him eyeing my jacket\neverytime I wear it out...";
			dialogues[0][2] = "Find him, would you? For justice...\nand fashion.";	
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.player.searchItemInInventory("Luca's Jacket") != 999 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "You found it! My precious jacket!";		
			dialogues[0][1] = "Ugh, it smells like cave moss... but I\ndon’t even care. You are a lifesaver!";	
			dialogues[0][2] = "Cain can keep his jealous little hands\nto himself next time. Thank you!";
		}
		else {
			dialogues[0][0] = "Hello there!";		
			dialogues[0][1] = "Need Sumthin";	
			dialogues[0][2] = null;
			

			dialogues[1][0] = "I used to be an adventurer like you...";		
			dialogues[1][1] = null;
			dialogues[1][2] = null;
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.player.searchItemInInventory("Luca's Jacket") != 999 &&
				!gp.player.isGremlin) {
			gp.player.inventory.remove(gp.player.searchItemInInventory("Luca's Jacket"));
			gp.qManager.progressQuest("Stolen Style");
			gp.qManager.progressQuest("Stolen Style"); //Just in case player already has in inventory
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"));
			gp.pManager.addNotification("Quest Completed!");
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}

	}

	
}
