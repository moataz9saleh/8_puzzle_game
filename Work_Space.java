import java.io.*;
import java.util.*;
public class Work_Space {
    //"printBoard" method to print the puzzle in the console an the file
    public static void printBoard(char[][] board, PrintWriter file) {
    System.out.println("|"+board[0][0] + "|" + board[0][1] + "|" + board[0][2]+"|");
    System.out.println("|"+board[1][0] + "|" + board[1][1] + "|" + board[1][2]+"|");
    System.out.println("|"+board[2][0] + "|" + board[2][1] + "|" + board[2][2]+"|");

    file.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
    file.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
    file.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
}
//"toBoardArray" method to return the string puzzle to 2d array
    public static char[][] toBoardArray(String stateToExplore) {
        char[][] board = new char[3][3];
        board[0][0] = stateToExplore.charAt(0);
        board[0][1] = stateToExplore.charAt(1);
        board[0][2] = stateToExplore.charAt(2);
        board[1][0] = stateToExplore.charAt(3);
        board[1][1] = stateToExplore.charAt(4);
        board[1][2] = stateToExplore.charAt(5);
        board[2][0] = stateToExplore.charAt(6);
        board[2][1] = stateToExplore.charAt(7);
        board[2][2] = stateToExplore.charAt(8);

        return board;
    }
    //"toBoardString" method to return the 2d array puzzle to string
    public static String toBoardString(char[][] board) {
        String boardString = "" + board[0][0] + board[0][1] + board[0][2]
                + board[1][0] + board[1][1] + board[1][2]
                + board[2][0] + board[2][1] + board[2][2];

        return boardString;
    }
    //"check" method that get the lowest heuristic
public static int check(int H1,int H2,int H3,int H4){
        if (H1<H2&&H1<H3&&H1<H4){
            return H1;
        }else if (H2<H1&&H2<H3&&H2<H4){
            return H2;
        }else if (H3<H2&&H3<H1&&H3<H4){
            return H3;
        }else if (H4<H2&&H4<H3&&H4<H1){
            return H4;
        } return -1;
    }
    //"Manhattan" calculate Manhattan Distance
    public static int Manhattan(int currentX,int currentY,int goalX,int goalY){
        int Manhattan=Math.abs(currentX-goalX)+Math.abs(currentY-goalY);
        return Manhattan;
    }
    //"Euclidean" calculate Euclidean Distance
    public static double Euclidean(int currentX,int currentY,int goalX,int goalY) {
        double Euclidean=  Math.sqrt(Math.pow(currentX-goalX,2)+Math.pow(currentY-goalY,2));
        return Euclidean;
    }
    //"GetHManhattan" method to get the heuristic with Manhattan Distance
        public static int GetHManhattan(char[][] State){
        int H=0;
        for (int i=0;i<State.length;i++){
            for (int j=0;j<State.length;j++){
                char current=State[i][j];
                int currentX=i;
                int currentY=j;
                int goalX=GoalX(current);
                int goalY=GoalY(current);
                H+=Manhattan(currentX,currentY,goalX,goalY);
    }
}return H;
    }
    //"GetHEuclidean" method to get the heuristic with Euclidean Distance
    public static double GetHEuclidean(char[][] State){
        double H=0;
        for (int i=0;i<State.length;i++){
            for (int j=0;j<State.length;j++){
                char current=State[i][j];
                int currentX=i;
                int currentY=j;
                int goalX=GoalX(current);
                int goalY=GoalY(current);
                H+=Euclidean(currentX,currentY,goalX,goalY);
            }
        }return H;
    }
    //"GoalX" method to get the index of x for the chosen element in the goal
    public static int GoalX( char t) {
        String goal="012345678";
        char [][] Goal=toBoardArray(goal);
        int len = Goal.length;
        int i = 0;
        for ( i=0;i<len;i++) {
            for (int j = 0; j < len; j++) {

                if (Goal[i][j] == t) {
                    return i;
                }
            }
        }
        return -1;
    }
    //"GoalY" method to get the index of Y for the chosen element in the goal
    public static int GoalY( char Num) {
        String goal="012345678";
        char [][] Goal=toBoardArray(goal);
        int len = Goal.length;
        char i = '0';
        for ( i='0';i<len;i++) {
            for (char j = '0'; j < len; j++) {
                if (Goal[i][j] == Num) {
                    return j;
                }
            }
        }
        return -1;
    }
    }
