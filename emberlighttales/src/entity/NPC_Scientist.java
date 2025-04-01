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
		}
		else {
			dialogues[0][0] = "Hmmm...";		
			dialogues[0][1] = "Oh! How long have you been staring\nat me?";	
			
			dialogues[1][0] = "Yes?";		
			dialogues[1][1] = "Chop chop I have work to do!";
		}

	}
	public void setAction() {
		
		if(onPath == true) {
			
//			int goalCol = 18;
//			int goalRow = 19;
			int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
			int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;
			
			searchPath(goalCol, goalRow);
		}
		else {
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

	}
	
	public void speak() {
		
		facePlayer();
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
		onPath = true;
	}
	
}
