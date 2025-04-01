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
		
		dialogues[0][0] = "Hello there!";		
		dialogues[0][1] = "Need Sumthin";	
		

		dialogues[1][0] = "I used to be an adventurer like you...\nUntil I took an arrow to the knee";		
		dialogues[1][1] = "What chu want";
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
