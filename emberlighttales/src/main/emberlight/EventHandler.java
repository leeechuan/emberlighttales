package main.emberlight;

import java.awt.Rectangle;

import data.Progress;
import entity.Entity;
import entity.NPC_Shopkeeper;
import entity.NPC_Son;
import entity.NPC_Son_Quest;

public class EventHandler{

	GamePanel gp;
	EventRect eventRect[][][];
	Entity eventMaster;
	
	int previousEventX, previousEventY;
	boolean canTouchEvent = true;
	int tempMap, tempCol, tempRow;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventMaster = new Entity(gp);
		
		eventRect = new EventRect[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];
		
		int map = 0;
		int col = 0;
		int row = 0;
		while(map < gp.maxMap && col < gp.maxWorldCol && row < gp.maxWorldRow) {
			
			eventRect[map][col][row] = new EventRect();
			eventRect[map][col][row].x = 23;
			eventRect[map][col][row].y = 23;
			eventRect[map][col][row].width = 2;
			eventRect[map][col][row].height = 2;
			eventRect[map][col][row].eventRectDefaultX = eventRect[map][col][row].x;
			eventRect[map][col][row].eventRectDefaultY = eventRect[map][col][row].y;
			
			col++;
			if(col == gp.maxWorldCol) {
				col = 0;
				row++;
				
				if(row == gp.maxWorldRow) {
					row = 0;
					map++;
				}
			}
		}
		
		setDialogue();
	}
	public void setDialogue() {
		
		eventMaster.dialogues[0][0] = "You fell into a pit!";
		eventMaster.dialogues[1][0] = "You drank some water.\nHP and mana is restored";
		eventMaster.dialogues[2][0] = "There is a werid energy stopping you\nfrom entering.";
		eventMaster.dialogues[3][0] = "The door is locked.";
		eventMaster.dialogues[4][0] = "I haven't warmed up yet!";
		eventMaster.dialogues[5][0] = "I never back down from a fight!";
	}
	public void checkEvent() {
		//Check if player character is more than 1 tile away from last event
		int xDistance = Math.abs(gp.player.worldX - previousEventX);
		int yDistance = Math.abs(gp.player.worldY - previousEventY);
		int distance = Math.max(xDistance, yDistance);
		if(distance > gp.tileSize) {
			canTouchEvent = true;
		}
		
		if(canTouchEvent == true) {
//			if(hit(0, 27, 18,"right") == true) {
//				damagePit(gp.dialogueState);
//			}
//			else if(hit(0, 28, 21,"any") == true) {
//				healingPool(gp.dialogueState);
//			}
//			else if(hit(0, 16, 26,"any") == true) {
//				teleport(1, 50, 50, gp.indoor);
//				gp.playSE(14);
//			}
//			else if(hit(1, 50, 50,"any") == true) {
//				teleport(0, 16, 26, gp.outside);
//				gp.playSE(14);
//			}
//			
			//CUTSCENES
			
			if(hit(2, 59, 79,"any") == true || hit(2, 60, 79,"any") == true ) {
				OrcLieutenantBattle();
			}
			else if(hit(0, 74, 29,"any") == true || hit(0, 75, 29, "any") == true || hit(0, 76, 29,"any") == true) {
				OrcSecondBattle();
			}
			else if(hit(3, 50, 58,"any") == true) {
				OrcChiefBattle();
			}
			else if(hit(3, 50, 60,"down") == true) {
				if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Price of War")) &&
						gp.qManager.getQuestJournal().getQuestByName("The Price of War").getCurrentStageIndex() == 1) {
					gp.gameState = gp.cutsceneState;
					gp.csManager.scenePhase = 0;
					gp.csManager.sceneNum = gp.csManager.ending2;
				}
				else if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Price of War")) &&
						gp.qManager.getQuestJournal().getQuestByName("The Price of War").getCurrentStageIndex() == 2) {
					gp.gameState = gp.cutsceneState;
					gp.csManager.scenePhase = 0;
					gp.csManager.sceneNum = gp.csManager.ending3;
				}
			}
			else if(hit(0, 70, 76,"any") == true || hit(0, 72, 76,"any") == true || hit(0, 71, 77,"any") == true) {
				TownhallScene();
			}
			else if(hit(0, 64, 62,"any") == true || hit(0, 64, 63,"any") == true || hit(0, 64, 64,"any") == true) {
				GuardSpeak();
			}
			
			//EMBERVILLE
			
			//Witch house
			else if(hit(0, 83, 84,"up") == true) {
				teleport(4, 43, 53, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(4, 43, 54,"any") == true) {
				teleport(0, 83, 84, gp.outside);
				gp.playSE(14);
			}
			else if(hit(4, 50, 44,"any") == true || hit(4, 51, 44,"any") == true) {
				teleport(4, 50, 24, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(4, 50, 25,"any") == true || hit(4, 51, 25,"any") == true) {
				teleport(4, 50, 45, gp.indoor);
				gp.playSE(14);
			}
			
			//Player house
			else if(hit(0, 71, 75,"up") == true) {
				teleport(21, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(21, 50, 51,"any") == true) {
				if(Progress.gameStage == Progress.STAGE_TUTORIAL) {
					gp.gameState = gp.dialogueState;
					eventMaster.startDialogue(eventMaster, 4);
					canTouchEvent = false;
				}
				else {
					teleport(0, 71, 76, gp.outside);
					gp.playSE(14);
				}
			}
			
			//Mayor house
			else if(hit(0, 51, 84,"up") == true) {
				teleport(5, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(5, 50, 51,"any") == true) {
				teleport(0, 51, 85, gp.outside);
				gp.playSE(14);
			}
			
			//Merchant house
			else if(hit(0, 61, 78,"up") == true) {
				teleport(6, 54, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(6, 54, 51,"any") == true) {
				teleport(0, 61, 79, gp.outside);
				gp.playSE(14);
			}
			
			//Couple house
			else if(hit(0, 68, 87,"up") == true) {
				teleport(7, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(7, 50, 51,"any") == true) {
				teleport(0, 68, 88, gp.outside);
				gp.playSE(14);
			}

			//Punk house
			else if(hit(0, 84, 73,"up") == true) {
				teleport(8, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(8, 50, 51,"any") == true) {
				teleport(0, 84, 74, gp.outside);
				gp.playSE(14);
			}
			
			//Gymbro house
			else if(hit(0, 87, 61,"up") == true) {
				teleport(9, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(9, 50, 51,"any") == true) {
				teleport(0, 87, 62, gp.outside);
				gp.playSE(14);
			}
			
			//Scientist house
			else if(hit(0, 71, 53,"up") == true) {
				teleport(10, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(10, 50, 51,"any") == true) {
				teleport(0, 71, 54, gp.outside);
				gp.playSE(14);
			}
			
			//Farmer house
			else if(hit(0, 87, 51,"up") == true) {
				teleport(11, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(11, 50, 51,"any") == true) {
				teleport(0, 87, 52, gp.outside);
				gp.playSE(14);
			}
			
			//Barn
			else if(hit(0, 83, 45,"up") == true || hit(0, 84, 45,"up") == true || hit(0, 85, 45,"up") == true) {
				teleport(24, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(24, 50, 51,"any") == true || hit(24, 49, 51,"any") == true || hit(24, 51, 51,"any") == true) {
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
						gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 2) {
					gp.gameState = gp.dialogueState;
					eventMaster.startDialogue(eventMaster, 3);
					canTouchEvent = false;
				}
				else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
						gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 3) {
					gp.qManager.progressQuest("The Suspicious Merchant");
					gp.pManager.addNotification("Journal Updated");
					teleport(0, 84, 46, gp.outside);
					gp.playSE(14);
				}
				else {
					teleport(0, 84, 46, gp.outside);
					gp.playSE(14);
				}
			}
			
			//Wood Cave
			else if(hit(0, 79, 58,"up") == true || hit(0, 80, 58,"up") == true || hit(0, 81, 58,"up") == true) {
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
						gp.qManager.getQuestJournal().getQuestByName("Stolen Style").getCurrentStageIndex() == 1 &&
						!gp.player.isGremlin) {
					gp.qManager.progressQuest("Stolen Style");
					gp.pManager.addNotification("Journal Updated");
				}
				teleport(25, 50, 50, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(25, 50, 51,"any") == true || hit(25, 49, 51,"any") == true || hit(25, 51, 51,"any") == true) {
				teleport(0, 80, 60, gp.outside);
				gp.playSE(24);
			}
			
			//Abandoned house
			else if(hit(0, 24, 77,"up") == true) {
				teleport(22, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(22, 50, 51,"any") == true) {
				teleport(0, 24, 78, gp.outside);
				gp.playSE(14);
			}
			
			
			//GILDENSHORE
			
			//President house
			else if(hit(0, 36, 12,"up") == true) {
				teleport(12, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(12, 50, 51,"any") == true) {
				teleport(0, 36, 13, gp.outside);
				gp.playSE(14);
			}
			
			//Scout house
			else if(hit(0, 32, 16,"up") == true) {
				teleport(13, 54, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(13, 54, 51,"any") == true) {
				teleport(0, 32, 17, gp.outside);
				gp.playSE(14);
			}
			
			//Fisherman house
			else if(hit(0, 20, 24,"up") == true) {
				teleport(14, 54, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(14, 54, 51,"any") == true) {
				teleport(0, 20, 25, gp.outside);
				gp.playSE(14);
			}
			
			//Thief house
			else if(hit(0, 21, 33,"up") == true) {
				teleport(15, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(15, 50, 51,"any") == true) {
				teleport(0, 21, 34, gp.outside);
				gp.playSE(14);
			}
			
			//Woodcutter house
			else if(hit(0, 35, 33,"up") == true) {
				teleport(16, 54, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(16, 54, 51,"any") == true) {
				teleport(0, 35, 34, gp.outside);
				gp.playSE(14);
			}
			
			//Elder house
			else if(hit(0, 47, 30,"up") == true) {
				teleport(17, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(17, 50, 51,"any") == true) {
				teleport(0, 47, 31, gp.outside);
				gp.playSE(14);
			}
			
			//Shopkeeper house
			else if(hit(0, 12, 39,"up") == true) {
				teleport(18, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(18, 50, 51,"any") == true) {
				teleport(0, 12, 39, gp.outside);
				gp.playSE(14);
			}
			
			//Windmill
			else if(hit(0, 57, 61,"up") == true) {
				gp.gameState = gp.dialogueState;
				eventMaster.startDialogue(eventMaster, 3);
				canTouchEvent = false;
			}
			
			//Orc Camp
			else if(hit(0, 58, 15,"up") == true) {
//				teleport(18, 50, 50, gp.indoor);
				if(Progress.gameStage < Progress.STAGE_DISABLED_FORCE_FIELD) {
					gp.gameState = gp.dialogueState;
					eventMaster.startDialogue(eventMaster, 2);
					canTouchEvent = false;
				}
				else {
					teleport(20, 50, 50, gp.indoor);
					gp.playSE(24);
				}
			}
			else if(hit(20, 50, 47,"any") == true) {
				teleport(3, 50, 67, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(3, 50, 67,"any") == true) {
				teleport(20, 50, 47, gp.indoor);
				gp.playSE(24);
			}
			
			//Dungeon 1
			
			else if(hit(0, 47, 54,"any") == true || hit(0, 48, 54,"any") == true) {
				if(Progress.gameStage == Progress.STAGE_FIND_ORC_LIEUTENANT && gp.qManager.getQuestJournal().getQuestByName("Beneath Enemy Lines").getCurrentStageIndex() == 0){
					gp.qManager.progressQuest("Beneath Enemy Lines");
					gp.pManager.addNotification("Journal Updated");
				}
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
						gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 0){
					gp.qManager.progressQuest("Where’s Wibby?");
					gp.pManager.addNotification("Journal Updated");
				}
				teleport(2, 20, 30, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(2, 20, 30,"any") == true || hit(2, 21, 30,"any") == true) {
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
						gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 2){
					// Remove instances of NPC_Son_Quest
					for (int map = 0; map < gp.npc.length; map++) {
					    for (int i = 0; i < gp.npc[map].length; i++) {
					        Entity npc = gp.npc[map][i];
					        if (npc != null && npc instanceof NPC_Son_Quest) {
					            gp.npc[map][i] = null;
					        }
					    }
					}

					// Add NPC_Son
					if(!gp.aSetter.npcExists(NPC_Son.npcName)) {
						NPC_Son newSon = new NPC_Son(gp); 
						newSon.worldX = 48 * gp.tileSize;
						newSon.worldY = 54 * gp.tileSize;
						for (int i = 0; i < gp.npc[0].length; i++) {
						    if (gp.npc[0][i] == null) {
						        gp.npc[0][i] = newSon;
						        break;
						    }
					}

					}
				}
				teleport(0, 47, 55, gp.outside);
				gp.playSE(24);
			}

			
			//SOLARA
			
			else if(hit(19, 77, 50,"any") == true || hit(19, 78, 50,"any") == true) {
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
						gp.qManager.getQuestJournal().getQuestByName("Dust and Glory").getCurrentStageIndex() == 0) {
					gp.qManager.progressQuest("Dust and Glory");
					gp.pManager.addNotification("Journal Updated");
				}
				teleport(23, 50, 50, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(23, 50, 50,"any") == true || hit(23, 51, 50,"any") == true) {
				if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
						gp.qManager.getQuestJournal().getQuestByName("Dust and Glory").getCurrentStageIndex() == 1) {
					gp.gameState = gp.dialogueState;
					eventMaster.startDialogue(eventMaster, 5);
					canTouchEvent = false;
				}
				else {
					teleport(19, 77, 51, gp.outside);
					gp.playSE(24);
				}
			}
			
			//GILDENSHORE
			
			
			//TOWN WELCOMES
			//Emberville
			else if(hit(0, 66, 62,"right") == true || hit(0, 66, 63,"right") == true || hit(0, 66, 64,"right") == true) {
				popup("Emberville");
			}
			//South Coast
			else if(hit(0, 63, 62,"left") == true || hit(0, 63, 63,"left") == true || hit(0, 63, 64,"left") == true) {
				popup("South Coast");
				if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
						gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
						gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked").getCurrentStageIndex() == 0
						) {
					gp.qManager.progressQuest("No Rest for the Wicked");
					gp.pManager.addNotification("Journal Updated");
				}
			}
			//South Coast
			else if(hit(0, 33, 64,"down") == true || hit(0, 34, 64,"down") == true || hit(0, 35, 64,"down") == true || hit(0, 36, 64,"down") == true || hit(0, 37, 64,"down") == true) {
				popup("South Coast");
			}
			//Gildenshore
			else if(hit(0, 33, 64,"up") == true || hit(0, 34, 64,"up") == true || hit(0, 35, 64,"up") == true || hit(0, 36, 64,"up") == true || hit(0, 37, 64,"up") == true) {
				popup("Gildenshore");
			}
			//Gildenshore
			else if(hit(0, 56, 35,"left") == true || hit(0, 56, 36,"left") == true || hit(0, 56, 37,"left") == true) {
				popup("Gildenshore");
			}
			//Orc Camp
			else if(hit(0, 65, 35,"right") == true || hit(0, 65, 36,"right") == true || hit(0, 65, 37,"right") == true) {
				if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Second's Fall")) &&
						gp.qManager.getQuestJournal().getQuestByName("Second's Fall").getCurrentStageIndex() == 0){
					gp.qManager.progressQuest("Second's Fall");
					gp.pManager.addNotification("Journal Updated");
				}
				popup("Orc Camp");
			}
			
		}

	}
	public boolean hit(int map, int col, int row, String reqDirection) {
		boolean hit = false;
		if(map == gp.currentMap) {
			gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
			gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
			eventRect[map][col][row].x = col * gp.tileSize + eventRect[map][col][row].x;
			eventRect[map][col][row].y = row * gp.tileSize + eventRect[map][col][row].y;
			
		    // **Expand event area slightly to account for in-between positions**
		    Rectangle expandedEventRect = new Rectangle(
		        eventRect[map][col][row].x - 12,
		        eventRect[map][col][row].y - 12,
		        eventRect[map][col][row].width + 24,
		        eventRect[map][col][row].height + 24
		    );
			
		    if (gp.player.solidArea.intersects(expandedEventRect) && !eventRect[map][col][row].eventDone) {
		        if (gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
		            hit = true;
		            previousEventX = gp.player.worldX;
		            previousEventY = gp.player.worldY;
		        }
		    }
			
			gp.player.solidArea.x = gp.player.solidAreaDefaultX;
			gp.player.solidArea.y = gp.player.solidAreaDefaultY;
			eventRect[map][col][row].x = eventRect[map][col][row].eventRectDefaultX;
			eventRect[map][col][row].y = eventRect[map][col][row].eventRectDefaultY;
		}

		return hit;
	}
	public void damagePit(int gameState) {
		
		gp.gameState = gameState;
		eventMaster.startDialogue(eventMaster, 0);
		gp.player.life -= 1;
//		eventRect[col][row].eventDone = true;
		canTouchEvent = false;
	}
	
	public void healingPool(int gameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gameState;
			gp.player.attackCancelled = true;
			eventMaster.startDialogue(eventMaster, 1);
			gp.player.life = gp.player.maxLife;
			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMobs();
		}
	}
	public void sleep() {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gp.sleepState;
			gp.player.attackCancelled = true;
//			gp.ui.currentDialogue = "You rested til morning.\nHP and mana is restored";
//			gp.gameState = gp.dialogueState;
//			gp.player.life = gp.player.maxLife;
//			gp.player.mana = gp.player.maxMana;
			gp.aSetter.setMobs();
		}
	}
	public void teleport(int map, int col, int row, int area) {
		
		gp.gameState = gp.transitionState;
		gp.nextArea = area;
		tempMap = map;
		tempCol = col;
		tempRow = row;
		canTouchEvent = false;
	}
	public void popup(String message) {
		
		gp.pManager.addPopup(message);
		canTouchEvent = false;
	}
	public void speak(Entity entity) {
		
		if(gp.keyH.enterPressed == true) {
			gp.gameState = gp.dialogueState;
			gp.player.attackCancelled = true;
			entity.speak();
		}
	}
	public void OrcChiefBattle() {
		
		if(gp.bossBattleOn == false && Progress.gameStage < Progress.STAGE_ORC_CHIEF_DEFEATED) {
			gp.gameState = gp.cutsceneState;
			gp.csManager.scenePhase = 0;
			gp.csManager.sceneNum = gp.csManager.orcChief;
			
		}
	}
	public void OrcLieutenantBattle() {
		
		if(gp.bossBattleOn == false && Progress.gameStage < Progress.STAGE_ORC_LIEUTENANT_DEFEATED) {
			if(gp.qManager.getQuestJournal().getQuestByName("Beneath Enemy Lines").getCurrentStageIndex() < 2) {
				gp.gameState = gp.cutsceneState;
				gp.csManager.scenePhase = 0;
				gp.csManager.sceneNum = gp.csManager.orcLieutenant;
				gp.qManager.progressQuest("Beneath Enemy Lines");
				gp.pManager.addNotification("Journal Updated");
			}
		}
	}
	public void OrcSecondBattle() {
		
		if(gp.bossBattleOn == false && Progress.gameStage < Progress.STAGE_ORC_SECONDINCOMMAND_DEFEATED) {
			if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Second's Fall")) &&
					gp.qManager.getQuestJournal().getQuestByName("Second's Fall").getCurrentStageIndex() == 1) {
				gp.gameState = gp.cutsceneState;
				gp.csManager.scenePhase = 0;
				gp.csManager.sceneNum = gp.csManager.orcSecond;
			}
		}
	}
	public void TownhallScene() {
		
		if(Progress.gameStage == Progress.STAGE_INTRODUCTION) {
			gp.gameState = gp.cutsceneState;
			gp.csManager.scenePhase = 0;
			gp.csManager.sceneNum = gp.csManager.townhall;
			
		}
	}
	public void GuardSpeak() {
		
		if(Progress.gameStage == Progress.STAGE_BRIDGE_RUBBLE_REMOVED) {
			gp.gameState = gp.cutsceneState;
			gp.csManager.scenePhase = 0;
			gp.csManager.sceneNum = gp.csManager.guardSpeak;
			
		}
	}
}
