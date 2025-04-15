package tile_interactive;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import data.Progress;
import main.emberlight.GamePanel;

public class IT_BossTent extends InteractiveTile{

	GamePanel gp;
	
	public IT_BossTent(GamePanel gp, int col, int row) {
		super(gp, col, row);
		this.gp = gp;
		


		this.worldX = gp.tileSize * col;
		this.worldY = gp.tileSize * row;
		solidArea.x = (int) (gp.tileSize * 0.75);
		solidArea.y = -gp.tileSize * 2;
		solidArea.width = (int) (gp.tileSize * 3.5);
		solidArea.height = (int) (gp.tileSize * 2.5);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		tileHeight = 4;
		tileWidth = 5;
		
		if(Progress.gameStage >= Progress.STAGE_DISABLED_FORCE_FIELD) {
			image1 = setup("/camp_object/tent_1_2", tileHeight + 2, tileWidth);
		}
		else {
			image1 = setup("/camp_object/tent_1_4", tileHeight + 2, tileWidth);
		}

	}
//    public void setDialogue() {
//    	if(Progress.gameStage < Progress.STAGE_DISABLED_FORCE_FIELD) {
//    		dialogues[0][0] = "(There is a werid energy stopping you from entering.)";
//    	}
//		
//    }
//	public void interact() {
//		setDialogue();
//		startDialogue(this, 0);
//		
////		if(gp.player.isGremlin) {
////			gp.pManager.addNotification("Quest Completed!");
////			gp.qManager.progressQuest("Bound By Blood And Magic");
////			gp.qManager.getQuestJournal().completeQuest(gp.qManager.getQuestJournal().getQuestByName("Bound By Blood And Magic"));
////			Progress.gameStage = Progress.STAGE_BRIDGE_RUBBLE_REMOVED;
////		}
//	}
	
	public void update() {
		if(Progress.gameStage < Progress.STAGE_DISABLED_FORCE_FIELD) {
			image1 = setup("/camp_object/tent_1_4", tileHeight + 2, tileWidth);
		}
		else {
			image1 = setup("/camp_object/tent_1_2", tileHeight + 2, tileWidth);
		}

	}
	
}
