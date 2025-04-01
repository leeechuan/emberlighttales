package main.emberlight;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.*;

public class Main {
	
	public static JFrame window;

	public static void main(String[] args) {
		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Emberlight Tales");
        new Main().setIcon();
//		window.setLocationRelativeTo(null);
		
		
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        gamePanel.config.loadConfig();
        if(gamePanel.fullScreenOn == true) {
            window.setUndecorated(true);
        }
        
        window.pack();
        
        // Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int windowX = (screenSize.width - window.getWidth()) / 2;
        int windowY = (screenSize.height - window.getHeight()) / 2;
        window.setLocation(windowX, windowY);
        
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
		
		
	}
	public void setIcon() {
		
		URL imageURL = getClass().getClassLoader().getResource("animated_object/big_torch_4.png");
		if (imageURL != null) {
		    ImageIcon icon = new ImageIcon(imageURL);
		    window.setIconImage(icon.getImage());
		} else {
		    System.out.println("Error: Icon image not found!");
		}
	}
	
	
}
