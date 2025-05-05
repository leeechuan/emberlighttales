package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Cow extends Entity {
	
	public static final String npcName = "William the Cow";
	
	public NPC_Cow(GamePanel gp) {
		super(gp);
		
//		type = type_npc;
		direction = "down";
        defaultSpeed = 0;
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
	                frontStanding[i] = setup("/animals/cow_sleeping_" + i, 2f, 2f);
	                rightStanding[i] = setup("/animals/cow_sleeping_" +i, 2f, 2f);
	                backStanding[i] = setup("/animals/cow_sleeping_" + i, 2f, 2f);
	                frontWalking[i] = setup("/animals/cow_sleeping_" + i, 2f, 2f);
	                rightWalking[i] = setup("/animals/cow_sleeping_" + i, 2f, 2f);
	                
	                backWalking[i] = setup("/animals/cow_sleeping_" + i, 2f, 2f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Zzzzz";		
		
		dialogues[1][0] = "ZZZzzZZZ";

	}
	public void setAction() {
		
		actionLockCounter++;
		
		if(actionLockCounter == 120) {
			Random random = new Random();
			int i = random.nextInt(100) + 1; //pick number from 1 to 100
			
			if(i <= 25) {
				direction = "up";
			}
			if(i > 25 && i <= 50) {
				direction = "down";
			}
			if(i > 50 && i <= 75) {
				direction = "left";
			}
			if(i > 75 && i <= 100) {
				direction = "right";
			}
			
			actionLockCounter = 0;
		}		

	}
	

}
