package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.emberlight.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_Fruit_Juice;
import object.OBJ_Gold_Sword;
import object.OBJ_Iron_Sword;
import object.OBJ_Rabbit_Shield_1;
import object.OBJ_Seed;
import object.OBJ_Stone_Axe;
import object.OBJ_Stone_Sword;
import object.OBJ_Torch;
import object.OBJ_Wood_Axe;
import object.OBJ_Wood_Sword;

public class NPC_Merchant extends Entity{
	
	public static final String npcName = "Corvin Green";

	public NPC_Merchant(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "up";
        defaultSpeed = 1;
        speed = defaultSpeed;	
		name = npcName;
		
        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
    	homeWorldX = 54;
    	homeWorldY = 51;
    	outsideWorldX = 61;
    	outsideWorldY = 78;
    	homeMapNum = 6;
    	townNum = 1;
		
		getImage();
		setDialogue();
		setItems();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_merchant/merchant_down_" + i, 1.5f, 1.5f);
	                rightStanding[i] = setup("/npc_merchant/merchant_right_" +i, 1.5f, 1.5f);
	                backStanding[i] = setup("/npc_merchant/merchant_up_" + i, 1.5f, 1.5f);
	                frontWalking[i] = setup("/npc_merchant/merchant_movedown_" + i, 1.5f, 1.5f);
	                rightWalking[i] = setup("/npc_merchant/merchant_moveright_" + i, 1.5f, 1.5f);
	                backWalking[i] = setup("/npc_merchant/merchant_moveup_" + i, 1.5f, 1.5f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}
	         portrait = setup("/artwork/merchant_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Hey there, traveler!\nTake a look at what I’ve got.";
		dialogues[1][0] = "Take care out there!";
		dialogues[2][0] = "Eh... not enough coin, friend.\nYou’ll need more than that.";
		dialogues[3][0] = "You're carrying too much!";
		dialogues[4][0] = "You can’t sell what you're using!";
		dialogues[5][0] = "I can't trade in things like that.";
	}
	public void setItems() {
		
		inventory.add(new OBJ_Wood_Sword(gp));
		inventory.add(new OBJ_Stone_Sword(gp));
		inventory.add(new OBJ_Wood_Axe(gp));
		
		inventory.add(new OBJ_Rabbit_Shield_1(gp));
		inventory.add(new OBJ_Torch(gp));
		inventory.add(new OBJ_Fruit_Juice(gp));
		inventory.add(new OBJ_Arrow(gp));
    	inventory.add(new OBJ_Seed(gp, 0));
    	inventory.add(new OBJ_Seed(gp, 1));
    	inventory.add(new OBJ_Seed(gp, 2));
    	inventory.add(new OBJ_Seed(gp, 3));
    	inventory.add(new OBJ_Seed(gp, 4));
    	inventory.add(new OBJ_Seed(gp, 5));
    	inventory.add(new OBJ_Seed(gp, 6));
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
		
		setDialogue();
		facePlayer();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}


}
