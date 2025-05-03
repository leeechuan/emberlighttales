package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.emberlight.GamePanel;
import object.OBJ_Wood_Sword;
import object.OBJ_Fruit_Juice;
import object.OBJ_Gold_Sword;
import object.OBJ_Iron_Axe;
import object.OBJ_Iron_Sword;
import object.OBJ_Lantern;
import object.OBJ_Rabbit_Shield_1;
import object.OBJ_Rabbit_Shield_2;
import object.OBJ_Seed;
import object.OBJ_Silver_Sword;
import object.OBJ_Stone_Axe;

public class NPC_Shopkeeper extends Entity{
	
	public static final String npcName = "Korrin Greendale";

	public NPC_Shopkeeper(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;	
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
    	homeWorldX = 50;
    	homeWorldY = 50;
    	outsideWorldX = 12;
    	outsideWorldY = 39;
    	homeMapNum = 18;
    	townNum = 2;
		
		getImage();
		setDialogue();
		setItems();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_shopkeeper/shopkeeper_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_shopkeeper/shopkeeper_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_shopkeeper/shopkeeper_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_shopkeeper/shopkeeper_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_shopkeeper/shopkeeper_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_shopkeeper/shopkeeper_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/shopkeeper_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Welcome back!\nYou’ve got good taste.";
		dialogues[1][0] = "Good luck, sweetheart.";
		dialogues[2][0] = "You don’t have the coin for that.\nCome back when you do.";
		dialogues[3][0] = "Clean out your pack first!";
		dialogues[4][0] = "Unequip that before selling it.";
	}
	public void setItems() {
		
		inventory.add(new OBJ_Iron_Sword(gp));
		inventory.add(new OBJ_Silver_Sword(gp));
		inventory.add(new OBJ_Stone_Axe(gp));
		inventory.add(new OBJ_Iron_Axe(gp));
		
		inventory.add(new OBJ_Rabbit_Shield_2(gp));
		inventory.add(new OBJ_Lantern(gp));
		inventory.add(new OBJ_Fruit_Juice(gp));
    	inventory.add(new OBJ_Seed(gp, 7));
    	inventory.add(new OBJ_Seed(gp, 8));
    	inventory.add(new OBJ_Seed(gp, 9));
    	inventory.add(new OBJ_Seed(gp, 10));
    	inventory.add(new OBJ_Seed(gp, 11));
    	inventory.add(new OBJ_Seed(gp, 12));
    	inventory.add(new OBJ_Seed(gp, 13));
    	inventory.add(new OBJ_Seed(gp, 14));
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
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}


}
