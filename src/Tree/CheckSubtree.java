package Tree;

/**
 * Cracking the coding interview CheckSubtree
 */
public class CheckSubtree {

    class Node{
        int data;
        Node left;
        Node right;
    }

    private static boolean checkSubtree(Node t1, Node t2) {
        if(t1 == null) {
            return false;
        }
        else if(t1.data == t2.data && match(t1, t2)) {
            return true;
        }
        return checkSubtree(t1.left, t2) ||  checkSubtree(t1.right, t2);
    }

    private static boolean match(Node t1, Node t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        else if(t1 == null || t2 == null) {
            return false;
        }
        else {
            return t1.data == t2.data && match(t1.left, t2.left) && match(t1.right, t2.right);
        }
    }


}
