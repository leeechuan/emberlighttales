package popup;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import main.emberlight.GamePanel;

public class PopupManager {
    private ArrayList<Popup> popups = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private AutoSaveIndicator autoSaveIndicator;
    private LoadingIndicator loadingIndicator;
	GamePanel gp;
	private long lastPopupTime = 0;
    private static final long POPUP_COOLDOWN = 2000;
    
    public PopupManager(GamePanel gp) {
        this.gp = gp;
        autoSaveIndicator = new AutoSaveIndicator(gp);
        loadingIndicator = new LoadingIndicator(gp);

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

    public void showAutoSave() {
        autoSaveIndicator.show();
    }
    public void setLoadingActive(boolean isActive) {
        loadingIndicator.setActive(isActive);
    }
    
    public void update() {
        // Update popups and notifications
        Iterator<Popup> popupIterator = popups.iterator();
        while (popupIterator.hasNext()) {
            Popup p = popupIterator.next();
            p.update();
            if (p.isExpired()) {
                popupIterator.remove();  // Safe removal
            }
        }

        Iterator<Notification> notificationIterator = notifications.iterator();
        while (notificationIterator.hasNext()) {
            Notification n = notificationIterator.next();
            n.update();
            if (n.isExpired()) {
                notificationIterator.remove();  // Safe removal
            }
        }
        
        autoSaveIndicator.update();
        loadingIndicator.update();
    }

    public void draw(Graphics2D g2) {
        for (Popup p : popups) {
            p.draw(g2, gp.screenWidth);
        }
        for (Notification n : notifications) {
            n.draw(g2, gp.screenWidth);
        }
        autoSaveIndicator.draw(g2);
        loadingIndicator.draw(g2);
    }
}