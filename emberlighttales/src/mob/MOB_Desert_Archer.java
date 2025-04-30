package mob;

import java.awt.Color;
import java.util.Random;

import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_Skeleton_Mage_Projectile;

public class MOB_Desert_Archer extends Entity {

	GamePanel gp;
	
	public MOB_Desert_Archer(GamePanel gp) {
		super(gp);
		
		this.gp = gp;
		
		type = type_mob;
		name = "Desert Archer";
		defaultSpeed = 1;
		speed = defaultSpeed;
		maxLife = 80;
		life = maxLife;
		attack = 18;
		defense = 6;
		exp = 20;
		projectile = new OBJ_Arrow(gp);
		
		solidArea.x = gp.tileSize*3/8;
		solidArea.y = gp.tileSize*3/8;
		solidArea.width = gp.tileSize*3/4;
		solidArea.height = gp.tileSize*3/4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		getImage();
		getDeathImage();
	}
	public void getImage() {
		
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/enemy_desert_archer/desert_archer_down_" + i, 3f, 3f);
             rightStanding[i] = setup("/enemy_desert_archer/desert_archer_right_" +i, 3f, 3f);
             backStanding[i] = setup("/enemy_desert_archer/desert_archer_up_" + i, 3f, 3f);
             frontWalking[i] = setup("/enemy_desert_archer/desert_archer_movedown_" + i, 3f, 3f);
             rightWalking[i] = setup("/enemy_desert_archer/desert_archer_moveright_" + i, 3f, 3f);
             backWalking[i] = setup("/enemy_desert_archer/desert_archer_moveup_" + i, 3f, 3f);
             frontShooting[i] = setup("/enemy_desert_archer/desert_archer_attackdown_" + i, 3f, 3f);
             rightShooting[i] = setup("/enemy_desert_archer/desert_archer_attackright_" +i, 3f, 3f);
             backShooting[i] = setup("/enemy_desert_archer/desert_archer_attackup_" + i, 3f, 3f);
         	}
	     for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
             leftShooting[i] = invertImage(rightShooting[i]);
       		}
	}
    public void getDeathImage() {
	     for (int i = 0; i < 6; i++) {
            frontDeath[i] = setup("/enemy_desert_archer/desert_archer_death_" + i, 3f, 3f);
	     }
   }
    public void shooting() {
    	if (isShooting) {
    		shootingSpriteCounter++;

            if (shootingSpriteCounter <= 5) {
                spriteNum = 0;
                speed = 0;
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
                speed = defaultSpeed;
            }
            else {
                // Animation complete: reset and fire the projectile
                spriteNum = 0;
                shootingSpriteCounter = 0;

                // Fire the projectile after the animation
                projectile.set(worldX, worldY, direction, true, this);

                //CHECK VACANCY
                for(int ii = 0; ii < gp.projectile[1].length; ii++) {
                	if(gp.projectile[gp.currentMap][ii] == null) {
                		gp.projectile[gp.currentMap][ii] = projectile;
                		break;
                	}
                }

                // Reset shooting state
                isShooting = false;
                shotAvailableCounter = 0; // Reset shot cooldown
            }
        }
    }
	public void setAction() {
		
	    if (isShooting) {
	        shooting(); // Handle shooting animation and projectile logic
	        return; // Skip movement updates
	    }
    	
    	if(onPath == true) {
    		
    		//Check if it stops chasing
    		checkStopChasingOrNot(gp.player, 15, 100);
        	
        	//Search direction to go
			searchPath(getGoalCol(gp.player), getGoalRow(gp.player));
			
			//Check if it shoots a projectile
			checkShootOrNot(100, 30);
    	}
    	else {
    		
    		//Check if it starts chasing
        	checkStartChasingOrNot(gp.player, 5, 100);
        	
        	//Get a random direction
        	getRandomDirection();
			
			
		}
		
	}
	public void damageReaction() {
		
		actionLockCounter = 0;
		onPath = true;
	}
	public Color getParticleColor() {
		Color color = new Color(25, 0, 50);
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
}

