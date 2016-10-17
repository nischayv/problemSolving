package Tree;

/**
 * Cracking the Coding Interview Inorder Successor of BST
 * Returning next node inorder traversal. If current node is the
 * rightmost node in the tree(whole tree has been traversed), then
 * return null
 */
public class BSTSuccessor {
    class Node {
        int data;
        Node left;
        Node right;
        Node parent;
    }

    private Node successor(Node node) {
        if(node == null) {
            return null;
        }

        if(node.right != null) {
            return leftMostChild(node.right);
        }
        else {
            Node n = node;
            Node p = node.parent;
            while(p != null && p.left != n) {
                n = p;
                p = p.parent;
            }
            return p;
        }
    }

    private Node leftMostChild(Node node) {
        if(node != null) {
            while(node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

}
