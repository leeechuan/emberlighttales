package popup;

import java.awt.*;
import java.util.ArrayList;

import main.emberlight.GamePanel;

public class PopupManager {
    private ArrayList<Popup> popups = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
	GamePanel gp;
	private long lastPopupTime = 0;
    private static final long POPUP_COOLDOWN = 2000;
    
    public PopupManager(GamePanel gp) {
        this.gp = gp;
    }

    public void addPopup(String message) {
    	long currentTime = System.currentTimeMillis();
        if (currentTime - lastPopupTime >= POPUP_COOLDOWN) { // Check cooldown
            popups.add(new Popup(message, gp));
            gp.playSE(27);
            lastPopupTime = currentTime; // Update last popup time
        }
    }
    
    public void addNotification(String message) {
        notifications.add(new Notification(message, gp));
        gp.qManager.refreshQuestMarkers();
        gp.playSE(29);
    }

    public void update() {
        for (Popup p : popups) {
            p.update();
        }
        popups.removeIf(Popup::isExpired); // Remove expired popups
        for (Notification n : notifications) {
            n.update();
        }
        notifications.removeIf(Notification::isExpired); // Remove expired notifications
    }

    public void draw(Graphics2D g2) {
        for (Popup p : popups) {
            p.draw(g2, gp.screenWidth);
        }
        for (Notification n : notifications) {
            n.draw(g2, gp.screenWidth);
        }
    }
}