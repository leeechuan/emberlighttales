package entity;

import java.awt.Rectangle;
import java.util.Random;

import main.emberlight.GamePanel;
import object.OBJ_Fruit_Juice;
import object.OBJ_Rabbit_Shield_1;

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
		
		dialogues[0][0] = "Hi there!\nHave a look at my wares.";
		dialogues[1][0] = "See you soon!";
		dialogues[2][0] = "Tryna scam me?";
		dialogues[3][0] = "Your inventory is full!";
		dialogues[4][0] = "You cannot sell an equipped item!";
	}
	public void setItems() {
		
		inventory.add(new OBJ_Rabbit_Shield_1(gp));
		inventory.add(new OBJ_Fruit_Juice(gp));
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
	
	public void speak() {
		
		facePlayer();
		gp.gameState = gp.tradeState;
		gp.ui.npc = this;
	}
	

}
