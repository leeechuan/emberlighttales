package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

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
    	townNum = 1;
		
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
		
		dialogues[0][0] = "Hmmm...";
		dialogues[1][0] = "You're different... I can tell...";

		dialogues[1][0] = "Yes?";

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
		
		facePlayer();
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}
	
}
