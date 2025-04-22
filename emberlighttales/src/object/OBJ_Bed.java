package object;

import java.util.Random;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Bed extends Entity{
	
	GamePanel gp;
	public static final String objName = "Bed";
	
	public OBJ_Bed(GamePanel gp) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		image1 = setup("/interior_decor/bed", 2, 1);
		
		collision = true;
		solidArea.x = 0;
		solidArea.y = 16;
		solidArea.width = 48;
		solidArea.height = 64;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
	}
	
	public void setDialogue() {
	    Random rand = new Random();

	    if (gp.currentMap == 21) {
	        String[] restMessages = {
	            "You drift into a deep slumber...\n[Progress saved]",
	            "You feel warmth wrap around you as you\nsleep...\n[Progress saved]",
	            "A quiet night passes.\nYou're refreshed and ready.\n[Progress saved]",
	            "Dreams visit you as you rest.\n[Progress saved]",
	            "You sleep peacefully until dawn.\n[Progress saved]",
	            "Your back doesn't hurt for once.\nMiracles do happen.\n[Progress saved]",
	            "You snored loud enough to scare\noff a mob.\n[Progress saved]",
	            "You drooled a bit...\nBut no one's judging.\n[Progress saved]"
	        };
	        dialogues[0][0] = restMessages[rand.nextInt(restMessages.length)];
	    } else {
	        String[] rudeMessages = {
	            "Hey! That's not your bed.\nShow some manners!",
	            "You can't just nap anywhere you like!",
	            "You feel the judgment of a thousand\nancestors. Time to move.",
	            "What are you? A gremlin?",
	            "This isn't an inn. Behave yourself!",
	            "You try to lie down, but the bed growls.\nBetter not.",
	            "You flop dramatically onto the bed.\nNothing happens.\nYou get up in shame.",
	            "You hear a distant voice...\n\"Get your own bed!\""
	        };
	        dialogues[0][0] = rudeMessages[rand.nextInt(rudeMessages.length)];
	    }
	}
	public void interact() {
		setDialogue();
		startDialogue(this, 0);
		if(gp.currentMap == 21) {
			gp.eHandler.sleep();
		}
		
	}
}
