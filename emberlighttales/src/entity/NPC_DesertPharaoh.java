package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_DesertPharaoh extends Entity {
	
	public static final String npcName = "Pharaoh Ahmuron";
	
	public NPC_DesertPharaoh(GamePanel gp) {
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
		
//    	homeWorldX = 54;
//    	homeWorldY = 51;
//    	outsideWorldX = 35;
//    	outsideWorldY = 33;
//    	homeMapNum = 16;
    	townNum = 3;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_desert_pharaoh/desert_pharaoh_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_desert_pharaoh/desert_pharaoh_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_desert_pharaoh/desert_pharaoh_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_desert_pharaoh/desert_pharaoh_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_desert_pharaoh/desert_pharaoh_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_desert_pharaoh/desert_pharaoh_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/desert_pharaoh_portrait", 3f, 3f);
	}
	public void setDialogue() {

		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				!gp.player.isGremlin) {
			dialogues[0][0] = "Traveler... the sands whisper of movement\nbeneath the Temple of Light.";
			dialogues[0][1] = "An Ancient Guardian, long sealed, now\nstirs. I ask not lightly... but Solara\nneeds your blade.";
			dialogues[0][2] = "Bring peace to the temple... and to those\nwho once guarded it with honor.";
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				gp.qManager.getQuestJournal().getQuestByName("Dust and Glory").getCurrentStageIndex() == 2 &&
				!gp.player.isGremlin) {
			dialogues[0][0] = "The silence from the sands tells me the\ndeed is done.";
			dialogues[0][1] = "You’ve done more than slay a beast. You've\ncalmed a spirit bound by duty.";
			dialogues[0][2] = "Solara is in your debt.";
		}
		else {
			dialogues[0][0] = "What do you need?";
			dialogues[0][1] = null;
			dialogues[0][2] = null;
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				!gp.player.isGremlin) {
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"));
			gp.pManager.addNotification("Journal Updated");
		}
		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
				gp.qManager.getQuestJournal().getQuestByName("Dust and Glory").getCurrentStageIndex() == 2 &&
				!gp.player.isGremlin) {
			gp.qManager.progressQuest("Dust and Glory");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"));
			gp.player.finishQuest(50, 120);
		}
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

	
}
