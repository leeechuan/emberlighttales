package entity;

import main.emberlight.GamePanel;

public class Projectile extends Entity{
	
	Entity user;
	
	public Projectile(GamePanel gp) {
		super(gp);
		
	}
	public void set(int worldX, int worldY, String direction, boolean alive, Entity user) {
		this.worldX = worldX;
		this.worldY = worldY;
		this.direction = direction;
		this.alive = alive;
		this.user = user;
		this.life = this.maxLife;
	}
	public void update() {
		
		if(user == gp.player) {
			
			int mobIndex = gp.cChecker.checkEntity(this, gp.mob);
			if(mobIndex != 999) {
				gp.player.damageMob(mobIndex, this, attack*(gp.player.level/2), knockBackPower);
				generateParticle(gp.mob[gp.currentMap][mobIndex], gp.mob[gp.currentMap][mobIndex]);
				alive = false;
			}
		}
		if(user != gp.player) {
			boolean contactPlayer = gp.cChecker.checkPlayer(this);
			if(gp.player.invincible == false && contactPlayer == true) {
				damagePlayer(attack);
				generateParticle(gp.player, gp.player);
				alive = false;
			}
		}
		
		switch(direction) {
		case "up": worldY -= speed; break;
		case "down": worldY += speed; break;
		case "left": worldX -= speed; break;
		case "right": worldX += speed; break;
		}
		
		life--;
		if(life <= 0) {
			alive = false;
		}
		
		spriteCounter++;
        if (spriteCounter > 20) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % 6; // Loop through 6 frames
            spriteCounter = 0;
        }
	}
	public boolean haveResource(Entity user) {
		boolean haveResource = false;
		return haveResource;
	}
	public void subtractResource(Entity user) {}
}
