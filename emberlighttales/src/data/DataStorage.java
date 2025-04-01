package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import quest.Quest;

public class DataStorage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//PLAYER STATS
	int level;
	int maxLife;
	int life;
	int maxMana;
	int mana;
	int strength;
	int dexterity;
	int exp;
	int nextLevelExp;
	int coin;
	
	//PLAYER INVENTORY
	ArrayList<String> itemNames = new ArrayList<>();
	ArrayList<Integer> itemAmounts = new ArrayList<>();
	int currentWeaponSlot;
	int currentShieldSlot;
	
	//OBJECT ON MAP
	String mapObjectNames[][];
	int mapObjectWorldX[][];
	int mapObjectWorldY[][];
	String mapObjectLootNames[][];
	boolean mapObjectOpened[][];
	
    // GAME STAGE
    int gameStage;
    
    // GAME STAGE
    public ArrayList<String> activeQuestNames = new ArrayList<>();
    public ArrayList<Integer> activeQuestProgress = new ArrayList<>();
    public ArrayList<String> completedQuestNames = new ArrayList<>();
}
