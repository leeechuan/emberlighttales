package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Well extends Entity{
	
	GamePanel gp;
	public static final String objName = "Well";
	
	public OBJ_Well(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;

			image1 = setup("/decoration/well", 3 , 2);
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize*4/5;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize*3/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;

	}
	public void setLoot() {
		this.loot = new OBJ_WaterBucket(gp);
		
		setDialogue();
	}
    public void setDialogue() {
    	
		dialogues[0][0] = "You cannot carry any more items!";
		dialogues[1][0] = "You scooped a bucket of water.";
		dialogues[2][0] = "It's empty.";
    }
	public void interact() {
		setLoot();
	    if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 0) {
            giveLoot();
	    }
	}

	private void giveLoot() {
		
		if (gp.player.canObtainItem(loot) == false) {
			startDialogue(this, 0);
		} else {
			startDialogue(this, 1);
			
		    if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
					gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
					gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 0) {
				gp.qManager.progressQuest("To Do List");
				gp.pManager.addNotification("Journal Updated");
			}
		}
	}
}

