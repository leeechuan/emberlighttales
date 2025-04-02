package entity;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;
import main.emberlight.KeyHandler;
import main.emberlight.UtilityTool;
import object.OBJ_Arrow;
import object.OBJ_Lantern;
import object.OBJ_Rabbit_Shield_1;
import object.OBJ_Stone_Axe;
import object.OBJ_Stone_Sword;

public class Player extends Entity {

    KeyHandler keyH;
    public final int screenX;
    public final int screenY;
    public boolean attackCancelled = false;
    public boolean lightUpdated = false;
    public boolean isGremlin = false;
    
    boolean gremlinKeyPreviouslyPressed = false;
    public BufferedImage[] gremlinfrontStanding = new BufferedImage[6];
    public BufferedImage[] gremlinfrontWalking = new BufferedImage[6];
    public BufferedImage[] gremlinbackStanding = new BufferedImage[6];
    public BufferedImage[] gremlinbackWalking = new BufferedImage[6];
    public BufferedImage[] gremlinrightStanding = new BufferedImage[6];
    public BufferedImage[] gremlinrightWalking = new BufferedImage[6];
    public BufferedImage[] gremlinleftStanding = new BufferedImage[6];
    public BufferedImage[] gremlinleftWalking = new BufferedImage[6];
    public BufferedImage[] gremlinfrontAttacking = new BufferedImage[6];
    public BufferedImage[] gremlinbackAttacking = new BufferedImage[6];
    public BufferedImage[] gremlinrightAttacking = new BufferedImage[6];
    public BufferedImage[] gremlinleftAttacking = new BufferedImage[6];
    private int baseStrength, baseDexterity, baseSpeed; // Store original stats
    public ArrayList<SmokeParticle> smokeParticles = new ArrayList<>();
    
    // To track animation state
//    private int spriteCounter = 0;
//    private int spriteNum = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
    	
    	super(gp);
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        //SOLID AREA
        solidArea = new Rectangle(6, 6, gp.tileSize - 12, gp.tileSize - 12);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        //ATTACK AREA
//        attackArea.width = 36;
//        attackArea.height = 36;

        setDefaultValues();
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 75;
        worldY = gp.tileSize * 78;
//        worldX = gp.tileSize * 82;
//        worldY = gp.tileSize * 50;
        defaultSpeed = 5;
        speed = defaultSpeed;
        direction = "down";
        
        //PLAYER STATUS
        name = "Player";
        level = 1;
        maxLife = 6;
        life = maxLife;
        maxMana = 4;
        mana = maxMana;
        ammo = 10;
        strength = 1; //More strength = More damage
        dexterity = 1; //More dexterity = Less damage
        exp = 0;
        nextLevelExp = 5;
        coin = 300;
        currentWeapon = new OBJ_Stone_Sword(gp);
        currentShield = new OBJ_Rabbit_Shield_1(gp);
        currentLight = null;
        projectile = new OBJ_Arrow(gp);
        attack = getAttack(); //Strength and Weapon
        defense = getDefense(); //Dexterity and Shield
        
        getImage();
        getAttackImage();
        getGuardImages();
        getGremlinImages();
        setItems();
        setDialogue();
    }
    public void setDefaultPositions() {
    	
    	gp.currentMap = 0;
        worldX = gp.tileSize * 75;
        worldY = gp.tileSize * 78;
//        worldX = gp.tileSize * 82;
//        worldY = gp.tileSize * 50;
        direction = "down";
    }
    public void setDialogue() {
    	
		dialogues[0][0] = "You feel stronger...\nYou are now level " + level + "!";
    }
    public void restoreStatus() {
    	
    	life = maxLife;
    	mana = maxMana;
        speed = defaultSpeed;
    	invincible = false;
    	transparent = false;
    	isAttacking = false;
    	isBlocking = false;
    	knockBack = false;
    	lightUpdated = true;
    }
    public void setItems() {
    	
    	inventory.clear();
    	inventory.add(currentWeapon);
    	inventory.add(currentShield);
    	inventory.add(new OBJ_Lantern(gp));
    	inventory.add(new OBJ_Stone_Axe(gp));
    }
    public int getAttack() {
    	attackArea = currentWeapon.attackArea;
    	motion1_duration = currentWeapon.motion1_duration;
    	motion2_duration = currentWeapon.motion2_duration;
    	motion3_duration = currentWeapon.motion3_duration;
    	motion4_duration = currentWeapon.motion4_duration;
    	motion5_duration = currentWeapon.motion5_duration;
    	motion6_duration = currentWeapon.motion6_duration;
    	return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense() {
    	return defense = dexterity * currentShield.defenseValue;
    }
    public int getCurrentWeaponSlot() {
    	int currentWeaponSlot = 0;
    	for(int i = 0; i < inventory.size(); i++) {
    		if(inventory.get(i) == currentWeapon) {
    			currentWeaponSlot = i;
    		}
    	}
    	return currentWeaponSlot;
    }
    public int getCurrentShieldSlot() {
    	int currentShieldSlot = 0;
    	for(int i = 0; i < inventory.size(); i++) {
    		if(inventory.get(i) == currentShield) {
    			currentShieldSlot = i;
    		}
    	}
    	return currentShieldSlot;
    }
    public void getImage() {
        
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/player/player_down_" + i, 1.5f, 1.5f);
             rightStanding[i] = setup("/player/player_right_" +i, 1.5f, 1.5f);
             backStanding[i] = setup("/player/player_up_" + i, 1.5f, 1.5f);
             frontWalking[i] = setup("/player/player_movedown_" + i, 1.5f, 1.5f);
             rightWalking[i] = setup("/player/player_moveright_" + i, 1.5f, 1.5f);
             backWalking[i] = setup("/player/player_moveup_" + i, 1.5f, 1.5f);
             frontShooting[i] = setup("/player/player_bowdown_" + i, 1.5f, 1.5f);
             rightShooting[i] = setup("/player/player_bowright_" + i, 1.5f, 1.5f);
             backShooting[i] = setup("/player/player_bowup_" + i, 1.5f, 1.5f);
         	}
	     for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
             leftShooting[i] = invertImage(rightShooting[i]);
       		}
    }
    public void getAttackImage() {
    	
    	if(currentWeapon.type == type_sword) {
    		for (int i = 0; i < 4; i++) {
                frontAttacking[i] = setup("/player/player_attackdown_" + i, 1.5f, 1.5f);
                rightAttacking[i] = setup("/player/player_attackright_" +i, 1.5f, 1.5f);
                backAttacking[i] = setup("/player/player_attackup_" + i, 1.5f, 1.5f);
            	}
   	     for (int i = 0; i < 4; i++) {
                leftAttacking[i] = invertImage(rightAttacking[i]);
          		}
    	}
    	if(currentWeapon.type == type_axe) {
    		for (int i = 0; i < 6; i++) {
                frontAttacking[i] = setup("/player/player_axedown_" + i, 2.25f, 2.25f);
                rightAttacking[i] = setup("/player/player_axeright_" +i, 2.25f, 2.25f);
                backAttacking[i] = setup("/player/player_axeup_" + i, 2.25f, 2.25f);
            	}
   	     for (int i = 0; i < 6; i++) {
                leftAttacking[i] = invertImage(rightAttacking[i]);
          		}
    	}
    }
    public void getGremlinImages() {
    	
		for (int i = 0; i < 6; i++) {
			gremlinfrontStanding[i] = setup("/player_gremlin/player_gremlin_down_" + i, 1.5f, 1.5f);
			gremlinrightStanding[i] = setup("/player_gremlin/player_gremlin_right_" +i, 1.5f, 1.5f);
			gremlinbackStanding[i] = setup("/player_gremlin/player_gremlin_up_" + i, 1.5f, 1.5f);
        	}
	    for (int i = 0; i < 6; i++) {
	    	gremlinleftStanding[i] = invertImage(gremlinrightStanding[i]);
      		}
		for (int i = 0; i < 6; i++) {
			gremlinfrontWalking[i] = setup("/player_gremlin/player_gremlin_movedown_" + i, 1.5f, 1.5f);
			gremlinrightWalking[i] = setup("/player_gremlin/player_gremlin_moveright_" +i, 1.5f, 1.5f);
			gremlinbackWalking[i] = setup("/player_gremlin/player_gremlin_moveup_" + i, 1.5f, 1.5f);
        	}
	    for (int i = 0; i < 6; i++) {
	    	gremlinleftWalking[i] = invertImage(gremlinrightWalking[i]);
      		}
		for (int i = 0; i < 6; i++) {
			gremlinfrontAttacking[i] = setup("/player_gremlin/player_gremlin_attackdown_" + i, 1.5f, 1.5f);
			gremlinrightAttacking[i] = setup("/player_gremlin/player_gremlin_attackright_" +i, 1.5f, 1.5f);
			gremlinbackAttacking[i] = setup("/player_gremlin/player_gremlin_attackup_" + i, 1.5f, 1.5f);
        	}
	    for (int i = 0; i < 6; i++) {
	    	gremlinleftAttacking[i] = invertImage(gremlinrightAttacking[i]);
      		}

    }
    public void getLightImages() {
        if (currentLight == null) {
            return; // No lantern equipped
        }

        if ("Torch".equals(currentLight.name)) {
            for (int i = 0; i < 6; i++) {
                frontLight[i] = setup("/player_lights/player_torchdown_" + i, 1.5f, 1.5f);
                rightLight[i] = setup("/player_lights/player_torchright_" + i, 1.5f, 1.5f);
                backLight[i] = setup("/player_lights/player_torchup_" + i, 1.5f, 1.5f);
                frontMoveLight[i] = setup("/player_lights/player_torchmovedown_" + i, 1.5f, 1.5f);
                rightMoveLight[i] = setup("/player_lights/player_torchmoveright_" + i, 1.5f, 1.5f);
                backMoveLight[i] = setup("/player_lights/player_torchmoveup_" + i, 1.5f, 1.5f);
            }
            for (int i = 0; i < 6; i++) {
                leftLight[i] = invertImage(rightLight[i]);
                leftMoveLight[i] = invertImage(rightMoveLight[i]);
            }
        }

        if ("Lantern".equals(currentLight.name)) {
            for (int i = 0; i < 6; i++) {
                frontLight[i] = setup("/player_lights/player_lanterndown_" + i, 1.5f, 1.5f);
                rightLight[i] = setup("/player_lights/player_lanternright_" + i, 1.5f, 1.5f);
                backLight[i] = setup("/player_lights/player_lanternup_" + i, 1.5f, 1.5f);
                frontMoveLight[i] = setup("/player_lights/player_lanternmovedown_" + i, 1.5f, 1.5f);
                rightMoveLight[i] = setup("/player_lights/player_lanternmoveright_" + i, 1.5f, 1.5f);
                backMoveLight[i] = setup("/player_lights/player_lanternmoveup_" + i, 1.5f, 1.5f);
            }
            for (int i = 0; i < 6; i++) {
                leftLight[i] = invertImage(rightLight[i]);
                leftMoveLight[i] = invertImage(rightMoveLight[i]);
            }
        }
    }
    public void getGuardImages(){
        if ("Pablo".equals(currentShield.name)) {
            for (int i = 0; i < 6; i++) {
                frontBlocking[i] = setup("/player_block/player_blockfront1_" + i, 1.5f, 1.5f);
                rightBlocking[i] = setup("/player_block/player_blockright1_" + i, 1.5f, 1.5f);
                backBlocking[i] = setup("/player_block/player_blockback1_" + i, 1.5f, 1.5f);
            }
            for (int i = 0; i < 6; i++) {
                leftBlocking[i] = invertImage(rightBlocking[i]);
            }
        }
        if ("Willow".equals(currentShield.name)) {
            for (int i = 0; i < 6; i++) {
                frontBlocking[i] = setup("/player_block/player_blockfront2_" + i, 1.5f, 1.5f);
                rightBlocking[i] = setup("/player_block/player_blockright2_" + i, 1.5f, 1.5f);
                backBlocking[i] = setup("/player_block/player_blockback2_" + i, 1.5f, 1.5f);
            }
            for (int i = 0; i < 6; i++) {
                leftBlocking[i] = invertImage(rightBlocking[i]);
            }
        }
        if ("Blossom".equals(currentShield.name)) {
            for (int i = 0; i < 6; i++) {
                frontBlocking[i] = setup("/player_block/player_blockfront3_" + i, 1.5f, 1.5f);
                rightBlocking[i] = setup("/player_block/player_blockright3_" + i, 1.5f, 1.5f);
                backBlocking[i] = setup("/player_block/player_blockback3_" + i, 1.5f, 1.5f);
            }
            for (int i = 0; i < 6; i++) {
                leftBlocking[i] = invertImage(rightBlocking[i]);
            }
        }
    }
    public void gremlinMode() {
    	if (keyH.gremlinPressed) {
    	    if (!gremlinKeyPreviouslyPressed) {  // Ensures toggle happens only once per press
    	        isGremlin = !isGremlin;
    	        //Smoke particles for transition
	        	for (int i = 0; i < 15; i++) { // Generate 10 smoke particles
	        	    smokeParticles.add(new SmokeParticle(gp, this));
	        	}
	        	gp.playSE(26);
	        	gp.updateNPCDialogues();
	        	
    	        if(isGremlin) {
                    baseStrength = strength;
                    baseDexterity = dexterity;
                    baseSpeed = speed;

                    // Apply 1.5x boost
                    strength = (int) Math.round(baseStrength * 1.5);
                    dexterity = (int) Math.round(baseDexterity * 1.5);
                    speed = (int) Math.round(baseSpeed * 1.5);
                    
                    //SolidArea
                    solidArea.x = 12;
                    solidArea.y = 16;
                    solidArea.width = gp.tileSize - 24;
                    solidArea.height = gp.tileSize - 24;
                    
                    solidAreaDefaultX = solidArea.x;
                    solidAreaDefaultY = solidArea.y;
    	        }
    	        else {
                    strength = baseStrength;
                    dexterity = baseDexterity;
                    speed = baseSpeed;
                    
                    //SolidArea
                    solidArea.x = 6;
                    solidArea.y = 6;
                    solidArea.width = gp.tileSize - 12;
                    solidArea.height = gp.tileSize - 12;
                    
                    solidAreaDefaultX = solidArea.x;
                    solidAreaDefaultY = solidArea.y;
    	        }
    	    }
    	    gremlinKeyPreviouslyPressed = true;  // Mark key as pressed
    	} else {
    	    gremlinKeyPreviouslyPressed = false; // Reset when key is released
    	}
    }
    public void update() {
        isWalking = keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed;
        
        gremlinMode();
                
		if (!isGremlin && keyH.spacePressed && !isBlocking) {
		    isBlocking = true;
		    blocking();
		} else if (!keyH.spacePressed && isBlocking) {
		    isBlocking = false;
		    blockCounter = 0; // Reset block counter when stopping block
		}
        
		if(knockBack == true) {
			
            collisionOn = false;
            gp.cChecker.checkTile(this);
			gp.cChecker.checkObject(this, true);
			gp.cChecker.checkEntity(this, gp.npc);
			gp.cChecker.checkEntity(this, gp.mob);
			gp.cChecker.checkEntity(this, gp.iTile);
           
			
			if(collisionOn == true) {
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
			else if (collisionOn == false) {
				switch(knockBackDirection) {
		        	case "up": worldY -= speed; break;
		    		case "down": worldY += speed; break;
			    	case "left": worldX -= speed; break;
					case "right": worldX += speed; break;
				}
			}
			
			knockBackCounter++;
			
			if(knockBackCounter == 10) {
				knockBackCounter = 0;
				knockBack = false;
				speed = defaultSpeed;
			}
		}
        
		else if(isAttacking) {
        	attacking();
        }
		else if (!isGremlin && isBlocking) {
		    blocking();
		}
        else if(!isGremlin && isShooting) {
        	shooting();
        }
        else if (isWalking || keyH.enterPressed) {
            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";

            } else if (keyH.leftPressed) {
                direction = "left";

            } else if (keyH.rightPressed) {
                direction = "right";

            }
            
            //Check tile collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
			int tileIndex = gp.cChecker.checkTile(this); // Get tile the player is stepping on
			if (tileIndex == 14 && soundCooldown == 0) { 
			    int soundID = (Math.random() < 0.5) ? 22 : 23;
			    gp.playSE(soundID); // Play the selected sound effect
			    soundCooldown = soundDelay; // Reset cooldown
			}

			// Reduce the cooldown timer
			if (soundCooldown > 0) {
			    soundCooldown--;
			}
            
            //Check object collision
           int objIndex = gp.cChecker.checkObject(this, true);
           pickUpObject(objIndex);
           
           //Check NPC collision
           int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
           interactNPC(npcIndex);
           
           //Check Mob collision
           int mobIndex = gp.cChecker.checkEntity(this, gp.mob);
           contactMob(mobIndex);
           
           //Check Interactive Tile Collision
           int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
           
           //Check Event
           gp.eHandler.checkEvent();
            
           //If Collision is False, Move player. 
           if(collisionOn == false && keyH.enterPressed == false) {
        	   	switch(direction) {
        	   		case "up":
        	   			worldY -= speed;
        	   			break;
        			case "down":
                    	worldY += speed;
        				break;
		    		case "left":
	                	worldX -= speed;
		    			break;
					case "right":
	                	worldX += speed;
						break;
				}
            }
           // If collision is detected, allow sliding along walls
           else {
               if (direction.equals("up") || direction.equals("down")) {
                   // If moving vertically and colliding, try horizontal movement
                   collisionOn = false;
                   gp.cChecker.checkTile(this);
                   if (!collisionOn) {
                       if (keyH.leftPressed) worldX -= speed;
                       else if (keyH.rightPressed) worldX += speed;
                   }
               } 
               else if (direction.equals("left") || direction.equals("right")) {
                   // If moving horizontally and colliding, try vertical movement
                   collisionOn = false;
                   gp.cChecker.checkTile(this);
                   if (!collisionOn) {
                       if (keyH.upPressed) worldY -= speed;
                       else if (keyH.downPressed) worldY += speed;
                   }
               }
           }
           
           if(keyH.enterPressed == true && attackCancelled == false) {
        	   gp.playSE(4);
        	   isAttacking = true;
        	   spriteCounter = 0;
           }
           
           attackCancelled = false;
           gp.keyH.enterPressed = false;
//           isBlocking = false;
//           blockCounter = 0;

        }
        
        spriteCounter++;
        
        
        if (!isBlocking && spriteCounter > 20) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % 6; // Loop through 6 frames
            spriteCounter = 0;
        }
       
        if(!isGremlin && gp.keyH.shotKeyPressed == true && projectile.alive == false && shotAvailableCounter == 30
        		&& projectile.haveResource(this) == true) {
        	
        	isShooting = true;
        }
        
    	if(shootingSpriteCounter > 20) {
        	//SET DEFAULT COORDINATES, DIRECTION AND USER (only after shooting animation)
        	projectile.set(worldX, worldY, direction, true, this);
        	//SUBTRACT THE COST (MANA, AMMO ETC.)
        	projectile.subtractResource(this);
        	//CHECK VACANCY
        	for(int i = 0; i < gp.projectile[1].length; i++) {
        		if(gp.projectile[gp.currentMap][i] == null) {
        			gp.projectile[gp.currentMap][i] = projectile;
        			break;
        		}
        	}
        	shotAvailableCounter = 0; 
        	gp.playSE(7);
        	isShooting = false;
        	shootingSpriteCounter = 0;
    	}
        
        //Outside of key if statement
        if(invincible == true) {
        	invincibleCounter++;
        	if(invincibleCounter > 60) {
        		invincible = false;
        		transparent = false;
        		invincibleCounter = 0;
        	}
        }
        
        if(shotAvailableCounter < 30) {
        	shotAvailableCounter++;
        }
        if(life > maxLife) {
        	life = maxLife;
        }
        if(mana > maxMana) {
        	mana = maxMana;
        }
        if(keyH.godModeOn == false) {
            if(life <= 0) {
            	gp.gameState = gp.gameOverState;
            	gp.ui.commandNum = -1;
            	gp.stopMusic();
            	gp.playSE(9);
            }
        }
    }
    public void shooting() {
    	
    	if (isShooting) {
    		shootingSpriteCounter++;

            if (shootingSpriteCounter <= 5) {
                spriteNum = 0;
            } else if (shootingSpriteCounter <= 12) {
                spriteNum = 1;
            } else if (shootingSpriteCounter <= 15) {
                spriteNum = 2;
            } else if (shootingSpriteCounter <= 20) {
                spriteNum = 3;
            } else if (shootingSpriteCounter <= 25) {
                spriteNum = 4;
            } else if (shootingSpriteCounter <= 30) {
                spriteNum = 5;
            }

        }
    }
    public void blocking() {
    	
        if (isBlocking) {
            blockCounter++;
            if (blockCounter <= 4) {
                spriteNum = 0;
            } else if (blockCounter <= 8) {
                spriteNum = 1;
            } else if (blockCounter <= 12) {
                spriteNum = 2;
            } else if (blockCounter <= 16) {
                spriteNum = 3;
            } else if (blockCounter <= 20) {
                spriteNum = 4;
            } else if (blockCounter <= 24) {
                spriteNum = 5;  // Ensure this stays 5
            }

            // Corrected reset logic to prevent spriteNum = 0 issue
            if (blockCounter > 24) {
                spriteNum = 3;  
                blockCounter = 12;
            }
        }
    }
    public void pickUpObject(int i) {
    	
    	if (i != 999) {
    		
    		//PICKUP ONLY ITEMS
    		if(gp.obj[gp.currentMap][i].type == type_pickupOnly) {
    			
    			gp.obj[gp.currentMap][i].use(this);
    			gp.obj[gp.currentMap][i] = null;
    		}
    		//OBSTACLE
    		else if(gp.obj[gp.currentMap][i].type == type_obstacle) {
    			if(keyH.enterPressed == true) {
    				attackCancelled = true;
    				gp.obj[gp.currentMap][i].interact();
    			}
    		}
    		//INVENTORY ITEMS
    		else {
        		String text;
        		
        		if(canObtainItem(gp.obj[gp.currentMap][i]) == true) {
        			gp.playSE(1);
        			text = "You picked up " + gp.obj[gp.currentMap][i].name + "!";
        		}
        		else {
        			text = "You cannot carry any more!";
        		}
        		gp.ui.addMessage(text);
        		gp.obj[gp.currentMap][i] = null;
    		}
    	}
    } 
    public void interactNPC(int i) {
    	
    	if(i != 999) {
    		if (gp.keyH.enterPressed == true) {
    			attackCancelled = true;
        		gp.npc[gp.currentMap][i].speak();
        	}
    		gp.npc[gp.currentMap][i].move(direction);
    	}
		
    }
    public void contactMob(int i) {
    	
    	if (i != 999) {
    		
    		if(invincible == false && gp.mob[gp.currentMap][i].dying == false) {
    			gp.playSE(3);
    			
    			int damage = gp.mob[gp.currentMap][i].attack - defense;
    			if(damage < 1) {
    				 damage = 1;
    			}
    			
    			life -= damage;
    			invincible = true;
    			transparent = true;
    		}
    	}
    }
    public void damageMob(int i, Entity attacker, int attack, int knockBackPower) {
    	
    	if(i != 999) {
    		
    		if(gp.mob[gp.currentMap][i].invincible == false) {
    			gp.playSE(2);
    			
    			if(knockBackPower > 0) {
    				setKnockBack(gp.mob[gp.currentMap][i], attacker, knockBackPower);
    			}
    			if(gp.mob[gp.currentMap][i].offBalance == true) {
    				attack *= 5;
    			}
    			int damage = attack - gp.mob[gp.currentMap][i].defense;
    			if(damage < 0) {
    				 damage = 0;
    			}
				generateParticle(gp.mob[gp.currentMap][i], gp.mob[gp.currentMap][i]);
    			gp.mob[gp.currentMap][i].life -= damage;
    			gp.ui.addMessage(damage + " damage!");
    			gp.mob[gp.currentMap][i].invincible = true;
    			gp.mob[gp.currentMap][i].damageReaction();
    				
    			if(gp.mob[gp.currentMap][i].life <= 0) {
    				gp.mob[gp.currentMap][i].life = 0;
    				gp.mob[gp.currentMap][i].dying = true;
    				gp.ui.addMessage(gp.mob[gp.currentMap][i].name + " was killed!");
    				gp.ui.addMessage("Exp + " + gp.mob[gp.currentMap][i].exp);
    				exp += gp.mob[gp.currentMap][i].exp;
    				checkLevelUp();
    			}
    		}
    	}
    }
    public void damageInteractiveTile(int i) {
    	
    	if(i != 999 && gp.iTile[gp.currentMap][i].destructible == true && gp.iTile[gp.currentMap][i].isCorrectItem(this) == true && gp.iTile[gp.currentMap][i].invincible == false) {
    		gp.iTile[gp.currentMap][i].playSE();
    		gp.iTile[gp.currentMap][i].life--;
    		gp.iTile[gp.currentMap][i].invincible = true;
    		
    		generateParticle(gp.iTile[gp.currentMap][i], gp.iTile[gp.currentMap][i]);
    		
    		if(gp.iTile[gp.currentMap][i].life == 0) {
        		gp.iTile[gp.currentMap][i] = gp.iTile[gp.currentMap][i].getDestroyedForm();
    		}
    	}
    }
    public void damageProjectile(int i) {
    	
    	if(i != 999) {
    		Entity projectile = gp.projectile[gp.currentMap][i];
    		projectile.alive = false;
    		generateParticle(projectile, projectile);
    	}
    }
    public void checkLevelUp() {
    	
    	if(exp >= nextLevelExp) {
    		
    		level++;
    		nextLevelExp = nextLevelExp*2;
    		maxLife += 2;
    		strength++;
    		dexterity++;
    		attack = getAttack();
    		defense = getDefense();
    		
    		gp.playSE(5);
    		gp.gameState = gp.dialogueState;
    		setDialogue();
    		startDialogue(this, 0);
    	}
    }
    public void selectItem() {
    	
    	int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);
    	
    	if(itemIndex < inventory.size()) {
    		
    		Entity selectedItem = inventory.get(itemIndex);
    		
    		if(selectedItem.type == type_sword || selectedItem.type == type_axe) {
    			
    			currentWeapon = selectedItem;
    			attack = getAttack();
    			getAttackImage();
    		}
    		if(selectedItem.type == type_shield) {
    			
    			currentShield = selectedItem;
    			defense = getDefense();
    			getGuardImages();
    		}
    		if(selectedItem.type == type_light) {
    			
    			if(currentLight == selectedItem) {
    				currentLight = null;
    			}
    			else {
    				currentLight = selectedItem;
    				getLightImages();
    			}
    			lightUpdated = true;
    		}
    		if(selectedItem.type == type_consumable) {
    			
    			if(selectedItem.use(this) == true){
    				if(selectedItem.amount > 1) {
    					selectedItem.amount--;
    				}
    				else {
    					inventory.remove(itemIndex);
    				}

    			}
    			
    		}
    		
    	}
    }
	public Color getParticleColor() {
		Color color = new Color(210, 50, 0);
		return color;
	}
	public int getParticleSize() {
		int size = 5;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 1;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 20;
		return maxLife;
	}
	public int searchItemInInventory(String itemName) {
		
		int itemIndex = 999;
				
		for(int i = 0; i< inventory.size(); i++) {
			if(inventory.get(i).name.equals(itemName)) {
				itemIndex = i;
				break;
			}
		}
		return itemIndex;
	}
	public boolean canObtainItem(Entity item) {
		
		boolean canObtain = false;
		
		Entity newItem = gp.eGenerator.getObject(item.name);
		
		//CHECK IF STACKABLE
		if(newItem.stackable == true) {
			
			int index = searchItemInInventory(newItem.name);
			
			if(index != 999) { //Can stack, so add to amount
				inventory.get(index).amount++;
				canObtain = true;
			}
			else {//New item, check vacancy
				if(inventory.size() != maxInventorySize) {
					inventory.add(newItem);
					canObtain = true;
				}
			}
		}
		else {//Not stackable, no need to check vacancy
			if(inventory.size() != maxInventorySize) {
				inventory.add(newItem);
				canObtain = true;
			}
		}
		return canObtain;
	}
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        
        if (isAttacking) {
        	if(isGremlin) {
            	switch (direction) {
	            case "up": image = gremlinbackAttacking[spriteNum]; break;
	            case "down": image = gremlinfrontAttacking[spriteNum]; break;
	            case "left": image = gremlinleftAttacking[spriteNum]; break;
	            case "right": image = gremlinrightAttacking[spriteNum]; break;
            	}
        	}else {
            	switch (direction) {
	            case "up": image = backAttacking[spriteNum]; break;
	            case "down": image = frontAttacking[spriteNum]; break;
	            case "left": image = leftAttacking[spriteNum]; break;
	            case "right": image = rightAttacking[spriteNum]; break;
            	}
        	}

        }
        else if (isBlocking) {
        	switch (direction) {
	            case "up": image = backBlocking[spriteNum]; break;
	            case "down": image = frontBlocking[spriteNum]; break;
	            case "left": image = leftBlocking[spriteNum]; break;
	            case "right": image = rightBlocking[spriteNum]; break;
         }
        }
    	else if (isShooting) {
            switch (direction) {
                case "up": image = backShooting[spriteNum]; break;
                case "down": image = frontShooting[spriteNum]; break;
                case "left": image = leftShooting[spriteNum]; break;
                case "right": image = rightShooting[spriteNum]; break;
            }
    	}
        else if (isWalking) {
         	if(isGremlin) {
            	switch (direction) {
	            case "up": image = gremlinbackWalking[spriteNum]; break;
	            case "down": image = gremlinfrontWalking[spriteNum]; break;
	            case "left": image = gremlinleftWalking[spriteNum]; break;
	            case "right": image = gremlinrightWalking[spriteNum]; break;
            	}
        	}else {
        		if (currentLight != null) {
                    switch (direction) {
                    case "up": image = backMoveLight[spriteNum]; break;
                    case "down": image = frontMoveLight[spriteNum]; break;
                    case "left": image = leftMoveLight[spriteNum]; break;
                    case "right": image = rightMoveLight[spriteNum]; break;
                    }
                }
                else {
                	switch (direction) {
                    case "up": image = backWalking[spriteNum]; break;
                    case "down": image = frontWalking[spriteNum]; break;
                    case "left": image = leftWalking[spriteNum]; break;
                    case "right": image = rightWalking[spriteNum]; break;
                }
              }
        	}
            
        } 
        else {
         	if(isGremlin) {
            	switch (direction) {
	            case "up": image = gremlinbackStanding[spriteNum]; break;
	            case "down": image = gremlinfrontStanding[spriteNum]; break;
	            case "left": image = gremlinleftStanding[spriteNum]; break;
	            case "right": image = gremlinrightStanding[spriteNum]; break;
            	}
        	}
         	else {
                if (currentLight != null) {
                    switch (direction) {
                    case "up": image = backLight[spriteNum]; break;
                    case "down": image = frontLight[spriteNum]; break;
                    case "left": image = leftLight[spriteNum]; break;
                    case "right": image = rightLight[spriteNum]; break;
                    }
                }
                else {
                    switch (direction) {
                    case "up": image = backStanding[spriteNum]; break;
                    case "down": image = frontStanding[spriteNum]; break;
                    case "left": image = leftStanding[spriteNum]; break;
                    case "right": image = rightStanding[spriteNum]; break;
                }
              }
         	}

        }
        
        if(transparent == true) {
        	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }
        
        //Shadow
        g2.setColor(new Color(0, 0, 0, 100));
        g2.fillOval(screenX + 8, screenY + 37, 30, 10);
        
        // Calculate offsets to keep character centered
        if(image != null) { //To prevent null pointer exception
            int spriteWidth = image.getWidth();
            int spriteHeight = image.getHeight();
            int xOffset = (spriteWidth - gp.tileSize) / 2;
            int yOffset = (spriteHeight - gp.tileSize) / 2;
        	if(drawing == true) {
                g2.drawImage(image, screenX - xOffset, screenY - yOffset, null);
        	}

        }
        

      
        //Reset opacity 
    	g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    	
        //Debug: Player Collision
    	if(gp.keyH.showDebugText) {
            g2.setColor(Color.red);
            g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);
//          g2.drawString("Invincible Counter: " + invincibleCounter, 10, 400);
    	}
    }
}