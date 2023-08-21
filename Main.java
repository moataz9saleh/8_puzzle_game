
import java.util.Scanner;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String initialState;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.print("Enter initial state: ");
        String r = console.next();

        puzzle.setinit(Work_Space.toBoardArray(r));
        puzzle pu = new puzzle();
        initialState = r;
    }

    public static void callBFS() throws IOException {

        BFS.bfs(initialState);
        puzzle.pathList = BFS.pathList;
        puzzle.moveList = BFS.moveList;
    }
    public static void callDFS() throws IOException {
        DFS.dfs(initialState);
        puzzle.pathList = DFS.pathList;
        puzzle.moveList = DFS.moveList;
    }

    public static void callManhattan() throws IOException {
        Manhattan.AstarManhattan(initialState);
        puzzle.pathList = Manhattan.pathList;
        puzzle.moveList = Manhattan.moveList;
    }
    public static void callEuc() throws IOException {
        Euclidean.AstarEuclidean(initialState);
        puzzle.pathList = Euclidean.pathList;
        puzzle.moveList = Euclidean.moveList;
    }

}