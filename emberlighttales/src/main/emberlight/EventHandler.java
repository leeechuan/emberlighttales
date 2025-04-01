package main.emberlight;

import java.awt.Rectangle;

import data.Progress;
import entity.Entity;

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
			if(hit(0, 27, 18,"right") == true) {
				damagePit(gp.dialogueState);
			}
			else if(hit(0, 28, 21,"any") == true) {
				healingPool(gp.dialogueState);
			}
			else if(hit(0, 16, 26,"any") == true) {
				teleport(1, 50, 50, gp.indoor);
				gp.playSE(14);
			}
			else if(hit(1, 50, 50,"any") == true) {
				teleport(0, 16, 26, gp.outside);
				gp.playSE(14);
			}
			else if(hit(0, 47, 54,"any") == true || hit(0, 48, 54,"any") == true) {
				teleport(2, 20, 30, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(2, 20, 30,"any") == true || hit(2, 21, 30,"any") == true) {
				teleport(0, 47, 55, gp.outside);
				gp.playSE(24);
			}
			else if(hit(2, 16, 21,"any") == true) {
				teleport(3, 50, 67, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(3, 50, 67,"any") == true) {
				teleport(2, 16, 21, gp.dungeon);
				gp.playSE(24);
			}
			else if(hit(3, 50, 58,"any") == true) {
				OrcChiefBattle();
			}
			else if(hit(0, 74, 80,"any") == true || hit(0, 75, 80,"any") == true || hit(0, 76, 80,"any") == true) {
				TownhallScene();
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
	public void TownhallScene() {
		
		if(Progress.gameStage == Progress.STAGE_INTRODUCTION || false) {
			gp.gameState = gp.cutsceneState;
			gp.csManager.scenePhase = 0;
			gp.csManager.sceneNum = gp.csManager.townhall;
			
		}
	}
}
