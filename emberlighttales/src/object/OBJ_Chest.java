package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Chest extends Entity{
	
	GamePanel gp;
	public static final String objName = "Chest";
	
	public OBJ_Chest(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		frontStanding[0] = setup("/animated_object/chest_0", 1, 1);
		frontStanding[1] = setup("/animated_object/chest_1", 1, 1);
		frontStanding[2] = setup("/animated_object/chest_2", 1, 1);
		frontStanding[3] = setup("/animated_object/chest_3", 1, 1);
		frontStanding[4] = setup("/animated_object/chest_4", 1, 1);
		frontStanding[5] = setup("/animated_object/chest_5", 1, 1);
		
		
		collision = true;
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 32;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	public void setLoot(Entity loot) {
		this.loot = loot;
		
		setDialogue();
	}
    public void setDialogue() {
    	
		dialogues[0][0] = "You opened the chest and found a " + loot.name + "!\n...But you cannot carry any more items!";
		dialogues[1][0] = "You opened the chest and found a " + loot.name + "!\nYou obtained the " + loot.name + "!";
		dialogues[2][0] = "It's empty.";
    }
	public void interact() {
	    if (!opened && !isAnimating) { // Only start animation if not already animating
	        gp.playSE(13);
	        isAnimating = true;
	        animationCounter = 0;
	        spriteNum = 0;  // Reset animation
	    }
	}

	public void update() {
	    if (isAnimating) {
	        animationCounter++;

	        // Change frame every 5 updates
	        if (animationCounter % 5 == 0) {
	            spriteNum++;

	            // If all frames are played, stop animation
	            if (spriteNum >= frontStanding.length) {
	                spriteNum = frontStanding.length - 1; // Stay on last frame
	                isAnimating = false; // Animation finished
	                giveLoot();  // Now give loot and show dialogue
	                opened = true;  // Mark chest as opened
	            }
	        }
	    }
	}

	private void giveLoot() {
		
		if(opened == false) {
			if (gp.player.canObtainItem(loot) == false) {
				startDialogue(this, 0);
			} else {
				startDialogue(this, 1);
			}
		}
		else {
			startDialogue(this, 2);
		}

	}
}
