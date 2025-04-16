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
    	    "The Missing Chickens",
    	    "Farmer has claimed to lose his chickens after the orc attack.\nHelp him chase them down.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Gather chickens"),
    	        new QuestStage("Report back to the farmer")
    	    ),
            gp
    	);
    	Quest sideQuest3 = new Quest(
    	    "A Lost Heirloom",
    	    "Elder has lost his family heirloom\nduring orc raid.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Find heirloom in abandoned house"),
    	        new QuestStage("Report back to the elder")
    	    ),
            gp
    	);

    	Quest sideQuest4 = new Quest(
    	    "The Rogue Bandits",
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
    	    "The Cursed Forest",
    	    "The once-beautiful forest nearby has been cursed. Creatures are becoming aggressive,\nand strange lights are seen every night. Investigate the cause of the curse.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Enter the cursed forest and explore."),
    	        new QuestStage("Find the source of the curse."),
    	        new QuestStage("Defeat the cursed creature guarding the forest."),
    	        new QuestStage("Return to the village and inform the elder.")
    	    ),
            gp
    	);

    	Quest sideQuest6 = new Quest(
    	    "The Thief in the Night",
    	    "A thief has been stealing from the local villagers during the night.\nIt's up to you to find the culprit and bring them to justice.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Speak with the villagers to gather information."),
    	        new QuestStage("Follow the thief's trail."),
    	        new QuestStage("Confront and apprehend the thief."),
    	        new QuestStage("Return the stolen goods and report to the village chief.")
    	    ),
            gp
    	);

    	Quest sideQuest7 = new Quest(
    	    "The Forgotten Temple",
    	    "An old and forgotten temple lies hidden deep in the mountains.\nThe temple is said to contain great treasures,\nbut it is also rumored to be cursed.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Find the location of the hidden temple."),
    	        new QuestStage("Navigate the dangerous ruins of the temple."),
    	        new QuestStage("Retrieve the treasure from the temple."),
    	        new QuestStage("Return to the village and warn them of the curse.")
    	    ),
            gp
    	);

    	Quest sideQuest8 = new Quest(
    	    "The Druid's Request",
    	    "A local druid has asked for your help in restoring the balance of nature,\nwhich has been disturbed by strange creatures in the nearby woods.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Meet with the druid and hear their request."),
    	        new QuestStage("Find and defeat the corrupted creatures in the woods."),
    	        new QuestStage("Collect the necessary ingredients for the druid."),
    	        new QuestStage("Return the ingredients and restore the balance.")
    	    ),
            gp
    	);

    	Quest sideQuest9 = new Quest(
    	    "The Lost Expedition",
    	    "A group of explorers went missing while mapping out the ruins in the far north.\nYour task is to find out what happened to them.",
    	    false,
    	    Arrays.asList(
    	        new QuestStage("Track down the missing expedition team."),
    	        new QuestStage("Search the ruins for clues."),
    	        new QuestStage("Rescue any survivors or report their fate."),
    	        new QuestStage("Return to the village and report your findings.")
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
}