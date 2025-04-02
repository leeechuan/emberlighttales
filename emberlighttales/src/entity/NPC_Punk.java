package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Punk extends Entity {
	
	public static final String npcName = "Vex Cragstone";
	
	public NPC_Punk(GamePanel gp) {
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
    	outsideWorldX = 84;
    	outsideWorldY = 73;
    	homeMapNum = 8;
    	townNum = 0;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_punk/punk_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_punk/punk_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_punk/punk_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_punk/punk_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_punk/punk_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_punk/punk_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/punk_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "So what now?";
			dialogues[0][1] = "Just stand around while our home\ncrumbles?";
			dialogues[0][2] = "Pathetic... If nobody else is gonna do\nsomething, maybe I will.";
		}
		else {
			dialogues[0][0] = "What you lookin' at...";		
			dialogues[0][1] = "...";	
			

			dialogues[1][0] = "Leave...";		
			dialogues[1][1] = "Me...";
			dialogues[1][2] = "Alone...";
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
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
		onPath = true;
	}

}
