package Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Cracking the coding interview List of Depths
 */
public class ListOfDepths {

    class Node {
        Node left;
        Node right;
    }

    public static void main(String args[]) {

    }

    private static void createLists(Node node, int level, ArrayList<LinkedList<Node>> lists) {
        if(node == null) {
            return;
        }

        LinkedList<Node> newList;
        if(lists.size() < level) {
            newList = new LinkedList<>();
            lists.add(newList);
        }
        else {
            newList = lists.get(level);
        }
        newList.add(node);
        createLists(node.left, level + 1, lists);
        createLists(node.right, level + 1, lists);
    }
}
