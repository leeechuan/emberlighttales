package quest;

public class QuestStage {
    private String description;
    private boolean isCompleted;

    public QuestStage(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeStage() {
        isCompleted = true;
    }
}