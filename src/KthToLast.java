/**
 * Cracking the coding interview Return Kth to Last
 */
public class KthToLast {

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private static int printKthToLast(Node head, int k){
        if(head == null) {
            return -1;
        }

        int index = printKthToLast(head.next, k) + 1;
        if(index == k) {
            System.out.println("Kth to the last node is" + head.data);
        }
        return index;
    }
}
