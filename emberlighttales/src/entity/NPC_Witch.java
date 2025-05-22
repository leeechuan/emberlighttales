package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import data.Progress;
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
    	townNum = 1;
        
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
			dialogues[0][3] = "But be warned... what I offer does not\ncome without consequence.";
		} 
		else if(gp.csManager.sceneNum == gp.csManager.witchSerum) {
			dialogues[0][0] = "So... you came. Good.";
			dialogues[0][1] = "You wish to face the orcs.\nTo go beyond the wall. ";
			dialogues[0][2] = "But brute strength alone won’t be enough—\nnot against what guards that Pearl.";
			dialogues[0][3] = "(She steps closer, holding up a vial filled\nwith thick, glowing green serum\nthat swirls unnaturally.)";
			dialogues[0][4] = "This… is my own design. A serum forged\nfrom gremlin essence, distilled through\nforgotten rites.";
			dialogues[0][5] = "Know this — once taken, you will never\nbe the same. You will be more than\nhuman... and less.";
			dialogues[0][6] = "But with this gift... you will be\nable to clear the rubble blocking\nthe eastern pass.";
			dialogues[0][7] = "And begin your journey to reclaim what\nwas lost.";
		}
		else if(Progress.gameStage == Progress.STAGE_MEET_WITCH && gp.eManager.lighting.dayState != gp.eManager.lighting.night) {
			dialogues[0][0] = "Not yet...";	
			dialogues[0][1] = "Meet me at night in my hut...";
			
			dialogues[1][0] = "Did you not hear what I just said?";	
			dialogues[1][1] = "Meet me at night in my hut...";

		} 
		else if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"))&&
				gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 0) {
			dialogues[0][0] = "You’re back. I felt a shift in\nthe wind... something violent.";	
			dialogues[0][1] = "(She finally turns, eyes scanning\nthe player.)";
			dialogues[0][2] = "You faced him, didn’t you?\nZulgar...";	
			dialogues[0][3] = "But the chief remains hidden. Of\ncourse he does";
			dialogues[0][4] = "The barrier protecting him... it's not\nsimple magic. Old. Layered. Possibly bound\nto the Emberlight Pearl itself.";
			dialogues[0][5] = "To unbind it without... consequences,\nI’ll need something rare.";
			dialogues[0][6] = "Sunmire Glassroot. Grows only in the\nsalt-glass dunes near Solara, a desert\ntown west of here.";
			dialogues[0][7] = "You’ll find a trader there that sells\nit... Bring me the root, and I’ll\ncast the spell.";

		} 
		else if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"))&&
				gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 2) {
			if(gp.player.searchItemInInventory("Sunmire Glassroot") != 999) {
				dialogues[0][0] = "Ah... I feel it. You’ve returned";	
				dialogues[0][1] = "Sunmire Glassroot. Still intact too.\nI’m impressed";
				dialogues[0][2] = "(She carefully places it into a small\nmortar and begins grinding it with\nslow, deliberate motions.)";	
				dialogues[0][3] = "This... will do. The ashes, once burned,\nwill cling to the old magic around\nGhorath's tent.";
				dialogues[0][4] = "Expose the seams. Let you in.";
				dialogues[0][5] = "(She tosses the ground root into the\ncauldron. It hisses, then bursts into\na sudden flash of blue flame.)";
				dialogues[0][6] = "It is done...";
				dialogues[0][7] = "But understand this... barriers like that\naren’t just built to keep others out...\nTake care.";
			}
			else {
				dialogues[0][0] = "Sunmire Glassroot... I sense\nyou had it?";	
				dialogues[0][1] = "Bring it to me... else I wont\nbe able to help you...";
				dialogues[0][2] = null;	
				dialogues[0][3] = null;
				dialogues[0][4] = null;
				dialogues[0][5] = null;
				dialogues[0][6] = null;
				dialogues[0][7] = null;
			}


		} 
		else {
			if(gp.player.isGremlin) {
			    dialogues[0][0] = "Look at you now, my little masterpiece!";
			    dialogues[0][1] = null;
			} else {
			    dialogues[0][0] = "Hue hue, you need somethin'?";
			    dialogues[0][1] = null;
			}
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
		
		if(Progress.gameStage == Progress.STAGE_MEET_WITCH && gp.eManager.lighting.dayState == gp.eManager.lighting.night) {
			gp.csManager.sceneNum = gp.csManager.witchSerum;
			gp.csManager.setDialogue();
			gp.csManager.scenePhase = 0;
			gp.gameState = gp.cutsceneState;

		}
		else if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"))&&
				gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 2 &&
				gp.player.searchItemInInventory("Sunmire Glassroot") != 999) {
			gp.player.inventory.remove(gp.player.searchItemInInventory("Sunmire Glassroot"));
			gp.qManager.progressQuest("Stolen Style");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"));
			gp.player.finishQuest(55, 85);
		}
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet = 0;
		}

		
	}

}
