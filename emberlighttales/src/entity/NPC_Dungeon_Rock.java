package entity;

import java.awt.Rectangle;
import java.util.ArrayList;

import main.emberlight.GamePanel;
import object.OBJ_Spike_Gate;
import tile_interactive.IT_PressurePlate;
import tile_interactive.InteractiveTile;

public class NPC_Dungeon_Rock extends Entity{
	
	public static final String npcName = "Dungeon Rock";
	
	public NPC_Dungeon_Rock(GamePanel gp) {
		super(gp);
		
		name = npcName;
		direction = "down";
		speed = 4;	
		type = type_npc;
		
//        solidArea = new Rectangle(18, 24, gp.tileSize - 16, gp.tileSize - 16);
		solidArea = new Rectangle();
		solidArea.x = gp.tileSize/4;
		solidArea.y = gp.tileSize*4/5;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = gp.tileSize/2;
        solidArea.height = gp.tileSize*3/5;
        
        dialogueSet = -1;
        
        townNum = 0;
		
		getImage();
		setDialogue();
	}
	
	public void getImage() {
		     for (int i = 0; i < 6; i++) {
	                frontStanding[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	                rightStanding[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	                backStanding[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	                frontWalking[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	                rightWalking[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	                backWalking[i] = setup("/dungeon_objects/dungeon_box", 2f, 1f);
	            }
	         for (int i = 0; i < 6; i++) {
	                leftStanding[i] = invertImage(rightStanding[i]);
	                leftWalking[i] = invertImage(rightWalking[i]);
	          	}

	}
	public void setDialogue() {
		
		dialogues[0][0] = "Hmm, I can push this...";		
	}
	public void setAction() {}
	public void update() {}
	public void speak() {
		
		facePlayer();
		startDialogue(this, dialogueSet);
		
		dialogueSet++;
		
		if(dialogues[dialogueSet][0] == null) {
			
			dialogueSet--;
		}
	}
	public void move(String d) {
		
		this.direction = d;
		
		checkCollision();
		
		if(collisionOn == false) {
			
			switch(direction) {
			case "up": worldY -= speed; break;
			case "down": worldY += speed; break;
			case "left": worldX -= speed; break;
			case "right": worldX += speed; break;
			}
		}
		
		detectPlate();
	}
	public void detectPlate() {
		ArrayList<InteractiveTile> plateList = new ArrayList<>();
		ArrayList<Entity> rockList = new ArrayList<>();
		
		//Create a plate list
		for(int i = 0; i < gp.iTile[1].length; i++) {
			
			if(gp.iTile[gp.currentMap][i] != null &&
					gp.iTile[gp.currentMap][i].name != null &&
					gp.iTile[gp.currentMap][i].name.equals(IT_PressurePlate.itName)) {
				plateList.add(gp.iTile[gp.currentMap][i]);
			}
		}
		
		//Create a rock list
		for(int i = 0; i < gp.npc[1].length; i++) {
			
			if(gp.npc[gp.currentMap][i] != null &&
					gp.npc[gp.currentMap][i].name.equals(NPC_Dungeon_Rock.npcName)) {
				rockList.add(gp.npc[gp.currentMap][i]);
			}
		}
		
		int count = 0;
		
		//Scan the plate list
		for(int i = 0; i < plateList.size(); i++) {
			int xDistance = Math.abs(worldX - plateList.get(i).worldX);
			int yDistance = Math.abs(worldY - plateList.get(i).worldY);
			int distance = Math.max(xDistance, yDistance);
			
			if(distance < 20) {
				if(linkedEntity == null) {
					linkedEntity = plateList.get(i);
					plateList.get(i).activated = true;  // Activate the pressure plate
					gp.playSE(16);
				}
			}
			else {
				if(linkedEntity == plateList.get(i)) {
					linkedEntity = null;
					plateList.get(i).activated = false; // Deactivate the pressure plate
				}
			}
		}
		
		//Scan the rock list
		for(int i = 0; i < rockList.size(); i++) {
			
			//Count the rock on the plate
			if(rockList.get(i).linkedEntity != null) {
				count++;
			}
			
		}
		
		//If all the rocks are on the plates, the iron door opens

			
		for(int i = 0; i < gp.obj[1].length; i++) {
				
			if(gp.obj[gp.currentMap][i] != null && gp.obj[gp.currentMap][i].name.equals(OBJ_Spike_Gate.objName)) {
					
		       OBJ_Spike_Gate gate = (OBJ_Spike_Gate) gp.obj[gp.currentMap][i];
		       
		           if(count == rockList.size()) {
		            gate.gate_open_state = true;
		            gp.playSE(18);
		           } else {
		            gate.gate_open_state = false;
		           }
		           
		        if (soundCooldown == 0) {
		        	gp.playSE(17);
		        	soundCooldown = soundDelay; // Reset cooldown	
		        }
				// Reduce the cooldown timer
				if (soundCooldown > 0) {
				    soundCooldown--;
				}
			}
		}
		
	}
	
}
