package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Fruit;
import object.OBJ_PlantedCrop;
import object.OBJ_Seed;
import quest.Quest;

public class SaveLoad {

	GamePanel gp;
	
	public SaveLoad(GamePanel gp) {
		this.gp = gp;
	}
	public void save() {
		
		gp.pManager.showAutoSave();
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
			
			DataStorage ds = new DataStorage();
			
			//PLAYER STATS
			ds.level = gp.player.level;
			ds.maxLife = gp.player.maxLife;
			ds.life = gp.player.life;
			ds.maxMana = gp.player.maxMana;
			ds.mana = gp.player.mana;
			ds.strength = gp.player.strength;
			ds.dexterity = gp.player.dexterity;
			ds.exp = gp.player.exp;
			ds.nextLevelExp = gp.player.nextLevelExp;
			ds.coin = gp.player.coin;
			
	        // Save Game Progress
	        ds.gameStage = Progress.gameStage;
	        
	        // Save quest journal
	        for (Quest quest : gp.qManager.getQuestJournal().getActiveQuests()) {
	            ds.activeQuestNames.add(quest.getName());
	            ds.activeQuestProgress.add(quest.getCurrentStageIndex()); // You might want to add a getter for currentStageIndex
	        }
	        for (Quest quest : gp.qManager.getQuestJournal().getCompletedQuests()) {
	            ds.completedQuestNames.add(quest.getName());
	        }
	        System.out.println("Active Quests: " + ds.activeQuestNames);
	        System.out.println("Active QuestProgress: " + ds.activeQuestProgress);
            System.out.println("Completed Quests: " + ds.completedQuestNames);
			
           // PLAYER INVENTORY
           for(int i = 0; i < gp.player.inventory.size(); i++) {
                Entity item = gp.player.inventory.get(i);
                ds.itemNames.add(item.name);
                ds.itemAmounts.add(item.amount);
                ds.itemDurabilities.add(item.durability);

                // Save cropId if the item is a seed or fruit
                if (item instanceof OBJ_Seed) {
                    ds.itemCropIds.add(((OBJ_Seed) item).getCropId());
                } else if (item instanceof OBJ_Fruit) {
                    ds.itemCropIds.add(((OBJ_Fruit) item).getCropId());
                } else {
                    ds.itemCropIds.add(-1);
                }

            }
			//PLAYER EQUIPMENT
			ds.currentWeaponSlot = gp.player.getCurrentWeaponSlot();
			ds.currentShieldSlot = gp.player.getCurrentShieldSlot();
			
			//OBJECTS ON MAP
			ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
			ds.mapObjectWorldX = new int[gp.maxMap][gp.obj[1].length];
			ds.mapObjectWorldY = new int[gp.maxMap][gp.obj[1].length];
			ds.mapObjectLootNames = new String[gp.maxMap][gp.obj[1].length];
			ds.mapObjectOpened = new boolean[gp.maxMap][gp.obj[1].length];
			
			for(int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
				
				for(int i = 0; i < gp.obj[1].length; i++) {
					
					if(gp.obj[mapNum][i] == null) {
						ds.mapObjectNames[mapNum][i] = "NA";
					}
					else {
						ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
						ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
						ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
						if(gp.obj[mapNum][i].loot != null) {
							ds.mapObjectLootNames[mapNum][i] = gp.obj[mapNum][i].loot.name;
						}
						ds.mapObjectOpened[mapNum][i] = gp.obj[mapNum][i].opened;
					}
				}
			}
			
			//PLANTED CROPS
			// Save planted crops
			for (Entity e : gp.plantedCrops) {
			    if (e instanceof OBJ_PlantedCrop crop) {
			        ds.plantedCropIds.add(crop.getCropId());
			        ds.plantedCropWorldX.add(crop.worldX);
			        ds.plantedCropWorldY.add(crop.worldY);
			        ds.plantedCropGrowthStages.add(crop.getGrowthStage());
			        ds.plantedCropGrowthTicks.add(crop.getGrowthTicks());
			    }
			}

			//Write the DataStorage object
			oos.writeObject(ds);
		}
		catch(Exception e) {
			System.out.println("Save Exception");
			e.printStackTrace();
		}

		
	}
	public void load() {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
			
			//Read the DataStorage object
			DataStorage ds = (DataStorage)ois.readObject();
			
			gp.player.level = ds.level;
			gp.player.maxLife = ds.maxLife;
			gp.player.life = ds.life;
			gp.player.maxMana = ds.maxMana;
			gp.player.mana = ds.mana;
			gp.player.strength = ds.strength;
			gp.player.dexterity = ds.dexterity;
			gp.player.exp = ds.exp;
			gp.player.nextLevelExp = ds.nextLevelExp;
			gp.player.coin = ds.coin;
			
	        // Load Game Progress
	        Progress.gameStage = ds.gameStage;
	        
	     // Initialize Quests
	        gp.qManager.initializeQuests();
	        System.out.println("Quests Initialized");

	        // Update quest states
	        for (int i = 0; i < ds.activeQuestNames.size(); i++) {
	            String questName = ds.activeQuestNames.get(i);
	            int progress = ds.activeQuestProgress.get(i);
	            Quest quest = gp.qManager.getQuestJournal().getQuestByName(questName);
	            if (quest == null) {
	                System.out.println("ERROR: Quest '" + questName + "' is NOT found in the quest journal!");
	            } else {
	                System.out.println("Found quest: " + questName);
	            }
	            if (quest != null) {
	                System.out.println("Loading quest: " + questName + " (Current Stage: " + quest.getCurrentStageIndex() + ", Saved Progress: " + progress + ")");
	                
	                gp.qManager.getQuestJournal().addQuest(quest);
	                // Advance quest if needed
	                while (quest.getCurrentStageIndex() < progress) {
	                    quest.advanceStage();
	                    System.out.println("Advancing quest: " + questName + " to stage " + quest.getCurrentStageIndex());
	                }
	            } else {
	                System.out.println("Error: Quest '" + questName + "' not found in quest journal!");
	            }
	        }

	        // Load completed quests
	        for (String questName : ds.completedQuestNames) {
	            Quest quest = gp.qManager.getQuestJournal().getQuestByName(questName);
                if (quest != null) {
                    gp.qManager.getQuestJournal().addQuest(quest);
                }

	            if (quest != null && !quest.isCompleted()) {
	                while (!quest.isCompleted()) {
	                    quest.advanceStage();
	                }
	                System.out.println("Marking quest as completed: " + questName);
	            } else {
	                System.out.println("Error: Completed quest '" + questName + "' not found in quest journal!");
	            }
	        }

	        // Print final quest state
	        System.out.println("Final Active Quests: " + gp.qManager.getQuestJournal().getActiveQuests());
	        System.out.println("Final Completed Quests: " + gp.qManager.getQuestJournal().getCompletedQuests());
	        
	        //Refresh Quest Markers
	        gp.qManager.refreshQuestMarkers();
	        
			//PLAYER INVENTORY
	        gp.player.inventory.clear();
	        for (int i = 0; i < ds.itemNames.size(); i++) {
	            String itemName = ds.itemNames.get(i);
	            int amount = ds.itemAmounts.get(i);
	            int durability = ds.itemDurabilities.get(i);
	            Entity item = null;

	            try {
	                if ("Seed".equals(itemName)) {
	                    if (i < ds.itemCropIds.size()) {
	                        int cropId = ds.itemCropIds.get(i);
	                        item = new OBJ_Seed(gp, cropId);
	                    } else {
	                        System.out.println("Warning: Missing crop ID for Seed at index " + i);
	                        continue;
	                    }
	                } else if ("Fruit".equals(itemName)) {
	                    if (i < ds.itemCropIds.size()) {
	                        int cropId = ds.itemCropIds.get(i);
	                        item = new OBJ_Fruit(gp, cropId);
	                    } else {
	                        System.out.println("Warning: Missing crop ID for Fruit at index " + i);
	                        continue;
	                    }
	                } else {
	                    item = gp.eGenerator.getObject(itemName);
	                }

	                if (item != null) {
	                    item.amount = amount;
	                    item.durability = durability;
	                    gp.player.inventory.add(item);
	                }

	            } catch (Exception e) {
	                System.out.println("Error loading item '" + itemName + "' at index " + i);
	                e.printStackTrace();
	            }
	        }
			//PLAYER EQUIPMENT
			gp.player.currentWeapon = gp.player.inventory.get(ds.currentWeaponSlot);
			gp.player.currentShield = gp.player.inventory.get(ds.currentShieldSlot);
			gp.player.getAttack();
			gp.player.getDefense();
			gp.player.getAttackImage();
			gp.player.getGuardImages();

			// OBJECTS ON MAP
			try {
			    for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
			        for (int i = 0; i < gp.obj[1].length; i++) {

			            if (ds.mapObjectNames[mapNum][i].equals("NA")) {
			                gp.obj[mapNum][i] = null;  // No object
			                
			            } else {
			                // Object is already initialized; just update its properties
			                if (gp.obj[mapNum][i] != null) {
			                	
			                    // Load properties like position and loot from the save data
			                    gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
			                    gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];

			                    // Load loot if applicable
			                    if (ds.mapObjectLootNames[mapNum][i] != null) {
			                        gp.obj[mapNum][i].setLoot(gp.eGenerator.getObject(ds.mapObjectLootNames[mapNum][i]));
			                    }

			                    // Check if object has been opened (e.g., chest)
			                    gp.obj[mapNum][i].opened = ds.mapObjectOpened[mapNum][i];

			                    // If object is opened, update its image/animation
			                    if (gp.obj[mapNum][i].opened) {
			                        try {
			                            gp.obj[mapNum][i].frontStanding[1] = gp.obj[mapNum][i].frontStanding[5];
			                        } catch (Exception e) {
			                            System.out.println("Error loading object image at map " + mapNum + " index " + i);
			                            e.printStackTrace();
			                        }
			                    }
			                }
			            }
			        }
			    }
			    System.out.println("Loaded Objects on Map");
			} catch (Exception e) {
			    System.out.println("Error loading objects on map");
			    e.printStackTrace();
			}
			
			
			//PLANTED CROPS
			
			gp.plantedCrops.clear();

			for (int i = 0; i < ds.plantedCropIds.size(); i++) {
			    int cropId = ds.plantedCropIds.get(i);
			    int worldX = ds.plantedCropWorldX.get(i);
			    int worldY = ds.plantedCropWorldY.get(i);
			    
			    int stage = ds.plantedCropGrowthStages.get(i);
			    int ticks = ds.plantedCropGrowthTicks.get(i);

			    OBJ_PlantedCrop crop = new OBJ_PlantedCrop(worldX / gp.tileSize, worldY / gp.tileSize, cropId, gp);
			    crop.setGrowthStage(stage);
			    crop.setGrowthTicks(ticks);
			    gp.plantedCrops.add(crop);
			}

		}
		catch(Exception e) {
			System.out.println("Load Exception");
			e.printStackTrace();
		}
	}
}