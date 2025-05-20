package quest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import data.Progress;
import entity.Entity;
import main.emberlight.GamePanel;
import object.OBJ_Suspicious_Juice;

public class QuestManager {
    private QuestJournal questJournal;
    private GamePanel gp;

    public QuestManager(GamePanel gp) {
        this.gp = gp;
        this.questJournal = new QuestJournal();
    }

    public void initializeQuests() {
    	// Main Quest
    	Quest mainQuest1 = new Quest(
    	    "Bound By Blood And Magic",
    	    "The village Witch has said that\nshe has something for me.\nI should meet her.",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Talk to village witch from 8pm - 4am"),
    	        new QuestStage("Transform into a gremlin"),
    	        new QuestStage("Use gremlin form to clean up bridge")
    	    ),
            gp
    	);
    	Quest mainQuest2 = new Quest(
    	    "Beneath Enemy Lines",
    	    "The guard has spotted some orc\nactivity in a nearby cave.",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Investigate nearby cave"),
    	        new QuestStage("Explore cave"),
    	        new QuestStage("Defeat Orc Lieutenant")
    	    ),
            gp
    	);
    	Quest mainQuest3 = new Quest(
    	    "Sands of Peril",
    	    "Found some important information\nabout the orc's upcoming attack,\nwe need to inform Gildenshore!",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Find some important information about the\norc chief's upcoming attack"),
    	        new QuestStage("Make way to Gildenshore to warn about\nthe attack"),
    	        new QuestStage("Help the politician ask Emberville Mayor\nfor resources"),
//    	        new QuestStage("Help out with 3 quests around Emberville"),
    	        new QuestStage("Tell politician that Emberville will send\nresources"),
    	        new QuestStage("Speak to scout who will point direction\nto next orc camp")
    	    ),
            gp
    	);
    	Quest mainQuest4 = new Quest(
    	    "Second's Fall",
    	    "Gildenshore's scout has told me\nabout a nearby orc camp.",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Go to orc camp east of Gildenshore"),
    	        new QuestStage("Defeat orc chief second in command")
    	    ),
            gp
    	);
    	Quest mainQuest5 = new Quest(
    	    "Fissures in the Shield",
    	    "The Orc Chief is protected by a\nMagical Shield. Perhaps the witch\nwould have an idea.",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Speak with the witch on how to break through\nthe magical shield."),
    	        new QuestStage("Travel to Solara to obtain ingredients."),
    	        new QuestStage("Report back to the witch")
    	    ),
            gp
    	);
    	Quest mainQuest6 = new Quest(
    	    "The Price of War",
    	    "The time has come to face\nthe orc chief.",
    	    true,
    	    Arrays.asList(
    	        new QuestStage("Investigate Chief's Tent"),
    	        new QuestStage("Defeat orc chief or walk away"),
    	        new QuestStage("Retrieve emberlight pearl or walk away")
    	    ),
            gp
    	);

    	// Side Quest
    	Quest sideQuest1 = new Quest(
    	    "The Suspicious Merchant",
    	    "Vex claims he makes the tastiest\nfruit juice in town. I should\ntry them.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Purchase juice from the Vex."),
    	        new QuestStage("Drink suspicious juice"),
    	        new QuestStage("Survive"),
    	        new QuestStage("Exit the barn"),
    	        new QuestStage("Confront Vex")
    	    ),
            gp
    	);
    	Quest sideQuest2 = new Quest(
    	    "Cluck and Dagger",
    	    "Farmer Tiller has lost his\nchickens after the orc\nattack. Help him chase them down.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Gather first chicken"),
    	        new QuestStage("Gather second chicken"),
    	        new QuestStage("Gather last chicken"),
    	        new QuestStage("Report back to the farmer")
    	    ),
            gp
    	);
    	Quest sideQuest3 = new Quest(
    	    "Critical Malfunction",
    	    "The village scientist lost a\npiece of vital equipment during\nthe orc raid. Help retrieve it\nfrom an abandoned house.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Find equipment in abandoned house"),
    	        new QuestStage("Report back to the scientist")
    	    ),
            gp
    	);

    	Quest sideQuest4 = new Quest(
    	    "No Rest for the Wicked",
    	    "The gym bro can't do his daily\nruns along the south beach trail\ndue to a bandit camp. Help clear\nthe way so he can get back\nto training.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Investigate the trail near South Beach."),
    	        new QuestStage("Return gym bro when camp is cleared")
    	    ),
            gp
    	);

    	Quest sideQuest5 = new Quest(
    		    "Where’s Wibby?",
    		    "A worried father in Gildenshore\npleads for help. Perhaps I\nshould look outside the village.",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Search the cave for any clues."),
    		        new QuestStage("Speak to Wibby"),
    		        new QuestStage("Return to Elder Veldor")
    		    ),
    		    gp
    	);
    	Quest sideQuest6 = new Quest(
    		    "Stolen Style",
    		    "Luca claims Cain from Gildenshore\nstole his favorite jacket. Find\nthe thief and settle the\nfashion feud.",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Confront the Thief in Gildenshore"),
    		        new QuestStage("Go to Emberville mines"),
    		        new QuestStage("Search for the jacket"),
    		        new QuestStage("Return jacket to Luca")
    		    ),
    		    gp
    	);
    	Quest sideQuest7 = new Quest(
    		    "Seeds of Solace",
    		    "The herbalist in Solara seeks\na single vibrant sunflower for\na calming remedy, but none grow\nin the region.",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Obtain sunflower seed from Gildenshore"),
    		        new QuestStage("Plant the sunflower seed in a fertile area"),
    		        new QuestStage("Bring the harvested sunflower to the herbalist")
    		    ),
    		    gp
    		);
    	Quest sideQuest8 = new Quest(
    		    "To Do List",
    		    "Nessa from Emberville needs help\nrunning errands.",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Fetch water from the well"),
    		        new QuestStage("Bring water back to Nessa"),
    		        new QuestStage("Buy 10 corn seeds from the Crovin"),
    		        new QuestStage("Bring corn seeds to Nessa")
    		    ),
    		    gp
    	);
    	Quest sideQuest9 = new Quest(
    		    "Dust and Glory",
    		    "The Pharaoh of Solara seeks your\nstrength to defeat an Ancient\nGuardian that stirs within the\ntemple sands.",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Enter the ancient desert temple."),
    		        new QuestStage("Defeat the Ancient Guardian."),
    		        new QuestStage("Return to the Pharaoh.")
    		    ),
    		    gp
    	);
    	
    	
    	gp.qManager.getQuestJournal().initQuest(mainQuest1);
    	gp.qManager.getQuestJournal().initQuest(mainQuest2);
    	gp.qManager.getQuestJournal().initQuest(mainQuest3);
    	gp.qManager.getQuestJournal().initQuest(mainQuest4);
    	gp.qManager.getQuestJournal().initQuest(mainQuest5);
    	gp.qManager.getQuestJournal().initQuest(mainQuest6);
    	gp.qManager.getQuestJournal().initQuest(sideQuest1);
    	gp.qManager.getQuestJournal().initQuest(sideQuest2);
    	gp.qManager.getQuestJournal().initQuest(sideQuest3);
    	gp.qManager.getQuestJournal().initQuest(sideQuest4);
    	gp.qManager.getQuestJournal().initQuest(sideQuest5);
    	gp.qManager.getQuestJournal().initQuest(sideQuest6);
    	gp.qManager.getQuestJournal().initQuest(sideQuest7);
    	gp.qManager.getQuestJournal().initQuest(sideQuest8);
    	gp.qManager.getQuestJournal().initQuest(sideQuest9);
    }

    public void progressQuest(String questName) {
        for (Quest quest : questJournal.getActiveQuests()) {
            if (quest.getName().equals(questName)) {
                quest.advanceStage();
                if (quest.isCompleted()) {
                    questJournal.completeQuest(quest);
                }
                return;
            }
        }
    }

    public QuestJournal getQuestJournal() {
        return questJournal;
    }
    
    public void refreshQuestMarkers() {
    	
    	Entity herbalist = gp.findNPCByName("Tala Nireh");
    	if (herbalist != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
    				!gp.player.isGremlin) {
    			herbalist.questMarker = herbalist.questMarker_newQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Seeds of Solace"))&&
    				gp.player.searchItemInInventory("Sunflower") != 999 &&
    				!gp.player.isGremlin) {
    			herbalist.questMarker = herbalist.questMarker_activeQuest;
    		}
    	    else {
    	    	herbalist.questMarker = herbalist.questMarker_none;
    	    }
    	}
    	
    	Entity pharaoh = gp.findNPCByName("Pharaoh Ahmuron");
    	if (pharaoh != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
    				!gp.player.isGremlin) {
    			pharaoh.questMarker = pharaoh.questMarker_newQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Dust and Glory"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Dust and Glory").getCurrentStageIndex() == 2 &&
    				!gp.player.isGremlin) {
    			pharaoh.questMarker = pharaoh.questMarker_activeQuest;
    		}
    	    else {
    	    	pharaoh.questMarker = pharaoh.questMarker_none;
    	    }
    	}
    	
    	Entity elder = gp.findNPCByName("Elder Veldor");
    	if (elder != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				!gp.player.isGremlin) {
    			elder.questMarker = elder.questMarker_newQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 2 &&
    				!gp.player.isGremlin) {
    			elder.questMarker = elder.questMarker_activeQuest;
    		}
    	    else {
    	    	elder.questMarker = elder.questMarker_none;
    	    }
    	}
    	
    	Entity farmer = gp.findNPCByName("Bram Tiller");
    	if (farmer != null) {

    	    if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger")) &&
    	        !gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))) {
    	    	farmer.questMarker = farmer.questMarker_newQuest;
    	    }
    	    else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Cluck and Dagger").getCurrentStageIndex() == 3) {
    	    	farmer.questMarker = farmer.questMarker_activeQuest;
    	    }
    	    else {
    	    	farmer.questMarker = farmer.questMarker_none;
    	    }
    	}
    	
    	Entity gymbro = gp.findNPCByName("Bran Iron-Hands");
    	if (gymbro != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
    				Progress.gameStage > Progress.STAGE_BRIDGE_RUBBLE_REMOVED &&
    				!gp.player.isGremlin) {
    			gymbro.questMarker = gymbro.questMarker_newQuest;
    		}
    		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("No Rest for the Wicked"))&&
    				!gp.player.isGremlin) {
    			gymbro.questMarker = gymbro.questMarker_activeQuest;
    		}
    	    else {
    	    	gymbro.questMarker = gymbro.questMarker_none;
    	    }
    	}
    	
    	Entity husband = gp.findNPCByName("Luca Aldermere");
    	if (husband != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				Progress.gameStage > Progress.STAGE_BRIDGE_RUBBLE_REMOVED &&
    				!gp.player.isGremlin) {
    			husband.questMarker = husband.questMarker_activeQuest;
    		}
    		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				gp.player.searchItemInInventory("Luca's Jacket") != 999 &&
    				!gp.player.isGremlin) {
    			husband.questMarker = husband.questMarker_activeQuest;
    		}
    	    else {
    	    	husband.questMarker = husband.questMarker_none;
    	    }
    	}    
    	
    	Entity mayor = gp.findNPCByName("Mayor Oren");
    	if (mayor != null) {

    	    if (gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 2) {
    	    	mayor.questMarker = mayor.questMarker_activeQuest;
    	    }
    	    else {
    	    	mayor.questMarker = mayor.questMarker_none;
    	    }
    	}
    	
    	Entity president = gp.findNPCByName("Alaric Calloway");
    	if (president != null) {

    	    if (gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril")) &&
    				(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 1  || 
    				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 3)) {
    	    	president.questMarker = president.questMarker_activeQuest;
    	    }
    	    else {
    	    	president.questMarker = president.questMarker_none;
    	    }
    	}
    	
    	Entity punk = gp.findNPCByName("Vex Cragstone");
    	if (punk != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				!gp.player.isGremlin) {
    			punk.questMarker = punk.questMarker_newQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 0 &&
    				gp.player.coin >= 50 &&
    				!gp.player.isGremlin) {
    			punk.questMarker = punk.questMarker_activeQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant"))&&
    				gp.qManager.getQuestJournal().getQuestByName("The Suspicious Merchant").getCurrentStageIndex() == 4 &&
    				!gp.player.isGremlin) {
    			punk.questMarker = punk.questMarker_activeQuest;
    		}
    	    else {
    	    	punk.questMarker = punk.questMarker_none;
    	    }
    	}
    	
    	Entity scientist = gp.findNPCByName("Dr. Thorne Baxter");
    	if (scientist != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
    				Progress.gameStage > Progress.STAGE_BRIDGE_RUBBLE_REMOVED &&
    				!gp.player.isGremlin) {
    			scientist.questMarker = scientist.questMarker_newQuest;
    		}
    		else if (!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Critical Malfunction"))&&
    				gp.player.searchItemInInventory("Field Resonator") != 999 &&
    				!gp.player.isGremlin) {
    			scientist.questMarker = scientist.questMarker_activeQuest;
    		}
    	    else {
    	    	scientist.questMarker = scientist.questMarker_none;
    	    }
    	}
    	
    	Entity scout = gp.findNPCByName("Rowan Swiftfoot");
    	if (scout != null) {

    	    if (gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Sands of Peril"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Sands of Peril").getCurrentStageIndex() == 4) {
    	    	scout.questMarker = scout.questMarker_activeQuest;
    	    }
    	    else {
    	    	scout.questMarker = scout.questMarker_none;
    	    }
    	}
    	
    	
    	Entity son = gp.findNPCByName("Captured Wibby");
    	if (son != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Where’s Wibby?").getCurrentStageIndex() == 1 &&
    				!gp.player.isGremlin) {
    			son.questMarker = son.questMarker_activeQuest;
    		}
    	    else {
    	    	son.questMarker = son.questMarker_none;
    	    }
    	}
    	
    	Entity thief = gp.findNPCByName("Cains Steelcloak");
    	if (thief != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Stolen Style"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Stolen Style").getCurrentStageIndex() == 0 &&
    				!gp.player.isGremlin) {
    			thief.questMarker = thief.questMarker_activeQuest;
    		}
    	    else {
    	    	thief.questMarker = thief.questMarker_none;
    	    }
    	}
    	
    	Entity wife = gp.findNPCByName("Nessa Aldermere");
    	if (wife != null) {

    		if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				!gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				!gp.player.isGremlin) {
    			wife.questMarker = wife.questMarker_newQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 1 &&
    				gp.player.searchItemInInventory("Water Bucket") != 999 &&
    				!gp.player.isGremlin) {
    			wife.questMarker = wife.questMarker_activeQuest;
    		}
    		else if(!gp.qManager.getQuestJournal().getCompletedQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("To Do List"))&&
    				gp.qManager.getQuestJournal().getQuestByName("To Do List").getCurrentStageIndex() == 3 &&
    				gp.player.searchItemInInventory("Corn Seed") != 999 &&
    				gp.player.inventory.get(gp.player.searchItemInInventory("Corn Seed")).amount >= 10 &&
    				!gp.player.isGremlin) {
    			wife.questMarker = wife.questMarker_activeQuest;
    		}
    	    else {
    	    	wife.questMarker = wife.questMarker_none;
    	    }
    	}
    	
    	Entity witch = gp.findNPCByName("Witch Morga");
    	if (witch != null) {

    	    if ((gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 0) ||
    	    		
    	    		gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield"))&&
    				gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 2 ||
    				
    				Progress.gameStage == Progress.STAGE_MEET_WITCH) {
    	    	witch.questMarker = witch.questMarker_activeQuest;
    	    }
    	    else {
    	    	witch.questMarker = witch.questMarker_none;
    	    }
    	}
    	


    	

    	
    	Entity desert_trader = gp.findNPCByName("Zayid Marruk");
    	if (desert_trader != null) {

    	    if (gp.qManager.getQuestJournal().getActiveQuests().contains(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield")) &&
    				(gp.qManager.getQuestJournal().getQuestByName("Fissures in the Shield").getCurrentStageIndex() == 1)) {
    	    	desert_trader.questMarker = desert_trader.questMarker_activeQuest;
    	    }
    	    else {
    	    	desert_trader.questMarker = desert_trader.questMarker_none;
    	    }
    	}
    	
    	
    	
    }
}