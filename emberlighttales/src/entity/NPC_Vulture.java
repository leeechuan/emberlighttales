package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Vulture extends Entity {
	
	public static final String npcName = "Vulture";
	
	public NPC_Vulture(GamePanel gp) {
		super(gp);
		
//		type = type_npc;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize/4, gp.tileSize/4);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
        
        townNum = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/animals/vulture_stand_" + i, 2f, 2f);
             rightStanding[i] = setup("/animals/vulture_stand_" +i, 2f, 2f);
             backStanding[i] = setup("/animals/vulture_stand_" + i, 2f, 2f);
             frontWalking[i] = setup("/animals/vulture_move_" + i, 2f, 2f);
             rightWalking[i] = setup("/animals/vulture_move_" + i, 2f, 2f);
             backWalking[i] = setup("/animals/vulture_move_" + i, 2f, 2f);
         }
      for (int i = 0; i < 6; i++) {
             leftStanding[i] = invertImage(rightStanding[i]);
             leftWalking[i] = invertImage(rightWalking[i]);
       	}
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Kraaaak!";		
		
		dialogues[1][0] = "Hrrnnk… hrrrnk!";		
		dialogues[1][1] = "Skreee-uhk!";

	}
	public void setAction() {
		
	    actionLockCounter++;

	    if (actionLockCounter == 120) {
	        Random random = new Random();
	        int i = random.nextInt(100) + 1; // 1 to 100

	        if (i <= 60) {
	            // 60% chance to stay still
	            direction = "up";
	            isWalking = false;
	            speed = 0;
	        } else if (i <= 70) {
	            direction = "up";
	            isWalking = true;
	            speed = defaultSpeed;
	        } else if (i <= 80) {
	            direction = "down";
	            isWalking = true;
	            speed = defaultSpeed;
	        } else if (i <= 90) {
	            direction = "left";
	            isWalking = true;
	            speed = defaultSpeed;
	        } else {
	            direction = "right";
	            isWalking = true;
	            speed = defaultSpeed;
	        }

	        actionLockCounter = 0;
	    }
	}
	

}
