package popup;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.emberlight.GamePanel;

public class AutoSaveIndicator {
    private GamePanel gp;
    private BufferedImage[] frames = new BufferedImage[16];
    private int currentFrame = 0;
    private int frameDelay = 4; // Change to control animation speed
    private int frameCounter = 0;
    private boolean active = false;
    private int duration = 120; // Duration the autosave icon appears (in frames)
    private int timer = 0;

    public AutoSaveIndicator(GamePanel gp) {
        this.gp = gp;
        try {
            for (int i = 0; i < 16; i++) {
                frames[i] = ImageIO.read(getClass().getResourceAsStream("/ui/loading_" + i + ".png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        active = true;
        timer = duration;
        currentFrame = 0;
        frameCounter = 0;
    }

    public void update() {
        if (active) {
            frameCounter++;
            if (frameCounter >= frameDelay) {
                frameCounter = 0;
                currentFrame = (currentFrame + 1) % frames.length;
            }
            timer--;
            if (timer <= 0) {
                active = false;
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (!active) return;

        int scale = 2;
        int size = 16 * scale;
        int padding = 12;

        int x = gp.screenWidth - size - padding;
        int y = gp.screenHeight - gp.tileSize*2 - size - padding;

        // Draw the spinner
        g2.drawImage(frames[currentFrame], x, y, size, size, null);

        // Draw words
        String text = "Saving Progress";
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 12f));
        g2.setColor(Color.WHITE);

        int textWidth = g2.getFontMetrics().stringWidth(text);
        int textX = x - textWidth - 8; // 8px gap between text and icon
        int textY = y + size - 8;      // align vertically with the icon

        g2.drawString(text, textX, textY);
    }

    public boolean isActive() {
        return active;
    }
}