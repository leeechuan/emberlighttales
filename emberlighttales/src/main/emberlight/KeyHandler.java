package main.emberlight;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import data.Progress;

public class KeyHandler implements KeyListener {
	
	GamePanel gp;
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, attackPressed, shotKeyPressed, blockPressed, characterPressed, gremlinPressed, journalPressed, rollPressed;
	//DEBUG
	public boolean showDebugText = false;
	public boolean godModeOn = false;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			titleState(code);
		}
		//PLAY STATE
		else if(gp.gameState == gp.playState) {
			playState(code);
		}
		//PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			pauseState(code);
		}
		//DIALOGUE STATE OR CUTSCENE STATE
		else if(gp.gameState == gp.dialogueState || gp.gameState == gp.cutsceneState) {
			dialogueState(code);
		}
		//CHARACTER STATE
		else if(gp.gameState == gp.characterState) {
			characterState(code);
		}
		//OPTIONS STATE
		else if(gp.gameState == gp.optionsState) {
			optionsState(code);
		}
		//GAME OVER STATE
		else if(gp.gameState == gp.gameOverState) {
			gameOverState(code);
		}
		//TRADE STATE
		else if(gp.gameState == gp.tradeState) {
			tradeState(code);
		}
		//MAP STATE
		else if(gp.gameState == gp.mapState) {
			mapState(code);
		}
		//JOURNAL STATE
		else if(gp.gameState == gp.journalState) {
			journalState(code);
		}
	}	
	public void titleState(int code) {
		if(gp.ui.titleScreenState == 0) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
			}
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.ui.titleScreenState = 1;
				}
				if(gp.ui.commandNum == 1) {
					gp.loadSavedGame();
//				    gp.csManager.sceneNum = gp.csManager.NA;
//					gp.gameState = gp.playState;
//					gp.playMusic(0);
				}
				if(gp.ui.commandNum == 2) {
					System.exit(0);
				}
			}
		}
		else if(gp.ui.titleScreenState == 1) {
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
				    gp.startNewGame();
				}
			}
		}
	}
	public void playState(int code) {
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.pauseState;
		}
		if(code == KeyEvent.VK_C) {
			characterPressed = true;
			gp.gameState = gp.characterState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
			attackPressed = true;
		}
		if(code == KeyEvent.VK_E) {
			shotKeyPressed = true;
		}
		if(code == KeyEvent.VK_Q) {
			gremlinPressed = true;
		}
		if(code == KeyEvent.VK_J) {
			gp.gameState = gp.journalState;
		}
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.optionsState;
			gp.ui.optionScreenState = 0;
			gp.ui.commandNum = 0;
		}
		if(code == KeyEvent.VK_M) {
			gp.gameState = gp.mapState;
		}
		if(code == KeyEvent.VK_X) {
			if(gp.map.miniMapOn == false) {
				gp.map.miniMapOn = true;
			}
			else {
				gp.map.miniMapOn = false;
			}
		}
		if(code == KeyEvent.VK_F) {
			blockPressed = true;
		}
		if(code == KeyEvent.VK_SPACE) {
			rollPressed = true;
		}
		
		//DEBUG
		if(code == KeyEvent.VK_T) {
			if(showDebugText == false) {
				showDebugText = true;
			}
			else if(showDebugText == true) {
				showDebugText= false;
			}
		}
		if(code == KeyEvent.VK_UP && showDebugText) {
			Progress.gameStage++;
		}
		if(code == KeyEvent.VK_DOWN && showDebugText) {
			Progress.gameStage--;
		}
		if(code == KeyEvent.VK_RIGHT && showDebugText) {
			gp.eManager.lighting.timeSpeed++;
		}
		if(code == KeyEvent.VK_LEFT && showDebugText) {
			gp.eManager.lighting.timeSpeed--;
		}
		if(code ==  KeyEvent.VK_R) {
			switch(gp.currentMap) {
			case 0: gp.tileM.loadMap("/maps/world01.txt", 0);
			case 1: gp.tileM.loadMap("/maps/interior01.txt", 1);
			}
			
		}
		if(code == KeyEvent.VK_G) {
			if(godModeOn == false) {
				godModeOn = true;
			}
			else if(godModeOn == true) {
				godModeOn= false;
			}
		}
	}
	public void pauseState(int code) {
		if(code == KeyEvent.VK_P) {
			gp.gameState = gp.playState;
		}	
	}
	public void dialogueState(int code) {
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}	
	}
	public void characterState(int code) {
		if(code == KeyEvent.VK_C) {
			characterPressed = true;
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ENTER) {
			gp.player.selectItem();
		}
		playerInventory(code);
	}
	public void optionsState(int code) {
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		
		int maxCommandNum = 0;
		switch(gp.ui.optionScreenState) {
		case 0: maxCommandNum = 5; break;
		case 3: maxCommandNum = 1; break;
		
		}
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(6);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = maxCommandNum;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(6);
			if(gp.ui.commandNum > maxCommandNum) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_A) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(6);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
					gp.se.volumeScale--;
					gp.playSE(6);
				}
		}
		if(code == KeyEvent.VK_D) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(6);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
					gp.se.volumeScale++;
					gp.playSE(6);
				}
		}
	}
	public void gameOverState(int code) {
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(6);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 1;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(6);
			if(gp.ui.commandNum > 1) {
				gp.ui.commandNum = 0;
			}
		}
		if(code == KeyEvent.VK_ENTER) {
			if(gp.ui.commandNum == 0) {
				gp.loadSavedGame();
//			    gp.csManager.sceneNum = gp.csManager.NA;
//				gp.gameState = gp.playState;
//				gp.playMusic(0);
			}
			if(gp.ui.commandNum == 1) {
				gp.gameState = gp.titleState;
				gp.ui.titleScreenState = 0;
				gp.ui.commandNum = 0;
				gp.resetGame(false);
			}
		}
	}
	public void tradeState(int code) {
		
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}		
		if(gp.ui.optionScreenState == 0) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
				gp.playSE(6);
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
				gp.playSE(6);
			}		
		}
		if(gp.ui.optionScreenState == 1) {
			npcInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.optionScreenState = 0;
			}
		}
		if(gp.ui.optionScreenState == 2) {
			playerInventory(code);
			if(code == KeyEvent.VK_ESCAPE) {
				gp.ui.optionScreenState = 0;
			}
		}
	}
	public void mapState(int code) {
		
		if(code == KeyEvent.VK_M) {
			gp.gameState = gp.playState;
		}
	}
	public void journalState(int code) {
		if(code == KeyEvent.VK_J || code == KeyEvent.VK_ESCAPE) {
			journalPressed = true;
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_W) {
			if(gp.ui.playerJournalIndex > 0) {
				gp.ui.playerJournalIndex--;
				gp.playSE(6);
				gp.ui.scrollUp();
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.playerJournalIndex < gp.qManager.getQuestJournal().getActiveQuests().size() - 1 + gp.qManager.getQuestJournal().getCompletedQuests().size()) {
				gp.ui.playerJournalIndex++;
				gp.playSE(6);
				gp.ui.scrollDown();
			}
		}
	}
	public void playerInventory(int code) {
		if(code == KeyEvent.VK_W) {
			if(gp.ui.playerSlotRow != 0) {
				gp.ui.playerSlotRow--;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.playerSlotCol != 0) {
				gp.ui.playerSlotCol--;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.playerSlotRow != 3) {
				gp.ui.playerSlotRow++;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.playerSlotCol != 4) {
				gp.ui.playerSlotCol++;
				gp.playSE(6);
			}
		}
	}
	public void npcInventory(int code) {
		if(code == KeyEvent.VK_W) {
			if(gp.ui.npcSlotRow != 0) {
				gp.ui.npcSlotRow--;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_A) {
			if(gp.ui.npcSlotCol != 0) {
				gp.ui.npcSlotCol--;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_S) {
			if(gp.ui.npcSlotRow != 3) {
				gp.ui.npcSlotRow++;
				gp.playSE(6);
			}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.npcSlotCol != 4) {
				gp.ui.npcSlotCol++;
				gp.playSE(6);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_E) {
			shotKeyPressed = false;
		}
		if(code == KeyEvent.VK_C) {
			characterPressed = false;
		}
		if(code == KeyEvent.VK_Q) {
			gremlinPressed = false;
		}
		if(code == KeyEvent.VK_J) {
			journalPressed = false;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = false;
			attackPressed = false;
		}
		if(code == KeyEvent.VK_F) {
			blockPressed = false;
		}
		if(code == KeyEvent.VK_SPACE) {
			rollPressed = false;
		}
	}
}
