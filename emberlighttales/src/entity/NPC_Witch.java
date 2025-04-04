package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Witch extends Entity {
	
	public static final String npcName = "Witch Morga";
	
	public NPC_Witch(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		name = npcName;
		direction = "up";
        defaultSpeed = 2;
        speed = defaultSpeed;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
		
    	homeWorldX = 43;
    	homeWorldY = 54;
    	outsideWorldX = 83;
    	outsideWorldY = 84;
    	homeMapNum = 4;
    	townNum = 0;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_witch/npc_witch_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_witch/npc_witch_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_witch/npc_witch_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_witch/npc_witch_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_witch/npc_witch_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_witch/npc_witch_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/witch_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "Mayor... if I may speak...";
			dialogues[0][1] = "If we are to fight the orcs, if we\nare to take back what was stolen...\nyou will need more than steel and courage.";
			dialogues[0][2] = "For those who truly wish to change\nEmberville’s fate... come to my house\nafter dark.";
			dialogues[0][3] = "But be warned—what I offer does not\ncome without consequence.";
		} else {
			dialogues[0][0] = "Hue hue!";	
			dialogues[0][1] = "Need Sumthn";			
			dialogues[0][2] = "Yes?";
			
			dialogues[1][0] = "WEEHU!";
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
		
		facePlayer();
		startDialogue(this, dialogueSet);
		
	}

}
