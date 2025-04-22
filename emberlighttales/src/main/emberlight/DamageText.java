package main.emberlight;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics2D;

public class DamageText {
    public int worldX, worldY;
    public String text;
    public float alpha = 1.0f;
    public int riseSpeed = 1;
    public int life = 60;
    public Color color;
    public float scale = 1.0f;
    public boolean isBlocked = false; 
    GamePanel gp;

    public DamageText(int worldX, int worldY, String text, Color color, GamePanel gp) {
        this.worldX = worldX;
        this.worldY = worldY - 20;
        this.text = text;
        this.color = color;
        this.gp = gp;
        
        if (text.equals("BLOCKED")) {
            this.isBlocked = true;
            this.scale = 1.5f;  // Increase size for BLOCKED text
            this.riseSpeed = 0;  // Make it stay in place a bit longer
            this.life = 60;      // Let it linger longer
        }
    }

    public boolean update() {
        if (!isBlocked) {
            worldY -= riseSpeed;
        }
        alpha -= 0.015f;
        life--;
        return life <= 0 || alpha <= 0;
    }

    public void draw(Graphics2D g2) {
	    int screenX = 0;
	    int screenY = 0;
    	
    	if(text.contains("XP")) {
    	    screenX = worldX;
    	    screenY = worldY;
    	}
    	else {
            screenX = worldX - gp.player.worldX + gp.player.screenX;
            screenY = worldY - gp.player.worldY + gp.player.screenY;
    	}

        Composite original = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, Math.max(0, alpha)));

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 14f));
        g2.setColor(color);
        g2.drawString(text, screenX, screenY);

        g2.setComposite(original);
    }
}