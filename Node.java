import java.util.*;
public class Node {
    //declaring all the nodes in the tree and the puzzle that will enter the tree
    String value;
    Node node1;
    Node node2;
    Node node3;
    Node node4;
    Node parent;
    String Move;
    int Depth;
    //making Node constructor to recieve all the data about the node
    public Node(String value,Node parent,String Move) {
        this.value = value;
        this.node1 = null;
        this.node2 = null;
        this.node3 = null;
        this.node4 = null;
        this.parent=parent;
    this.Move=Move;
    if (parent==null){
        Depth=0;
    }else {
        Depth= parent.Depth+1;
    }
    }
}