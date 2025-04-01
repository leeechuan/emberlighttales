package main.emberlight;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import object.OBJ_BigTorch;
import object.OBJ_Campfire;
import object.OBJ_Coin;
import object.OBJ_Heart;
import object.OBJ_LampPost;
import object.OBJ_ManaCrystal;
import quest.Quest;
import quest.QuestStage;
import entity.Entity;
import environment.LightSource;


public class UI {
	
	GamePanel gp;
	Graphics2D g2;
	public Font pressStart2P;
	BufferedImage heart_full, heart_half, heart_empty, mana_full, mana_empty, coin;
	public boolean messageOn = false;
//	public String message = "";
//	int messageCounter = 0;
	ArrayList<String> message = new ArrayList<>();
	ArrayList<Integer> messageCounter =  new ArrayList<>();
	public boolean gameFinished = false;
	public String currentDialogue = "";
	public int commandNum = 0;
	public int titleScreenState = 0;
	public int playerSlotCol = 0;
	public int playerSlotRow = 0;
	public int npcSlotCol = 0;
	public int npcSlotRow = 0;
	public int optionScreenState = 0;
	public int playerJournalIndex = 0;
	int counter = 0;
	public Entity npc;
	int charIndex = 0;
	String combinedText = "";
	public List<LightSource> lightSources;
    private BufferedImage titleScreenBackground;
    private int activeScrollOffset = 0;
    private int completedScrollOffset = 0;
    private float arrowY = 0; // Starting position of the arrow
    private Image downArrowSprite;
	
	
	public UI(GamePanel gp) {
		this.gp = gp;
		try {
			InputStream is = getClass().getResourceAsStream("/font/Press_Start_2P_Regular.ttf");
			pressStart2P = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
            titleScreenBackground = ImageIO.read(getClass().getResource("/artwork/title_screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Load the arrow sprite image (ensure the path is correct relative to your resources folder)
            downArrowSprite = ImageIO.read(getClass().getResource("/ui/arrowhead_downward_white.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//CREATE HUD OBJECT
		Entity heart = new OBJ_Heart(gp);
		heart_full = heart.image1;
		heart_half = heart.image2;
		heart_empty = heart.image3;
		Entity mana = new OBJ_ManaCrystal(gp);
		mana_full = mana.image1;
		mana_empty = mana.image2;
		Entity goldCoin = new OBJ_Coin(gp);
		coin = goldCoin.image1;
	}
	public void addMessage(String text) {
		
		message.add(text);
		messageCounter.add(0);
	}
	public void draw(Graphics2D g2) {
		
		this.g2 = g2;
		
		g2.setFont(pressStart2P);
		g2.setColor(Color.white);
		
		//TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		//PLAY STATE
		if(gp.gameState == gp.playState) {
			drawPlayerLife();
			drawMobLife();
			drawMessage();
		}
		//PAUSE STATE
		if(gp.gameState == gp.pauseState) {
			drawPlayerLife();
			drawPauseScreen();
		}
		//DIALOGUE STATE
		if(gp.gameState == gp.dialogueState) {
			drawDialogueScreen();
		}
		//CHARACTER STATE
		if(gp.gameState == gp.characterState) {
			drawCharacterScreen();
			drawInventory(gp.player, true);
		}
		//OPTIONS STATE
		if(gp.gameState == gp.optionsState) {
			drawOptionsScreen();
		}
		//GAME OVER STATE
		if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen();
		}
		//TRANSITION STATE
		if(gp.gameState == gp.transitionState) {
			drawTransition();
		}
		//TRADE STATE
		if(gp.gameState == gp.tradeState) {
			drawTradeScreen();
		}
		//SLEEP STATE
		if(gp.gameState == gp.sleepState) {
			drawSleepScreen(g2);
		}
		//JOURNAL STATE
		if(gp.gameState == gp.journalState) {
			drawJournalScreen();
		}
	}
	public void drawPlayerLife() {
	    int x = gp.tileSize / 2;
	    int y = gp.tileSize / 2;
	    int iconSize = 32;
	    
	    // Draw full, half, and empty hearts based on the player's current life
	    for (int i = 0; i < gp.player.maxLife / 2; i++) {
	        if (i < gp.player.life / 2) {
	            // Draw full heart if the player has full health
	            g2.drawImage(heart_full, x, y, iconSize, iconSize, null);
	        } else if (i == gp.player.life / 2 && gp.player.life % 2 != 0) {
	            // Draw half heart if the player's life is odd
	            g2.drawImage(heart_half, x, y, iconSize, iconSize, null);
	        } else {
	            // Draw empty heart if the player doesn't have enough life for a full heart
	            g2.drawImage(heart_empty, x, y, iconSize, iconSize, null);
	        }
	        x += gp.tileSize*iconSize/48; // Move to the next heart's position
	    }
	    
	    // DRAW MANA UI
	    x = (gp.tileSize / 2) - 2;
	    y = (int)(gp.tileSize * 1.2);

	    // Draw max mana (empty and full in a single loop)
	    for (int i = 0; i < gp.player.maxMana; i++) {
	        if (i < gp.player.mana) {
	            // Draw filled mana if within current mana
	            g2.drawImage(mana_full, x, y, iconSize, iconSize, null);
	        } else {
	            // Draw empty mana for remaining slots
	            g2.drawImage(mana_empty, x, y, iconSize, iconSize, null);
	        }
	        x += 30; // Adjust spacing for the next mana icon
	    }
	}
	public void drawMobLife() {
    	
		for(int i = 0; i < gp.mob[1].length; i++) {
			
			Entity mob = gp.mob[gp.currentMap][i];
			
			if(mob != null && mob.inCamera() == true) {
				
		    	if(mob.hpBarOn == true && mob.boss == false) {
		    		
		    		double oneScale = (double)gp.tileSize/mob.maxLife;
		    		double hpBarValue = oneScale*mob.life;
		    		
		    		g2.setColor(new Color(35, 35, 35));
		    		g2.fillRect(mob.getScreenX()-1, mob.getScreenY() - 16, gp.tileSize+2, 10);
		    		
		        	g2.setColor(new Color(255 ,0 ,30));
		        	g2.fillRect(mob.getScreenX(), mob.getScreenY() - 15, (int)hpBarValue, 8);
		        	
		        	mob.hpBarCounter++;
		        	
		        	if(mob.hpBarCounter > 600) {
		        		mob.hpBarCounter = 0;
		        		mob.hpBarOn = false;
		        	}
		    	}
		    	else if(mob.boss == true) {
		    		double oneScale = (double)gp.tileSize*8/mob.maxLife;
		    		double hpBarValue = oneScale*mob.life;
		    		
		    		int x = gp.screenWidth/2 - gp.tileSize*4;
		    		int y = gp.tileSize*10;
		    		
		    		g2.setColor(new Color(35, 35, 35));
		    		g2.fillRect(x-1, y-1, gp.tileSize*8 + 2, 22);
		        	g2.setColor(new Color(255 ,0 ,30));
		        	g2.fillRect(x, y, (int)hpBarValue, 20);
		        	
		        	g2.setFont(g2.getFont().deriveFont(Font.BOLD,12f));
		        	g2.setColor(Color.white);
		        	g2.drawString(mob.name, x+4, y-10);
		    	}
			}
		}

	}
	public void drawMessage() {
		
		int messageX = gp.tileSize;
		int messageY = gp.tileSize * 4;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 16F));
		
		for (int i = 0; i < message.size(); i++) {
			
			if(message.get(i) != null) {
				
				g2.setColor(Color.black);
				g2.drawString(message.get(i), messageX + 2, messageY + 2);
				g2.setColor(Color.white);
				g2.drawString(message.get(i), messageX, messageY);
				
				int counter = messageCounter.get(i) + 1;
				messageCounter.set(i, counter);
				messageY += 50;
				
				if(messageCounter.get(i) > 180) {
					message.remove(i);
					messageCounter.remove(i);
				}
			}

		}
		
	}
	public void drawTitleScreen() {
		
		if(titleScreenState == 0) {
		    
		    // Draw the background image or fallback to a solid color
		    if (titleScreenBackground != null) {
		        g2.drawImage(titleScreenBackground, 0, 0, gp.screenWidth, gp.screenHeight, null);
		    } else {
		        g2.setColor(new Color(0, 0, 0));
		        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		    }
		    
		    // Draw a translucent overlay for overall darkening
		    g2.setColor(new Color(0, 0, 0, 120));
		    g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		    
		    // Draw the title text (static, with shadow)
		    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32F));
		    String text = "Emberlight Tales";
		    int x = getXforCenteredText(text);
		    int y = gp.tileSize * 3;
		    
		    // Title shadow
		    g2.setColor(Color.gray);
		    g2.drawString(text, x + 5, y + 5);
		    // Main title
		    g2.setColor(Color.white);
		    g2.drawString(text, x, y);
		    
		    // Draw the character image below the title text
		    x = gp.screenWidth / 2 - gp.tileSize;
		    y += gp.tileSize * 4;
		    
		    // Set the font for menu options
		    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));
		    
		    // NEW GAME option
		    text = "NEW GAME";
		    x = getXforCenteredText(text);
		    g2.setColor(Color.white);
		    g2.drawString(text, x, y);
		    if (commandNum == 0) {
		        // Only the ">" moves with a subtle horizontal sine wave animation
		        int arrowOffset = (int)(Math.sin(System.currentTimeMillis() * 0.005) * 5);
		        g2.drawString(">", x - gp.tileSize + arrowOffset, y);
		    }
		    
		    // LOAD GAME option
		    y += gp.tileSize;
		    text = "LOAD GAME";
		    x = getXforCenteredText(text);
		    g2.drawString(text, x, y);
		    if (commandNum == 1) {
		        int arrowOffset = (int)(Math.sin(System.currentTimeMillis() * 0.005) * 5);
		        g2.drawString(">", x - gp.tileSize + arrowOffset, y);
		    }
		    
		    // EXIT option
		    y += gp.tileSize;
		    text = "EXIT";
		    x = getXforCenteredText(text);
		    g2.drawString(text, x, y);
		    if (commandNum == 2) {
		        int arrowOffset = (int)(Math.sin(System.currentTimeMillis() * 0.005) * 5);
		        g2.drawString(">", x - gp.tileSize + arrowOffset, y);
		    }
		    
		    // Draw version number on the bottom right
		    String versionText = "Alpha v1.0.9";
		    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
		    g2.setColor(Color.white);  // Use white color for the version text
		    int versionX = gp.screenWidth - g2.getFontMetrics().stringWidth(versionText) - 10;  // Right-aligned
		    int versionY = gp.screenHeight - 10;  // 10 pixels from the bottom
		    g2.drawString(versionText, versionX, versionY);
		}
		else if(titleScreenState == 1) {
			
	        g2.setColor(new Color(0, 0, 0)); // Reset background
	        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
			g2.setColor(Color.white);
			g2.setFont(g2.getFont().deriveFont(16F));
			
			
			String text = "In a realm where ancient forces stir,\n" +
		              "a lone wanderer must uncover hidden truths\n" +
		              "to restore balance and face the darkness.\n" +
		              "Journey through treacherous lands and\n" +
		              "unravel the mysteries of a world on the\n" +
		              "brink of chaos. Your destiny awaits.\n" +
		              "Will you rise to meet it?";
			int y = gp.tileSize*2;
			for(String line : text.split("\n")) {
				int x = getXforCenteredText(line);
				g2.drawString(line, x, y);
				y += gp.tileSize;
			}
			
			text = "BEGIN YOUR JOURNEY";
			int x = getXforCenteredText(text);
			y += gp.tileSize;
			
			g2.drawString(text, x, y);
			g2.drawString(">", x-gp.tileSize, y);
		}
		
		
	}
	public void drawPauseScreen() {
		
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
		String text = "PAUSED";
		int x = getXforCenteredText(text);
		int y = gp.screenHeight/2;
		
		g2.drawString(text, x, y);
	}
	public void drawDialogueScreen() {
		
	    if (npc.portrait != null) {
	    	drawSubWindow(70, 24, gp.tileSize*5/2, gp.tileSize*5/2);
	        g2.drawImage(npc.portrait, 84, 42, gp.tileSize*2, gp.tileSize*2, null);
	        
	      //WINDOW
			int x = gp.tileSize * 4 + 10;
			int y = gp.tileSize / 2;
			int width = gp.screenWidth - (gp.tileSize * 6);
			int height = gp.tileSize * 4;
			drawSubWindow(x, y, width, height);
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,14));
			x += gp.tileSize;
			y += gp.tileSize;
			if(npc.dialogues[npc.dialogueSet][npc.dialogueIndex] != null) {
				
//				currentDialogue = npc.dialogues[npc.dialogueSet][npc.dialogueIndex];
				
				char characters[] = npc.dialogues[npc.dialogueSet][npc.dialogueIndex].toCharArray();
				
				if(charIndex < characters.length) {
					
					gp.playSE(12);
					String s = String.valueOf(characters[charIndex]);
					combinedText = combinedText + s;
					currentDialogue = combinedText;
					charIndex++;
				}
				
				
				if(gp.keyH.enterPressed == true) {
					
					charIndex = 0;
					combinedText = "";
					
					if(gp.gameState == gp.dialogueState || gp.gameState == gp.cutsceneState) {
						
						npc.dialogueIndex++;
						gp.keyH.enterPressed = false;
					}
				}
			}
			else { //If no text is in the array
				npc.dialogueIndex = 0;
				
				if(gp.gameState == gp.dialogueState) {
					gp.gameState = gp.playState;
				}
				if(gp.gameState == gp.cutsceneState) {
					gp.csManager.scenePhase++;
				}
			}
			
			for(String line : currentDialogue.split("\n")) {
				g2.drawString(line, x, y);
				y += 40;
			}
			if(npc.name != null) {
			    String speakerName = npc.name;
			    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 10));
			    drawSubWindow(240, 186, g2.getFontMetrics().stringWidth(speakerName) + 40, g2.getFontMetrics().getHeight() + 35);
			    g2.setColor(Color.WHITE);
			    g2.drawString(speakerName, x + 10, gp.tileSize * 9 / 2);
			    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 14));
			    y += 20;  // Add space below the name for dialogue
			}
	    }
	    else {
	    	//WINDOW
			int x = gp.tileSize * 3;
			int y = gp.tileSize / 2;
			int width = gp.screenWidth - (gp.tileSize * 6);
			int height = gp.tileSize * 4;
			drawSubWindow(x, y, width, height);
			
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,14));
			x += gp.tileSize;
			y += gp.tileSize;
			
			if(npc.dialogues[npc.dialogueSet][npc.dialogueIndex] != null) {
				
//				currentDialogue = npc.dialogues[npc.dialogueSet][npc.dialogueIndex];
				
				char characters[] = npc.dialogues[npc.dialogueSet][npc.dialogueIndex].toCharArray();
				
				if(charIndex < characters.length) {
					
					gp.playSE(12);
					String s = String.valueOf(characters[charIndex]);
					combinedText = combinedText + s;
					currentDialogue = combinedText;
					charIndex++;
				}
				
				
				if(gp.keyH.enterPressed == true) {
					
					charIndex = 0;
					combinedText = "";
					
					if(gp.gameState == gp.dialogueState || gp.gameState == gp.cutsceneState) {
						
						npc.dialogueIndex++;
						gp.keyH.enterPressed = false;
					}
				}
			}
			else { //If no text is in the array
				npc.dialogueIndex = 0;
				
				if(gp.gameState == gp.dialogueState) {
					gp.gameState = gp.playState;
				}
				if(gp.gameState == gp.cutsceneState) {
					gp.csManager.scenePhase++;
				}
			}
			
			for(String line : currentDialogue.split("\n")) {
				g2.drawString(line, x, y);
				y += 40;
			}
			
			if(npc.name != null) {
			    String speakerName = npc.name;
			    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 10));
			    drawSubWindow(180, 185, g2.getFontMetrics().stringWidth(speakerName) + 40, g2.getFontMetrics().getHeight() + 35);
			    g2.setColor(Color.WHITE);
			    g2.drawString(speakerName, x + 10, gp.tileSize * 9 / 2);
			    g2.setFont(g2.getFont().deriveFont(Font.BOLD, 14));
			    y += 20;  // Add space below the name for dialogue
			}

	    }
		
	}
	public void drawCharacterScreen() {
		
		//CREATE A FRAME
		final int frameX = gp.tileSize * 2;
		final int frameY = gp.tileSize;
		final int frameWidth = gp.tileSize*6;
		final int frameHeight = gp.tileSize*10;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//TEXT
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(16F));
		
		int textX = frameX + 20;
		int textY = frameY + gp.tileSize;
		final int lineHeight = 35;
		
		//NAMES
		g2.drawString("Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Life", textX, textY);
		textY += lineHeight;
		g2.drawString("Mana", textX, textY);
		textY += lineHeight;
		g2.drawString("Strength", textX, textY);
		textY += lineHeight;
		g2.drawString("Dexterity", textX, textY);
		textY += lineHeight;
		g2.drawString("Attack", textX, textY);
		textY += lineHeight;
		g2.drawString("Defense", textX, textY);
		textY += lineHeight;
		g2.drawString("Exp", textX, textY);
		textY += lineHeight;
		g2.drawString("Next Level", textX, textY);
		textY += lineHeight;
		g2.drawString("Coin", textX, textY);
		textY += lineHeight + 10;
		g2.drawString("Weapon", textX, textY);
		textY += lineHeight + 15;
		g2.drawString("Shield", textX, textY);
		textY += lineHeight;
		
		//Values
		int tailX = (frameX + frameWidth) - 30;
		//Reset textY
		textY = frameY + gp.tileSize;
		String value;
		
		value = String.valueOf(gp.player.level);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.life + "/" + gp.player.maxLife);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;

		value = String.valueOf(gp.player.mana + "/" + gp.player.maxMana);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.strength);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.dexterity);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.attack);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.defense);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.exp);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.nextLevelExp);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		
		value = String.valueOf(gp.player.coin);
		textX = getXforAlignToRightText(value, tailX);
		g2.drawString(value, textX, textY);
		textY += lineHeight;
		

		g2.drawImage(gp.player.currentWeapon.image1, tailX - gp.tileSize, textY - 24, null);
		
		textY += gp.tileSize;
		g2.drawImage(gp.player.currentShield.image1, tailX - gp.tileSize, textY - 24, null);
	}
	public void drawInventory(Entity entity, boolean cursor) {
		
		int frameX = 0;
		int frameY = 0;
		int frameWidth = 0;
		int frameHeight = 0;
		int slotCol = 0;
		int slotRow = 0;
		
		if(entity == gp.player) {
			frameX = gp.tileSize*12;
			frameY = gp.tileSize;
			frameWidth = gp.tileSize*6;
			frameHeight = gp.tileSize*5;
			slotCol = playerSlotCol;
			slotRow = playerSlotRow;
		} 
		else {
			frameX = gp.tileSize*2;
			frameY = gp.tileSize;
			frameWidth = gp.tileSize*6;
			frameHeight = gp.tileSize*5;
			slotCol = npcSlotCol;
			slotRow = npcSlotRow;
		}
		//FRAME
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		//SLOT
		final int slotXstart = frameX + 20;
		final int slotYstart = frameY + 20;
		int slotX = slotXstart;
		int slotY = slotYstart;
		int slotSize = gp.tileSize + 2;
		
		//DRAW PLAYER ITEMS
		for(int i = 0; i < entity.inventory.size(); i++) {
			
			//EQUIP CURSOR
			if(entity.inventory.get(i) == entity.currentWeapon ||
					entity.inventory.get(i) == entity.currentShield ||
					entity.inventory.get(i) == entity.currentLight) {
				g2.setColor(new Color(240,190,90));
				g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
			}
			
			g2.drawImage(entity.inventory.get(i).image1, slotX, slotY, null);
			
			//DISPLAY AMOUNT
			if(entity == gp.player && entity.inventory.get(i).amount > 1) {
				
				g2.setFont(g2.getFont().deriveFont(16f));
				int amountX;
				int amountY;
				
				String s = "" + entity.inventory.get(i).amount;
				amountX = getXforAlignToRightText(s, slotX + 44);
				amountY = slotY + gp.tileSize;
				
				//SHADOW
				g2.setColor(new Color(60, 60, 60));
				g2.drawString(s, amountX, amountY);
				//NUMBER
				g2.setColor(Color.white);
				g2.drawString(s, amountX - 3, amountY-3);
				
			}
			
			slotX += slotSize;
			
			if(i == 4 || i == 9 || i == 14) {
				slotX = slotXstart;
				slotY += slotSize;
			}
		}
		
		//CURSOR
		if(cursor == true) {
			int cursorX = slotXstart + (slotSize * slotCol);
			int cursorY = slotYstart + (slotSize * slotRow);
			int cursorWidth = gp.tileSize;
			int cursorHeight = gp.tileSize;
			//DRAW CURSOR
			g2.setColor(Color.white);
			g2.setStroke(new BasicStroke(3));
			g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
			
			//DESCRIPTION FRAME
			int dFrameX = frameX;
			int dFrameY = frameY + frameHeight;
			int dFrameWidth = frameWidth;
			int dFrameHeight = gp.tileSize * 5;
			
			//DESCRIPTION TEXT
			int textX = dFrameX + 20;
			int textY = dFrameY + gp.tileSize;
			g2.setFont(g2.getFont().deriveFont(14F));
			
			int itemIndex = getItemIndexOnSlot(slotCol, slotRow);
			
			if(itemIndex < entity.inventory.size()) {
				
				drawSubWindow(dFrameX, dFrameY, dFrameWidth, dFrameHeight);
				for(String line: entity.inventory.get(itemIndex).description.split("\n")) {
					
					g2.drawString(line, textX, textY);
					textY += 32;
				}
			}
		}

	}
	public void drawGameOverScreen() {
		
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		int x;
		int y;
		String text;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 50f));
		
		text = "Game Over";
		//Shadow
		g2.setColor(Color.black);
		x = getXforCenteredText(text);
		y = gp.tileSize * 4;
		g2.drawString(text, x, y);
		//Main
		g2.setColor(Color.white);
		g2.drawString(text, x-4, y-4);
		//Retry
		g2.setFont(g2.getFont().deriveFont(25f));
		text = "Respawn";
		x = getXforCenteredText(text);
		y += gp.tileSize * 4;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x - 40, y);
		}
		
		//Back To Title Screen
		text = "Main Menu";
		x = getXforCenteredText(text);
		y += 55;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x - 40, y);
		}
		
	}
	public void drawOptionsScreen() {
		
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(16F));
		
		//SUB WINDOW
		int frameX = gp.tileSize * 5;
		int frameY = gp.tileSize;
		int frameWidth = gp.tileSize * 10;
		int frameHeight = gp.tileSize * 10;
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		switch(optionScreenState) {
		case 0: options_top(frameX, frameY); break;
		case 1: options_fullScreenNotification(frameX, frameY); break;
		case 2: options_control(frameX, frameY); break;
		case 3: options_endGameConfirmation(frameX, frameY); break;
		}
		
		gp.keyH.enterPressed = false;
	}
	public void options_top(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "Options";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		//FULL SCREEN ON/OFF
		textX = frameX + gp.tileSize;
		textY += gp.tileSize * 2;
		g2.drawString("Full Screen", textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				gp.fullScreenOn = !gp.fullScreenOn;
				optionScreenState = 1;
			}
		}
		
		//MUSIC
		textY += gp.tileSize;
		g2.drawString("Music", textX, textY);
		if(commandNum == 1) {
			g2.drawString(">", textX - 25, textY);
		}
		
		//SE
		textY += gp.tileSize;
		g2.drawString("Sound Effects", textX, textY);
		if(commandNum == 2) {
			g2.drawString(">", textX - 25, textY);
		}
		
		//CONTROL
		textY += gp.tileSize;
		g2.drawString("Controls", textX, textY);
		if(commandNum == 3) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 2;
				commandNum = 0;
			}
		}
		
		//END GAME
		textY += gp.tileSize;
		g2.drawString("End Game", textX, textY);
		if(commandNum == 4) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 3;
				commandNum = 0;
			}
		}
		
		//BACK
		textY += gp.tileSize * 2;
		g2.drawString("Back", textX, textY);
		if(commandNum == 5) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				gp.gameState = gp.playState;
				commandNum = 0;
			}
		}
		
		//FULL SCREEN CHECK BOX
		textX = frameX + (int)(gp.tileSize * 6.5);
		textY = frameY + gp.tileSize * 2 + 24;
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(textX, textY, 24, 24);
		if(gp.fullScreenOn == true) {
			g2.fillRect(textX, textY, 24, 24);
		}
		
		//MUSIC VOLUME
		textY += gp.tileSize;
		g2.drawRect(textX, textY, 120, 24);
		int volumeWidth = 24 * gp.music.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		//SE VOLUME
		textY += gp.tileSize;
		g2.drawRect(textX, textY, 120, 24);
		volumeWidth = 24 * gp.se.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		gp.config.saveConfig();
	}
	public void options_fullScreenNotification(int frameX, int frameY) {
		
		int textX = frameX + gp.tileSize;
		int textY = frameY + gp.tileSize * 3;
		
		currentDialogue = "This change will take\neffect after restarting\nthe game.";
		
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
		
		//BACK
		textY = frameY + gp.tileSize * 9;
		g2.drawString("Back", textX, textY);
		if(commandNum ==0) {
			g2.drawString(">", textX -25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 0;
			}
		}
	}
	public void options_control(int frameX, int frameY) {
		
		int textX;
		int textY;
		
		//TITLE
		String text = "Controls";
		textX = getXforCenteredText(text);
		textY = frameY + gp.tileSize;
		g2.drawString(text, textX, textY);
		
		textX = frameX + gp.tileSize;
		textY += gp.tileSize;
		
		g2.drawString("Move", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Interact/Attack", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Shoot Arrow", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Block/Parry", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Character Screen", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Transform", textX, textY); 
		textY += gp.tileSize;
		
		g2.drawString("Options", textX, textY); 
		textY += gp.tileSize;
		
		textX = frameX + gp.tileSize * 7;
		textY = frameY + gp.tileSize * 2;
		g2.drawString("WASD", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("ENTER", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("E", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("SPACE", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("C", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("Q", textX, textY);
		textY += gp.tileSize;
		
		g2.drawString("ESC", textX, textY);
		textY += gp.tileSize;
		
		//BACK
		textX = frameX + gp.tileSize;
		textY = frameY + gp.tileSize * 9;
		g2.drawString("Back", textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 0;
				commandNum = 3;
			}
		}
	}
	public void options_endGameConfirmation(int frameX, int frameY) {
		
		int textX = frameX + gp.tileSize;
		int textY = frameY + gp.tileSize * 3;
		
		currentDialogue = "Quit the game and return\nto the title screen?";
		
		for(String line: currentDialogue.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
		
		//YES
		String text = "Yes";
		textX = getXforCenteredText(text);
		textY += gp.tileSize * 2;
		g2.drawString(text, textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 0;
				titleScreenState = 0;
				gp.stopMusic();
				gp.gameState = gp.titleState;
				gp.resetGame(true);
			}
		}
		
		//NO
		text = "No";
		textX = getXforCenteredText(text);
		textY += gp.tileSize;
		g2.drawString(text, textX, textY);
		if(commandNum == 1) {
			g2.drawString(">", textX - 25, textY);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 0;
				commandNum = 4;
			}
		}
	}
	public void drawTransition() {
		
		counter++;
		g2.setColor(new Color(0, 0, 0, counter*5));
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		
		if(counter == 50) {//The transition is done
			counter = 0;
			gp.gameState = gp.playState;
			gp.currentMap = gp.eHandler.tempMap;
			gp.player.worldX = gp.tileSize * gp.eHandler.tempCol;
			gp.player.worldY = gp.tileSize * gp.eHandler.tempRow;
			gp.eHandler.previousEventX = gp.player.worldX;
			gp.eHandler.previousEventY = gp.player.worldY;
			gp.changeArea();
			initWorldLightSources();
		    gp.lastTime = System.nanoTime();
		    gp.delta = 0;
		}
	}
	public void drawTradeScreen() {
		
		switch(optionScreenState) {
		case 0: trade_select(); break;
		case 1: trade_buy(); break;
		case 2: trade_sell(); break;
		}
		gp.keyH.enterPressed = false;
	}
	public void trade_select() {
		
		npc.dialogueSet = 0;
		drawDialogueScreen();
		
		//DRAW WINDOW
		int x = gp.tileSize * 15;
		int y = gp.tileSize * 4;
		int width = gp.tileSize * 3;
		int height = (int)(gp.tileSize * 3.5);
		drawSubWindow(x, y, width, height);
		
		//DRAW TEXTS
		x += gp.tileSize;
		y += gp.tileSize;
		g2.drawString("Buy", x, y);
		
		if(commandNum == 0) {
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 1;
			}
		}
		y += gp.tileSize;
		g2.drawString("Sell", x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				optionScreenState = 2;
			}
		}
		y += gp.tileSize;
		g2.drawString("Leave", x, y);
		if(commandNum == 2) {
			g2.drawString(">", x-24, y);
			if(gp.keyH.enterPressed == true) {
				commandNum = 0;
				npc.startDialogue(npc, 1);
			}
		}
	}
	public void trade_buy() {
		
		//DRAW PLAYER INVENTORY
		drawInventory(gp.player, false);
		//DRAW NPC INVENTORY
		drawInventory(npc, true);
		
		//DRAW HINT WINDOW
		int x = gp.tileSize * 2;
		int y = gp.tileSize * 9;
		int width = gp.tileSize * 6;
		int height = gp.tileSize * 2;
//		drawSubWindow(x, y, width, height);
//		g2.drawString("[ESC] Back", x + 24, y + 60);
		
		//DRAW PLAYER COIN WINDOW
		x = gp.tileSize * 12;
		y = gp.tileSize * 9;
		width = gp.tileSize * 6;
		height = gp.tileSize * 2;
		drawSubWindow(x, y, width, height);
		g2.drawString("Your Coin: " + gp.player.coin, x + 24, y + 60);
		
		//DRAW PRICE WINDOW
		int itemIndex = getItemIndexOnSlot(npcSlotCol, npcSlotRow);
		if(itemIndex < npc.inventory.size()) {
			
			x = (int)(gp.tileSize*5.5);
			y = (int)(gp.tileSize*5.5);
			width = (int)(gp.tileSize*2.5);
			height = gp.tileSize;
			drawSubWindow(x, y, width, height);
			g2.drawImage(coin, x + 10, y + 10, 32, 32, null);
			
			int price = npc.inventory.get(itemIndex).price;
			String text = "" + price;
			x = getXforAlignToRightText(text, gp.tileSize * 8 - 20);
			g2.drawString(text, x, y + 34);
			
			//BUY AN ITEM
			if(gp.keyH.enterPressed == true) {
				if(npc.inventory.get(itemIndex).price > gp.player.coin) {
					optionScreenState = 0;
					npc.startDialogue(npc, 2);
				}
				else {
					if(gp.player.canObtainItem(npc.inventory.get(itemIndex)) == true) {
						gp.player.coin -= npc.inventory.get(itemIndex).price;
					}
					else {
						optionScreenState = 0;
						npc.startDialogue(npc, 3);
					}
				}
			}
		}
	}
	public void trade_sell() {
		
		//DRAW PLAYER INVENTORY
		drawInventory(gp.player, true);
		
		int x;
		int y;
		int width;
		int height;
		
		//DRAW HINT WINDOW
		x = gp.tileSize * 2;
		y = gp.tileSize * 9;
		width = gp.tileSize * 6;
		height = gp.tileSize * 2;
//		drawSubWindow(x, y, width, height);
//		g2.drawString("[ESC] Back", x + 24, y + 60);
		
		//DRAW PLAYER COIN WINDOW
		x = gp.tileSize * 2;
		y = gp.tileSize * 9;
		width = gp.tileSize * 6;
		height = gp.tileSize * 2;
		drawSubWindow(x, y, width, height);
		g2.drawString("Your Coin: " + gp.player.coin, x + 24, y + 60);
		
		//DRAW PRICE WINDOW
		int itemIndex = getItemIndexOnSlot(playerSlotCol, playerSlotRow);
		if(itemIndex < gp.player.inventory.size()) {
			
			x = (int)(gp.tileSize*15.5);
			y = (int)(gp.tileSize*5.5);
			width = (int)(gp.tileSize*2.5);
			height = gp.tileSize;
			drawSubWindow(x, y, width, height);
			g2.drawImage(coin, x + 10, y + 10, 32, 32, null);
			
			int price = gp.player.inventory.get(itemIndex).price /4*3;
			String text = "" + price;
			x = getXforAlignToRightText(text, gp.tileSize * 18 - 20);
			g2.drawString(text, x, y + 34);
			
			//SELL AN ITEM
			if(gp.keyH.enterPressed == true) {
				
				if(gp.player.inventory.get(itemIndex) == gp.player.currentWeapon ||
						gp.player.inventory.get(itemIndex) == gp.player.currentShield) {
					commandNum = 0;
					optionScreenState = 0;
					npc.startDialogue(npc, 4);
				}
				else {
					if(gp.player.inventory.get(itemIndex).amount > 1) {
						gp.player.inventory.get(itemIndex).amount--;
					}
					else {
						gp.player.inventory.remove(itemIndex);
					}
					gp.player.coin += price;
				}
			}
		}
	}
	public void drawSleepScreen(Graphics2D g2) {
		
	    counter++;
	    float sleepAlpha;
	    
	    if (counter < 120) {
	        // Dimming
	        sleepAlpha = counter * 0.01f;  // Goes from 0.0 to ~1.2, so we cap it at 1.0
	        if (sleepAlpha > 1f) {
	            sleepAlpha = 1f;
	        }
	    } else if (counter < 240) {
	        // Brightening
	        sleepAlpha = 1f - ((counter - 120) * 0.01f);  // Decreases from 1f to 0f
	        if (sleepAlpha < 0f) {
	            sleepAlpha = 0f;
	        }
	    } else {
	        sleepAlpha = 0f;
	        counter = 0;
	        gp.player.life = gp.player.maxLife;
	        gp.player.mana = gp.player.maxMana;
            gp.eManager.lighting.timeOfDay = 8.0f;
            gp.eManager.lighting.hours = 8;
            gp.eManager.lighting.minutes = 0;
	        gp.gameState = gp.dialogueState;
	        gp.saveLoad.save();
	        System.out.println("Game saved");
	    }

	    Composite originalComposite = g2.getComposite();
	    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, sleepAlpha));
	    g2.setColor(Color.black);
	    g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
	    // Restore the original composite so that further drawing isn't affected.
	    g2.setComposite(originalComposite);
	}
	public void drawJournalScreen() {
	    int leftFrameX = 20;  // Left section (for quests)
	    int leftFrameY = 20;
	    int leftFrameWidth = gp.screenWidth * 4 / 10;
	    int leftFrameHeight = gp.screenHeight - 40;

	    // Draw the left quest journal window
	    drawSubWindow(leftFrameX, leftFrameY, leftFrameWidth, leftFrameHeight);

	    int textX = leftFrameX + 30;
	    int textY = leftFrameY + 50;

	    // Determine the number of quests
	    int activeCount = gp.qManager.getQuestJournal().getActiveQuests().size();
	    int completedCount = gp.qManager.getQuestJournal().getCompletedQuests().size();

	    // Combined total quests for selection:
	    int totalCombined = activeCount + completedCount;
	    
	    // Display "You have no active quests" or "You have no completed quests" if no quests are available
	    if (activeCount == 0 && playerJournalIndex < activeCount) {
	        g2.setFont(g2.getFont().deriveFont(13F));
	        g2.setColor(Color.WHITE);
	        g2.drawString("No active quests", textX, textY + 50);
	    } else if (completedCount == 0 && playerJournalIndex >= activeCount) {
	        g2.setFont(g2.getFont().deriveFont(13F));
	        g2.setColor(Color.WHITE);
	        g2.drawString("No completed quests", textX, textY + 50);
	    }

	    // Depending on the selection, draw Active or Completed section
	    if (playerJournalIndex < activeCount) {
	    	
	        // ACTIVE
	        g2.setFont(g2.getFont().deriveFont(21F));
	        g2.setColor(Color.white);
	        g2.drawString("Active Quests", leftFrameX + 30, leftFrameY + 50);
	        
	        textY = leftFrameY + 100;
	        int lineSpacing = 20;
	        g2.setFont(g2.getFont().deriveFont(13F));

	        // Use activeScrollOffset for the active list
	        int scrollStartIndex = activeScrollOffset;
	        for (int i = scrollStartIndex; i < activeCount; i++) {
	            Quest quest = gp.qManager.getQuestJournal().getActiveQuests().get(i);

	            // Highlight the selected quest if within active section
	            if (i == playerJournalIndex) {
	                g2.setColor(Color.YELLOW);
	            } else {
	                g2.setColor(Color.LIGHT_GRAY);
	            }

	            for (String line : quest.getName().split("\n")) {
	                g2.drawString(line, textX, textY);
	                textY += 25;
	            }
	            textY += lineSpacing;
	            if (textY > leftFrameY + leftFrameHeight - 20) {
	                break;
	            }
	        }
	    } else {
	    	
	        // COMPLETED
	        g2.setFont(g2.getFont().deriveFont(21F));
	        g2.setColor(Color.white);
	        g2.drawString("Completed Quests", leftFrameX + 30, leftFrameY + 50);

	        textY = leftFrameY + 100;
	        int lineSpacing = 20;
	        g2.setFont(g2.getFont().deriveFont(13F));

	        // Use completedScrollOffset for the completed list
	        int scrollStartIndex = completedScrollOffset;
	        // Adjust selection index for completed
	        int selectionInCompleted = playerJournalIndex - activeCount;
	        for (int i = scrollStartIndex; i < completedCount; i++) {
	            Quest quest = gp.qManager.getQuestJournal().getCompletedQuests().get(i);

	            if (i == selectionInCompleted) {
	                g2.setColor(Color.YELLOW);
	            } else {
	                g2.setColor(Color.DARK_GRAY);
	            }

	            for (String line : quest.getName().split("\n")) {
	                g2.drawString(line, textX, textY);
	                textY += 25;
	            }
	            textY += lineSpacing;
	            if (textY > leftFrameY + leftFrameHeight - 20) {
	                break;
	            }
	        }
	    }
	    // Bobbing arrow
	    if (playerJournalIndex == activeCount - 1 && completedCount > 0) {
	        drawBobbingDownwardsArrow(leftFrameX + leftFrameWidth / 2, leftFrameY + leftFrameHeight - 50);
	    }
	    // Right Panel (Expanded Quest Details)
	    if (totalCombined > 0) {
	        drawExpandedQuestDetails(g2, playerJournalIndex);
	    }
	}
	public void scrollDown() {
	    int activeCount = gp.qManager.getQuestJournal().getActiveQuests().size();
	    int completedCount = gp.qManager.getQuestJournal().getCompletedQuests().size();
	    int maxVisibleQuests = 9;

	    if (gp.ui.playerJournalIndex < activeCount) {
	        // Active
	        if (gp.ui.playerJournalIndex >= activeScrollOffset + maxVisibleQuests - 1 && activeScrollOffset + maxVisibleQuests < activeCount) {
	            activeScrollOffset++;
	        }
	    } else {
	        // Completed
	        int selectionInCompleted = gp.ui.playerJournalIndex - activeCount;
	        if (selectionInCompleted >= completedScrollOffset + maxVisibleQuests - 1 && completedScrollOffset + maxVisibleQuests < completedCount) {
	            completedScrollOffset++;
	        }
	    }
	}

	public void scrollUp() {
	    int activeCount = gp.qManager.getQuestJournal().getActiveQuests().size();

	    if (gp.ui.playerJournalIndex < activeCount) {
	        // Active
	        if (gp.ui.playerJournalIndex <= activeScrollOffset && activeScrollOffset > 0) {
	            activeScrollOffset--;
	        }
	    } else {
	        // Completed
	        int selectionInCompleted = gp.ui.playerJournalIndex - activeCount;
	        if (selectionInCompleted <= completedScrollOffset && completedScrollOffset > 0) {
	            completedScrollOffset--;
	        }
	    }
	}
	// Method to display the expanded quest details on the right side
	private void drawExpandedQuestDetails(Graphics2D g2, int selectedIndex) {
	    int rightFrameX = gp.screenWidth * 5/10 - 50; // Right side of the screen
	    int rightFrameY = 20;
	    int rightFrameWidth = gp.screenWidth * 5/10 + 30; // Right half of the screen
	    int rightFrameHeight = gp.screenHeight - 40;  // Full screen height

	    // Draw the right panel for expanded quest details
	    drawSubWindow(rightFrameX, rightFrameY, rightFrameWidth, rightFrameHeight);

	    // Determine if the selected quest is active or completed.
	    int activeCount = gp.qManager.getQuestJournal().getActiveQuests().size();
	    Quest selectedQuest;
	    if (selectedIndex < activeCount) {
	        selectedQuest = gp.qManager.getQuestJournal().getActiveQuests().get(selectedIndex);
	    } else {
	        int completedIndex = selectedIndex - activeCount;
	        selectedQuest = gp.qManager.getQuestJournal().getCompletedQuests().get(completedIndex);
	    }
	    
	    // Title of the selected quest
	    g2.setFont(g2.getFont().deriveFont(18F));
	    g2.setColor(Color.WHITE);
	    int titleX = rightFrameX + 30;
	    int titleY = rightFrameY + 50;
	    g2.drawString(selectedQuest.getName().replace("\n", " "), titleX, titleY);
	    
	    // Underline the title
	    int titleWidth = g2.getFontMetrics().stringWidth(selectedQuest.getName().replace("\n", " "));
	    int underlineY = titleY + 5; // Position the underline slightly below the text
	    g2.drawLine(titleX, underlineY, titleX + titleWidth, underlineY); // Draw the underline

	    // Quest description
	    g2.setFont(g2.getFont().deriveFont(14F));
        for(String line : selectedQuest.getDescription().split("\n")) {
			g2.drawString(line, rightFrameX + 30, rightFrameY + 100);
			rightFrameY += 25;
		}

     // Draw quest stages with strikethrough for completed stages
        int textY = rightFrameY + 120;
        int lineSpacing = 20;
        boolean firstIncompleteStageFound = false;

        for (QuestStage stage : selectedQuest.getStages()) {
            g2.setFont(g2.getFont().deriveFont(10F));

            // Split the description into lines for both completed and non-completed stages
            String[] lines = stage.getDescription().split("\n");
            
            if (!firstIncompleteStageFound) {
            	
                // Draw the stage description
                if (stage.isCompleted()) {
                    g2.setColor(Color.GRAY);
                    for (String line : lines) {
                        g2.drawString(line, rightFrameX + 30, textY);

                        // Strikethrough
                        g2.setStroke(new BasicStroke(0.5f));
                        int strikethroughY = textY - 5;
                        int strikethroughWidth = g2.getFontMetrics().stringWidth(line);
                        g2.drawLine(rightFrameX + 30, strikethroughY, rightFrameX + 30 + strikethroughWidth, strikethroughY);

                        // Reset the stroke
                        g2.setStroke(new BasicStroke(1f));

                        // Increment textY after drawing each line
                        textY += lineSpacing;
                    }
                } else {
                    // For non-completed stages
                    g2.setColor(Color.YELLOW);
                    for (String line : lines) {
                        g2.drawString(line, rightFrameX + 30, textY);
                        textY += lineSpacing;
                    }
                    firstIncompleteStageFound = true;
                }
            }
            // Additional spacing between stages
            textY += lineSpacing;
        }
	}
	public int getItemIndexOnSlot(int slotCol, int slotRow) {
		int itemIndex = slotCol + (slotRow * 5);
		return itemIndex;
	}
    public void initWorldLightSources() {
    	lightSources.removeAll(lightSources);
    	
        // Loop through all objects in the current map
        for (int i = 0; i < gp.obj[gp.currentMap].length; i++) {
        	
        	//LampPost
            if (gp.obj[gp.currentMap][i] != null &&
                gp.obj[gp.currentMap][i].name.equals(OBJ_LampPost.objName)) {

            	// Cast to OBJ_LampPost to access lamppost_size
                OBJ_LampPost lamp = (OBJ_LampPost) gp.obj[gp.currentMap][i];
                

                int offset;
                int lightIntensity;
                
				if(lamp.lamppost_size == 2) {
                    lightIntensity = 170;
                    offset = 1;
                } else {
                    lightIntensity = 150;
                    offset = 0;
                }
				
            	
                // Cast to the lamp post object if needed, or use it directly
                // Assuming the lamp post has worldX and worldY fields for its position:
                lightSources.add(new LightSource(gp.obj[gp.currentMap][i].worldX/gp.tileSize,
                                                 gp.obj[gp.currentMap][i].worldY/gp.tileSize + offset,
                                                 lightIntensity, // adjust light radius/intensity as needed
                                                 gp));
            }
            //Campfire
            if (gp.obj[gp.currentMap][i] != null &&
                    gp.obj[gp.currentMap][i].name.equals(OBJ_Campfire.objName)) {     	
                    // Cast to the lamp post object if needed, or use it directly
                    // Assuming the lamp post has worldX and worldY fields for its position:
                    lightSources.add(new LightSource(gp.obj[gp.currentMap][i].worldX/gp.tileSize,
                                                     (gp.obj[gp.currentMap][i].worldY/gp.tileSize) + 1,
                                                     250, // adjust light radius/intensity as needed
                                                     gp));
            }
            //Big Torch
            if (gp.obj[gp.currentMap][i] != null &&
                    gp.obj[gp.currentMap][i].name.equals(OBJ_BigTorch.objName)) {     	
                    // Cast to the lamp post object if needed, or use it directly
                    // Assuming the lamp post has worldX and worldY fields for its position:
                    lightSources.add(new LightSource(gp.obj[gp.currentMap][i].worldX/gp.tileSize,
                                                     (gp.obj[gp.currentMap][i].worldY/gp.tileSize) + 1,
                                                     150, // adjust light radius/intensity as needed
                                                     gp));
                }
        }
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        // Shadow effect
        Color shadow = new Color(30, 20, 15, 150); 
        g2.setColor(shadow);
        g2.fillRoundRect(x + 5, y + 5, width, height, 40, 40);

        // Modern brown background
        Color background = new Color(60, 42, 33, 210);
        g2.setColor(background);
        g2.fillRoundRect(x, y, width, height, 30, 30);

        // Light beige border
        Color border = new Color(230, 215, 190);
        g2.setColor(border);
        g2.setStroke(new BasicStroke(4));
        g2.drawRoundRect(x + 4, y + 4, width - 8, height - 8, 20, 20);
    }
	public int getXforCenteredText(String text) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = gp.screenWidth/2 - length/2;
		return x;
	}
	public int getXforAlignToRightText(String text, int tailX) {
		
		int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = tailX - length;
		return x;
	}
	private void drawBobbingDownwardsArrow(int x, int baseY) {
	    // Use sine wave for bobbing effect
	    arrowY = (float) Math.sin(System.currentTimeMillis() / 250.0) * 5;  // Adjust frequency and amplitude

	    // Draw a downward arrow (you can replace this with a custom image if needed)
	    g2.setColor(Color.WHITE);
	    g2.drawImage(downArrowSprite, x - downArrowSprite.getWidth(null) / 2, baseY + (int) arrowY, 
	             downArrowSprite.getWidth(null) * 2, downArrowSprite.getHeight(null) * 2, null);
	}
}
	
