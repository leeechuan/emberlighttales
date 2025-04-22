package main.emberlight;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ai.PathFinder;
import data.Progress;
import data.SaveLoad;
import entity.Entity;
import entity.NPC_Chicken1;
import entity.NPC_Chicken2;
import entity.NPC_Chicken3;
import entity.Player;
import entity.SmokeParticle;
import environment.EnvironmentManager;
import environment.LightSource;
import environment.Lighting;
import popup.PopupManager;
import tile.Map;
import tile.TileManager;
import tile_interactive.IT_PressurePlate;
import tile_interactive.InteractiveTile;
import quest.Quest;
import quest.QuestManager;

public class GamePanel extends JPanel implements Runnable{

	//Screen Settings
	public final int originalTileSize = 16;
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48 x 48 tile
	public final int maxScreenCol = 20;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 960px
	public final int screenHeight = tileSize * maxScreenRow; // 576px
	
	//WORLD SETTINGS
	public final int maxWorldCol = 100;
	public final int maxWorldRow = 100;
	public final int maxMap = 25;
	public int currentMap = 0;
	//FOR FULL SCREEN
	int screenWidth2 = screenWidth;
	int screenHeight2 = screenHeight;
	BufferedImage tempScreen;
	Graphics2D g2;
	public boolean fullScreenOn = false;
	
	
	//FPS
	int FPS = 60;
	double delta = 0;
	long lastTime = System.nanoTime();
	
	//SYSTEM
	public TileManager tileM = new TileManager(this);
	public KeyHandler keyH = new KeyHandler(this);
	Sound music = new Sound();
	Sound se = new Sound();
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public EventHandler eHandler = new EventHandler(this);
	Config config = new Config(this);
	public PathFinder pFinder = new PathFinder(this);
	public EnvironmentManager eManager = new EnvironmentManager(this);
	Map map = new Map(this);
	SaveLoad saveLoad = new SaveLoad(this);
	public EntityGenerator eGenerator = new EntityGenerator(this);
	public CutsceneManager csManager = new CutsceneManager(this);
	public QuestManager qManager = new QuestManager(this);
	public PopupManager pManager = new PopupManager(this);
	Thread gameThread;
	
	//Entity and object and mobs
	public Player player = new Player(this, keyH);
	public Entity obj[][] = new Entity[maxMap][500];
	public Entity npc[][] = new Entity[maxMap][30];
	public Entity mob[][] = new Entity[maxMap][30];
	public InteractiveTile iTile[][] = new InteractiveTile[maxMap][100];
	public Entity projectile[][] = new Entity[maxMap][20];
//	public ArrayList<Entity> projectileList = new ArrayList<>();
	public ArrayList<Entity> particleList = new ArrayList<>();
	public ArrayList<Entity> entityList = new ArrayList<>();
	
	//SCHEDULE LIMITER
	private int scheduleCounter = 0;
	private final int SCHEDULE_INTERVAL = 120;
	
	//GAME STATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogueState = 3;
	public final int characterState = 4;
	public final int optionsState = 5;
	public final int gameOverState = 6;
	public final int transitionState = 7;
	public final int tradeState = 8;
	public final int sleepState = 9;
	public final int mapState = 10;
	public final int cutsceneState = 11;
	public final int journalState = 12;
	
	//OTHERS
	public boolean bossBattleOn = false;
	
	//AREA STATE
	public int currentArea;
	public int nextArea;
	public final int outside = 50;
	public final int indoor = 51;
	public final int dungeon = 52;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		
		aSetter.setObject();
		aSetter.setNPC();
		aSetter.setMobs();
		aSetter.setInteractiveTile();
		eManager.setup();
		qManager.initializeQuests();
//		playMusic(0);
//		stopMusic();
		gameState = titleState;
		currentArea = outside;
		
		tempScreen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D)tempScreen.getGraphics();
		
        if(fullScreenOn == true) {
    		setFullScreen();
        }
	}
	public void resetGame(boolean restart) {
		
		stopMusic();
		currentArea = outside;
		removeTempEntity();
		bossBattleOn = false;
		player.setDefaultPositions();
		player.restoreStatus();
		player.resetCounter();
		aSetter.setNPC();
		aSetter.setMobs();
		aSetter.setObject();
		
		if(restart == true) {
			player.setDefaultValues();
//			aSetter.setObject();
			aSetter.setInteractiveTile();
			eManager.lighting.resetDay();
		}

	}
	public void startNewGame() {
	    qManager.getQuestJournal().resetQuestJournal();
	    Progress.gameStage = Progress.STAGE_TUTORIAL;
	    player.isGremlin = false;
	    resetGame(true);
	}
	public void loadSavedGame() {
	    resetGame(false);
	    saveLoad.load();
		aSetter.setMobs();
		moveChickens();
		removeBanditsIfQuestCompleted();
	}
	public void setFullScreen() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		Main.window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		screenWidth2 = (int) width;
		screenHeight2 = (int) height;
	}
	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
		
	}
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;

		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		
		while(gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				drawToTempScreen();//draw everything to the buffered image
				drawToScreen();//draw the buffered image to the screen
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		
		}
		
	}
	public void update() {
		
		if(gameState == playState) {
			//PLAYER
			player.update();
			
//			//NPC
			for(int i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					npc[currentMap][i].update();
				}
			}
			// Update NPCs for all maps (unoptimised)
			scheduleCounter++;
			if(scheduleCounter >= SCHEDULE_INTERVAL) {
				scheduleCounter = 0;
				for (int map = 0; map < npc.length; map++) {
				    for (int i = 0; i < npc[map].length; i++) {
				        if (npc[map][i] != null && npc[map][i].homeMapNum != 0) {
				            npc[map][i].npcScheduleAndBoundaries();
				        }
				    }
				}
			}

			
			//MOB
			for(int i = 0; i < mob[1].length; i++) {
				if(mob[currentMap][i] != null) {
					if(mob[currentMap][i].alive == true && mob[currentMap][i].dying == false) {
						mob[currentMap][i].update();
					}
					if(mob[currentMap][i].alive == false) {
						mob[currentMap][i].checkDrop();
						mob[currentMap][i] = null;
					}
				}
			}
			//PROJECTILE
			for(int i = 0; i < projectile[1].length; i++) {
				if(projectile[currentMap][i] != null) {
					if(projectile[currentMap][i].alive == true) {
						projectile[currentMap][i].update();
					}
					if(projectile[currentMap][i].alive == false) {
						projectile[currentMap][i] = null;
					}
				}
			}
			//PARTICLE
			for(int i = 0; i < particleList.size(); i++) {
				if(particleList.get(i) != null) {
					if(particleList.get(i).alive == true) {
						particleList.get(i).update();
					}
					if(particleList.get(i).alive == false) {
						particleList.remove(i);
					}
				}
			}
			//INTERACTIVE TILE
			for(int i = 0; i < iTile[1].length; i++) {
				if(iTile[currentMap][i] != null) {
					iTile[currentMap][i].update();
				}
			}
			//OBJECT
		    for (int i = 0; i < obj[1].length; i++) {
		        if (obj[currentMap][i] != null) {
		            obj[currentMap][i].update();
		        }
		    }
		    eManager.update();
		    
		}
		if(gameState == pauseState) {
			
		}
		pManager.update();
	}
	public void drawToTempScreen() {

		//DEBUG
		long drawStart = 0;
		if(keyH.showDebugText == true) {
			drawStart = System.nanoTime();			
		}
		
		//TITLE SCREEN
		if(gameState == titleState) {
			ui.draw(g2);
		}
		//MAP SCREEN
		else if(gameState == mapState) {
			map.drawFullMapScreen(g2);
		}
		//OTHERS
		else {
			//TILE
			tileM.draw(g2);
			
			//ADD ENTITIES TO LIST
			//PLAYER
			entityList.add(player);
			
			//NPC
			for(int i = 0; i < npc[1].length; i++) {
				if(npc[currentMap][i] != null) {
					entityList.add(npc[currentMap][i]);
				}
			}
			
			//OBJECT
			for(int i = 0; i < obj[1].length; i++) {
				if(obj[currentMap][i] != null) {
					entityList.add(obj[currentMap][i]);
				}
			}
			
			//INTERACTIVE TILE
			for(int i = 0; i < iTile[1].length; i++) {
				if(iTile[currentMap][i] != null) {
					entityList.add(iTile[currentMap][i]);
//					iTile[i].draw(g2);
				}
			}
			
			//MOB
			for(int i = 0; i < mob[1].length; i++) {
				if(mob[currentMap][i] != null) {
					entityList.add(mob[currentMap][i]);
				}
			}
			//PROJECTILE
			for(int i = 0; i < projectile[1].length; i++) {
				if(projectile[currentMap][i] != null) {
					entityList.add(projectile[currentMap][i]);
				}
			}
			//PARTICLE
			for(int i = 0; i < particleList.size(); i++) {
				if(particleList.get(i) != null) {
					entityList.add(particleList.get(i));
				}
			}
			// SMOKE PARTICLE
			for (int i = 0; i < player.smokeParticles.size(); i++) {
			    SmokeParticle particle = player.smokeParticles.get(i);
			    particle.update();  // Update the particle's position, life, and alpha
			    if (particle.alive) {  // Draw only if the particle is still alive
			        particle.draw(g2);
			    }
			}
			// Remove finished particles (that are no longer alive)
			player.smokeParticles.removeIf(particle -> !particle.alive);
			
			//SORT
			Collections.sort(entityList, new Comparator<Entity>() {
			    @Override
			    public int compare(Entity e1, Entity e2) {
			        // Ensure pressure plates are drawn behind other entities
			        if (e1 instanceof IT_PressurePlate && !(e2 instanceof IT_PressurePlate)) {
			            return -1;
			        } else if (!(e1 instanceof IT_PressurePlate) && e2 instanceof IT_PressurePlate) {
			            return 1;
			        } else {
			            // Fallback to comparing their worldY coordinates
			            return Integer.compare(e1.worldY, e2.worldY);
			        }
			    }
			});
			
			//DRAW ENTITIES
			for(int i = 0; i < entityList.size(); i++) {
				entityList.get(i).draw(g2);
			}
			//EMPTY ENTITY LIST
			entityList.clear();
			//ENVIRONMENT
			eManager.draw(g2);
			//MINI MAP
			map.drawMiniMap(g2);
			//CUTSCENE
			csManager.draw(g2);
			//UI
			ui.draw(g2);
			//POPUP
			pManager.draw(g2);
		}
		
		//DEBUG
		if(keyH.showDebugText == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setFont(g2.getFont().deriveFont(Font.PLAIN,14));
			g2.setColor(Color.white);
			g2.drawString("Draw Time          : " + passed, 10, 400);
			g2.drawString("Coordinates        : " + player.worldX + "," + player.worldY, 10, 420);
			g2.drawString("Tile               : " + ((player.worldX + player.solidArea.x)/tileSize) + "," + ((player.worldY + player.solidArea.y)/tileSize), 10, 440);
			g2.drawString("God Mode           : " + keyH.godModeOn, 10, 460);
			g2.drawString("Game Stage         : " + Progress.gameStage, 10, 480);
			g2.drawString("Time Speed         : " + eManager.lighting.timeSpeed, 10, 500);
			
			System.out.println("Draw Time: " + passed);
		}
	}
	public void drawToScreen() {
		
		Graphics g = getGraphics();
		g.drawImage(tempScreen, 0, 0, screenWidth2, screenHeight2, null);
		g.dispose();
	}
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		
		music.stop();
	}
	public void playSE(int i) {
		
		se.setFile(i);
		se.play();
	}
	public void changeArea() {
		
		if(nextArea != currentArea) {
			
			stopMusic();
			if(nextArea == outside) {
				playMusic(0);
			}
			if(nextArea == indoor) {
				playMusic(20);
			}
			if(nextArea == dungeon) {
				aSetter.setNPC();
				playMusic(21);
			}
			
		}
		
		currentArea = nextArea;
		aSetter.setMobs();
	}
	public void removeTempEntity() {
		
		for(int mapNum = 0; mapNum < maxMap; mapNum++) {
			
			for(int i = 0; i < obj[1].length; i++) {
				if(obj[mapNum][i] != null && obj[mapNum][i].temp == true) {
					obj[mapNum][i] = null;
				}
			}
		}
	}
	public void updateNPCDialogues() {
	    for (int i = 0; i < npc[currentMap].length; i++) {
	        if (npc[currentMap][i] != null) {
	        	//Reset Dialogue
	            for (int row = 0; row < npc[currentMap][i].dialogues.length; row++) {
	                for (int col = 0; col < npc[currentMap][i].dialogues[row].length; col++) {
	                    npc[currentMap][i].dialogues[row][col] = null;
	                    npc[currentMap][i].dialogueSet = -1;
	                }
	            }
	        	
	            npc[currentMap][i].setDialogue();
	        }
	    }
	}
	public void moveChickens() {
	    Quest cluckQuest = qManager.getQuestJournal().getQuestByName("Cluck and Dagger");
	    boolean questActive = qManager.getQuestJournal().getActiveQuests().contains(cluckQuest);
	    boolean questCompleted = qManager.getQuestJournal().getCompletedQuests().contains(cluckQuest);
	    int stage = (cluckQuest != null) ? cluckQuest.getCurrentStageIndex() : -1;

	    for (int i = 0; i < npc[0].length; i++) {
	        if (npc[0][i] == null || npc[0][i].name == null) continue;

	        String npcName = npc[0][i].name;

	        switch (npcName) {
	            case NPC_Chicken1.npcName:
	                if (!questCompleted || (questActive && stage < 1)) {
	                    npc[0][i].worldX = tileSize * 89;
	                    npc[0][i].worldY = tileSize * 67;
	                } else {
	                    npc[0][i].worldX = tileSize * 76;
	                    npc[0][i].worldY = tileSize * 47;
	                }
	                break;

	            case NPC_Chicken2.npcName:
	                if (!questCompleted || (questActive && stage < 2)) {
	                    npc[0][i].worldX = tileSize * 64;
	                    npc[0][i].worldY = tileSize * 76;
	                } else {
	                    npc[0][i].worldX = tileSize * 77;
	                    npc[0][i].worldY = tileSize * 48;
	                }
	                break;

	            case NPC_Chicken3.npcName:
	                if (!questCompleted || (questActive && stage < 3)) {
	                    npc[0][i].worldX = tileSize * 73;
	                    npc[0][i].worldY = tileSize * 54;
	                } else {
	                    npc[0][i].worldX = tileSize * 79;
	                    npc[0][i].worldY = tileSize * 47;
	                }
	                break;
	        }
	    }
	}
	public void removeBanditsIfQuestCompleted() {
	    Quest banditQuest = qManager.getQuestJournal().getQuestByName("No Rest for the Wicked");
	    boolean questCompleted = qManager.getQuestJournal().getCompletedQuests().contains(banditQuest);

	    if (!questCompleted) return;

	    for (int mapNum = 0; mapNum < maxMap; mapNum++) {
	        for (int i = 0; i < mob[mapNum].length; i++) {
	            if (mob[mapNum][i] == null || mob[mapNum][i].name == null) continue;

	            String name = mob[mapNum][i].name;
	            if (name.contains("Swordman Bandit") || name.contains("Templar Bandit")) {
	            	mob[mapNum][i] = null; // Remove the bandit from the map
	                System.out.println("Removed bandit from map " + mapNum + " index " + i);
	            }
	        }
	    }
	}
}
