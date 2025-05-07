package entity;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Scout extends Entity {
	
	public static final String npcName = "Rowan Swiftfoot";
	
	public NPC_Scout(GamePanel gp) {
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
		
    	homeWorldX = 54;
    	homeWorldY = 51;
    	outsideWorldX = 32;
    	outsideWorldY = 16;
    	homeMapNum = 13;
    	townNum = 2;
        
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_scout/scout_down_" + i, 2f, 2f);
	                rightStanding[i] = setup("/npc_scout/scout_right_" +i, 2f, 2f);
	                backStanding[i] = setup("/npc_scout/scout_up_" + i, 2f, 2f);
	                frontWalking[i] = setup("/npc_scout/scout_movedown_" + i, 2f, 2f);
	                rightWalking[i] = setup("/npc_scout/scout_moveright_" + i, 2f, 2f);
	                backWalking[i] = setup("/npc_scout/scout_moveup_" + i, 2f, 2f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/scout_portrait", 3f, 3f);
	}
	public void setDialogue() {
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 4) {
			dialogues[0][0] = "I heard you’re the one bringing\nEmberville’s support. Good. We’ll\nneed it.";		
			dialogues[0][1] = "The orc camp’s east of here.\nI’ve been tracking them for days.";	
			dialogues[0][2] = "Be careful. They’re not as disorganized\nas they seem. If you strike now, you might\ncatch them off guard.";
			dialogues[0][3] = "Stay low and keep your wits about you.";
		}
		else {
			dialogues[0][0] = "I smell orc...";		
			dialogues[0][1] = "You smell it too?";	
			
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
		
		
		facePlayer();
		setDialogue();
		startDialogue(this, dialogueSet);
		
		if(gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 4) {
			gp.qManager.progressQuest("Sands of Peril");
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"));
			gp.qManager.getQuestJournal().addQuest(gp.qManager.getQuestJournal().getQuestByName("Second's Fall"));
			gp.player.finishQuest(45, 70);
			
		}

		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
		
	}

	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = getScreenX();
        int screenY = getScreenY();

        // Optimization for rendering on screen
        if (inCamera() == true) {
        	
        	if(image1 != null) {
        		image = image1;
        	}
        	else if(dying) {
        		image = frontDeath[spriteNum];
        	}
        	else if (isAttacking) {
            	switch (direction) {
    	            case "up":
    	                image = backAttacking[spriteNum];
    	                break;
    	            case "down":
    	                image = frontAttacking[spriteNum];
    	                break;
    	            case "left":
    	                image = leftAttacking[spriteNum];
    	                break;
    	            case "right":
    	                image = rightAttacking[spriteNum];
    	                break;
             }
        	}
        	else if (isShooting) {
                switch (direction) {
                    case "up":
                        image = backShooting[spriteNum];
                        break;
                    case "down":
                        image = frontShooting[spriteNum];
                        break;
                    case "left":
                        image = leftShooting[spriteNum];
                        break;
                    case "right":
                        image = rightShooting[spriteNum];
                        break;
                }
        	}
        	else if (isWalking) {
                switch (direction) {
                    case "up":
                        image = backWalking[spriteNum];
                        break;
                    case "down":
                        image = frontWalking[spriteNum];
                        break;
                    case "left":
                        image = leftWalking[spriteNum];
                        break;
                    case "right":
                        image = rightWalking[spriteNum];
                        break;
                }
            } 
        	else {
                switch (direction) {
                    case "up":
                        image = backStanding[spriteNum];
                        break;
                    case "down":
                        image = frontStanding[spriteNum];
                        break;
                    case "left":
                        image = leftStanding[spriteNum];
                        break;
                    case "right":
                        image = rightStanding[spriteNum];
                        break;
                }
            }
        	
            if(invincible == true) {
            	hpBarOn = true;
            	hpBarCounter = 0;
            	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }
            if(dying == true) {
            	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            	dyingAnimation();
            }
            
            
            // Calculate offsets to keep character centered
            if(image != null) {
                if(image.getWidth() != gp.tileSize) {
                    int spriteWidth = image.getWidth();
                    int spriteHeight = image.getHeight();
                    int xOffset = (spriteWidth - gp.tileSize) / 2;
                    int yOffset = (spriteHeight - gp.tileSize) / 2;
                    g2.drawImage(image, screenX - xOffset + gp.tileSize/4, screenY - yOffset + gp.tileSize/4, null);
                }
                else {
                	g2.drawImage(image, screenX, screenY, null);
                }
            }
            
            //Shadow for NPC
            if((type == type_npc && name != "Dungeon Rock") || name == "Dummy") {
                g2.setColor(new Color(0, 0, 0, 100));
                g2.fillOval(screenX + 20, screenY + 60, 30, 10);
            }

        	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        	
            if(gp.keyH.showDebugText) {
            	//Debug: Entity Collision
		        g2.setColor(Color.red);
		        g2.setStroke(new BasicStroke(1));
		        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);	
		        g2.setStroke(new BasicStroke());
            }
        }
	}
}
