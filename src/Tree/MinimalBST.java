package Tree;

/**
 * Cracking the Coding Interview Minimal BST
 * Sorted array has to be transformed into
 * a minimum BST
 */
public class MinimalBST {

    class Node {
        int data;
        Node left;
        Node right;
    }

    private Node minimumBST(int arr[]) {
        return minimumBST(arr, 0, arr.length - 1);
    }

    private Node minimumBST(int arr[], int beg, int end) {
        if(end < beg) {
            return null;
        }
        int mid = (beg + end)/2;
        Node node = new Node();
        node.data = arr[mid];
        node.left = minimumBST(arr, beg, mid - 1);
        node.right = minimumBST(arr, mid + 1, end);
        return node;
    }
}
