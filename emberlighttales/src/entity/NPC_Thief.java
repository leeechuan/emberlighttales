package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Thief extends Entity {
	
	public static final String npcName = "Cains Steelcloak";
	
	public NPC_Thief(GamePanel gp) {
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
    	outsideWorldX = 21;
    	outsideWorldY = 33;
    	homeMapNum = 15;
    	townNum = 2;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_thief/thief_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_thief/thief_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_thief/thief_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_thief/thief_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_thief/thief_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_thief/thief_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/thief_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getQuestByName("Stolen Style").getCurrentStageIndex() == 0 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Look, I didn’t steal the jacket. I just...\nborrowed it.";		
			dialogues[0][1] = "Okay, fine... maybe I took it without\nasking. But Luca was flaunting it\naround in my face.";
			dialogues[0][2] = "When I saw the guard coming, I panicked and\nran into the mines. Thought I could lose\nthem in the tunnels.";	
			dialogues[0][3] = "Something down there started growling... I\nfreaked out, tossed the jacket in a\nchest, and ran for it.";
			dialogues[0][4] = "You want it? Go get it. I’m not going back\nin there.";	
		}
		
		else {
			dialogues[0][0] = "What?";
			dialogues[0][1] = "Don't speak to me...";
			dialogues[0][2] = null;	
			dialogues[0][3] = null;
			dialogues[0][4] = null;	

			dialogues[1][0] = "Do I know you?";
			dialogues[1][1] = null;
			dialogues[1][2] = null;	
			dialogues[1][3] = null;
			dialogues[1][4] = null;	
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
		
		setDialogue();
		facePlayer();
		startDialogue(this, dialogueSet);
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
				gp.qManager.getQuestJournal().getQuestByName("Stolen Style").getCurrentStageIndex() == 0 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("Stolen Style");
			gp.pManager.addNotification("Journal Updated");
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

	
}
