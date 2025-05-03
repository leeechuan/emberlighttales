package quest;

import java.io.Serializable;
import java.util.List;

import main.emberlight.GamePanel;

public class Quest implements Serializable{

	private static final long serialVersionUID = 1231339954040533059L;
	private String name;
    private String description;
    private boolean isMainQuest;
    private List<QuestStage> stages;
    private int currentStageIndex;
    private boolean isCompleted;
    private GamePanel gp;

    public Quest(String name, String description, boolean isMainQuest, List<QuestStage> stages, GamePanel gp) {
        this.name = name;
        this.description = description;
        this.isMainQuest = isMainQuest;
        this.stages = stages;
        this.currentStageIndex = 0;
        this.isCompleted = false;
        this.gp = gp;
    }
    
    public List<QuestStage> getStages() {
        return stages;  // This method should return the list of quest stages
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isMainQuest() {
        return isMainQuest;
    }
    public QuestStage getCurrentStage() {
        if (currentStageIndex < stages.size()) {
            return stages.get(currentStageIndex);
        }
        return null;
    }
    public int getCurrentStageIndex() {
        return currentStageIndex;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public void advanceStage() {
        if (currentStageIndex < stages.size()) {
            stages.get(currentStageIndex).completeStage();
            currentStageIndex++;

            if (currentStageIndex >= stages.size()) {
                completeQuest();
                gp.qManager.getQuestJournal().completeQuest(this); // Notify QuestJournal
            }
        }
    }
    private void completeQuest() {
        isCompleted = true;
    }
    public void reset() {
        currentStageIndex = 0;
        isCompleted = false;
        
        for (QuestStage stage : stages) {
            stage.reset();
        }
    }
}
