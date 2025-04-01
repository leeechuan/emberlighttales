package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Chicken extends Entity {
	
	public static final String npcName = "Henry the Bee";
	
	public NPC_Chicken(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "right";
        defaultSpeed = 1;
        speed = defaultSpeed;
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize*2/3, gp.tileSize*2/3);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
		
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
		
		dialogues[0][0] = "Buzzzz";		
		
		dialogues[1][0] = "Buzzzzzzzz";		
		dialogues[1][1] = "Buzz buzzzzzzzz";

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
	
//	public void speak() {
//		
//		facePlayer();
//		startDialogue(this, dialogueSet);
//		
//		dialogueSet++;
//		
//		if(dialogues[dialogueSet][0] == null) {
//			
//			dialogueSet--;
//		}
//		
//		onPath = true;
//	}
	
}
