package Implementation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Check is path exists between 2 nodes
 */
public class BFS {
    class Node {
        boolean visited;
        LinkedList<Node> nodes;
    }

    private static boolean findPath(Node node1, Node node2) {
        Queue<Node> q = new LinkedList<>();
        node1.visited = true;
        q.add(node1);


        while(!q.isEmpty()) {
            Node temp = q.remove();
            if(temp == node2){
                return true;
            }

            for(int i = 0; i < temp.nodes.size(); i++) {
                if(!temp.nodes.get(i).visited) {
                    temp.nodes.get(i).visited = true;
                    q.add(temp.nodes.get(i));
                }
            }
        }
        return false;
    }

}
