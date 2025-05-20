package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_BridgeRubble extends Entity{
	
	GamePanel gp;
	public static final String objName = "Bridge Rubble";
	
	public OBJ_BridgeRubble(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		image1 = setup("/decoration/bridge_rubble", 6 , 6);
		solidArea.x = -gp.tileSize;
		solidArea.y = 0;
		solidArea.width = gp.tileSize*4;
		solidArea.height = gp.tileSize*4;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		collision = true;

	}
    public void setDialogue() {
    	if(gp.player.isGremlin) {
    		dialogues[0][0] = "(You stand before the rubble. Eyes glowing,\nclaws twitching, body humming with\ngremlin energy.)";
    	}
    	else {
    		dialogues[0][0] = "It’s too heavy... I could push for hours\nand this thing wouldn’t budge an inch.";
    	}
		
    }
	public void interact() {
		setDialogue();
		startDialogue(this, 0);
		
		if(gp.player.isGremlin) {
			gp.qManager.progressQuest("Bound By Blood And Magic");
			Progress.gameStage = Progress.STAGE_BRIDGE_RUBBLE_REMOVED;
			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Bound By Blood And Magic"));
			gp.player.finishQuest(15, 50);
		}
	}
	
	public void update() {
		if (Progress.gameStage > Progress.STAGE_SERUM_GIVEN) {
			collision = false;
			solidArea.width = 0;
			solidArea.height = 0;
			image1 = null;
		}
	}
	
	public void draw(Graphics2D g2) {
		

		int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Optimization for rendering on screen - 7 tileSize buffer
        if (worldX + 8*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 8*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 8*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 8*gp.tileSize < gp.player.worldY + gp.player.screenY) {
		
        	g2.drawImage(image1, screenX - (gp.tileSize * 2), screenY - (gp.tileSize * 2), null);
        }
        
        if(gp.keyH.showDebugText) {
        	//Debug: Entity Collision
	        g2.setColor(Color.red);
	        g2.setStroke(new BasicStroke(1));
	        g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);	
	        g2.setStroke(new BasicStroke());
        }
	}
}
