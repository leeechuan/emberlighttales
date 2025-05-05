package object;

import java.util.Random;

import entity.Entity;
import main.emberlight.GamePanel;

public class OBJ_CoinPouch extends Entity {
	
	GamePanel gp;
	public static final String objName = "Coin Pouch";
	private final Random rand = new Random();

	public OBJ_CoinPouch(GamePanel gp, int pouch_type) {
		super(gp);
		this.gp = gp;
		type = type_consumable;
		name = objName;
		stackable = true;
		
		if (pouch_type == 6) {
			pouch_type = getRandomPouchType(); // Randomize the type based on chance
		}

		switch (pouch_type) {
			case 1 -> { // Tiny
				name = "Tiny Pouch";
				image1 = setup("/objects/tiny_pouch", 1, 1);
				value = getRandomValue(5, 12);
			}
			case 2 -> { // Small
				name = "Small Pouch";
				image1 = setup("/objects/small_pouch", 1, 1);
				value = getRandomValue(13, 25);
			}
			case 3 -> { // Medium
				name = "Medium Pouch";
				image1 = setup("/objects/medium_pouch", 1, 1);
				value = getRandomValue(26, 45);
			}
			case 4 -> { // Large
				name = "Large Pouch";
				image1 = setup("/objects/large_pouch", 1, 1);
				value = getRandomValue(46, 75);
			}
			case 5 -> { // Extra Large
				name = "Extra Large Pouch";
				image1 = setup("/objects/extralarge_pouch", 1, 1);
				value = getRandomValue(76, 120);
			}
			default -> {
				name = "Unknown Pouch";
				image1 = setup("/objects/tiny_pouch", 1, 1);
				value = 1;
			}
		}
		description = "[" + name + "]" + "\nA pouch jingling\nwith coins.";
	}

	private int getRandomValue(int min, int max) {
		return rand.nextInt(max - min + 1) + min;
	}

	public void setDialogue() {
		dialogues[0][0] = "You opened the pouch! \nYou earned " + value + " coins!";
	}

	public boolean use(Entity entity) {
		setDialogue();
		startDialogue(this, 0);
		gp.playSE(38);
		gp.player.coin += value;
		return true;
	}
	
	private int getRandomPouchType() {
		int roll = rand.nextInt(100) + 1; // 1–100

		if (roll <= 40) return 1;       // 40% chance - Tiny
		else if (roll <= 70) return 2;  // 30% chance - Small
		else if (roll <= 85) return 3;  // 15% chance - Medium
		else if (roll <= 95) return 4;  // 10% chance - Large
		else return 5;                  // 5% chance - Extra Large
	}
}
