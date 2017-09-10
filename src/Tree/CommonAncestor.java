package Tree;

/**
 * Cracking the Coding Interview CommonAncestor
 * Solution with links to parents
 */
public class CommonAncestor {

    class Node {
        Node parent;
    }

    private static Node findAncestor(Node a, Node b) {
        int diff = depth(a) - depth(b);
        Node deepNode = diff > 0 ? a : b;
        Node shallowNode = diff > 0 ? b : a;
        deepNode = goUpBy(deepNode, Math.abs(diff));

        while(deepNode != shallowNode && deepNode != null && shallowNode != null) {
            deepNode = deepNode.parent;
            shallowNode = shallowNode.parent;
        }

        return deepNode == null || shallowNode == null ? null : shallowNode;
    }

    private static Node goUpBy(Node node, int depth) {
        while(depth != 0 && node != null) {
            node = node.parent;
            depth--;
        }
        return node;
    }

    private static int depth(Node node) {
        int depth = 0;
        while(node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
}
