package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;
import quest.Quest;

public class NPC_Mayor extends Entity {
	
	public static final String npcName = "Mayor Oren";
	
	public NPC_Mayor(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "down";
        defaultSpeed = 1;
        speed = defaultSpeed;
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
        
    	homeWorldX = 50;
    	homeWorldY = 50;
    	outsideWorldX = 51;
    	outsideWorldY = 85;
    	homeMapNum = 5;
    	townNum = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_mayor/mayor_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_mayor/mayor_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_mayor/mayor_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_mayor/mayor_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_mayor/mayor_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_mayor/mayor_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/mayor_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		if(gp.csManager.sceneNum == gp.csManager.townhall) {
			dialogues[0][0] = "Gather round, people of Emberville!\nQuickly now!";		
			dialogues[0][1] = "Last night, our home...our Emberville\nhas suffered a terrible attack!";	
			
			dialogues[1][0] = "The orcs… they raided us. Not just for\nfood, not just to pillage—but\nfor something far more precious. ";		
			dialogues[1][1] = "The Emberlight Pearl...";	
			dialogues[1][2] = "...is gone";
			
			dialogues[2][0] = "The Emberlight Pearl has been the\nheart of our town for generations...";		
			dialogues[2][1] = "Without it, our crops will wither\nour fires will grow cold";	
			dialogues[2][2] = "and Emberville itself may not survive\nthe coming months...";
			
			dialogues[3][0] = "We do not yet know their true intentions...";		
			dialogues[3][1] = "But what we do know is this — their leader,\nOrc Chief Ghorath personally led the raid.";	
			dialogues[3][2] = "It was planned... Precise...";
			dialogues[3][3] = "And if the Pearl remains in their\nhands for too long...";
			dialogues[3][4] = "...we may never get it back.";
			
			dialogues[4][0] = "No Vex... we will not stand idle.\nBut we must act wisely, not recklessly.";		
			dialogues[4][1] = "I need brave souls — those willing\nto track the orcs,to find where\nthey’ve taken the Emberlight Pearl.";	
			dialogues[4][2] = "If we act quickly, we may have a\nchance to reclaim it before it’s\nlost forever.";
		}
		else {
			if(gp.player.isGremlin) {
				dialogues[0][0] = "GREMLIN!";		
				dialogues[0][1] = "GET...GET AWAY FROM ME!!";	
			}
			else {
				dialogues[0][0] = "Good day!";		
				dialogues[0][1] = "Perfect weather for a stroll!";	
			}
			dialogues[1][0] = "Mission!";		
			dialogues[1][1] = "Do it!";	
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

		if (gp.qManager.getQuestJournal().getActiveQuests().stream().noneMatch(quest -> quest.getName().equals("Bound By Blood And Magic"))) {
	        // Start the quest if it's not already active
	        Quest mainQuest1 = gp.qManager.getQuestJournal().getQuestByName("Bound By Blood And Magic");
	        if (mainQuest1 != null && !mainQuest1.isCompleted()) {
	        	gp.qManager.getQuestJournal().addQuest(mainQuest1);
//	        	mainQuest1.advanceStage();
	        	startDialogue(this, 1); // Show the quest starting dialogue
	        }
	    }
		
		
		
		else {
			startDialogue(this, dialogueSet);
			
			dialogueSet++;
			
			if(dialogues[dialogueSet][0] == null) {
				
				dialogueSet--;
			}
		}

//		onPath = true;
	}
	
}
