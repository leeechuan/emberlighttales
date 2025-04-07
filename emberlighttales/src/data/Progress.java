package data;

public class Progress {

//	public static boolean orcChiefDefeated;
	
	// Named constants for stages
    public static final int STAGE_TUTORIAL = 0;
    public static final int STAGE_INTRODUCTION = 1;
    public static final int STAGE_MEET_WITCH = 3;
    public static final int STAGE_SERUM_GIVEN = 4;
    public static final int STAGE_BRIDGE_RUBBLE_REMOVED = 5;
    public static final int STAGE_FIND_ORC_LIEUTENANT = 6;
    public static final int STAGE_ORC_LIEUTENANT_DEFEATED = 8;
    public static final int STAGE_FIND_ORC_SECONDINCOMMAND = 9;
    public static final int STAGE_ORC_SECONDINCOMMAND_DEFEATED = 10;
    public static final int STAGE_FIND_ORC_CHIEF = 11;
    public static final int STAGE_ORC_CHIEF_DEFEATED = 12;
	
	public static int gameStage = STAGE_TUTORIAL;
	
	
    public static void updateStage(int newStage) {
        if (newStage > gameStage) {
            gameStage = newStage; // Only update if progressing forward
        }
    }
}
