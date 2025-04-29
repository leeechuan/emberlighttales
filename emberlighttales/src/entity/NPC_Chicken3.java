package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Chicken3 extends Entity {
	
	public static final String npcName = "Eggatha Christie";
	public boolean caught = false;
	
	public NPC_Chicken3(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "right";
        defaultSpeed = 1;
        speed = defaultSpeed;
		name = npcName;
		
		townNum = 0;
		
        solidArea = new Rectangle(18, 24, gp.tileSize*2/3, gp.tileSize*2/3);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
        
        if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger").getCurrentStageIndex() < 3) {
        	worldX = 73 * gp.tileSize;
        	worldY = 54 * gp.tileSize;
        }
        else {
        	worldX = 79 * gp.tileSize;
        	worldY = 47 * gp.tileSize;
        }
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/animals/chicken_stand_" + i, 2f, 2f);
	                leftStanding[i] = setup("/animals/chicken_stand_" +i, 2f, 2f);
	                backStanding[i] = setup("/animals/chicken_stand_" + i, 2f, 2f);
	                frontWalking[i] = setup("/animals/chicken_move_" + i, 2f, 2f);
	                leftWalking[i] = setup("/animals/chicken_move_" + i, 2f, 2f);
	                backWalking[i] = setup("/animals/chicken_move_" + i, 2f, 2f);
	            }
	         for (int i = 0; i < 6; i++) {
	                rightStanding[i] = invertImage(leftStanding[i]);
	                rightWalking[i] = invertImage(leftWalking[i]);
	          	}
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Bok";		
		
		dialogues[1][0] = "Bokkkkkkkkk";		
		dialogues[1][1] = "Bok Bok";

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
		
		if(!caught) {
			caught = true;
		}
		
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))) {
			gp.qManager.progressQuest("Cluck and Dagger");
			gp.pManager.addNotification("Journal Updated");
	        if(!caught) {
	        	worldX = 73 * gp.tileSize;
	        	worldY = 54 * gp.tileSize;
	        }
	        else {
	        	worldX = 79 * gp.tileSize;
	        	worldY = 47 * gp.tileSize;
	        }
		}
		
		facePlayer();

		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}
	
}
