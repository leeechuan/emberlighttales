package quest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.emberlight.GamePanel;

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
    	        new QuestStage("Talk to village witch from 7pm - 4am"),
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
    	        new QuestStage("Defeat Orc Commander")
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
    	    "A suspicious merchant was spotted outside Emberville,\nclaiming he has the cheapest potions.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Purchase a potion from the merchant."),
    	        new QuestStage("Drink suspicious potion"),
    	        new QuestStage("Find your way out.")
    	    ),
            gp
    	);
    	Quest sideQuest2 = new Quest(
    	    "Cluck and Dagger",
    	    "The farmer has lost his chickens\nafter the orc attack.\nHelp him chase them down.",
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
    	    "Lost Heirloom",
    	    "Elder has lost his family heirloom\nduring orc raid.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Find heirloom in abandoned house"),
    	        new QuestStage("Report back to the elder")
    	    ),
            gp
    	);

    	Quest sideQuest4 = new Quest(
    	    "No Rest for the Wicked",
    	    "A group of bandits has been raiding caravans along the road to the south.\nThe local authorities are overwhelmed, and it's up to you to put an end to their reign of terror.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Investigate the last known location of the bandits."),
    	        new QuestStage("Defeat the rogue bandits in their hideout."),
    	        new QuestStage("Return to the village and report to the guard captain.")
    	    ),
            gp
    	);

    	Quest sideQuest5 = new Quest(
    		    "Where’s Wibby?",
    		    "A worried father in Emberville pleads for help.\nHis young son went missing in the\nchaos following the orc raid. Perhaps I\nshould look outside the village..",
    		    false,
    		    Arrays.asList(
    		        new QuestStage("Search the cave for any clues."),
    		        new QuestStage("Bring Wibby back to his father.")
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
}