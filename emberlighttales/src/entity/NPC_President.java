package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import data.Progress;
import main.emberlight.GamePanel;

public class NPC_President extends Entity {
	
	public static final String npcName = "Alaric Calloway";
	
	public NPC_President(GamePanel gp) {
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
    	outsideWorldX = 36;
    	outsideWorldY = 12;
    	homeMapNum = 12;
    	townNum = 1;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_president/president_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_president/president_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_president/president_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_president/president_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_president/president_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_president/president_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/president_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 1) {
			dialogues[0][0] = "A planned assault? East of here...";		
			dialogues[0][1] = "So it's begun. Ghorath moves faster\nthan we feared.";
			dialogues[0][2] = "You defeated Skarr? Then you've done more\nthan most of my guards. We owe you.";
			dialogues[0][3] = "But this won't stop the tide.\nIt was only the first wave.";
			dialogues[0][4] = "Please, go return to Emberville and tell\nMayor Oren we need supplies... and fast.\nReinforcements, if they can spare them.";
			dialogues[0][5] = "We can stand on our own—but not forever.\nLet’s not fall apart in silence.";
		}
		else if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 3) {
			dialogues[0][0] = "That's a relief. We can't afford\nto face this alone.";		
			dialogues[0][1] = "Now we need to strike back before they\ncan hit us again. ";
			dialogues[0][2] = "One of my scouts spotted another orc camp\neast of here. If we want to stop this,\nwe need to know what they’re planning.";
			dialogues[0][3] = "Go speak to Scout Rowan. He’s been tracking\ntheir movements and can point you\nto the camp’s location.";
			dialogues[0][4] = "The sooner we hit them, the better...";
		}
		else {
			dialogues[0][0] = "Hello there!";		
			dialogues[0][1] = "Need Sumthin?";

			dialogues[1][0] = "Yes?";
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
		
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril")) &&
				(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 1  || 
				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 3)) {
			gp.qManager.progressQuest("Sands of Peril");
			gp.pManager.addNotification("Journal Updated");
		}
//		setDialogue();
		facePlayer();
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}

		
	}

	
}
