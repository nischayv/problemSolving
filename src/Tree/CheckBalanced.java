package Tree;

/**
 * Cracking the Coding Interview Check Balanced
 */
public class CheckBalanced {

    class Node {
        int data;
        Node left;
        Node right;
    }

    private boolean checkBalanced(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    private int checkHeight(Node node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        int rightHeight = checkHeight(node.right);
        int heightDiff = leftHeight - rightHeight;

        if(Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
