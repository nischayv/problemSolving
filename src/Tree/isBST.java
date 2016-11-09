package Tree;

/**
 * Hackerrank is Binary Tree?
 */
public class isBST {

    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        return check(root, 0, 10000);
    }

    boolean check(Node root, int min, int max) {
        if (root != null) {
            if (root.data >= max || root.data <= min) {
                return false;
            }
            else {
                return check(root.left, min, root.data) && check(root.right, root.data, max);
            }
        }
        else {
            return true;
        }
    }
}
