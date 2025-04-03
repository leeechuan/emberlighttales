package data;

public class Progress {

//	public static boolean orcChiefDefeated;
	
	// Named constants for stages
    public static final int STAGE_TUTORIAL = 0;
    public static final int STAGE_INTRODUCTION = 1;
    public static final int STAGE_TRANSFORMATION = 2;
    public static final int STAGE_BRIDGE_UNBLOCKED = 3;
    public static final int STAGE_ORC_CHIEF_DEFEATED = 4;
	
	public static int gameStage = STAGE_TUTORIAL;
	
	
    public static void updateStage(int newStage) {
        if (newStage > gameStage) {
            gameStage = newStage; // Only update if progressing forward
        }
    }
}
