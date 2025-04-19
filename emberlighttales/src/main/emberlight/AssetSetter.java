package main.emberlight;

import data.Progress;
import entity.NPC_Husband;
import entity.NPC_Bee;
import entity.NPC_Chicken1;
import entity.NPC_Chicken2;
import entity.NPC_Chicken3;
import entity.NPC_Desert_Trader;
import entity.NPC_Dungeon_Rock;
import entity.NPC_Elder;
import entity.NPC_Farmer;
import entity.NPC_FirstLady;
import entity.NPC_Fisherman;
import entity.NPC_Guard;
import entity.NPC_GymBro;
import entity.NPC_Wife;
import entity.NPC_Mayor;
import entity.NPC_Merchant;
import entity.NPC_President;
import entity.NPC_Punk;
import entity.NPC_Scientist;
import entity.NPC_Scout;
import entity.NPC_Shopkeeper;
import entity.NPC_Son;
import entity.NPC_Thief;
import entity.NPC_Witch;
import entity.NPC_Woodcutter;
import mob.MOB_Orc_Archer;
import mob.MOB_Orc_Chief;
import mob.MOB_Orc_Grunt;
import mob.MOB_Orc_Lieutenant;
import mob.MOB_Orc_Second;
import mob.MOB_PinkSlime;
import mob.MOB_Skeleton_Mage;
import object.OBJ_Bed;
import object.OBJ_Bench;
import object.OBJ_BigTorch;
import object.OBJ_Boat;
import object.OBJ_BridgeRubble;
import object.OBJ_Broom;
import object.OBJ_CampDeco;
import object.OBJ_CampLookoutTower;
import object.OBJ_Campfire;
import object.OBJ_CampfirePot;
import object.OBJ_Cauldron;
import object.OBJ_Chest;
import object.OBJ_Coin;
import object.OBJ_DungeonDeco;
import object.OBJ_DungeonDoor;
import object.OBJ_EmberlightPearl;
import object.OBJ_FenceGate;
import object.OBJ_Flower;
import object.OBJ_Fruit_Juice;
import object.OBJ_GoldenChest;
import object.OBJ_Haybale;
import object.OBJ_Heart;
import object.OBJ_LampPost;
import object.OBJ_Lantern;
import object.OBJ_ManaCrystal;
import object.OBJ_Palisade;
import object.OBJ_Rabbit_Shield_2;
import object.OBJ_Rabbit_Shield_3;
import object.OBJ_Scarecrow;
import object.OBJ_Sewer;
import object.OBJ_Sign;
import object.OBJ_SmallTorch;
import object.OBJ_Spike_Gate;
import object.OBJ_Stone_Axe;
import object.OBJ_Stone_Sword;
import object.OBJ_Torch;
import object.OBJ_Waterfall;
import object.OBJ_Well;
import object.OBJ_WoodBridge;
import object.OBJ_DungeonWoodBridge;
import tile_interactive.IT_Abandon_House_1;
import tile_interactive.IT_Barn;
import tile_interactive.IT_Beehive;
import tile_interactive.IT_BossTent;
import tile_interactive.IT_CaveEntrance;
import tile_interactive.IT_ChickenCoop;
import tile_interactive.IT_DesertHouse;
import tile_interactive.IT_DungeonTintWindows;
import tile_interactive.IT_Fountain;
import tile_interactive.IT_Horse_Stable_1;
import tile_interactive.IT_House;
import tile_interactive.IT_Planter;
import tile_interactive.IT_PressurePlate;
import tile_interactive.IT_Tree;
import tile_interactive.IT_Spike;
import tile_interactive.IT_Tent;
import tile_interactive.IT_Witch_Hut;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {

		int mapNum = 0;
		int i = 0;
		
		//DEV AREA
//		gp.obj[mapNum][i] = new OBJ_GoldenChest(gp);
//		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 15 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Stone_Axe(gp);
//		gp.obj[mapNum][i].worldX = 21 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Rabbit_Shield_2(gp);
//		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Rabbit_Shield_3(gp);
//		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Fruit_Juice(gp);
//		gp.obj[mapNum][i].worldX = 25 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Coin(gp);
//		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Coin(gp);
//		gp.obj[mapNum][i].worldX = 30 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Heart(gp);
//		gp.obj[mapNum][i].worldX = 33 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_ManaCrystal(gp);
//		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_DungeonDoor(gp);
//		gp.obj[mapNum][i].worldX = 36 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Lantern(gp);
//		gp.obj[mapNum][i].worldX = 36 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 20 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Torch(gp);
//		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 20 * gp.tileSize;
//		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Waterfall(gp); //Waterfall
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Waterfall(gp); //Waterfall
		gp.obj[mapNum][i].worldX = 65 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Sign(gp, 0); //Sign
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		
		//SOUTH COAST

		gp.obj[mapNum][i] = new OBJ_Campfire(gp);
		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 86 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_BigTorch(gp);
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 53 * gp.tileSize;
		i++;
		
		//Emberville
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 2);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 3);
		gp.obj[mapNum][i].worldX = 77 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 62 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 3);
		gp.obj[mapNum][i].worldX = 82 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 76 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 2);
		gp.obj[mapNum][i].worldX = 64 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 74 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 2);
		gp.obj[mapNum][i].worldX = 84 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 1);
		gp.obj[mapNum][i].worldX = 88 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 72 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 1);
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Scarecrow(gp);
		gp.obj[mapNum][i].worldX = 89 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 77 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_BridgeRubble(gp);
		gp.obj[mapNum][i].worldX = 64 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 62 * gp.tileSize - gp.tileSize/3;
		i++;
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_Fruit_Juice(gp));
		gp.obj[mapNum][i].worldX = 89 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
//		gp.obj[mapNum][i] = new OBJ_Broom(gp);
//		gp.obj[mapNum][i].worldX = 84 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
//		i++;
//		gp.obj[mapNum][i] = new OBJ_Cauldron(gp);
//		gp.obj[mapNum][i].worldX = 80 * gp.tileSize;
//		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
//		i++;
		
		//Emberville Farm
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 1);
		gp.obj[mapNum][i].worldX = 86 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 2);
		gp.obj[mapNum][i].worldX = 82 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bench(gp, 1);
		gp.obj[mapNum][i].worldX = 82 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 0, 4);
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 2, 8);
		gp.obj[mapNum][i].worldX = 68 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 61 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Well(gp);
		gp.obj[mapNum][i].worldX = 70 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Haybale(gp, 0);
		gp.obj[mapNum][i].worldX = 77 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 78 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Haybale(gp, 1);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 77 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_FenceGate(gp, false);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 79 * gp.tileSize;
		i++;
		
		//GildenShore
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 5);
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 31 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 6);
		gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 6);
		gp.obj[mapNum][i].worldX = 21 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 36 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 6);
		gp.obj[mapNum][i].worldX = 21 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 36 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 2, 4);
		gp.obj[mapNum][i].worldX = 38 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 5);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 26 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LampPost(gp, 1, 4);
		gp.obj[mapNum][i].worldX = 25 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Bench(gp, 1);
		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 21 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Boat(gp);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 26 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_WoodBridge(gp);
		gp.obj[mapNum][i].worldX = 12 * gp.tileSize - gp.tileSize/3;
		gp.obj[mapNum][i].worldY = 26 * gp.tileSize - gp.tileSize/3;
		i++;
		
		//Orc Camp
		gp.obj[mapNum][i] = new OBJ_Palisade(gp);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 29 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampfirePot(gp);
		gp.obj[mapNum][i].worldX = 79 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 34 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampfirePot(gp);
		gp.obj[mapNum][i].worldX = 64 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 13);
		gp.obj[mapNum][i].worldX = 63 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 14);
		gp.obj[mapNum][i].worldX = 65 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 16);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 11);
		gp.obj[mapNum][i].worldX = 63 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 14 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 12);
		gp.obj[mapNum][i].worldX = 65 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 13 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 79 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 23 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 5);
		gp.obj[mapNum][i].worldX = 79 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 25 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 7);
		gp.obj[mapNum][i].worldX = 78 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 10);
		gp.obj[mapNum][i].worldX = 71 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 32 * gp.tileSize;
		i++;		
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 71 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 34 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 76 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 35 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 2);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_Fruit_Juice(gp));
		gp.obj[mapNum][i].worldX = 83 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 19 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_Fruit_Juice(gp));
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 13 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampLookoutTower(gp, 0);
		gp.obj[mapNum][i].worldX = 71 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 28 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampLookoutTower(gp, 7);
		gp.obj[mapNum][i].worldX = 81 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 28 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampLookoutTower(gp, 3);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampLookoutTower(gp, 2);
		gp.obj[mapNum][i].worldX = 83 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 15 * gp.tileSize;
		i++;
		
		//Dungeon
		mapNum = 2;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 7);
		gp.obj[mapNum][i].worldX = 16 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 13 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 7);
		gp.obj[mapNum][i].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 38 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 13);
		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 17);
		gp.obj[mapNum][i].worldX = 31 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 18);
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 19 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 7);
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 8);
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 18);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 0);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 66 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 29 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 73 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 20);
		gp.obj[mapNum][i].worldX = 70 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 28 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 6);
		gp.obj[mapNum][i].worldX = 73 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 29 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 66 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 65 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 18);
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 68 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 79 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 82 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 8);
		gp.obj[mapNum][i].worldX = 70 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 86 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 12);
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 0);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 87 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 14);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 86 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 21);
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 82 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Spike_Gate(gp);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonWoodBridge(gp, false);
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Sewer(gp);
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 23 * gp.tileSize;
		i++;
		
		//Boss Dungeon
		mapNum = 3;
		
		gp.obj[mapNum][i] = new OBJ_EmberlightPearl(gp);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 34 * gp.tileSize;
		i++;
		
		
		//Solara
		
		mapNum = 19;
		
		gp.obj[mapNum][i] = new OBJ_Boat(gp);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_WoodBridge(gp);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize - gp.tileSize/3;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize - gp.tileSize/3;
		i++;
		
	}
	
	public void setNPC() {
		
		int mapNum = 0;
		int i = 0;
		
		//Emberville
		if (!npcExists(NPC_Guard.npcName)) {
			gp.npc[mapNum][i] = new NPC_Guard(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*68;
			gp.npc[mapNum][i].worldY = gp.tileSize*62;
			i++;
		}
		if (!npcExists(NPC_Husband.npcName)) {
			gp.npc[mapNum][i] = new NPC_Husband(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*80;
			gp.npc[mapNum][i].worldY = gp.tileSize*65;
			i++;
		}
		if (!npcExists(NPC_Wife.npcName)) {
			gp.npc[mapNum][i] = new NPC_Wife(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*85;
			gp.npc[mapNum][i].worldY = gp.tileSize*65;
			i++;
		}

//		gp.npc[mapNum][i] = new NPC_Son(gp);
//		gp.npc[mapNum][i].worldX = gp.tileSize*62;
//		gp.npc[mapNum][i].worldY = gp.tileSize*87;
//		i++;
		
		if (!npcExists(NPC_Punk.npcName)) {
			gp.npc[mapNum][i] = new NPC_Punk(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*84;
			gp.npc[mapNum][i].worldY = gp.tileSize*67;
			i++;
		}

		if (!npcExists(NPC_GymBro.npcName)) {
			gp.npc[mapNum][i] = new NPC_GymBro(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*84;
			gp.npc[mapNum][i].worldY = gp.tileSize*65;
			i++;
		}

		if (!npcExists(NPC_Farmer.npcName)) {
			gp.npc[mapNum][i] = new NPC_Farmer(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*70;
			gp.npc[mapNum][i].worldY = gp.tileSize*68;
			i++;
		}
		
		if (!npcExists(NPC_Mayor.npcName)) {
			gp.npc[mapNum][i] = new NPC_Mayor(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*77;
			gp.npc[mapNum][i].worldY = gp.tileSize*66;
			i++;
		}

		if (!npcExists(NPC_Scientist.npcName)) {
			gp.npc[mapNum][i] = new NPC_Scientist(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*82;
			gp.npc[mapNum][i].worldY = gp.tileSize*65;
			i++;
		}
		
		if (!npcExists(NPC_Witch.npcName)) {
			gp.npc[mapNum][i] = new NPC_Witch(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*89;
			gp.npc[mapNum][i].worldY = gp.tileSize*76;
			i++;
		}

		if (!npcExists(NPC_Merchant.npcName)) {
			gp.npc[mapNum][i] = new NPC_Merchant(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*89;
			gp.npc[mapNum][i].worldY = gp.tileSize*69;
			i++;
		}

		if (!npcExists(NPC_Bee.npcName)) {
			gp.npc[mapNum][i] = new NPC_Bee(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*75;
			gp.npc[mapNum][i].worldY = gp.tileSize*47;
			i++;
		}

		if (!npcExists(NPC_Chicken1.npcName)) {
			gp.npc[mapNum][i] = new NPC_Chicken1(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*89;
			gp.npc[mapNum][i].worldY = gp.tileSize*67;
			i++;
		}
		if (!npcExists(NPC_Chicken2.npcName)) {
			gp.npc[mapNum][i] = new NPC_Chicken2(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*64;
			gp.npc[mapNum][i].worldY = gp.tileSize*76;
			i++;
		}
		if (!npcExists(NPC_Chicken3.npcName)) {
			gp.npc[mapNum][i] = new NPC_Chicken3(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*73;
			gp.npc[mapNum][i].worldY = gp.tileSize*54;
			i++;
		}

		
		//Gildenshore
		if (!npcExists(NPC_President.npcName)) {
			gp.npc[mapNum][i] = new NPC_President(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*37;
			gp.npc[mapNum][i].worldY = gp.tileSize*14;
			i++;
		}
		
		if (!npcExists(NPC_FirstLady.npcName)) {
			gp.npc[mapNum][i] = new NPC_FirstLady(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*35;
			gp.npc[mapNum][i].worldY = gp.tileSize*15;
			i++;
		}

		if (!npcExists(NPC_Scout.npcName)) {
			gp.npc[mapNum][i] = new NPC_Scout(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*31;
			gp.npc[mapNum][i].worldY = gp.tileSize*17;
			i++;
		}
		
		if (!npcExists(NPC_Fisherman.npcName)) {
			gp.npc[mapNum][i] = new NPC_Fisherman(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*20;
			gp.npc[mapNum][i].worldY = gp.tileSize*25;
			i++;
		}

		if (!npcExists(NPC_Thief.npcName)) {
			gp.npc[mapNum][i] = new NPC_Thief(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*21;
			gp.npc[mapNum][i].worldY = gp.tileSize*34;
			i++;
		}

		if (!npcExists(NPC_Woodcutter.npcName)) {
			gp.npc[mapNum][i] = new NPC_Woodcutter(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*35;
			gp.npc[mapNum][i].worldY = gp.tileSize*34;
			i++;
		}
		
		if (!npcExists(NPC_Elder.npcName)) {
			gp.npc[mapNum][i] = new NPC_Elder(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*46;
			gp.npc[mapNum][i].worldY = gp.tileSize*30;
			i++;
		}

		if (!npcExists(NPC_Shopkeeper.npcName)) {
			gp.npc[mapNum][i] = new NPC_Shopkeeper(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*12;
			gp.npc[mapNum][i].worldY = gp.tileSize*40;
			i++;
		}

		
		//Orc Camp
		
		
		mapNum = 1;
		i = 0;

		
		//Dungeon
		mapNum = 2;
		i = 0;
		gp.npc[mapNum][i] = new NPC_Dungeon_Rock(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize*33;
		gp.npc[mapNum][i].worldY = gp.tileSize*39;
		i++;
		
		gp.npc[mapNum][i] = new NPC_Dungeon_Rock(gp);
		gp.npc[mapNum][i].worldX = gp.tileSize*74;
		gp.npc[mapNum][i].worldY = gp.tileSize*32;
		i++;
		
		//Solara
		mapNum = 19;
		i = 0;
		
		if (!npcExists(NPC_Desert_Trader.npcName)) {
			gp.npc[mapNum][i] = new NPC_Desert_Trader(gp);
			gp.npc[mapNum][i].worldX = gp.tileSize*42;
			gp.npc[mapNum][i].worldY = gp.tileSize*56;
			i++;
		}
				
	}
	
	public void setMobs() {
		
		int mapNum = 0;
		int i = 0;
		
		gp.mob[mapNum][i] = new MOB_Orc_Archer(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*45;
		gp.mob[mapNum][i].worldY = gp.tileSize*56;
		i++;
		
		gp.mob[mapNum][i] = new MOB_Orc_Grunt(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*49;
		gp.mob[mapNum][i].worldY = gp.tileSize*56;
		i++;
		
//		gp.mob[mapNum][i] = new MOB_PinkSlime(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*31;
//		gp.mob[mapNum][i].worldY = gp.tileSize*21;
//		i++;
//		gp.mob[mapNum][i] = new MOB_PinkSlime(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*33;
//		gp.mob[mapNum][i].worldY = gp.tileSize*23;
//		i++;
//		gp.mob[mapNum][i] = new MOB_PinkSlime(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*33;
//		gp.mob[mapNum][i].worldY = gp.tileSize*24;
//		i++;
//		gp.mob[mapNum][i] = new MOB_PinkSlime(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*33;
//		gp.mob[mapNum][i].worldY = gp.tileSize*25;
//		i++;
//		gp.mob[mapNum][i] = new MOB_Skeleton_Mage(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*16;
//		gp.mob[mapNum][i].worldY = gp.tileSize*28;
//		i++;
		
		if(Progress.gameStage < Progress.STAGE_ORC_SECONDINCOMMAND_DEFEATED) {
			System.out.println(Progress.gameStage);
			gp.mob[mapNum][i] = new MOB_Orc_Second(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*63;
			gp.mob[mapNum][i].worldY = gp.tileSize*16;
			i++;
		}
		
		gp.mob[mapNum][i] = new MOB_Orc_Grunt(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*79;
		gp.mob[mapNum][i].worldY = gp.tileSize*19;
		i++;
		
		gp.mob[mapNum][i] = new MOB_Orc_Archer(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*73;
		gp.mob[mapNum][i].worldY = gp.tileSize*27;
		i++;
		
		gp.mob[mapNum][i] = new MOB_Orc_Grunt(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*67;
		gp.mob[mapNum][i].worldY = gp.tileSize*15;
		i++;

		gp.mob[mapNum][i] = new MOB_Orc_Grunt(gp);
		gp.mob[mapNum][i].worldX = gp.tileSize*75;
		gp.mob[mapNum][i].worldY = gp.tileSize*38;
		i++;
		
		
		//Dungeon
		mapNum = 2;
		i = 0;
		
		if(Progress.gameStage < Progress.STAGE_ORC_LIEUTENANT_DEFEATED) {
			gp.mob[mapNum][i] = new MOB_Orc_Lieutenant(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*59;
			gp.mob[mapNum][i].worldY = gp.tileSize*87;
			i++;
		}

		
		
		
		//Boss Dungeon
		mapNum = 3;
		i = 0;
		
		if(Progress.gameStage < Progress.STAGE_ORC_CHIEF_DEFEATED) {
			gp.mob[mapNum][i] = new MOB_Orc_Chief(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*50;
			gp.mob[mapNum][i].worldY = gp.tileSize*46;
			i++;
		}

	}
	public void setInteractiveTile() {
		
		int mapNum = 0;
		int i = 0;
		

		

		
		//Emberville Deco
		gp.iTile[mapNum][i] = new IT_Tree(gp, 65, 80, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 63, 85, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 57, 82, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 55, 88, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 64, 74, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 71, 66, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 77, 61, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 76, 84, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 74, 86, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 82, 86, 5);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 81, 74, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 85, 67, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 83, 64, 5);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 88, 65, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 78, 51, 4);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 88, 54, 4);
		i++;
		
		//Emberville Houses
		gp.iTile[mapNum][i] = new IT_House(gp, 70, 74, 2, 4); //Player Home
		i++;
		gp.iTile[mapNum][i] = new IT_Planter(gp, 74, 74, 0, 3); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 83, 72, 1, 5); //Small House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 57, 78, 4, 2); //Medium House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 83, 60, 3, 2); //Big House top
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 67, 86, 2, 5); //Big House bottom
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 50, 83, 2, 4); //Big House bottom
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 70, 52, 2, 2); //Big House farm
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 86, 50, 1, 2); //Small House farm
		i++;
		
		gp.iTile[mapNum][i] = new IT_Barn(gp, 80, 44);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Fountain(gp, 79, 68);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Horse_Stable_1(gp, 71, 60);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Witch_Hut(gp, 82, 83);
		i++;
		
		gp.iTile[mapNum][i] = new IT_ChickenCoop(gp, 77, 46);
		i++;
		gp.iTile[mapNum][i] = new IT_Beehive(gp, 74, 46, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Beehive(gp, 75, 46, 0);
		i++;
		
		//Emberville Outskirts
		gp.iTile[mapNum][i] = new IT_Abandon_House_1(gp, 23, 76);
		i++;
		
		gp.iTile[mapNum][i] = new IT_CaveEntrance(gp, 47, 53);
		i++;
		
		//Gildenshore Houses
		gp.iTile[mapNum][i] = new IT_House(gp, 11, 38, 2, 1); //Big House bottom
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 20, 32, 1, 4); //Small House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 31, 33, 4, 7); //Medium Yellow House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 43, 29, 3, 4); //Big House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 16, 24, 4, 8); //Medium Yellow House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 28, 16, 4, 7); //Medium Yellow House
		i++;
		
		gp.iTile[mapNum][i] = new IT_House(gp, 35, 11, 2, 4); //Big House Top
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 22, 36, 0, 3); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 32, 36, 0, 3); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 42, 31, 0, 3); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 17, 27, 0, 4); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 31, 19, 2, 0); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 22, 24, 3, 0); //Planter
		i++;
		
		gp.iTile[mapNum][i] = new IT_Planter(gp, 16, 38, 3, 2); //Planter
		i++;
		
		//Orc Camp
		gp.iTile[mapNum][i] = new IT_Tent(gp, 69, 17, 0, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tent(gp, 75, 17, 3, 1);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tent(gp, 63, 21, 4, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tent(gp, 67, 23, 4, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_BossTent(gp, 56, 15);
		i++;
		
		
		//Dungeon
		mapNum = 2;
		
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 26, 25, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 27, 25, 1);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 28, 25, 5);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 29, 25, 2);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 30, 25, 2);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 31, 25, 6);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 32, 25, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DungeonTintWindows(gp, 33, 25, 4);
		i++;
		
		gp.iTile[mapNum][i] = new IT_PressurePlate(gp, 37, 20);
		i++;
		
		gp.iTile[mapNum][i] = new IT_PressurePlate(gp, 68, 30);
		i++;
		
//		gp.iTile[mapNum][i] = new IT_Spike(gp, 45, 34);
//		i++;
		
		gp.iTile[mapNum][i] = new IT_Spike(gp, 45, 35);
		i++;
		
		//Solara
		mapNum = 19;
		
		gp.iTile[mapNum][i] = new IT_DesertHouse(gp, 27, 57, 2, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DesertHouse(gp, 59, 48, 1, 2);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DesertHouse(gp, 50, 39, 3, 1);
		i++;
		
		gp.iTile[mapNum][i] = new IT_DesertHouse(gp, 36, 42, 0, 2);
		i++;
		
	}
	
	public boolean npcExists(String name) {
	    for (int m = 0; m < gp.npc.length; m++) {
	        for (int i = 0; i < gp.npc[m].length; i++) {
	            if (gp.npc[m][i] != null && gp.npc[m][i].name.equals(name)) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
}
