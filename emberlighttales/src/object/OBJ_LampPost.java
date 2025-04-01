package object;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_LampPost extends Entity{
	
	GamePanel gp;
    private BufferedImage[] animatedFrames = new BufferedImage[6];
    private int animatedCounter = 0;
	public static final String objName = "Lamp Post";
    public int lamppost_size;
    public int lamppost_type;
	
	public OBJ_LampPost(GamePanel gp, int lamppost_size, int lamppost_type) {
		
		super(gp);
		this.gp = gp;
		
        this.lamppost_size = lamppost_size;
        this.lamppost_type = lamppost_type;
		
		type = type_obstacle;
		name = objName;
		
		if(lamppost_size == 1) {
			for (int i = 0; i < animatedFrames.length; i++) {
		        animatedFrames[i] = setup("/animated_object/lamppost_" + lamppost_size + "_" + lamppost_type + "_" + i, 3, 1);
		    }
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize*4/5;
			solidArea.width = gp.tileSize*1/5;
			solidArea.height = gp.tileSize*7/5;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
			
			
			
		}
		else if (lamppost_size == 2) {
			for (int i = 0; i < animatedFrames.length; i++) {
		        animatedFrames[i] = setup("/animated_object/lamppost_" + lamppost_size + "_" + lamppost_type + "_" + i, 3, 2);
		    }
			solidArea.x = gp.tileSize*2/5;
			solidArea.y = gp.tileSize;
			solidArea.width = gp.tileSize*4/5;
			solidArea.height = gp.tileSize;
			solidAreaDefaultX = solidArea.x;
			solidAreaDefaultY = solidArea.y;
			collision = true;
		}

		

		
		
	}
	public void update() {
		animatedCounter++;
        
        if (animatedCounter > 10) { // Adjust speed of animation
            spriteNum = (spriteNum + 1) % animatedFrames.length;
            animatedCounter = 0;
        }
    }
	public void draw(Graphics2D g2) {
		
		BufferedImage image = null;
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Optimization for rendering on screen - 5 tileSize buffer
        if (worldX + 5*gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - 5*gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + 5*gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - 5*gp.tileSize < gp.player.worldY + gp.player.screenY) {
        	
        	
        	image = animatedFrames[spriteNum];
            
            g2.drawImage(image, screenX, screenY, null);       	
    
            if(gp.keyH.showDebugText) {
            	//Debug: Entity Collision
            	g2.setColor(Color.red);
            	g2.setStroke(new BasicStroke(1));
            	g2.drawRect(screenX + solidArea.x, screenY + solidArea.y, solidArea.width, solidArea.height);	
            	g2.setStroke(new BasicStroke());
            }

        }
	}
	
	
}
