package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.emberlight.GamePanel;
import object.OBJ_Fruit_Juice;
import object.OBJ_Rabbit_Shield_1;
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
		
		dialogues[0][0] = "Hi there!\nHave a look at my wares.";
		dialogues[1][0] = "See you soon!";
		dialogues[2][0] = "Tryna scam me?";
		dialogues[3][0] = "Your inventory is full!";
		dialogues[4][0] = "You cannot sell an equipped item!";
	}
	public void setItems() {
		
		inventory.add(new OBJ_Rabbit_Shield_1(gp));
		inventory.add(new OBJ_Fruit_Juice(gp));
		inventory.add(new OBJ_SunmireGlassroot(gp));
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
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}


}
