package object;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_DungeonDoor extends Entity{
	
	GamePanel gp;
	boolean opened = false;
	public static final String objName = "Dungeon Door";
	
	public OBJ_DungeonDoor(GamePanel gp) {
		
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		frontStanding[0] = setup("/animated_object/dungeon_door_0", 1, 1);
		frontStanding[1] = setup("/animated_object/dungeon_door_1", 1, 1);
		frontStanding[2] = setup("/animated_object/dungeon_door_2", 1, 1);
		frontStanding[3] = setup("/animated_object/dungeon_door_3", 1, 1);
		frontStanding[4] = setup("/animated_object/dungeon_door_4", 1, 1);
		frontStanding[5] = setup("/animated_object/dungeon_door_5", 1, 1);
		collision = true;
		
		
	}
	
	public void interact() {
		
		gp.gameState = gp.dialogueState;
		gp.ui.currentDialogue = "The door seems locked...";
	}

}
