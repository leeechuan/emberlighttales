package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Son extends Entity {
	
	public static final String npcName = "Jared Aldermere";
	
	public NPC_Son(GamePanel gp) {
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
		
    	homeWorldX = 51;
    	homeWorldY = 49;
    	outsideWorldX = 70;
    	outsideWorldY = 87;
    	homeMapNum = 7;
    	townNum = 0;
        
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
		
		if(onPath) {
			dialogues[0][0] = "Wait here?";		
			dialogues[0][1] = "Umm... Okay... But please be back soon!";
		}else {
			dialogues[0][0] = "I miss my family";		
			dialogues[0][1] = "Bring me back!!";
		}
			
	}
	public void setAction() {
		
		if(onPath == true) {
			
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
		setDialogue();
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
		if(onPath) {
			onPath = false;
		}else {
			onPath = true;
		}
		
	}

	
}
