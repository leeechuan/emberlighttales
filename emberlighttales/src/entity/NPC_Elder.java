package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;
import object.OBJ_Suspicious_Juice;

public class NPC_Elder extends Entity {
	
	public static final String npcName = "Elder Veldor";
	
	public NPC_Elder(GamePanel gp) {
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
    	outsideWorldX = 47;
    	outsideWorldY = 30;
    	homeMapNum = 17;
    	townNum = 2;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_elder/elder_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_elder/elder_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_elder/elder_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_elder/elder_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_elder/elder_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_elder/elder_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/elder_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Hey...have you a moment? My grandson...\nWibby... hasn’t come home.";
			dialogues[0][1] = "He's stubborn as a mule but this isn’t\nlike him. He’s been brooding lately,\nsaid something about proving himself.";
			dialogues[0][2] = "Last anyone saw him, he was heading south,\ntoward the old cave. I fear he’s gotten\nhimself into trouble.";
			dialogues[0][3] = "Please. If you find him... bring him back\nto me.";
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 2 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Wibby! You brought him back! Thank\nthe spirits!";
			dialogues[0][1] = "Thank you. I don’t know what would’ve\nhappened if you hadn’t found him. Here,\ntake this. It’s not much, but it’s yours.";
			dialogues[0][2] = null;
			dialogues[0][3] = null;
		}
		else {
			dialogues[0][0] = "Hmmm...";
			dialogues[0][1] = "You're different... I can tell...";
			dialogues[0][2] = null;
			dialogues[0][3] = null;

			dialogues[1][0] = "Yes?";
			dialogues[1][1] = null;
			dialogues[1][2] = null;
			dialogues[1][3] = null;
		}


	}
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; //pick number from 1 to 100
			
			if(i <= 25) {
				direction = "up";
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}		

	}
	
	public void speak() {
		
		setDialogue();
		facePlayer();
		startDialogue(this, dialogueSet);
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 2 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("Where’s Wibby?");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"));
			gp.player.finishQuest(35, 60);
		}

		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}
	
}
