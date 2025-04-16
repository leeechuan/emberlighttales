package main.emberlight;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

import data.Progress;
import entity.Entity;
import entity.NPC_Elder;
import entity.NPC_Farmer;
import entity.NPC_Guard;
import entity.NPC_GymBro;
import entity.NPC_Mayor;
import entity.NPC_Punk;
import entity.NPC_Scientist;
import entity.NPC_Wife;
import entity.NPC_Witch;
import entity.PlayerDummy;
import mob.MOB_Orc_Chief;
import mob.MOB_Orc_Lieutenant;
import mob.MOB_Orc_Second;
import object.OBJ_EmberlightPearl;
import object.OBJ_Spike_Gate;

public class CutsceneManager {
	GamePanel gp;
	Graphics2D g2;
	public int sceneNum;
	public int scenePhase;
	int counter = 0;
	float alpha = 0f;
	int y;
	String endCredit;
	Entity cutsceneMaster;
	public boolean usingDummyPlayer;
	
	//Check for 2nd key presses for tutorial
	private int pressCount = 0;
	private boolean characterKeyPressedLastFrame = false;
	
	//Scene Number
	public final int NA = 0;
	public final int tutorial = 1;
	public final int townhall = 2;
	public final int witchSerum = 3;
	public final int guardSpeak = 4;
	public final int orcLieutenant = 5;
	public final int orcLieutenantDefeated = 6;
	public final int orcSecond = 7;
	public final int orcSecondDefeated = 8;
	public final int orcChief = 9;
	public final int ending = 10;
	public final int ending2 = 11;
	public final int ending3 = 12;
	
	public CutsceneManager(GamePanel gp) {
		this.gp = gp;
		
		cutsceneMaster = new Entity(gp);
		
		endCredit = "Program\n"
				+"Lee Chuan\n\n"
				+"Music/SFX\n"
				+"Lee Chuan\n\n"
				+"Art\n"
				+"Lee Chuan/@KenmiPixelArt\n"
				+"\n\n\n\n\n\n\n\n\n\n\n\n"
				+"Special Thanks\n\n"
				+"@RyiSnow\n"
				+"for intuitive tutorials\n\n"
				+"SUNO\n"
				+"for music gneration\n\n"
				+"voidless.dev\n"
				+"for title screen\n\n\n\n\n\n\n\n"
				+"Thank you for playing!";
				
	}
	public void draw(Graphics2D g2) {
		this.g2 = g2;
		
		switch(sceneNum) {
		case tutorial: scene_tutorial(); break;
		case townhall: scene_townhall(); break;
		case witchSerum : scene_witchSerum(); break;
		case guardSpeak : scene_guardSpeak(); break;
		case orcLieutenant: scene_orcLieutenant(); break;
		case orcLieutenantDefeated: scene_orcLieutenantDefeated(); break;
		case orcSecond: scene_orcSecond(); break;
		case orcSecondDefeated: scene_orcSecondDefeated(); break;
		case orcChief : scene_orcChief(); break;
		case ending: scene_ending(); break;
		case ending2: scene_ending2(); break;
		case ending3: scene_ending3(); break;
		}
	}
	public void setDialogue() {
		if(sceneNum == tutorial) {
			cutsceneMaster.dialogues[0][0] = "Yawnnnnnnnnnnn";
			cutsceneMaster.dialogues[0][1] = "That was a good nap...";
			cutsceneMaster.dialogues[0][2] = "Let me stretch my legs...";
			cutsceneMaster.dialogues[0][3] = "(Press WASD to move)";
			
			cutsceneMaster.dialogues[1][0] = "Can't wait to take my sword on a spin...";
			cutsceneMaster.dialogues[1][1] = "(Press ENTER to attack/interact)";
			
			cutsceneMaster.dialogues[2][0] = "Hmm, if an enemy is far, I could use some\nrange...";
			cutsceneMaster.dialogues[2][1] = "(Press E to shoot an arrow.)";
			
			cutsceneMaster.dialogues[3][0] = "With the power of your plush toy\nPablo the rabbit...";
			cutsceneMaster.dialogues[3][1] = "...hold spacebar to block incoming attacks!";
			
			cutsceneMaster.dialogues[4][0] = "Nice!";
			cutsceneMaster.dialogues[4][1] = "(Press C to open your inventory)";
			
			cutsceneMaster.dialogues[5][0] = "All ready! Adventure awaits.";
		}
		if(sceneNum == witchSerum) {
			cutsceneMaster.dialogues[0][0] = "A shock of heat runs through your\nbody. Vision blurs. Muscles tense.\nShadows ripple nunnaturally across\nthe floor.";
			cutsceneMaster.dialogues[0][1] = "(Press Q to transform)";
			cutsceneMaster.dialogues[0][2] = null;
			cutsceneMaster.dialogues[0][3] = null;
		}
		if(sceneNum == orcLieutenantDefeated) {
			cutsceneMaster.dialogues[0][0] = "(Gorrun drops to his knees, blade\nclattering beside him. A heavy\nsilence settles in the chamber.)";
			cutsceneMaster.dialogues[0][1] = "(On him, you spotted a leather\nsatchel, sealed with a crude\nbone clasp.";
			cutsceneMaster.dialogues[0][2] = "To Skarr:\n"
					+ "We strike North. The chief's plan holds.\n"
					+ "Burn the bridges behind you. No mercy.\n"
					+ "— Zulgar";
		};
	}
	public void scene_tutorial() {
	    switch(scenePhase) {
	        case 0: // Fade in
	            alpha += 0.01f;
	            if (alpha >= 1f) {
	                alpha = 1f;
	                scenePhase++;
	            }
	            drawBlackBackground(1f - alpha);
	            break;
	        
	        case 1: // Display first instruction (Move with WASD)
	        	cutsceneMaster.startDialogue(cutsceneMaster, 0);
	        	scenePhase++;
	            break;
	        
	        case 2: // Wait 1 second after first movement
	            if (counter == 0) { 
	                // First time a movement key is pressed, start the timer
	                if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.leftPressed || gp.keyH.rightPressed) {
	                    counter = 1;  // Start counting frames
	                }
	            } else if (counterReached(60)) { 
	                // If 1 seconds (60 frames) have passed since first key press, proceed
	                scenePhase++;
	                counter = 0;
	            }
	            break;
	        case 3: // Display attack instruction
	        	cutsceneMaster.startDialogue(cutsceneMaster, 1);
	        	scenePhase++;
	            break;
	        
	        case 4: //attack tutorial
	            if (counter == 0) { 
	                // First time a movement key is pressed, start the timer
	                if (gp.keyH.attackPressed) {
	                    counter = 1;  // Start counting frames
	                }
	            } else if (counterReached(60)) { 
	                // If 1 seconds (60 frames) have passed since first key press, proceed
	                scenePhase++;
	                counter = 0;
	            }
	            break;
	        case 5: // Display shoot instruction
	        	cutsceneMaster.startDialogue(cutsceneMaster, 2);
	        	scenePhase++;
	            break;

	        case 6: // Wait 1 second after shoot
	            if (counter == 0) { 
	                // First time a shoot key is pressed, start the timer
	                if (gp.keyH.shotKeyPressed) {
	                    counter = 1;  // Start counting frames
	                }
	            } else if (counterReached(60)) { 
	                // If 1 second (60 frames) have passed since first key press, proceed
	                scenePhase++;
	                counter = 0;
	            }
	            break;
	        case 7: // Display block instruction dialogue
	            cutsceneMaster.startDialogue(cutsceneMaster, 3);
	            scenePhase++;
	            break;
	        case 8: // Wait for a key press to continue (or add a short delay)
	            if (counter == 0) { 
	            	// Wait 1 second after block
	                if (gp.keyH.spacePressed) {
	                    counter = 1;  // Start counting frames
	                }
	            } else if (counterReached(60)) { 
	                // If 1 second (60 frames) have passed since first key press, proceed
	                scenePhase++;
	                counter = 0;
	            }
	            break;
	        case 9: // Display character inventory instruction dialogue
	            cutsceneMaster.startDialogue(cutsceneMaster, 4);
	            scenePhase++;
	            break;
	        case 10: // Wait for second 'c' press to continue
	            if (gp.keyH.characterPressed && !characterKeyPressedLastFrame) {
	                // Increment the counter every time the key is pressed
	                pressCount++;
	                
	                // If it's the second press, proceed to the next phase
	                if (pressCount == 2) {
	                    scenePhase++; // Move to the next phase
	                    pressCount = 0; // Reset the press count for future use
	                }
	                
	                // Set the flag to prevent counting multiple presses in one frame
	                characterKeyPressedLastFrame = true;
	            } else if (!gp.keyH.characterPressed) {
	                // Reset the flag when the key is released
	                characterKeyPressedLastFrame = false;
	            }
	            break;
	        case 11: // Display final message
	        	cutsceneMaster.startDialogue(cutsceneMaster, 5);
                Progress.gameStage = Progress.STAGE_INTRODUCTION;
                scenePhase++;
	            if (gp.keyH.enterPressed) {
	                sceneNum = NA;
	                scenePhase = 0;
	            	gp.gameState = gp.playState;
	                cutsceneMaster.dialogueSet = 0; // Reset to the starting dialogue set
	                cutsceneMaster.dialogueIndex = 0; // Reset to the first dialogue
	            }
	            break;
	    }
	}
	public void scene_townhall() {
		switch(scenePhase) {
			case 0:
				alpha += 0.1f;
	            if(alpha > 1f) {
	                alpha = 1f;
	                // Set NPCs once when the screen is fully black
	                gp.aSetter.setNPC();
	                scenePhase++;
	            }
	            drawBlackBackground(alpha);
	            break;
			case 1:
				alpha -= 0.01f;
	            if (alpha <= 0f) {
	                alpha = 0f;
	                scenePhase++;
	            }
	            drawBlackBackground(alpha);
	            break;
			case 2:
				
				gp.player.update();
				gp.player.pathfindTo(81, 72, "up");


				for (int i = 0; i < gp.npc.length; i++) {
			        for (Entity npc : gp.npc[i]) {
			            if (npc != null && npc.name.equals("Mayor Oren")) {
		                	npc.update();
		                    npc.pathfindTo(80, 69, "down");
			            }
			            if (npc != null && npc.name.equals("Bram Tiller")) {
		                	npc.update();
		                    npc.pathfindTo(79, 71, "up");
			            }
			            if (npc != null && npc.name.equals("Luca Aldermere")) {
		                	npc.update();
		                    npc.pathfindTo(77, 70, "right");
			            }
			            if (npc != null && npc.name.equals("Corvin Green")) {
		                	npc.update();
		                    npc.pathfindTo(82, 70, "left");
			            }
			            if (npc != null && npc.name.equals("Vex Cragstone")) {
		                	npc.update();
		                    npc.pathfindTo(82, 69, "left");
			            }
			            if (npc != null && npc.name.equals("Dr. Thorne Baxter")) {
		                	npc.update();
		                    npc.pathfindTo(82, 71, "up");
			            }
			            if (npc != null && npc.name.equals("Nessa Aldermere")) {
		                	npc.update();
		                    npc.pathfindTo(77, 69, "right");
			            }
			            if (npc != null && npc.name.equals("Witch Morga")) {
		                	npc.update();
		                    npc.pathfindTo(78, 73, "up");
			            }
			            if (npc != null && npc.name.equals("Bran Iron-Hands")) {
		                	npc.update();
		                    npc.pathfindTo(80, 71, "up");
			            }
			        }
			    }
	            if (counterReached(600)) { 
	                // If 1 second (60 frames) have passed since first key press, proceed
	                scenePhase++;
	                counter = 0;
	            }
		        break;
			case 3:
				//Search for the mayor
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Mayor.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
			case 4:
				if(scenePhase == 4) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 5:
				//Search for the wife
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Wife.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
			case 6:
				if(scenePhase == 6) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 7:
				//Search for the mayor
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Mayor.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 8:
				if(scenePhase == 8) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 1;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 9:
				//Search for the farmer
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Farmer.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 10:
				if(scenePhase == 10) {
					//Farmer Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 11:
				//Search for the Mayor
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Mayor.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 12:
				if(scenePhase == 12) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 2;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 13:
				//Search for the GymBro
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_GymBro.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 14:
				if(scenePhase == 14) {
					//GymBro Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 15:
				//Search for the Scientist
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Scientist.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 16:
				if(scenePhase == 16) {
					//Scientist Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 17:
				//Search for the Mayor
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Mayor.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 18:
				if(scenePhase == 18) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 3;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 19:
				//Search for the Punk
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Punk.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 20:
				if(scenePhase == 20) {
					//Scientist Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 21:
				//Search for the Mayor
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Mayor.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 22:
				if(scenePhase == 22) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 4;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 23:
				//Search for the Witch
				for(int i = 0; i < gp.npc[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null &&
							gp.npc[gp.currentMap][i].name == NPC_Witch.npcName) {
						
						gp.npc[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.npc[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
				break;
			case 24:
				if(scenePhase == 24) {
					//Mayor Speak
					gp.ui.npc.dialogueSet = 0;
					gp.ui.npc.setDialogue();
					gp.ui.drawDialogueScreen();
				}
				break;
			case 25:
				alpha += 0.1f;
	            if(alpha > 1f) {
	                alpha = 1f;
	                scenePhase++;
	            }
	            drawBlackBackground(alpha);
	            break;
			case 26:
				alpha -= 0.01f;
	            if (alpha <= 0f) {
	                alpha = 0f;
	                scenePhase++;
	            }
	            drawBlackBackground(alpha);
	            break;
			case 27:
			    // Reset all NPCs to ensure they can move after the cutscene
			    for (int i = 0; i < gp.npc.length; i++) {
			        for (Entity npc : gp.npc[i]) {
			            if (npc != null) {
			                npc.resetPathfinding(); // Custom method to reset movement state
			                npc.getRandomDirection();
			            }
			        }
			    }
				gp.player.resetPathfinding();
				sceneNum = NA;
				scenePhase = 0;
				gp.gameState = gp.playState;
				gp.pManager.addNotification("Journal Updated");
				gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Bound By Blood And Magic"));
				gp.updateNPCDialogues();
				Progress.gameStage = Progress.STAGE_MEET_WITCH;
	            break;
		}
		
	}
	public void scene_witchSerum() {
		switch(scenePhase) {
		case 0:
			cutsceneMaster.setDialogue();
			//Search for the Witch
			for(int i = 0; i < gp.npc[1].length; i++) {
				
				if(gp.npc[gp.currentMap][i] != null &&
						gp.npc[gp.currentMap][i].name == NPC_Witch.npcName) {
					
					gp.npc[gp.currentMap][i].sleep = false;
					gp.ui.npc = gp.npc[gp.currentMap][i];
					scenePhase++;
					break;
				}
			}
			break;
		case 1:
			if(scenePhase == 1) {
				//Witch Speak
				gp.ui.npc.dialogueSet = 0;
				gp.ui.npc.setDialogue();
				gp.ui.drawDialogueScreen();
			}
			break;
        case 2: // Display cutscene
        	Progress.gameStage = Progress.STAGE_SERUM_GIVEN;
			gp.pManager.addNotification("Journal Updated");
			gp.qManager.progressQuest("Bound By Blood And Magic");
            cutsceneMaster.dialogueSet = 0; // Reset to the starting dialogue set
            cutsceneMaster.dialogueIndex = 0; // Reset to the first dialogue
        	cutsceneMaster.startDialogue(cutsceneMaster, 0);
        	scenePhase++;
            break;
        
        case 3: //transform tutorial
            if (counter == 0) { 
                // First time a movement key is pressed, start the timer
                if (gp.keyH.gremlinPressed) {
                    counter = 1;  // Start counting frames
                }
            } else if (counterReached(60)) { 
                // If 1 seconds (60 frames) have passed since first key press, proceed
                scenePhase++;
                counter = 0;
            }
            break;
		case 4:
			sceneNum = NA;
			scenePhase = 0;
			gp.gameState = gp.playState;
			gp.pManager.addNotification("Journal Updated");
			gp.qManager.progressQuest("Bound By Blood And Magic");
			gp.updateNPCDialogues();
            break;
		}
	}
	public void scene_guardSpeak() {
		switch(scenePhase) {
		case 0:
			//Search for the Guard
			for(int i = 0; i < gp.npc[1].length; i++) {
				
				if(gp.npc[gp.currentMap][i] != null &&
						gp.npc[gp.currentMap][i].name == NPC_Guard.npcName) {
					
					gp.npc[gp.currentMap][i].sleep = false;
					gp.ui.npc = gp.npc[gp.currentMap][i];
					scenePhase++;
					break;
				}
			}
			break;
		case 1:
			if(scenePhase == 1) {
				//Guard Speak
				gp.ui.npc.dialogueSet = 0;
				gp.ui.npc.setDialogue();
				gp.ui.drawDialogueScreen();
			}
			break;

		case 2:
			sceneNum = NA;
			scenePhase = 0;
			gp.gameState = gp.playState;
			gp.pManager.addNotification("Journal Updated");
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Beneath Enemy Lines"));
			gp.updateNPCDialogues();
			Progress.gameStage = Progress.STAGE_FIND_ORC_LIEUTENANT;
            break;
		}
	}
	public void scene_orcLieutenant() {
		
		if(scenePhase == 0) {
			
			gp.bossBattleOn = true;
			
			//Search a vacant slot for player dummy
			for(int i = 0; i < gp.npc[1].length; i++) {
				
				if(gp.npc[gp.currentMap][i] == null) {
					gp.npc[gp.currentMap][i] = new PlayerDummy(gp);
					gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
					gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
					gp.npc[gp.currentMap][i].direction = gp.player.direction;
					usingDummyPlayer = true;
					break;
				}
			}
			
			gp.player.drawing = false;
			
			scenePhase++;
			}
		
			if(scenePhase == 1) {
				gp.player.worldY += 2;
				if(gp.player.worldY > gp.tileSize*87) {
					scenePhase++;
				}
			}
			if(scenePhase == 2) {
				
				//Search for the boss
				for(int i = 0; i < gp.mob[1].length; i++) {
					
					if(gp.mob[gp.currentMap][i] != null &&
							gp.mob[gp.currentMap][i].name == MOB_Orc_Lieutenant.mobName) {
						
						gp.mob[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.mob[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
			}
			if(scenePhase == 3) {
				
				//Boss Speak
				gp.ui.drawDialogueScreen();
			}
			if(scenePhase == 4) {
				
				//Return camera to player
				
				//Search for dummy player
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name.equals(PlayerDummy.npcName)) {
						//Restore the player position
						gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
						gp.player.worldY = gp.npc[gp.currentMap][i].worldY;
						//Delete dummy
						gp.npc[gp.currentMap][i] = null;
						usingDummyPlayer = false;
						break;
					}
				}
				
				//Start drawing the player
				gp.player.drawing = true;
				
				//Reset
				sceneNum = NA;
				scenePhase = 0;
				gp.gameState = gp.playState;
				
				//Change boss music 
				gp.stopMusic();
				gp.playMusic(19);
				
				gp.qManager.progressQuest("Second's Fall");
				gp.pManager.addNotification("Journal Updated");
			}
	}
	public void scene_orcLieutenantDefeated() {
		System.out.println(scenePhase);
		switch(scenePhase) {
		case 0:
			gp.gameState = gp.playState;
			if (counter == 0) { 
	            // First time a shoot key is pressed, start the timer
	            if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.leftPressed || gp.keyH.rightPressed) {
	        		gp.csManager.setDialogue();
	                counter = 1;  // Start counting frames
	            }
	        } else if (counterReached(60)) { 
	            // If 1 second (60 frames) have passed since first key press, proceed
	            scenePhase++;
	            counter = 0;
	        }
		case 1:
			if(scenePhase == 1) {
	        	cutsceneMaster.startDialogue(cutsceneMaster, 0);
	        	gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"));
	        	gp.qManager.progressQuest("Sands of Peril");
	        	gp.pManager.addNotification("Journal Updated");
	        	scenePhase++;
			}
		}
        
	}
	public void scene_orcSecond() {
		System.out.println(scenePhase);
		if(scenePhase == 0) {
			
			gp.bossBattleOn = true;
			
			//Search a vacant slot for player dummy
			for(int i = 0; i < gp.npc[1].length; i++) {
				
				if(gp.npc[gp.currentMap][i] == null) {
					gp.npc[gp.currentMap][i] = new PlayerDummy(gp);
					gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
					gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
					gp.npc[gp.currentMap][i].direction = gp.player.direction;
					usingDummyPlayer = true;
					break;
				}
			}
			
			gp.player.drawing = false;
			
			scenePhase++;
			}
		
			if (scenePhase == 1) {
				
				if (gp.player.worldY <= gp.tileSize * 16) {
					gp.player.worldX -= 2;
					if (gp.player.worldX <= gp.tileSize * 63) {
						scenePhase++;
					}
				}else {
					gp.player.worldY -= 2;
				}
			}
			if(scenePhase == 2) {
				
				//Search for the boss
				for(int i = 0; i < gp.mob[1].length; i++) {
					
					if(gp.mob[gp.currentMap][i] != null &&
						gp.mob[gp.currentMap][i].name == MOB_Orc_Second.mobName) {
						
							gp.mob[gp.currentMap][i].sleep = false;
							gp.ui.npc = gp.mob[gp.currentMap][i];
							scenePhase++;
							break;
					}
				}
			}
			if(scenePhase == 3) {
				
				//Boss Speak
				gp.ui.npc.dialogueSet = 0;
				gp.ui.npc.setDialogue();
				gp.ui.drawDialogueScreen();
			}
			if(scenePhase == 4) {
				
				//Return camera to player
				
				//Search for dummy player
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name.equals(PlayerDummy.npcName)) {
						//Restore the player position
						gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
						gp.player.worldY = gp.npc[gp.currentMap][i].worldY;
						//Delete dummy
						gp.npc[gp.currentMap][i] = null;
						usingDummyPlayer = false;
						break;
					}
				}
				
				//Start drawing the player
				gp.player.drawing = true;
				
				//Reset
				sceneNum = NA;
				scenePhase = 0;
				gp.gameState = gp.playState;
				
				//Change boss music 
				gp.stopMusic();
				gp.playMusic(19);
			}
	}
	public void scene_orcSecondDefeated() {
		System.out.println(scenePhase);
		switch(scenePhase) {
		case 0:
			gp.gameState = gp.playState;
			if (counter == 0) { 
	            // First time a shoot key is pressed, start the timer
	            if (gp.keyH.upPressed || gp.keyH.downPressed || gp.keyH.leftPressed || gp.keyH.rightPressed) {
	        		gp.csManager.setDialogue();
	                counter = 1;  // Start counting frames
	            }
	        } else if (counterReached(60)) { 
	            // If 1 second (60 frames) have passed since first key press, proceed
	            scenePhase++;
	            counter = 0;
	        }
		case 1:
			if(scenePhase == 1) {
	        	cutsceneMaster.startDialogue(cutsceneMaster, 0);
	        	gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"));
	        	gp.qManager.progressQuest("Second's Fall");
	        	gp.pManager.addNotification("Journal Updated");
	        	scenePhase++;
			}
		}
        
	}
	public void scene_orcChief() {
		
		if(scenePhase == 0) {
			
			gp.bossBattleOn = true;
			
			//Shut Door 1
//			for(int i = 0; i < gp.obj[1].length; i++) {
//				
//				if(gp.obj[gp.currentMap][i] == null) {
//					gp.obj[gp.currentMap][i] = new OBJ_Spike_Gate(gp);
//					gp.obj[gp.currentMap][i].worldX = gp.tileSize*49;
//					gp.obj[gp.currentMap][i].worldY = gp.tileSize*63;
//					gp.obj[gp.currentMap][i].temp = true;
//			        // Ensure the gate starts closing
//			        gp.obj[gp.currentMap][i].gate_open_state = false;
//					gp.playSE(18);
//					break;
//				}
//			}
			//Shut Door 2
			for(int i = 0; i < gp.obj[1].length; i++) {
				
				if(gp.obj[gp.currentMap][i] == null) {
					gp.obj[gp.currentMap][i] = new OBJ_Spike_Gate(gp);
					gp.obj[gp.currentMap][i].worldX = gp.tileSize*49;
					gp.obj[gp.currentMap][i].worldY = gp.tileSize*42;
					gp.obj[gp.currentMap][i].temp = true;
			        // Ensure the gate starts closing
			        gp.obj[gp.currentMap][i].gate_open_state = false;
					break;
				}
			}
			//Search a vacant slot for player dummy
			for(int i = 0; i < gp.npc[1].length; i++) {
				
				if(gp.npc[gp.currentMap][i] == null) {
					gp.npc[gp.currentMap][i] = new PlayerDummy(gp);
					gp.npc[gp.currentMap][i].worldX = gp.player.worldX;
					gp.npc[gp.currentMap][i].worldY = gp.player.worldY;
					gp.npc[gp.currentMap][i].direction = gp.player.direction;
					usingDummyPlayer = true;
					break;
				}
			}
			
			gp.player.drawing = false;
			
			scenePhase++;
			}
		
			if(scenePhase == 1) {
				gp.player.worldY -= 2;
				if(gp.player.worldY < gp.tileSize*46) {
					scenePhase++;
				}
			}
			if(scenePhase == 2) {
				
				//Search for the boss
				for(int i = 0; i < gp.mob[1].length; i++) {
					
					if(gp.mob[gp.currentMap][i] != null &&
							gp.mob[gp.currentMap][i].name == MOB_Orc_Chief.mobName) {
						
						gp.mob[gp.currentMap][i].sleep = false;
						gp.ui.npc = gp.mob[gp.currentMap][i];
						scenePhase++;
						break;
					}
				}
			}
			if(scenePhase == 3) {
				
				//Boss Speak
				gp.ui.drawDialogueScreen();
			}
			if(scenePhase == 4) {
				
				//Return camera to player
				
				//Search for dummy player
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(gp.npc[gp.currentMap][i] != null && gp.npc[gp.currentMap][i].name.equals(PlayerDummy.npcName)) {
						//Restore the player position
						gp.player.worldX = gp.npc[gp.currentMap][i].worldX;
						gp.player.worldY = gp.npc[gp.currentMap][i].worldY;
						//Delete dummy
						gp.npc[gp.currentMap][i] = null;
						usingDummyPlayer = false;
						break;
					}
				}
				
				//Start drawing the player
				gp.player.drawing = true;
				
				//Reset
				sceneNum = NA;
				scenePhase = 0;
				gp.gameState = gp.playState;
				
				//Change boss music 
				gp.stopMusic();
				gp.playMusic(19);
				
				gp.qManager.progressQuest("The Price of War");
				gp.pManager.addNotification("Journal Updated");
			}
	}
	public void scene_ending() {
		
		if(scenePhase == 0) {
			gp.stopMusic();
			gp.ui.npc = new OBJ_EmberlightPearl(gp);
			scenePhase++;
		}
		if(scenePhase == 1) {
			
			//Display dialogues
			gp.ui.drawDialogueScreen();
		}
		if(scenePhase == 2) {
			
			//Play fanfare
			gp.stopMusic();
			gp.playMusic(25);
			scenePhase++;
		}
		if(scenePhase == 3) {
			
			//Wait until sound effect ends
			if(counterReached(100) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 4) {
			
			//Screen gets darker
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			drawBlackBackground(alpha);
			
			if(alpha == 1f) {
				alpha = 0;
				scenePhase++;
			}
		}
		if(scenePhase == 5) {
			
			drawBlackBackground(1f);
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			
			String text = "After the battle for the Pearl of Emberlight,\n"
			        + "the hero stood amidst the cheering villagers,\n"
			        + "their voices weaving tales of victory—each retelling\n"
			        + "grander than the last.\n"
			        + "Legends would speak of their courage, a beacon\n"
			        + "for generations to come.";
			drawString(alpha, 16f, 120, text, 70);
			
			if(counterReached(600) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 6) {
			
			drawBlackBackground(1f);
			
			drawString(1f, 40f, gp.screenHeight/2, "Emberlight Tales", 40);
			
			if(counterReached(360) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 7) {
			
			drawBlackBackground(1f);
			
			y = gp.screenHeight/4;
			drawString(1f, 16f, y, endCredit, 40);
			
			if(counterReached(480) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 8) {
			
			drawBlackBackground(1f);
			
			//Scrolling the credits
			y--;
			drawString(1f, 16f, y, endCredit, 40);
			if(counterReached(1000) == true) {
				scenePhase++;
				gp.gameState = gp.titleState;
				gp.stopMusic();
			}
		}
	}
	public void scene_ending2() {
		
		if(scenePhase == 0) {
			
			//Play fanfare
			gp.stopMusic();
			gp.playMusic(25);
			scenePhase++;
		}
		if(scenePhase == 1) {
			
			//Wait until sound effect ends
			if(counterReached(100) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 2) {
			
			//Screen gets darker
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			drawBlackBackground(alpha);
			
			if(alpha == 1f) {
				alpha = 0;
				scenePhase++;
			}
		}
		if(scenePhase == 3) {
			
			drawBlackBackground(1f);
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			
			String text = "The hero left the tent in silence,\n"
			        + "the Pearl untouched, the truth heavier than any blade.\n"
			        + "No songs were sung that day, but something deeper stirred—\n"
			        + "a quiet shift in stories yet to be told.\n"
			        + "And in the shadows of old wrongs, a fragile hope\n"
			        + "began to take root.";
			drawString(alpha, 16f, 120, text, 70);
			
			if(counterReached(600) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 4) {
			
			drawBlackBackground(1f);
			
			drawString(1f, 40f, gp.screenHeight/2, "Emberlight Tales", 40);
			
			if(counterReached(360) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 5) {
			
			drawBlackBackground(1f);
			
			y = gp.screenHeight/4;
			drawString(1f, 16f, y, endCredit, 40);
			
			if(counterReached(480) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 6) {
			
			drawBlackBackground(1f);
			
			//Scrolling the credits
			y--;
			drawString(1f, 16f, y, endCredit, 40);
			if(counterReached(1000) == true) {
				scenePhase++;
				gp.gameState = gp.titleState;
				gp.stopMusic();
			}
		}
	}
	public void scene_ending3() {
		
		if(scenePhase == 0) {
			
			//Play fanfare
			gp.stopMusic();
			gp.playMusic(25);
			scenePhase++;
		}
		if(scenePhase == 1) {
			
			//Wait until sound effect ends
			if(counterReached(100) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 2) {
			
			//Screen gets darker
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			drawBlackBackground(alpha);
			
			if(alpha == 1f) {
				alpha = 0;
				scenePhase++;
			}
		}
		if(scenePhase == 3) {
			
			drawBlackBackground(1f);
			alpha += 0.005f;
			if(alpha > 1f) {
				alpha = 1f;
			}
			
			String text = "The battle was won, but the Pearl remained.\n"
			        + "The hero stood over it, the weight of its glow\n"
			        + "no longer a prize, but a question.\n"
			        + "No cheers followed, only silence—as if the land\n"
			        + "itself paused to wonder what came next.\n"
			        + "Some victories, it seemed, were meant to be unfinished.";
			
			drawString(alpha, 16f, 120, text, 70);
			
			if(counterReached(600) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 4) {
			
			drawBlackBackground(1f);
			
			drawString(1f, 40f, gp.screenHeight/2, "Emberlight Tales", 40);
			
			if(counterReached(360) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 5) {
			
			drawBlackBackground(1f);
			
			y = gp.screenHeight/4;
			drawString(1f, 16f, y, endCredit, 40);
			
			if(counterReached(480) == true) {
				scenePhase++;
			}
		}
		if(scenePhase == 6) {
			
			drawBlackBackground(1f);
			
			//Scrolling the credits
			y--;
			drawString(1f, 16f, y, endCredit, 40);
			
			if(counterReached(1000) == true) {
				scenePhase++;
				gp.gameState = gp.titleState;
				gp.stopMusic();
			}
		}
	}
	public boolean counterReached(int target) {
		
		boolean counterReached = false;
		
		counter++;
		if(counter > target) {
			counterReached = true;
			counter = 0;
		}
		
		return counterReached;
	}
	public void drawBlackBackground(float alpha) {
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.setColor(Color.black);
		g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
	public void drawString(float alpha, float fontSize, int y, String text, int lineHeight) {
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(fontSize));
		
		for(String line: text.split("\n")) {
			int x = gp.ui.getXforCenteredText(line);
			g2.drawString(line, x, y);
			y += lineHeight;
		}
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
	}
}
