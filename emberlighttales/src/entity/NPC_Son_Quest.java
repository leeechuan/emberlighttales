package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Son_Quest extends Entity {
	
	public static final String npcName = "Captured Wibby";
	
	public NPC_Son_Quest(GamePanel gp) {
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
		
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_son/son_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_son/son_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_son/son_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_son/son_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_son/son_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_son/son_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/son_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 1 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "What? Whoa! You’re real?";
			dialogues[0][1] = "So, uh... slight issue. I stepped on a\npressure plate, and this iron gate shut\nbehind me.";
			dialogues[0][2] = "I came out here to prove I could handle\nmyself. Everyone still treats me like I’m\nten.";
			dialogues[0][3] = "But... okay. Maybe sneaking into a cave\nwith one torch was a bad idea.";
			dialogues[0][4] = "Thanks for freeing me. Let’s just... not\nmake a big deal of this, yeah?";
		}
		else {
//			if(onPath) {
//				dialogues[0][0] = "Wait here?";		
//				dialogues[0][1] = "Umm... Okay... But please be back soon!";
//				dialogues[0][2] = null;
//				dialogues[0][3] = null;
//				dialogues[0][4] = null;
//			}else {
//				dialogues[0][0] = "Let's go back!";		
//				dialogues[0][1] = "I miss my bed...";
//				dialogues[0][2] = null;
//				dialogues[0][3] = null;
//				dialogues[0][4] = null;
//			}
		}
	}
	public void setAction() {
		
		if(onPath == true) {
			
			int goalCol = 20;
			int goalRow = 30;
//			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
//			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			
			searchPath(goalCol, goalRow);
		}
		else {
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

	}
	
	public void speak() {
		
		facePlayer();
		setDialogue();
		startDialogue(this, dialogueSet);
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 1 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("Where’s Wibby?");
			gp.pManager.addNotification("Journal Updated");
			onPath = true;
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
		onPath = true;
		speed = 2;
		
//		if(onPath) {
//			onPath = false;
//			speed = defaultSpeed;
//		}else {
//			onPath = true;
//			speed = 2;
//		}
		
	}

	
}
