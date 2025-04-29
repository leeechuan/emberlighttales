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
import mob.MOB_Angel;
import mob.MOB_Angel2;
import mob.MOB_Orc_Archer;
import mob.MOB_Orc_Chief;
import mob.MOB_Orc_Grunt;
import mob.MOB_Orc_Lieutenant;
import mob.MOB_Orc_Second;
import mob.MOB_PinkSlime;
import mob.MOB_Skeleton_Mage;
import mob.MOB_Swordman;
import mob.MOB_Templar;
import object.OBJ_Bed;
import object.OBJ_Bench;
import object.OBJ_BigTorch;
import object.OBJ_Boat;
import object.OBJ_BridgeRubble;
import object.OBJ_Cauldron;
import object.OBJ_CampDeco;
import object.OBJ_CampLookoutTower;
import object.OBJ_Campfire;
import object.OBJ_CampfirePot;
import object.OBJ_Broom;
import object.OBJ_Chest;
import object.OBJ_Coin;
import object.OBJ_Desert_Bones;
import object.OBJ_DungeonDeco;
import object.OBJ_DungeonDoor;
import object.OBJ_EmberlightPearl;
import object.OBJ_FenceGate;
import object.OBJ_FieldResonator;
import object.OBJ_Fire_Pit;
import object.OBJ_Flower;
import object.OBJ_Fruit_Juice;
import object.OBJ_GoldenChest;
import object.OBJ_Grass;
import object.OBJ_GrassRock;
import object.OBJ_Haybale;
import object.OBJ_Heart;
import object.OBJ_IndoorDeco;
import object.OBJ_LampPost;
import object.OBJ_Lantern;
import object.OBJ_LilyPad;
import object.OBJ_Log;
import object.OBJ_ManaCrystal;
import object.OBJ_Palisade;
import object.OBJ_Rabbit_Shield_2;
import object.OBJ_Rabbit_Shield_3;
import object.OBJ_Rock;
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
import object.OBJ_Windmill;
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
		
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 68 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 76 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 61 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 80 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 85 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 87 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 73 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 85 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 84 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 63 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 74 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 81 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 63 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 87 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 79 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 78 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 74 * gp.tileSize;
		i++;

		
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
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 70 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 55 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 78 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 81 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 88 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 53 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 89 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
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
		
		//Outside Emberville
		gp.obj[mapNum][i] = new OBJ_Windmill(gp);
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 55 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 61 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 67 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 68 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 67 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 57 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 73 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 43 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 79 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 82 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 77 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 32 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 71 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 31 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 67 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 30 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 78 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 22 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 77 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 78 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 80 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 16 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 72 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 28 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 81 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 71 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		
		//Outside Gildenshore
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 30 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 26 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 62 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 65 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 21 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 68 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 19 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 67 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 61 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 61 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 14 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 55 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 54 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 57 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 18 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 59 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 22 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 15 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 26 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 28 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 29 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 54 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 35 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 43 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 41 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 39 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 37 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 38 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 62 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 54 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 53 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 64 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
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
		
		//Outside orc camp
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 40 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 78 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 36 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 82 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 83 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 86 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 19 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 76 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 12 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 64 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 10 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 16 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 21 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 2);
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 27 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 1);
		gp.obj[mapNum][i].worldX = 66 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 29 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Grass(gp, 0);
		gp.obj[mapNum][i].worldX = 67 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 32 * gp.tileSize;
		i++;
		
		//Bandit Camp
		
		gp.obj[mapNum][i] = new OBJ_CampfirePot(gp);
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 8);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 72 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 9);
		gp.obj[mapNum][i].worldX = 16 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 74 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 19);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 13);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 2);
		gp.obj[mapNum][i].worldX = 19 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 76 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_CampDeco(gp, 1);
		gp.obj[mapNum][i].worldX = 15 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 79 * gp.tileSize;
		i++;
		
		//Decoration
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 2);
		gp.obj[mapNum][i].worldX = 66 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 3);
		gp.obj[mapNum][i].worldX = 67 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 4);
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 0);
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 31 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 5);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 1);
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 85 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 3);
		gp.obj[mapNum][i].worldX = 36 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 90 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 4);
		gp.obj[mapNum][i].worldX = 20 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 91 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 0);
		gp.obj[mapNum][i].worldX = 93 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 5);
		gp.obj[mapNum][i].worldX = 17 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 89 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Rock(gp, 1);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 24 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_GrassRock(gp, 3);
		gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 73 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_GrassRock(gp, 4);
		gp.obj[mapNum][i].worldX = 82 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 2);
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 0);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 78 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 1);
		gp.obj[mapNum][i].worldX = 69 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 2);
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 33 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 4);
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 20 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 5);
		gp.obj[mapNum][i].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 90 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 6);
		gp.obj[mapNum][i].worldX = 23 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 92 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 7);
		gp.obj[mapNum][i].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 82 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 3);
		gp.obj[mapNum][i].worldX = 9 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 30 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_LilyPad(gp, 4);
		gp.obj[mapNum][i].worldX = 9 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 18 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_GrassRock(gp, 2);
		gp.obj[mapNum][i].worldX = 63 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 75 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_GrassRock(gp, 4);
		gp.obj[mapNum][i].worldX = 87 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 78 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_GrassRock(gp, 5);
		gp.obj[mapNum][i].worldX = 66 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 86 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 0);
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 2);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 68 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 8);
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 66 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 1);
		gp.obj[mapNum][i].worldX = 31 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 76 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 1);
		gp.obj[mapNum][i].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 77 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Log(gp, 10);
		gp.obj[mapNum][i].worldX = 79 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 3, 4);
		gp.obj[mapNum][i].worldX = 11 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 4, 2);
		gp.obj[mapNum][i].worldX = 22 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 63 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 2, 1);
		gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 1, 5);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 2, 8);
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 41 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 0, 9);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 41 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 3, 0);
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 2, 4);
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 2, 8);
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Flower(gp, 3, 4);
		gp.obj[mapNum][i].worldX = 89 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 80 * gp.tileSize;
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
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 72 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 70 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 64 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 60 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 34 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 52 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 27 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 58 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 38 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Fire_Pit(gp);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_WoodBridge(gp);
		gp.obj[mapNum][i].worldX = 74 * gp.tileSize - gp.tileSize/3;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize - gp.tileSize/3;
		i++;
		gp.obj[mapNum][i] = new OBJ_Desert_Bones(gp, 0);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 69 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Desert_Bones(gp, 1);
		gp.obj[mapNum][i].worldX = 24 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 57 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_Desert_Bones(gp, 2);
		gp.obj[mapNum][i].worldX = 77 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 56 * gp.tileSize;
		i++;
		
		//Witch home
		
		mapNum = 4;
		
		gp.obj[mapNum][i] = new OBJ_Cauldron(gp);
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Broom(gp);
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 51 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 50 * gp.tileSize;
		i++;
		
		//Witch second floor
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 23 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 9); //plant
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 18); //study table
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 2); //chair
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 23 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
		i++;
		
		
		//Mayor home
		
		mapNum = 5;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 9); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 14); //Plant
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Merchant home
		
		mapNum = 6;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 9); //plant
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		//Couple home
		
		mapNum = 7;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //Plant
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //Plant
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 16); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 14); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Punk home
		
		mapNum = 8;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 9); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 51* gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		//Gym Bro home
		
		mapNum = 9;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 43 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //Plant
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //Plant
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 11); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 13); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Scientist home
		
		mapNum = 10;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 7); //painting
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 18); //study table
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 2); //chair
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 9); //Plant
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Farmer home
		
		mapNum = 11;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //bookshelf
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //plant
		gp.obj[mapNum][i].worldX = 51* gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //Beerkeg
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		//President home
		
		mapNum = 12;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 60 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //Plant
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //Plant
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 16); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 3); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 11); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 13); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 48 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 56 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Scout home
		
		mapNum = 13;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //plant
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		//Fisherman home
		
		mapNum = 14;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //furnace
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //book shelf
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 11); //plant
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //Beerkeg
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		//Thief home
		
		mapNum = 15;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //plant
		gp.obj[mapNum][i].worldX = 49* gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //Beerkeg
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //Beerkeg
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;

		//Woodcutter home
		
		mapNum = 16;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 47 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 12); //plant
		gp.obj[mapNum][i].worldX = 48 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 47 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 10); //plant
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		//Elder home
		
		mapNum = 17;
				
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 42 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 43 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //Plant
		gp.obj[mapNum][i].worldX = 44 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //Bookshelf
		gp.obj[mapNum][i].worldX = 45 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 46 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
				
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;		
				
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;		
				
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;		
				
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 45 * gp.tileSize;
		i++;		
				
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 13); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 11); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;		

		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;		

		//Shopkeeper home
		
		mapNum = 18;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 7); //painting
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 52 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 18); //study table
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 2); //chair
		gp.obj[mapNum][i].worldX = 59 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
		i++;
		
		//Player home
		
		mapNum = 21;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 7); //painting
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 42 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_Bed(gp);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 15); //table
		gp.obj[mapNum][i].worldX = 50 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 4); //chair
		gp.obj[mapNum][i].worldX = 51 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 5); //chair
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 18); //study table
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 2); //chair
		gp.obj[mapNum][i].worldX = 57 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 8); //plant
		gp.obj[mapNum][i].worldX = 54 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 49 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 1); //BookShelf
		gp.obj[mapNum][i].worldX = 62 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 0); //beerkeg
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_IndoorDeco(gp, 6); //Furnace
		gp.obj[mapNum][i].worldX = 55 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		
		//Abandon House

		mapNum = 22;
		
		gp.obj[mapNum][i] = new OBJ_Chest(gp);
		gp.obj[mapNum][i].setLoot(new OBJ_FieldResonator(gp));
		gp.obj[mapNum][i].worldX = 58 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 44 * gp.tileSize;
		i++;
		
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 53 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 3);
		gp.obj[mapNum][i].worldX = 61 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 43 * gp.tileSize;
		i++;
		gp.obj[mapNum][i] = new OBJ_DungeonDeco(gp, 4);
		gp.obj[mapNum][i].worldX = 49 * gp.tileSize;
		gp.obj[mapNum][i].worldY = 46 * gp.tileSize;
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
			gp.npc[mapNum][i].worldX = gp.tileSize*76;
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
			gp.npc[mapNum][i].worldX = gp.tileSize*83;
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
//		
//		gp.mob[mapNum][i] = new MOB_Angel(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*28;
//		gp.mob[mapNum][i].worldY = gp.tileSize*81;
//		i++;
//
//		gp.mob[mapNum][i] = new MOB_Angel2(gp);
//		gp.mob[mapNum][i].worldX = gp.tileSize*20;
//		gp.mob[mapNum][i].worldY = gp.tileSize*80;
//		i++;
		
		if(Progress.gameStage < Progress.STAGE_ORC_SECONDINCOMMAND_DEFEATED) {
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
		
		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))) {
			gp.mob[mapNum][i] = new MOB_Swordman(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*12;
			gp.mob[mapNum][i].worldY = gp.tileSize*75;
			i++;
			
			gp.mob[mapNum][i] = new MOB_Swordman(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*16;
			gp.mob[mapNum][i].worldY = gp.tileSize*72;
			i++;

			gp.mob[mapNum][i] = new MOB_Templar(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*16;
			gp.mob[mapNum][i].worldY = gp.tileSize*73;
			i++;
			
			gp.mob[mapNum][i] = new MOB_Templar(gp);
			gp.mob[mapNum][i].worldX = gp.tileSize*17;
			gp.mob[mapNum][i].worldY = gp.tileSize*77;
			i++;
		}

		
		
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
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 53, 59, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 60, 60, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 44, 62, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 56, 66, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 55, 69, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 52, 68, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 59, 67, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 51, 70, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 54, 71, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 47, 71, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 44, 74, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 42, 71, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 42, 77, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 50, 72, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 42, 65, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 34, 72, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 31, 74, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 75, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 34, 78, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 31, 79, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 40, 81, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 28, 77, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 29, 81, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 75, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 83, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 21, 75, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 19, 80, 0);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 12, 76, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 10, 67, 3);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 16, 82, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 23, 79, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 32, 70, 0);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 26, 80, 0);
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
		
		//Gildenshore Outskirts
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 38, 60, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 30, 61, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 27, 64, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 21, 67, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 26, 68, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 23, 62, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 25, 59, 2);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 19, 61, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 15, 60, 1);
		i++;

		gp.iTile[mapNum][i] = new IT_Tree(gp, 12, 62, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 11, 60, 1);
		i++;
		

		gp.iTile[mapNum][i] = new IT_Tree(gp, 15, 55, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 12, 50, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 14, 46, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 11, 55, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 13, 52, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 17, 57, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 10, 56, 2);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 55, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 41, 56, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 39, 53, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 41, 51, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 43, 49, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 47, 51, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 46, 47, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 51, 49, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 54, 41, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 59, 54, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 54, 53, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 56, 50, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 63, 51, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 65, 45, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 62, 46, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 58, 48, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 53, 46, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 55, 44, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 59, 42, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 51, 42, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 61, 52, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 50, 45, 1);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 30, 52, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 23, 45, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 37, 46, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 27, 48, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 40, 43, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 34, 50, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 49, 36, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 44, 39, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 33, 45, 2);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 31, 49, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 24, 51, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 29, 44, 1);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 43, 1);
		i++;
		
		//Orc Camp Outskirts
		gp.iTile[mapNum][i] = new IT_Tree(gp, 67, 33, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 66, 30, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 65, 27, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 69, 39, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 64, 28, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 73, 40, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 82, 30, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 84, 25, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 70, 11, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 73, 11, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 61, 9, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 58, 10, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 65, 10, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 51, 13, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 49, 15, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 51, 17, 8);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 57, 23, 7);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 56, 21, 7);
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
		
		//Bandit Camp
		gp.iTile[mapNum][i] = new IT_Tent(gp, 11, 68, 0, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tent(gp, 15, 69, 3, 3);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tent(gp, 23, 84, 1, 3);
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
		
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 68, 72, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 63, 70, 10);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 58, 71, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 57, 67, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 62, 59, 10);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 52, 57, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 56, 53, 10);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 65, 47, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 58, 42, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 43, 40, 10);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 34, 44, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 36, 63, 10);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 30, 62, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 25, 54, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 50, 48, 10);
		i++;
		
		gp.iTile[mapNum][i] = new IT_Tree(gp, 72, 55, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 71, 51, 10);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 75, 44, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 80, 43, 9);
		i++;
		gp.iTile[mapNum][i] = new IT_Tree(gp, 83, 48, 10);
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
