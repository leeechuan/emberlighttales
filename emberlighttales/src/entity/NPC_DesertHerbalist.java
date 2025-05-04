package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_DesertHerbalist extends Entity {
	
	public static final String npcName = "Tala Nireh";
	
	public NPC_DesertHerbalist(GamePanel gp) {
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
		
//    	homeWorldX = 54;
//    	homeWorldY = 51;
//    	outsideWorldX = 35;
//    	outsideWorldY = 33;
//    	homeMapNum = 16;
    	townNum = 3;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_desert_npc2/desert_npc2_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_desert_npc2/desert_npc2_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_desert_npc2/desert_npc2_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_desert_npc2/desert_npc2_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_desert_npc2/desert_npc2_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_desert_npc2/desert_npc2_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/desert_herbalist_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "I’ve been trying to craft a calming\nsalve, but I need sunflowers\nto finish it.";		
			dialogues[0][1] = "They don’t grow anywhere near here.\nThe desert is far too dry.";
			dialogues[0][2] = "Do you think you could help me obtain\nsome sunflowers? Try Gildenshore, I’ve\nheard the trader there might carry seeds.";
			dialogues[0][3] = null;
			dialogues[0][4] = null;	
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				gp.player.searchItemInInventory("Sunflower") != 999 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "You actually grew one! It’s beautiful...\nexactly what I needed.";		
			dialogues[0][1] = "Thank you. You’ve brought a little warmth\nto this dry land.";
			dialogues[0][2] = "Here is something for your troubles!";	
			dialogues[0][3] = null;
			dialogues[0][4] = null;	
		}
		else {
			dialogues[0][0] = "Yes?";
			dialogues[0][1] = null;
			dialogues[0][2] = null;	
			dialogues[0][3] = null;
			dialogues[0][4] = null;	
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
				gp.player.searchItemInInventory("Sunflower") != 999 &&
				!gp.player.isGremlin) {
			gp.player.inventory.remove(gp.player.searchItemInInventory("Sunflower"));
			gp.qManager.progressQuest("Seeds of Solace");
			gp.qManager.progressQuest("Seeds of Solace"); //Just in case player already has in inventory
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"));
			gp.pManager.addNotification("Quest Completed!");
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

	
}
