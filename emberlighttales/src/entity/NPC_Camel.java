package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class NPC_Camel extends Entity {
	
	public static final String npcName = "Camel";
	
	public NPC_Camel(GamePanel gp) {
		super(gp);
		
//		type = type_npc;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;
		name = npcName;
		
        solidArea = new Rectangle(18, 18, gp.tileSize*3/4, gp.tileSize*5/4);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        dialogueSet = -1;
        
        townNum = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
	     for (int i = 0; i < 6; i++) {
             frontStanding[i] = setup("/animals/camel_stand_" + i, 2f, 3f);
             leftStanding[i] = setup("/animals/camel_stand_" +i, 2f, 3f);
             backStanding[i] = setup("/animals/camel_stand_" + i, 2f, 3f);
             frontWalking[i] = setup("/animals/camel_move_" + i, 2f, 3f);
             leftWalking[i] = setup("/animals/camel_move_" + i, 2f, 3f);
             backWalking[i] = setup("/animals/camel_move_" + i, 2f, 3f);
         }
      for (int i = 0; i < 6; i++) {
             rightStanding[i] = invertImage(leftStanding[i]);
             rightWalking[i] = invertImage(leftWalking[i]);
       	}
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Mrrrrrrhhhhh…";		
		
		dialogues[1][0] = "Brrrlllp-brrlp!";		
		dialogues[1][1] = "Thwaaaaah!";

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
