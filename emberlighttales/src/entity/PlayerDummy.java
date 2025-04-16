package entity;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.emberlight.GamePanel;

public class PlayerDummy extends Entity {

	public static final String npcName = "Dummy";
	
	public PlayerDummy(GamePanel gp) {
		super(gp);
		
		name = npcName;
		getImage();
	}
    public void getImage() {
        
    	if(gp.player.isGremlin) {
    		for (int i = 0; i < 6; i++) {
    			frontStanding[i] = setup("/player_gremlin/player_gremlin_down_" + i, 1.5f, 1.5f);
    			rightStanding[i] = setup("/player_gremlin/player_gremlin_right_" +i, 1.5f, 1.5f);
    			backStanding[i] = setup("/player_gremlin/player_gremlin_up_" + i, 1.5f, 1.5f);
            	}
    	    for (int i = 0; i < 6; i++) {
    	    	leftStanding[i] = invertImage(rightStanding[i]);
          		}
    		for (int i = 0; i < 6; i++) {
    			frontWalking[i] = setup("/player_gremlin/player_gremlin_movedown_" + i, 1.5f, 1.5f);
    			rightWalking[i] = setup("/player_gremlin/player_gremlin_moveright_" +i, 1.5f, 1.5f);
    			backWalking[i] = setup("/player_gremlin/player_gremlin_moveup_" + i, 1.5f, 1.5f);
            	}
    	    for (int i = 0; i < 6; i++) {
    	    	leftWalking[i] = invertImage(rightWalking[i]);
          		}
    		for (int i = 0; i < 6; i++) {
    			frontAttacking[i] = setup("/player_gremlin/player_gremlin_attackdown_" + i, 1.5f, 1.5f);
    			rightAttacking[i] = setup("/player_gremlin/player_gremlin_attackright_" +i, 1.5f, 1.5f);
    			backAttacking[i] = setup("/player_gremlin/player_gremlin_attackup_" + i, 1.5f, 1.5f);
            	}
    	    for (int i = 0; i < 6; i++) {
    	    	leftAttacking[i] = invertImage(rightAttacking[i]);
          		}

    	}
    	else {
    		for (int i = 0; i < 6; i++) {
                frontStanding[i] = setup("/player/player_down_" + i, 1.5f, 1.5f);
                rightStanding[i] = setup("/player/player_right_" +i, 1.5f, 1.5f);
                backStanding[i] = setup("/player/player_up_" + i, 1.5f, 1.5f);
                frontWalking[i] = setup("/player/player_movedown_" + i, 1.5f, 1.5f);
                rightWalking[i] = setup("/player/player_moveright_" + i, 1.5f, 1.5f);
                backWalking[i] = setup("/player/player_moveup_" + i, 1.5f, 1.5f);
                frontShooting[i] = setup("/player/player_bowdown_" + i, 1.5f, 1.5f);
                rightShooting[i] = setup("/player/player_bowright_" + i, 1.5f, 1.5f);
                backShooting[i] = setup("/player/player_bowup_" + i, 1.5f, 1.5f);
            	}
    	     for (int i = 0; i < 6; i++) {
                leftStanding[i] = invertImage(rightStanding[i]);
                leftWalking[i] = invertImage(rightWalking[i]);
                leftShooting[i] = invertImage(rightShooting[i]);
          		}
    	}
	     
   }
}
