package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Scientist extends Entity {
	
	public static final String npcName = "Dr. Thorne Baxter";
	
	public NPC_Scientist(GamePanel gp) {
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
    	outsideWorldX = 71;
    	outsideWorldY = 53;
    	homeMapNum = 10;
    	townNum = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_scientist/scientist_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_scientist/scientist_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_scientist/scientist_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_scientist/scientist_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_scientist/scientist_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_scientist/scientist_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/scientist_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "Mayor Oren, are they planning another\nattack?";	
			dialogues[0][1] = null;
			dialogues[0][2] = null;
			dialogues[0][3] = null;
			dialogues[0][4] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Wait! Stop right there!\nYes, you!";
			dialogues[0][1] = "During the orc raid, my lab suffered\na catastrophic breach!";
			dialogues[0][2] = "One of my field resonators was left behind\nin the old house by south beach.";
			dialogues[0][3] = "I tried going back for it, but I\nnearly got eaten by the orcs on the road.";
			dialogues[0][4] = "Please. Retrieve it for me, and\nI’ll owe you...science favors.";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				gp.player.searchItemInInventory("Field Resonator") != 999 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Ah! You found it! And it's\nonly...slightly singed.";
			dialogues[0][1] = "You’ve done a great service to\nexperimental integrity and vaguely\nsafe chemistry.";
			dialogues[0][2] = "Here, take this as thanks. It's\nnot radioactive. I think.";
			dialogues[0][3] = "...Probably shouldn't drop it, though.";
			dialogues[0][4] = null;
		}
		else {
			dialogues[0][0] = "Hmmm...";		
			dialogues[0][1] = "Oh! How long have you been staring\nat me?";	
			dialogues[0][2] = null;
			dialogues[0][3] = null;
			dialogues[0][4] = null;
			
			dialogues[1][0] = "Yes?";		
			dialogues[1][1] = "Chop chop I have work to do!";
			dialogues[1][2] = null;
			dialogues[1][3] = null;
			dialogues[1][4] = null;
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
				gp.player.searchItemInInventory("Field Resonator") != 999 &&
				!gp.player.isGremlin) {
			gp.player.inventory.remove(gp.player.searchItemInInventory("Field Resonator"));
			gp.qManager.progressQuest("Critical Malfunction");
			gp.qManager.progressQuest("Critical Malfunction"); //Just in case player already has in inventory
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"));
			gp.pManager.addNotification("Quest Completed!");
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

}
