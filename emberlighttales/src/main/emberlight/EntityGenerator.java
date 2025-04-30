package main.emberlight;

import entity.Entity;
import object.OBJ_Arrow;
import object.OBJ_Bed;
import object.OBJ_Bench;
import object.OBJ_BigTorch;
import object.OBJ_Boat;
import object.OBJ_BridgeRubble;
import object.OBJ_Cauldron;
import object.OBJ_Campfire;
import object.OBJ_CampfirePot;
import object.OBJ_Broom;
import object.OBJ_CampDeco;
import object.OBJ_CampLookoutTower;
import object.OBJ_Chest;
import object.OBJ_Coin;
import object.OBJ_Desert_Bones;
import object.OBJ_DungeonChest;
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
import object.OBJ_Rabbit_Shield_1;
import object.OBJ_Rabbit_Shield_2;
import object.OBJ_Rabbit_Shield_3;
import object.OBJ_Rock;
import object.OBJ_Scarecrow;
import object.OBJ_Sewer;
import object.OBJ_Sign;
import object.OBJ_Skeleton_Mage_Projectile;
import object.OBJ_SmallTorch;
import object.OBJ_Smoke;
import object.OBJ_Spike_Gate;
import object.OBJ_Stone_Axe;
import object.OBJ_Stone_Sword;
import object.OBJ_SunmireGlassroot;
import object.OBJ_Torch;
import object.OBJ_Waterfall;
import object.OBJ_Well;
import object.OBJ_Windmill;
import object.OBJ_WoodBridge;
import object.OBJ_DungeonWoodBridge;

public class EntityGenerator {
	
	GamePanel gp;
	
	public EntityGenerator(GamePanel gp) {
		this.gp = gp;
	}
	public Entity getObject(String itemName) {
		
		Entity obj = null;
		switch(itemName) {
		case OBJ_Arrow.objName: obj = new OBJ_Arrow(gp); break;
		case OBJ_Bed.objName: obj = new OBJ_Bed(gp); break;
		case OBJ_Bench.objName: obj = new OBJ_Bench(gp, 0); break;
		case OBJ_BigTorch.objName: obj = new OBJ_BigTorch(gp); break;
		case OBJ_Boat.objName: obj = new OBJ_Boat(gp); break;
		case OBJ_BridgeRubble.objName: obj = new OBJ_BridgeRubble(gp); break;
		case OBJ_Broom.objName: obj = new OBJ_Broom(gp); break;
		case OBJ_CampDeco.objName: obj = new OBJ_CampDeco(gp, 0); break;
		case OBJ_Campfire.objName: obj = new OBJ_Campfire(gp); break;
		case OBJ_CampfirePot.objName: obj = new OBJ_CampfirePot(gp); break;
		case OBJ_CampLookoutTower.objName: obj = new OBJ_CampLookoutTower(gp, 0); break;
		case OBJ_Cauldron.objName: obj = new OBJ_Cauldron(gp); break;
		case OBJ_Chest.objName: obj = new OBJ_Chest(gp); break;
		case OBJ_Coin.objName: obj = new OBJ_Coin(gp); break;
		case OBJ_Desert_Bones.objName: obj = new OBJ_Desert_Bones(gp, 0); break;
		case OBJ_DungeonChest.objName: obj = new OBJ_DungeonChest(gp); break;
		case OBJ_DungeonDeco.objName: obj = new OBJ_DungeonDeco(gp, 0); break;
		case OBJ_DungeonDoor.objName: obj = new OBJ_DungeonDoor(gp); break;
		case OBJ_DungeonWoodBridge.objName: obj = new OBJ_DungeonWoodBridge(gp, false); break;
		case OBJ_EmberlightPearl.objName: obj = new OBJ_EmberlightPearl(gp); break;
		case OBJ_FenceGate.objName: obj = new OBJ_FenceGate(gp, false); break;
		case OBJ_FieldResonator.objName: obj = new OBJ_FieldResonator(gp); break;
		case OBJ_Fire_Pit.objName: obj = new OBJ_Fire_Pit(gp); break;
		case OBJ_Flower.objName: obj = new OBJ_Flower(gp, 0, 0); break;
		case OBJ_Fruit_Juice.objName: obj = new OBJ_Fruit_Juice(gp); break;
		case OBJ_GoldenChest.objName: obj = new OBJ_GoldenChest(gp); break;
		case OBJ_Grass.objName: obj = new OBJ_Grass(gp, 0); break;
		case OBJ_GrassRock.objName: obj = new OBJ_GrassRock(gp, 0); break;
		case OBJ_Haybale.objName: obj = new OBJ_Haybale(gp, 0); break;
		case OBJ_Heart.objName: obj = new OBJ_Heart(gp); break;
		case OBJ_IndoorDeco.objName: obj = new OBJ_IndoorDeco(gp, 0); break;
		case OBJ_LampPost.objName: obj = new OBJ_LampPost(gp, 0, 0); break;
		case OBJ_Lantern.objName: obj = new OBJ_Lantern(gp); break;
		case OBJ_LilyPad.objName: obj = new OBJ_LilyPad(gp, 0); break;
		case OBJ_Log.objName: obj = new OBJ_Log(gp, 0); break;
		case OBJ_ManaCrystal.objName: obj = new OBJ_ManaCrystal(gp); break;
		case OBJ_Rabbit_Shield_1.objName: obj = new OBJ_Rabbit_Shield_1(gp); break;
		case OBJ_Rabbit_Shield_2.objName: obj = new OBJ_Rabbit_Shield_2(gp); break;
		case OBJ_Rabbit_Shield_3.objName: obj = new OBJ_Rabbit_Shield_3(gp); break;
		case OBJ_Rock.objName: obj = new OBJ_Rock(gp, 0); break;
		case OBJ_Scarecrow.objName: obj = new OBJ_Scarecrow(gp); break;
		case OBJ_Sewer.objName: obj = new OBJ_Sewer(gp); break;
		case OBJ_Sign.objName: obj = new OBJ_Sign(gp, 0); break;
		case OBJ_Skeleton_Mage_Projectile.objName: obj = new OBJ_Skeleton_Mage_Projectile(gp); break;
		case OBJ_SmallTorch.objName: obj = new OBJ_SmallTorch(gp); break;
		case OBJ_Smoke.objName: obj = new OBJ_Smoke(gp); break;
		case OBJ_Spike_Gate.objName: obj = new OBJ_Spike_Gate(gp); break;
		case OBJ_Stone_Axe.objName: obj = new OBJ_Stone_Axe(gp); break;
		case OBJ_Stone_Sword.objName: obj = new OBJ_Stone_Sword(gp); break;
		case OBJ_SunmireGlassroot.objName: obj = new OBJ_SunmireGlassroot(gp); break;
		case OBJ_Torch.objName: obj = new OBJ_Torch(gp); break;
		case OBJ_Waterfall.objName: obj = new OBJ_Waterfall(gp); break;
		case OBJ_Well.objName: obj = new OBJ_Well(gp); break;
		case OBJ_Windmill.objName: obj = new OBJ_Windmill(gp); break;
		case OBJ_WoodBridge.objName: obj = new OBJ_WoodBridge(gp); break;
		
		
		}
		return obj;
	}

}
