package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.emberlight.GamePanel;
import object.OBJ_Arrow;
import object.OBJ_CookedFish;
import object.OBJ_Fruit_Juice;
import object.OBJ_Gold_Axe;
import object.OBJ_Gold_Sword;
import object.OBJ_Lantern;
import object.OBJ_PurpleMushroom;
import object.OBJ_Rabbit_Shield_1;
import object.OBJ_Rabbit_Shield_3;
import object.OBJ_Seed;
import object.OBJ_Silver_Axe;
import object.OBJ_SunmireGlassroot;

public class NPC_Desert_Trader extends Entity{
	
	public static final String npcName = "Zayid Marruk";

	public NPC_Desert_Trader(GamePanel gp) {
		super(gp);
		
		type = type_npc;
		direction = "down";
        defaultSpeed = 0;
        speed = defaultSpeed;	
		name = npcName;
		
        solidArea = new Rectangle(0, 24, gp.tileSize * 2, gp.tileSize - 16);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        
        townNum = 0;
        
//    	homeWorldX = 50;
//    	homeWorldY = 50;
//    	outsideWorldX = 12;
//    	outsideWorldY = 39;
//    	homeMapNum = 18;
//    	townNum = 1;
		
		getImage();
		setDialogue();
		setItems();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/npc_desert_trader/desert_trader_" + i, 3f, 4.5f);
//	                rightStanding[i] = setup("/npc_shopkeeper/shopkeeper_right_" +i, 1.5f, 1.5f);
//	                backStanding[i] = setup("/npc_shopkeeper/shopkeeper_up_" + i, 1.5f, 1.5f);
//	                frontWalking[i] = setup("/npc_shopkeeper/shopkeeper_movedown_" + i, 1.5f, 1.5f);
//	                rightWalking[i] = setup("/npc_shopkeeper/shopkeeper_moveright_" + i, 1.5f, 1.5f);
//	                backWalking[i] = setup("/npc_shopkeeper/shopkeeper_moveup_" + i, 1.5f, 1.5f);
	            }
//	         for (int i = 0; i < 6; i++) {
//	                leftStanding[i] = invertImage(rightStanding[i]);
//	                leftWalking[i] = invertImage(rightWalking[i]);
//	          	}
	         portrait = setup("/artwork/desert_trader_portrait", 3f, 3f);
	}
	public void setDialogue() {
		
		dialogues[0][0] = "Step into the shade.\nBrowse with no haste.";
		dialogues[1][0] = "Winds guide your path.";
		dialogues[2][0] = "Gold is light in your pouch.\nCome richer next time.";
		dialogues[3][0] = "Your bags overflow like dunes.";
		dialogues[4][0] = "You wear it—why would I buy it?";
		dialogues[5][0] = "This... can't be sold. It's part of someone's journey";
	}
	public void setItems() {
		
		inventory.add(new OBJ_Gold_Sword(gp));
		inventory.add(new OBJ_Silver_Axe(gp));
		inventory.add(new OBJ_Gold_Axe(gp));
		inventory.add(new OBJ_Arrow(gp));
		
		inventory.add(new OBJ_Rabbit_Shield_3(gp));
		inventory.add(new OBJ_Lantern(gp));
		inventory.add(new OBJ_CookedFish(gp));
		inventory.add(new OBJ_PurpleMushroom(gp));
		inventory.add(new OBJ_SunmireGlassroot(gp));
    	inventory.add(new OBJ_Seed(gp, 15));
    	inventory.add(new OBJ_Seed(gp, 16));
    	inventory.add(new OBJ_Seed(gp, 17));
    	inventory.add(new OBJ_Seed(gp, 18));
    	inventory.add(new OBJ_Seed(gp, 19));
    	inventory.add(new OBJ_Seed(gp, 20));
    	inventory.add(new OBJ_Seed(gp, 21));
	}
//	public void setAction() {
//		
//		actionLockCounter++;
//        
//		if(actionLockCounter == 120) {
//			Random random = new Random();
//			int i = random.nextInt(100) + 1; //pick number from 1 to 100
//			
//			if(i <= 20) {
//				direction = "up";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 20 && i <= 40) {
//				direction = "down";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 40 && i <= 60) {
//				direction = "left";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 60 && i <= 80) {
//				direction = "right";
//				isWalking = true;
//				speed = defaultSpeed;
//			}
//			if(i > 80 && i <= 100) {
//				speed = 0;
//				isWalking = false;
//			}
//			
//			actionLockCounter = 0;
//		}	
//	}
	
	public void speak() {
		
//		facePlayer();
		setDialogue();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}


}
