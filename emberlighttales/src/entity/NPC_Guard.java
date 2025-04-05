package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Guard extends Entity {
	
	public static final String npcName = "Darnell Rootsman";
	
	public NPC_Guard(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "down";
        defaultSpeed = 0;
        speed = defaultSpeed;	
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
		
//    	homeWorldX = 54;
//    	homeWorldY = 51;
//    	outsideWorldX = 32;
//    	outsideWorldY = 16;
//    	homeMapNum = 13;
    	townNum = 0;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_guard/guard_down_" + i, 2.5f, 2.5f);
	                rightStanding[i] = setup("/npc_guard/guard_right_" +i, 2.5f, 2.5f);
	                backStanding[i] = setup("/npc_guard/guard_up_" + i, 2.5f, 2.5f);
	                frontWalking[i] = setup("/npc_guard/guard_movedown_" + i, 2.5f, 2.5f);
	                rightWalking[i] = setup("/npc_guard/guard_moveright_" + i, 2.5f, 2.5f);
	                backWalking[i] = setup("/npc_guard/guard_moveup_" + i, 2.5f, 2.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/guard_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.guardSpeak) {
			dialogues[0][0] = "By the Ember...Wh-what in the blazes—!?";
			dialogues[0][1] = "That... that form...you're not—are you\nstill—";
			dialogues[0][2] = "You're... one of us. Still you.\nRight?";
			dialogues[0][3] = "Look, I—I don’t know what the witch did\nto you, but if you’re not here to eat my\nface... I could actually use your help.";
			dialogues[0][4] = "There’s been movement near one of the\nold caves east of here. Tracks.\nBroken branches. Orc markings.";
			dialogues[0][5] = "I was going to check it out myself, but...";
			dialogues[0][6] = "You seem... a lot more qualified now";
			dialogues[0][7] = "(He takes a breath and nods respectfully.)";
			dialogues[0][8] = "You should look into it. If the orcs\nare planning something else... we’ll\nneed to know.";
			dialogues[0][9] = "Good luck out there... whatever you are.";
		}
		else {
			dialogues[0][0] = "Yes? What do you need?";
		}
		
	}
	public void setAction() {
		
//		actionLockCounter++;
//        
//		if(actionLockCounter == 120) {
//			Random random = new Random();
//			int i = random.nextInt(100) + 1; //pick number from 1 to 100
//			
//			if(i <= 20) {
//				direction = "up";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 20 && i <= 40) {
//				direction = "down";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 40 && i <= 60) {
//				direction = "left";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 60 && i <= 80) {
//				direction = "right";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 80 && i <= 100) {
//				speed = 0;
//				isWalking = false;
//			}
//			
//			actionLockCounter = 0;
//		}

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
