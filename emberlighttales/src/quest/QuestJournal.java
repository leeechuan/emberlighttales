package quest;
import java.util.ArrayList;
import java.util.List;

public class QuestJournal {
    private List<Quest> activeQuests;
    private List<Quest> completedQuests;
    private List<Quest> allQuests;

    public QuestJournal() {
        activeQuests = new ArrayList<>();
        completedQuests = new ArrayList<>();
        allQuests = new ArrayList<>();
    }
    public void initQuest(Quest quest) {
    	allQuests.add(quest);
    }
    public void setActiveQuests(List<Quest> activeQuests) {
        this.activeQuests = activeQuests;
    }
    public void setCompletedQuests(List<Quest> completedQuests) {
        this.completedQuests = completedQuests;
    }
    public void resetQuestJournal() {
        if (activeQuests != null) {
            activeQuests.clear();
        }
        if (completedQuests != null) {
            completedQuests.clear();
        }
    }
    public void addQuest(Quest quest) {
        activeQuests.add(quest);
    }

    public void completeQuest(Quest quest) {
        if (activeQuests.remove(quest)) {
            completedQuests.add(quest);
        }
    }

    public List<Quest> getActiveQuests() {
        return activeQuests;
    }

    public List<Quest> getCompletedQuests() {
        return completedQuests;
    }
    public Quest getQuestByName(String questName) {
        for (Quest quest : allQuests) {  // Check all quests (active, completed, initialized)
            if (quest.getName().equals(questName)) {
                return quest;
            }
        }
        return null;
    }
}
