package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_FirstLady extends Entity {
	
	public static final String npcName = "Eleanor Calloway";
	
	public NPC_FirstLady(GamePanel gp) {
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
    	homeWorldY = 49;
    	outsideWorldX = 36;
    	outsideWorldY = 13;
    	homeMapNum = 12;
    	townNum = 2;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_firstlady/firstlady_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_firstlady/firstlady_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_firstlady/firstlady_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_firstlady/firstlady_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_firstlady/firstlady_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_firstlady/firstlady_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/firstlady_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.player.isGremlin) {
		    dialogues[0][0] = "AHHHHHHH! SOMEONE HELP!";
		} else {
		    dialogues[0][0] = "A pleasure to see you, dear.";
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
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

	
}
