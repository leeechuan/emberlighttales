package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Farmer extends Entity {
	
	public static final String npcName = "Bram Tiller";
	
	public NPC_Farmer(GamePanel gp) {
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
    	homeWorldY = 51;
    	outsideWorldX = 87;
    	outsideWorldY = 51;
    	homeMapNum = 11;
    	townNum = 0;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_farmer/farmer_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_farmer/farmer_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_farmer/farmer_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_farmer/farmer_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_farmer/farmer_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_farmer/farmer_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/farmer_portrait", 3f, 3f);
	}
	public void setDialogue() {
		

		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "The Pearl? But without it...";
			dialogues[0][1] = null;
			dialogues[0][2] = null;
			dialogues[0][3] = null;
			dialogues[0][4] = null;
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "You! You're quick on your feet, right?";
			dialogues[0][1] = "After the orc raid, my poor chickens\npanicked and scattered everywhere like\nfeathered fools!";
			dialogues[0][2] = "They’re out there—hiding in bushes, behind\ncrates...";
			dialogues[0][3] = "I’d go get 'em myself, but my back’s\ngot more cracks than a dry loaf\nof cornbread.";
			dialogues[0][4] = "Be a good soul and round them up for\nme, would ya?";
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger").getCurrentStageIndex() == 3 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Well I’ll be! You found the whole flock!";
			dialogues[0][1] = "They’re filthy, scared, and loud...\njust how I left ‘em.";
			dialogues[0][2] = "You’ve done this old farmer a world of\ngood. Couldn’t let those orc-lovin’\negg layers run wild.";
			dialogues[0][3] = "Here take this. It ain’t much, but\nit’s honest thanks.";
			dialogues[0][4] = "Oh, and if one of 'em follows you home...\nthat one's yours now.";
		}
		else {
			dialogues[0][0] = "Hmmm...";		
			dialogues[0][1] = "Hope it rains soon...";
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
				gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger").getCurrentStageIndex() == 3 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("Cluck and Dagger");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"));
			gp.pManager.addNotification("Quest Completed!");
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}
	
	
}
