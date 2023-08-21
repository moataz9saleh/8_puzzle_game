import java.io.*;
import java.util.*;

public class DFS{
    static ArrayList<char[][]> pathList = new ArrayList<>();
    static ArrayList<String> moveList= new ArrayList<>();

    public static void dfs(String InitialState) throws IOException {
        double start = System.nanoTime();

        //here we started to use a file writer to make the output in a file
        FileWriter fileWriter = new FileWriter("8 Puzzle BFS Solution.txt");
        PrintWriter file = new PrintWriter(fileWriter);

        System.out.println("Depth first searching");
        String goal = "012345678";
        Node goal1 = new Node(goal,null,null);

        boolean foundSolution = false;

        //started to use the queue to work with BFS
        Stack<Node> Frontier = new Stack<>();

        //Declarring all data structure we will use in the search
        Node InitialStateNode=new Node(InitialState,null,null);
        Frontier.add(InitialStateNode);
        HashSet<String> Explored = new HashSet();
        Queue<Node>NodesNum=new LinkedList<>();
        Stack<char[][]>printparent=new Stack<>();
        Stack<String>printmoves=new Stack<>();
        Queue<String>printmoves1=new LinkedList<>();

        //start the searching
        while (!Frontier.isEmpty()) {
            int Depth=0;
            Node nodeToExplore =Frontier.pop() ;
            Explored.add(nodeToExplore.value);
            char[][] board = Work_Space.toBoardArray(nodeToExplore.value);
            String parent=Work_Space.toBoardString(board);
            file.println("Exploring: ");
            System.out.println("Exploring: ");
            Work_Space.printBoard(board, file);


            //check if we reached the goal
            if (nodeToExplore.value.equals(goal1.value)) {
                int count=0;
                file.println("arrived!");
                System.out.println("arrived!");
                foundSolution = true;
                System.out.println("_______________\nPath To Goal:\nInitial State");
                file.println("_______________\nPath To Goal:\nInitial State");
                Work_Space.printBoard(Work_Space.toBoardArray(InitialState),file);

                //to get nodes parents
                while (nodeToExplore.parent!=null){
                    char [][] o=Work_Space.toBoardArray(nodeToExplore.value);
                    printparent.add(o);
                    printmoves.add(nodeToExplore.Move);
                    nodeToExplore=nodeToExplore.parent;
                    Depth=printparent.size();

                    // to print the path to goal
                }while (!printparent.isEmpty()){
                    count++;
                    System.out.print("Move "+count+" to Goal: ");
                    file.print("Move "+count+" to Goal: ");
                    printmoves1.add(printmoves.peek());
                    System.out.println(printmoves.peek());
                    moveList.add(printmoves.peek());
                    file.println(printmoves.pop());
                    pathList.add(printparent.peek());
                    Work_Space.printBoard(printparent.pop(),file);
                }

                //printing the path to goal and all wanted information
                System.out.println("Path To Goal:"+printmoves1.toString()+"\nCost of path= "+count);
                file.println("Path To Goal:"+printmoves1.toString()+"\nCost of path= "+count);
                System.out.println("Depth= "+Depth);
                System.out.println("Nodes Expanded= "+NodesNum.size());
                file.println("Depth= "+Depth);
                file.println("Nodes Expanded= "+NodesNum.size());
                double end = System.nanoTime();
                double execution = end - start;
                System.out.println("Execution time of Depth first search: " + execution/100000000 + " seconds");
                file.println("Execution time of Depth first search: " + execution/100000000 + " seconds");
                break;
            }

            // getting the index of 0 in the puzzle
            int zeroIndex = nodeToExplore.value.indexOf('0');
            int zeroY = zeroIndex / 3;
            int zeroX = zeroIndex % 3;

            // getting 1st neighbour
            if (zeroX != 0) {
                board[zeroY][zeroX] = board[zeroY][zeroX - 1];
                board[zeroY][zeroX - 1] = '0';

                String boardString = Work_Space.toBoardString(board);

                //adding the move in the tree
                if (!Explored.contains(boardString)) {
                    Tree.add(nodeToExplore,boardString,1,nodeToExplore,"Left");
                    Frontier.add(nodeToExplore.node1);
                    Explored.add(nodeToExplore.node1.value);
                }

                // Undo the last move to reuse it
                board[zeroY][zeroX - 1] = board[zeroY][zeroX];
                board[zeroY][zeroX] = '0';
            }

            // getting 2nd neighbour
            if (zeroY != 0) {
                board[zeroY][zeroX] = board[zeroY - 1][zeroX];
                board[zeroY - 1][zeroX] = '0';

                //adding the move in the tree
                String boardString = Work_Space.toBoardString(board);
                if (!Explored.contains(boardString)) {
                    Tree.add(nodeToExplore,boardString,2,nodeToExplore,"Up");
                    Frontier.add(nodeToExplore.node2);
                    Explored.add(nodeToExplore.node2.value);

                }

                // Undo the last move to reuse it
                board[zeroY - 1][zeroX] = board[zeroY][zeroX];
                board[zeroY][zeroX] = '0';
            }
            //  getting 3rd neighbour
            if (zeroY != 2) {
                board[zeroY][zeroX] = board[zeroY + 1][zeroX];
                board[zeroY + 1][zeroX] = '0';

                //adding the move in the tree
                String boardString = Work_Space.toBoardString(board);
                if (!Explored.contains(boardString)) {
                    Tree.add(nodeToExplore,boardString,3,nodeToExplore,"Down");
                    Frontier.add(nodeToExplore.node3);
                    Explored.add(nodeToExplore.node3.value);
                }

                // Undo the last move to reuse it
                board[zeroY + 1][zeroX] = board[zeroY][zeroX];
                board[zeroY][zeroX] = '0';
            }

            // 4th neighbour
            if (zeroX != 2) {
                board[zeroY][zeroX] = board[zeroY][zeroX + 1];
                board[zeroY][zeroX + 1] = '0';

                //adding the move in the tree
                String boardString = Work_Space.toBoardString(board);
                if (!Explored.contains(boardString)) {
                    Tree.add(nodeToExplore,boardString,4,nodeToExplore,"Right");
                    Frontier.add(nodeToExplore.node4);
                    Explored.add(nodeToExplore.node4.value);
                }

                // Undo the last move to reuse it
                board[zeroY][zeroX + 1] = board[zeroY][zeroX];
                board[zeroY][zeroX] = '0';
            }
            NodesNum.add(nodeToExplore.parent);
        }

        //check if we didn't find a solution
        if (!foundSolution) {
            System.out.println("Not solvable");
            file.println("Not solvable");
        }
        file.close();
    }
}