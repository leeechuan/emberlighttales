package entity;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import ai.Node;
import ai.PathFinder;
import main.emberlight.GamePanel;
import main.emberlight.UtilityTool;

public class Entity {

	protected GamePanel gp;
	
    //ANIMATION FRAMES
    public BufferedImage[] frontStanding = new BufferedImage[6];
    public BufferedImage[] frontWalking = new BufferedImage[6];
    public BufferedImage[] backStanding = new BufferedImage[6];
    public BufferedImage[] backWalking = new BufferedImage[6];
    public BufferedImage[] rightStanding = new BufferedImage[6];
    public BufferedImage[] rightWalking = new BufferedImage[6];
    public BufferedImage[] leftStanding = new BufferedImage[6];
    public BufferedImage[] leftWalking = new BufferedImage[6];
    public BufferedImage[] frontAttacking = new BufferedImage[6];
    public BufferedImage[] backAttacking = new BufferedImage[6];
    public BufferedImage[] rightAttacking = new BufferedImage[6];
    public BufferedImage[] leftAttacking = new BufferedImage[6];
    public BufferedImage[] frontBlocking = new BufferedImage[6];
    public BufferedImage[] backBlocking = new BufferedImage[6];
    public BufferedImage[] rightBlocking = new BufferedImage[6];
    public BufferedImage[] leftBlocking = new BufferedImage[6];
    public BufferedImage[] frontShooting = new BufferedImage[6];
    public BufferedImage[] backShooting = new BufferedImage[6];
    public BufferedImage[] rightShooting = new BufferedImage[6];
    public BufferedImage[] leftShooting = new BufferedImage[6];
    public BufferedImage[] frontLight = new BufferedImage[6];
    public BufferedImage[] backLight = new BufferedImage[6];
    public BufferedImage[] rightLight = new BufferedImage[6];
    public BufferedImage[] leftLight = new BufferedImage[6];
    public BufferedImage[] frontMoveLight = new BufferedImage[6];
    public BufferedImage[] backMoveLight = new BufferedImage[6];
    public BufferedImage[] rightMoveLight = new BufferedImage[6];
    public BufferedImage[] leftMoveLight = new BufferedImage[6];
    public BufferedImage[] frontDeath = new BufferedImage[6];
	public BufferedImage image1, image2, image3;
	public BufferedImage portrait;
    //ANIMATION STATE
    public boolean isWalking = false;
    public boolean isAttacking = false;
    public boolean isShooting = false;
    public boolean isAnimating = false;
	public boolean isBlocking = false;
	public boolean transparent = false;
    //COLLISION
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
	public int solidAreaDefaultX, solidAreaDefaultY;
	public boolean collision = false;
	public String dialogues[][] = new String[20][20];
	public Entity attacker;
	public Entity linkedEntity;
	public boolean temp = false;
	
	//STATE
	public int worldX, worldY;
	public String direction = "down";
	public int spriteNum = 1;
	public int dialogueSet = 0;
	public int dialogueIndex = 0;
	public boolean collisionOn = false;
	public boolean invincible = false;
	public boolean alive = true;
	public boolean dying = false;
	public boolean hpBarOn = false;
	public boolean onPath = false;
	public boolean knockBack = false;
	public String knockBackDirection;
	public boolean offBalance = false;
	public Entity loot;
	public boolean opened = false;
	public boolean rageState = false;
	public boolean sleep = false;
	public boolean drawing = true;
	public boolean gate_open_state = false;
	public boolean isIndoors = false;
	
	//COUNTER
	public int spriteCounter = 0;
	public int actionLockCounter = 0;
	public int invincibleCounter = 0;
	public int shotAvailableCounter = 0;
    public int shootingSpriteCounter = 0;
    public int attackSpriteCounter = 0;
	public int animationCounter = 0;
	int dyingCounter = 0;
	public int hpBarCounter = 0;
	int knockBackCounter = 0;
	public int blockCounter = 0;
	int offBalanceCounter = 0;
	public int soundCooldown = 0;  // Countdown before playing sound again
	public final int soundDelay = 15; // Adjust this value to control delay (frames)
	
	//CHARACTER ATTRIBUTES
	public String name;
	public int defaultSpeed;
	public int speed;
	public int maxLife;
	public int life;
	public int maxMana;
	public int mana;
	public int ammo;
	public int level;
	public int strength;
	public int dexterity;
	public int attack;
	public int defense;
	public int exp;
	public int nextLevelExp;
	public int coin;
	public int motion1_duration;
	public int motion2_duration;
	public int motion3_duration;
	public int motion4_duration;
	public int motion5_duration;
	public int motion6_duration;
	public Entity currentWeapon;
	public Entity currentShield;
	public Entity currentLight;
	public Projectile projectile;
	public boolean boss;
	public Rectangle roamingArea;
	
	//ITEM ATTRIBUTES
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int maxInventorySize = 20;
	public int value;
	public int attackValue;
	public int defenseValue;
	public String description = "";
	public int useCost;
	public int price;
	public int knockBackPower = 0;
	public boolean stackable = false;
	public int amount = 1;
	public int lightRadius;
	
	//NPC SCHEDULE
	public int homeWorldX;
	public int homeWorldY;
	public int outsideWorldX;
	public int outsideWorldY;
	public int homeMapNum;
	public int townNum; // 1 - Emberville, 2 - Gildenshore, 3 - Solara
	private int scheduleCooldown = 0; // Controls how often this NPC does heavy scheduling stuff (like pathfinding)
	private PathFinder pFinder;

	//TYPE
	public int type; // 0 - player, 1 - npc, 2 - mob
	public final int type_player = 0;
	public final int type_npc = 1;
	public final int type_mob = 2;
	public final int type_sword = 3;
	public final int type_axe = 4;
	public final int type_shield = 5;
	public final int type_consumable = 6;
	public final int type_pickupOnly = 7;
	public final int type_obstacle = 8;
	public final int type_light = 9;
	
	public Entity(GamePanel gp) {
		this.gp = gp;
		this.pFinder = new PathFinder(gp);
		
	}
	public int getScreenX() {
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
        return screenX;
	}
	public int getScreenY() {
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        return screenY;
	}
	public int getLeftX() {
		return worldX + solidArea.x;
	}
	public int getRightX() {
		return worldX + solidArea.x + solidArea.width;
	}
	public int getTopY() {
		return worldY + solidArea.y;
	}
	public int getBottomY() {
		return worldY + solidArea.y + solidArea.height;
	}
	public int getCol() {
		return (worldX + solidArea.x)/gp.tileSize;
	}
	public int getRow() {
		return (worldY + solidArea.y)/gp.tileSize;
	}
	public int getCenterX(){
		int centerX = worldX + leftStanding[0].getWidth()/2;
		return centerX;
	}
	public int getCenterY(){
		int centerY = worldY + backStanding[0].getHeight()/2;
		return centerY;
	}
	public int getXdistance(Entity target) {
		int xDistance = Math.abs(getCenterX() - target.getCenterX());
		return xDistance;
	}
	public int getYdistance(Entity target) {
		int yDistance = Math.abs(getCenterY() - target.getCenterY());
		return yDistance;
	}
	public int getTileDistance(Entity target) {
		int tileDistance = (getXdistance(target) + getYdistance(target))/gp.tileSize;
		return tileDistance;
	}
	public int getGoalCol(Entity target) {
		int goalCol = (target.worldX + target.solidArea.x)/gp.tileSize;
		return goalCol;
	}
	public int getGoalRow(Entity target) {
		int goalRow = (target.worldY + target.solidArea.y)/gp.tileSize;
		return goalRow;
	}
	public void resetCounter() {
		
		spriteCounter = 0;
		actionLockCounter = 0;
		invincibleCounter = 0;
		shotAvailableCounter = 0;
	    shootingSpriteCounter = 0;
	    attackSpriteCounter = 0;
		animationCounter = 0;
		dyingCounter = 0;
		hpBarCounter = 0;
		knockBackCounter = 0;
		blockCounter = 0;
		offBalanceCounter = 0;
	}
	public void setLoot(Entity loot) {}
	public void setAction() {}
	public void move(String direction) {}
	public void damageReaction() {}
	public void speak() {}
	public void facePlayer() {
		switch(gp.player.direction) {
		case "up":
			direction = "down";
			break;
		case "down":
			direction = "up";
			break;
		case "left":
			direction = "right";
			break;
		case "right":
			direction = "left";
			break;
		}
	}
	public void startDialogue(Entity entity, int setNum) {
		gp.gameState = gp.dialogueState;
		gp.ui.npc = entity;
		dialogueSet = setNum;
	}
	public void interact() {}
	public boolean use (Entity entity) {return false;};
	public void checkDrop() {}
	public void dropItem(Entity droppedItem) {

		
		for(int i = 0; i < gp.obj[1].length; i++) {
			if(gp.obj[gp.currentMap][i] == null) {
				gp.obj[gp.currentMap][i] = droppedItem;
				gp.obj[gp.currentMap][i].worldX = worldX;
				gp.obj[gp.currentMap][i].worldY = worldY;
				break;
			}
		}
	}
	public Color getParticleColor() {
		Color color = null;
		return color;
	}
	public int getParticleSize() {
		int size = 0;
		return size;
	}
	public int getParticleSpeed() {
		int speed = 0;
		return speed;
	}
	public int getParticleMaxLife() {
		int maxLife = 0;
		return maxLife;
	}
	public void generateParticle(Entity generator, Entity target) {
		
		Color color = generator.getParticleColor();
		int size = generator.getParticleSize();
		int speed = generator.getParticleSpeed();
		int maxLife = generator.getParticleMaxLife();
		
		Particle p1 = new Particle(gp, target, color, size, speed, maxLife, -1, -1);
		Particle p2 = new Particle(gp, target, color, size, speed, maxLife, 1, -1);
		Particle p3 = new Particle(gp, target, color, size, speed, maxLife, -1, 1);
		Particle p4 = new Particle(gp, target, color, size, speed, maxLife, 1, 1);
		gp.particleList.add(p1);
		gp.particleList.add(p2);
		gp.particleList.add(p3);
		gp.particleList.add(p4);
	}
	public void checkCollision() {
		collisionOn = false;
		gp.cChecker.checkTile(this);
		gp.cChecker.checkObject(this, false);
		gp.cChecker.checkEntity(this, gp.npc);
		gp.cChecker.checkEntity(this, gp.mob);
		gp.cChecker.checkEntity(this, gp.iTile);
		boolean contactPlayer = gp.cChecker.checkPlayer(this);
		
		if(this.type == type_mob && contactPlayer == true) {
			
			damagePlayer(attack);
		}
	}
	public void update() {
		
		if(sleep == false) {
			if(knockBack == true) {
				
				checkCollision();
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
			else if(isAttacking == true){
				attacking();
			}
			else {
				setAction();
				checkCollision();
				
				isWalking = true;
			    // If collision is detected with an object or another NPC OR speed is 0, stop walking
			    if (this.collisionOn || speed == 0) {
			        isWalking = false; // NPC is stuck or colliding, stop walking
			    }
			    else {
			    	 isWalking = true; // Continue walking if no collision
			    }
			    
				
		        //If Collision is False, Move Entity.
		        if(collisionOn == false) {
		        	switch(direction) {
		        	case "up": worldY -= speed; break;
		    		case "down": worldY += speed; break;
			    	case "left": worldX -= speed; break;
					case "right": worldX += speed; break;
					}
		        }
		        spriteCounter++;
		        if (spriteCounter > 20) { // Adjust speed of animation
		            spriteNum = (spriteNum + 1) % 6; // Loop through 6 frames
		            spriteCounter = 0;
		        }
		        
			}


	        
	        //Outside of key if statement
	        if(invincible == true) {
	        	invincibleCounter++;
	        	if(invincibleCounter > 40) {
	        		invincible = false;
	        		invincibleCounter = 0;
	        	}
	        }
	        
	        if(shotAvailableCounter < 30) {
	        	shotAvailableCounter++;
	        }
	        if(offBalance == true) {
	        	offBalanceCounter++;
	        	if(offBalanceCounter > 60) {
	        		offBalance = false;
	        		offBalanceCounter = 0;
	        	}
	        }
		}
		if(homeMapNum != 0) {
			npcScheduleAndBoundaries();
		}
		
	}
	public void checkAttackOrNot(int rate, int straight, int horizontal) {
		
		boolean targetInRange = false;
		int xDis = getXdistance(gp.player);
		int yDis = getYdistance(gp.player);
		
		switch(direction) {
		case "up":
			if(gp.player.getCenterY() < getCenterY() && yDis < straight && xDis < horizontal) {
				targetInRange = true;
			}
			break;
		case "down":
			if(gp.player.getCenterY() > getCenterY() && yDis < straight && xDis < horizontal) {
				targetInRange = true;
			}
			break;
		case "left":
			if(gp.player.getCenterX() < getCenterX() && xDis < straight && yDis < horizontal) {
				targetInRange = true;
			}
			break;
		case "right":
			if(gp.player.getCenterX() > getCenterX() && xDis < straight && yDis < horizontal) {
				targetInRange = true;
			}
			break;
		}
		
		if(targetInRange == true) {
			//Check if it initiates an attack
			int i = new Random().nextInt(rate);
			if(i == 0) {
				isAttacking = true;
				spriteNum = 0;
				spriteCounter = 0;
				shotAvailableCounter = 0;
			}
		}
	}
	public void checkShootOrNot(int rate, int shotInterval) {
		
		int i = new Random().nextInt(rate);
		if(i == 0 && !isShooting && shotAvailableCounter >= shotInterval && projectile.alive == false) {
			isShooting = true;
	        shootingSpriteCounter = 0;
		}
		
	    // Increment cooldown counter
	    if (shotAvailableCounter < 30) {
	        shotAvailableCounter++;
	    }
	}
	public void checkStartChasingOrNot(Entity target, int distance, int rate) {
		
		if(getTileDistance(target) < distance) {
			int i = new Random().nextInt(rate);
			if(i == 0) {
				onPath = true;
			}
		}
	}
	public void checkStopChasingOrNot(Entity target, int distance, int rate) {
		
		if(getTileDistance(target) > distance) {
			int i = new Random().nextInt(rate);
			if(i == 0) {
				onPath = false;
			}
		}
	}
	public void getRandomDirection() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; //pick number from 1 to 100
			
			if(i <= 25) {direction = "up";}
			if(i > 25 && i <= 50) {direction = "down";}
			if(i > 50 && i <= 75) {direction = "left";}
			if(i > 75 && i <= 100) {direction = "right";}
			actionLockCounter = 0;
		}
	}
	public void moveTowardPlayer(int interval) {
		
		actionLockCounter++;
		
		if(actionLockCounter > interval) {
			
			if(getXdistance(gp.player) > getYdistance(gp.player)) {
				if(gp.player.getCenterX() < getCenterX()) {
					direction = "left";
				}
				else {
					direction = "right";
				}
			}
			else if(getXdistance(gp.player) < getYdistance(gp.player)) {
				if(gp.player.getCenterY() < getCenterY()) {
					direction = "up";
				}
				else {
					direction = "down";
				}
			}
			actionLockCounter = 0;
		}
	}
	public void moveToTarget(int targetX, int targetY) {
	    // Calculate the distance to move in both X and Y directions
	    int deltaX = targetX - worldX;
	    int deltaY = targetY - worldY;

	    // Move step-by-step towards the target
	    if (Math.abs(deltaX) > speed) {
	        worldX += (deltaX > 0) ? speed : -speed;
	    } else {
	        worldX = targetX; // Snap to target position once reached
	    }

	    if (Math.abs(deltaY) > speed) {
	        worldY += (deltaY > 0) ? speed : -speed;
	    } else {
	        worldY = targetY; // Snap to target position once reached
	    }

	    // Update animation based on direction
	    if (worldX < targetX) {
	        direction = "right";
	    } else if (worldX > targetX) {
	        direction = "left";
	    }

	    if (worldY < targetY) {
	        direction = "down";
	    } else if (worldY > targetY) {
	        direction = "up";
	    }
	}
	public void resetPathfinding() {
		speed = defaultSpeed;
	}

	public void pathfindTo(int targetCol, int targetRow, String endDirection) {
	    // convert world coords into tile coords
	    int startCol = (worldX + gp.tileSize / 2) / gp.tileSize;
	    int startRow = (worldY + gp.tileSize / 2) / gp.tileSize;

	    // if we’re already at the target, snap and bail
	    if (startCol == targetCol && startRow == targetRow) {
	        gp.pFinder.pathList.clear();
	        isWalking = false;
	        direction = endDirection;
	        speed = 0;
	        return;
	    }

	    if (scheduleCooldown <= 0) {
            pFinder.setNodes(startCol, startRow, targetCol, targetRow, this);
            if (pFinder.search()) {
                // pFinder.pathList is now YOUR list
            } else {
                pFinder.pathList.clear();
            }
            scheduleCooldown = 30;
        } else {
            scheduleCooldown--;
        }

        followNextStep(targetCol, targetRow, endDirection, pFinder.pathList);
	}

	private void followNextStep(int targetCol, int targetRow, String endDirection, List<Node> path) {
	    if (path.isEmpty()) return;

	    Node nextStep = path.get(0);
	    int nextX = nextStep.col * gp.tileSize;
	    int nextY = nextStep.row * gp.tileSize;
	    int threshold = 2;  // vertical snap threshold

	    // horizontal movement
	    if (worldX < nextX) {
	        isWalking = true; direction = "right";
	        worldX += Math.min(speed, nextX - worldX);
	    } else if (worldX > nextX) {
	        isWalking = true; direction = "left";
	        worldX -= Math.min(speed, worldX - nextX);
	    }

	    // vertical movement (with snap)
	    if (Math.abs(worldY - nextY) > threshold) {
	        if (worldY < nextY) {
	            isWalking = true; direction = "down";
	            worldY += Math.min(speed, nextY - worldY);
	        } else {
	            isWalking = true; direction = "up";
	            worldY -= Math.min(speed, worldY - nextY);
	        }
	    } else {
	        worldY = nextY;
	    }

	    // if we’ve reached the tile center, pop it off
	    if (Math.abs(worldX - nextX) < speed && Math.abs(worldY - nextY) < speed) {
	        worldX = nextX;
	        worldY = nextY;
	        path.remove(0);
	    }

	    // if that was the last step, snap perfectly
	    if (path.isEmpty()) {
	        isWalking = false;
	        worldX = targetCol * gp.tileSize - gp.tileSize/4;
	        worldY = targetRow * gp.tileSize - gp.tileSize/4;
	        direction = endDirection;
	    }
	}
	public String getOppositeDirection(String direction) {
		
		String oppositeDirection = "";
		
		switch(direction) {
		case "up" : oppositeDirection = "down";break;
		case "down" : oppositeDirection = "up";break;
		case "left" : oppositeDirection = "right";break;
		case "right" : oppositeDirection = "left";break;
		}
		return oppositeDirection;
	}
	public void attacking() {
    	attackSpriteCounter++;
    	if(attackSpriteCounter <= motion1_duration) {
    		spriteNum = 0;
    	}
    	if(attackSpriteCounter > motion1_duration && attackSpriteCounter <= motion2_duration) {
    		spriteNum = 1;	
    		
    		//Save current worldX, worldY, solidArea
    		int currentWorldX = worldX;
    		int currentWorldY = worldY;
    		int solidAreaWidth = solidArea.width;
    		int solidAreaHeight = solidArea.height;
    		
    		//Adjust player's worldX and worldY for the attackArea
    		switch(direction) {
    		case "up": worldY -= attackArea.height; break;
    		case "down": worldY += attackArea.height; break;
    		case "left": worldX -= attackArea.width; break;
    		case "right": worldX += attackArea.width; break;
    		}
    		
    		//attackArea becomes solidArea
    		solidArea.width = attackArea.width;
    		solidArea.height = attackArea.height;
    		
    		if(type == type_mob) {
    			if(gp.cChecker.checkPlayer(this) == true) {
    				damagePlayer(attack);
    			}
    		}
    		else { //Player
        		//Check mob collision with the updated worldX, worldY and solidArea
        		int mobIndex = gp.cChecker.checkEntity(this, gp.mob);
        		gp.player.damageMob(mobIndex, this, attack, currentWeapon.knockBackPower);
        		
        		int iTileIndex = gp.cChecker.checkEntity(this, gp.iTile);
        		gp.player.damageInteractiveTile(iTileIndex);
        		
        		int projectileIndex = gp.cChecker.checkEntity(this, gp.projectile);
        		gp.player.damageProjectile(projectileIndex);
    		}

    		
    		//After checking collision, we restore the original data
    		worldX = currentWorldX;
    		worldY = currentWorldY;
    		solidArea.width = solidAreaWidth;
    		solidArea.height = solidAreaHeight;
    	}
    	if(attackSpriteCounter > motion2_duration && attackSpriteCounter <= motion3_duration) {
    		spriteNum = 2;
    	}
    	if(attackSpriteCounter > motion3_duration && attackSpriteCounter < motion4_duration) {
    		spriteNum = 3;
    	}

    	if(motion5_duration != 0 && motion6_duration != 0) {
        	if(attackSpriteCounter > motion4_duration && attackSpriteCounter <= motion5_duration) {
        		spriteNum = 4;
        	}
        	if(attackSpriteCounter > motion5_duration && attackSpriteCounter < motion6_duration) {
        		spriteNum = 5;
        	}
        	if(attackSpriteCounter >= motion6_duration) {
        		spriteNum = 0;
        		attackSpriteCounter = 0;
        		isAttacking = false;
        	}
    	} 
    	else {
        	if(attackSpriteCounter >= motion4_duration) {
        		spriteNum = 0;
        		attackSpriteCounter = 0;
        		isAttacking = false;
        	}
    	}
    }
	public void damagePlayer(int attack) {
		
		if(gp.player.invincible == false) {
			gp.playSE(3);
			
			int damage = attack - gp.player.defense;
			
			//Get an opposite direction of this attacker
			String canBlockDirection = getOppositeDirection(direction);
			
			if(gp.player.isBlocking == true && gp.player.direction.equals(canBlockDirection)){
				
				//Parry
				if(gp.player.blockCounter < 12) {
					damage = 0;
					gp.playSE(11);
					setKnockBack(this, gp.player, knockBackPower);
					offBalance = true;
					spriteCounter =- 60;
				}
				//Normal guard
				else {
				damage /= 3;
				gp.playSE(10);
				}

			}
			else {
				//Not Blocking
				if(damage < 1) {
					 damage = 1;
				}
			}
			
			if(damage != 0) {
				gp.player.transparent = true;
				setKnockBack(gp.player, this, knockBackPower);
			}
			
			gp.player.life -= damage;
			gp.player.invincible = true;
		}
	}
    public void setKnockBack(Entity target, Entity attacker, int knockBackPower) {
    	
    	
    	this.attacker = attacker;
    	target.knockBackDirection = attacker.direction;
    	target.speed += knockBackPower;
    	target.knockBack = true;
    }
    public boolean inCamera() {
    	boolean inCamera = false;
    	
    	 if (worldX + gp.tileSize * 2 > gp.player.worldX - gp.player.screenX &&
                 worldX - gp.tileSize * 2 < gp.player.worldX + gp.player.screenX &&
                 worldY + gp.tileSize * 2 > gp.player.worldY - gp.player.screenY &&
                 worldY - gp.tileSize * 2 < gp.player.worldY + gp.player.screenY) {
    		 inCamera = true;
    	 }
    	 return inCamera;
    }
    public BufferedImage invertImage(BufferedImage image) {
        BufferedImage invertedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                invertedImage.setRGB(image.getWidth() - x - 1, y, image.getRGB(x, y));
            }
        }
        return invertedImage;
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
                g2.fillOval(screenX + 20, screenY + 47, 30, 10);
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
	public void dyingAnimation() {
	    if (!alive) {
	    	spriteNum = 5;
	        return; // If already dead, don't animate
	    }
		
		dyingCounter++;
    	
    	if(dyingCounter <= 5) {
    		spriteNum = 0;
    	}
    	if(dyingCounter > 5 && dyingCounter <= 10) {
    		spriteNum = 1;
    	}
    	
    	if(dyingCounter > 10 && dyingCounter <= 15) {
    		spriteNum = 2;
    	}
    	if(dyingCounter > 15 && dyingCounter <= 20) {
    		spriteNum = 3;
    	}
    	if(dyingCounter > 20 && dyingCounter <= 25) {
    		spriteNum = 4;
    	}
    	if(dyingCounter > 25 && dyingCounter <= 30) {
    		spriteNum = 5;
    	}
    	if(dyingCounter > 30) {
    		spriteNum = 5;
//    		dyingCounter = 0;
    		alive = false;
    	}
	}
	public BufferedImage setup(String imagePath, float scaleHeight, float scaleWidth) {
	    UtilityTool uTool = new UtilityTool();
	    BufferedImage image = null;

	    // Convert the scaled dimensions to integers
	    int scaledWidth = (int) (gp.tileSize * scaleWidth);
	    int scaledHeight = (int) (gp.tileSize * scaleHeight);

	    try {
	        InputStream is = getClass().getResourceAsStream(imagePath + ".png");
	        if (is == null) {
	            System.err.println("ERROR: Image file not found -> " + imagePath + ".png");
	            return null;
	        }

	        BufferedImage tempImage = ImageIO.read(is);
	        
	        // Ensure transparency is preserved
	        if (tempImage.getType() != BufferedImage.TYPE_INT_ARGB) {
	            BufferedImage newImage = new BufferedImage(tempImage.getWidth(), tempImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
	            Graphics2D g2 = newImage.createGraphics();
	            g2.drawImage(tempImage, 0, 0, null);
	            g2.dispose();
	            tempImage = newImage;
	        }

	        // Scale the image using UtilityTool
	        image = uTool.scaleImage(tempImage, scaledWidth, scaledHeight);

	    } catch (IOException e) {
	        System.err.println("Exception while loading image -> " + imagePath + ": " + e.getMessage());
	        e.printStackTrace();
	    }

	    return image;
	}
    public void searchPath(int goalCol, int goalRow) {
    	
    	int startCol  = (worldX + solidArea.x)/gp.tileSize;
    	int startRow = (worldY + solidArea.y)/gp.tileSize;

    	gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow, this);
    	
    	if(gp.pFinder.search() == true) {
    		
    		//Next worldX & worldY
    		int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
    		int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;
    		
    		//Entity's solidArea position
    		int enLeftX = worldX + solidArea.x;
    		int enRightX = worldX + solidArea.x + solidArea.width;
    		int enTopY = worldY + solidArea.y;
    		int enBottomY = worldY + solidArea.y + solidArea.height;
    		
    		if(enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
    			direction = "up";
    		}
    		else if(enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
    			direction = "down";
    		}
    		else if(enTopY >= nextY && enBottomY < nextY + gp.tileSize) {
    			
    			if(enLeftX > nextX) {
    				direction = "left";
    			}
    			if(enLeftX < nextX) {
    				direction = "right";
    			}
    		}
    		else if(enTopY > nextY && enLeftX > nextX) {
    			
    			direction = "up";
    			checkCollision();
    			if(collisionOn == true) {
    				direction = "left";
    			}
    		}
    		else if(enTopY > nextY && enLeftX < nextX) {
    			
    			direction = "up";
    			checkCollision();
    			if(collisionOn == true) {
    				direction = "right";
    			}
    		}
    		else if(enTopY < nextY && enLeftX > nextX) {
    			
    			direction = "down";
    			checkCollision();
    			if(collisionOn == true) {
    				direction = "left";
    			}
    		}
    		else if(enTopY < nextY && enLeftX < nextX) {
    			
    			direction = "down";
    			checkCollision();
    			if(collisionOn == true) {
    				direction = "right";
    			}
    		}
    		
    		//If reaches the goal, stop search
//    		int nextCol = gp.pFinder.pathList.get(0).col;
//    		int nextRow = gp.pFinder.pathList.get(0).row;
//    		if(nextCol == goalCol && nextRow == goalRow) {
//    			onPath = false;
//    		}
    	}
    }
    public int getDetected(Entity user, Entity target[][], String targetName) {
    	
    	int index = 999;
    	
    	//Check the surrounding object
    	int nextWorldX = user.getLeftX();
    	int nextWorldY = user.getTopY();
    	
    	switch(user.direction) {
    	case "up": nextWorldY = user.getTopY() - gp.player.speed; break;
    	case "down" : nextWorldY = user.getBottomY() + gp.player.speed; break;
    	case "left" : nextWorldX = user.getLeftX() - gp.player.speed; break;
    	case "right" : nextWorldX = user.getRightX() + gp.player.speed; break;
    	}
    	int col = nextWorldX/gp.tileSize;
    	int row = nextWorldY/gp.tileSize;
    	
    	for(int i = 0; i < target[1].length; i++) {
    		if(target[gp.currentMap][i] != null) {
    			if(target[gp.currentMap][i].getCol() == col &&
    					target[gp.currentMap][i].getRow() == row &&
    					target[gp.currentMap][i].name.equals(targetName)) {
    				
    				index = i;
    				break;
    			}
    		}
    	}
    	return index;
    }
	public void setDialogue() {}
	public void changeNPCMap(String npcName, int newMap, int newCol, int newRow) {
//		System.out.println(npcName + "---" + newCol + "---" + newRow);
	    // Iterate over all map layers
	    for (int m = 0; m < gp.npc.length; m++) {
	        for (int i = 0; i < gp.npc[m].length; i++) {
	            Entity npc = gp.npc[m][i];
	            if (npc != null && npc.name.equals(npcName)) {
	                // Found the NPC; remove it from the current map's array
	                gp.npc[m][i] = null;
	                
	                // Update the NPC's world coordinates
	                npc.worldX = newCol * gp.tileSize;
	                npc.worldY = newRow * gp.tileSize;
	                
	                // npc.currentMap = newMap;
	                
	                // Place the NPC in the new map's npc array (find the first available slot)
	                for (int j = 0; j < gp.npc[newMap].length; j++) {
	                    if (gp.npc[newMap][j] == null) {
	                        gp.npc[newMap][j] = npc;
	                        return;
	                    }
	                }
	            }
	        }
	    }
	}
	public void moveBackIntoRoamingArea() {
		System.out.println(name + " is moving back");
		System.out.println(name + " roaming Area =" + roamingArea);
	    // Left boundary
	    if (worldX < roamingArea.x) {
	        worldX = roamingArea.x;
	        direction = "right";
	    }
	    // Right boundary
	    else if (worldX > roamingArea.x + roamingArea.width) {
	        worldX = roamingArea.x + roamingArea.width;
	        direction = "left";
	    }

	    // Top boundary
	    if (worldY < roamingArea.y) {
	        worldY = roamingArea.y;
	        direction = "down";
	    }
	    // Bottom boundary
	    else if (worldY > roamingArea.y + roamingArea.height) {
	        worldY = roamingArea.y + roamingArea.height;
	        direction = "up";
	    }
	}
	
	public void npcScheduleAndBoundaries() {
		
		if (roamingArea == null) {
		    roamingArea = new Rectangle();
		}
	    
	    //Dawn
	    if (gp.eManager.lighting.dayState == gp.eManager.lighting.dawn) {
	        if (Math.abs(worldX - gp.tileSize * homeWorldX) < gp.tileSize && Math.abs(worldY - gp.tileSize * homeWorldY) < gp.tileSize) {
	        	isIndoors = false;
	            changeNPCMap(name, 0, outsideWorldX, outsideWorldY + 1);
	        } else {
	            pathfindTo(homeWorldX, homeWorldY, "down");
	        }
	    } 
	    
	    //Day
	    else if (gp.eManager.lighting.dayState == gp.eManager.lighting.day) {
	    	if(townNum == 1) {
	    		//EMBERVILLE
	    		roamingArea.setBounds(gp.tileSize * 48, gp.tileSize * 43, gp.tileSize * 50, gp.tileSize * 50);
	    	}
	    	else if(townNum == 2) {
	    		//GILDENSHORE
	    		roamingArea.setBounds(gp.tileSize * 5, gp.tileSize * 5, gp.tileSize * 45, gp.tileSize * 37);
	    	}
	    	else {
	    		//ENTIRE WORLD MAP
	    		roamingArea.setBounds(gp.tileSize * 0, gp.tileSize * 0, gp.tileSize * 100, gp.tileSize * 100);
	    	}
	        
	        if(isIndoors) {
	        	isIndoors = false;
	        	changeNPCMap(name, 0, outsideWorldX, outsideWorldY + 1);
	        }
	    } 
	    
	    //Dusk
	    else if (gp.eManager.lighting.dayState == gp.eManager.lighting.dusk) {
	        if (Math.abs(worldX - gp.tileSize * outsideWorldX) < gp.tileSize && Math.abs(worldY - gp.tileSize * outsideWorldY) < gp.tileSize) {
	        	isIndoors = true;
	            changeNPCMap(name, homeMapNum, homeWorldX, homeWorldY - 3);
	        } else {
	            pathfindTo(outsideWorldX, outsideWorldY, "up");
	        }
	    }
	    
	    //Night
	    else {
	    	roamingArea.setBounds(gp.tileSize * 0, gp.tileSize * 0, gp.tileSize * 100, gp.tileSize * 100);
	        if(!isIndoors) {
	        	isIndoors = true;
	        	changeNPCMap(name, homeMapNum, homeWorldX, homeWorldY - 3);
	        }
	    }
	    
	    //Test for out of bounds
	    if (!roamingArea.contains(worldX, worldY) && (gp.eManager.lighting.dayState == gp.eManager.lighting.day || gp.eManager.lighting.dayState == gp.eManager.lighting.night)) {
	    	moveBackIntoRoamingArea();
	    }
	}
	public boolean areBanditsRemaining() {
	    for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
	        for (int i = 0; i < gp.mob[mapNum].length; i++) {
	            Entity mob = gp.mob[mapNum][i];
	            if (mob != null && mob.name != null && (mob.name.contains("Swordman Bandit") || mob.name.contains("Templar Bandit")) && !mob.dying) {
	                return true; // Found a living bandit
	            }
	        }
	    }
	    return false; // No bandits left
	}
}
