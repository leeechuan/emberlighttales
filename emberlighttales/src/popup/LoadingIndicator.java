package popup;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.emberlight.GamePanel;

public class LoadingIndicator {
    private boolean active = false;
    private int currentFrame = 0;
    private int frameDelay = 5; // Frames per animation cycle
    private int frameCounter = 0;
    private GamePanel gp;
    private Image[] frames = new Image[16];

    public LoadingIndicator(GamePanel gp) {
        this.gp = gp;
        loadFrames();
    }

    private void loadFrames() {
        try {
            for (int i = 0; i < 16; i++) {
                frames[i] = ImageIO.read(getClass().getResourceAsStream("/ui/loading_" + i + ".png"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void update() {
        if (active) {
            frameCounter++;
            if (frameCounter >= frameDelay) {
                currentFrame = (currentFrame + 1) % 16;  // Loop through frames
                frameCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (active) {
            int scale = 2;
            int frameSize = 16 * scale;
            int x = 12;
            int y = 12;

            // Draw the loading spinner only
            g2.drawImage(frames[currentFrame], x, y, frameSize, frameSize, null);
        }
    }
}