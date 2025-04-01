package environment;

import main.emberlight.GamePanel;

public class LightSource {
    public int x, y, radius;

    public LightSource(int tileX, int tileY, int radius, GamePanel gp) {
        this.x = tileX * gp.tileSize + gp.tileSize / 2; // Convert tile to pixel and center
        this.y = tileY * gp.tileSize + gp.tileSize / 2; // Convert tile to pixel and center
        this.radius = radius;
    }}