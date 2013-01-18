import java.util.*;

public class BotClean {

    static final String DOWN = "DOWN";
    static final String LEFT = "LEFT";
    static final String RIGHT = "RIGHT";
    static final String CLEAN = "CLEAN";

    static final String DIRTY_CELL = "d";
    static final String ROBOT = "b";
    static final String CLEAN_CELL = "-";

    static boolean haveToClean;

    static void next_move(int posx, int posy, String[] board) {
        if(haveToClean(board)) move(CLEAN);

        for (String line : board) {
            if(robotLine(line) && lineIsDirty(line)) {
                cleanTheLine(line);
            } else if(robotLine(line) && lineIsClean(line)) {
                move(DOWN);
            }
        }
    }

    static boolean haveToClean(String[] board) {
        boolean robotIsHere = false;

        for(String line : board) {
            robotIsHere = robotLine(line);
        }

        return !robotIsHere;
    }

    static boolean lineIsClean(String line) {
        return !lineIsDirty(line);
    }
    static boolean lineIsDirty(String line) {
        return line.contains(DIRTY_CELL);
    }

    static boolean robotLine(String line) {
        return line.contains(ROBOT);
    }

    static void cleanTheLine(String line) {
        String flatView = line.replaceAll(CLEAN_CELL, "");

        if(flatView.startsWith(DIRTY_CELL)) {
            move(LEFT);
        } else {
            move(RIGHT);
        }
    }

    static void move(String direction) {
        System.out.println(direction);
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}