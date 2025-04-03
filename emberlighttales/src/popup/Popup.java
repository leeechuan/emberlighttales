package popup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.emberlight.GamePanel;

public class Popup {
	private String message;
    private int timer = 120;
    private int yPos = -40;
    private final int targetY = 40;
    private final int speed = 4;
    private boolean movingDown = true;
    private GamePanel gp;

    public Popup(String message, GamePanel gp) {
        this.message = message;
        this.gp = gp;
    }

    public void update() {
        if (movingDown) {
            if (yPos < targetY) {
                yPos += speed;
            } else {
                movingDown = false;
            }
        } else {
            timer--;
            if (timer <= 0) {
                if (yPos > -40) {
                    yPos -= speed;
                }
                if(yPos == 20) {
                	gp.playSE(28);
                }
                
            }
        }
    }

    public boolean isExpired() {
        return yPos <= -40;
    }

    public void draw(Graphics2D g2, int screenWidth) {
        // Set the font
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 13f));

        // Calculate the width of the text and add padding
        int textWidth = g2.getFontMetrics().stringWidth(message);
        int padding = 20;
        int signWidth = textWidth + (padding * 2);
        int signHeight = 50; // Fixed height for the sign

        // Calculate the x position to center the sign on the screen
        int signX = (screenWidth - signWidth) / 2;
        int signY = yPos; // yPos is updated to animate the popup

        gp.ui.drawSubWindow(signX, signY, signWidth, signHeight);

        // Calculate the position to center the text inside the sign
        int textX = signX + (signWidth - textWidth) / 2;
        // Vertically center: adjust using ascent and descent values
        int textY = signY + (signHeight + g2.getFontMetrics().getAscent() - g2.getFontMetrics().getDescent()) / 2;

        // Draw the message text
        g2.setColor(Color.WHITE);
        g2.drawString(message, textX + 2, textY + 2);
    }
}