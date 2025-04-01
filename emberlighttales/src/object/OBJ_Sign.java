package object;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_Sign extends Entity{
	
	GamePanel gp;
	public static final String objName = "Sign";
	
	public OBJ_Sign(GamePanel gp, int signType) {
		super(gp);
		this.gp = gp;
		
		type = type_obstacle;
		name = objName;
		
		collision = true;
		solidArea.x = (int) (gp.tileSize * 1);
		solidArea.y = (int) (gp.tileSize * 0.5);
		solidArea.width = (int) (gp.tileSize * 0.4);
		solidArea.height = (int) (gp.tileSize * 0.5);
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		
		image1 = setup("/objects/sign_" + signType, 3 , 2);
	}
    public void setDialogue() {
		dialogues[0][0] = "Welcome to Emberville!";
    }
	public void interact() {
		setDialogue();
		startDialogue(this, 0);
	}
}
