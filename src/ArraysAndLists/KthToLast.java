package ArraysAndLists;

/**
 * Cracking the coding interview Return Kth to Last
 */
public class KthToLast {

    public static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        Node t = new Node(2, null);
        Node n = new Node(1, t);
        t.next = new Node(3, new Node(4, null));
        printKthToLast(n, 3);
        System.out.println(kthToLast(n, 3).data);
    }

    private static int printKthToLast(Node head, int k){
        if(head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;
        if(index == k) {
            System.out.println("Kth to the last node is " + head.data);
        }
        return index;
    }

    private static Node kthToLast (Node start, int k) {
        if (start == null) {
            return null;
        }

        Node n1 = start;
        Node n2 = start;

        for (int i = 0; i < k; i++) {
            if (n1 == null) return null;
            n1 = n1.next;
        }

        while (n1 != null) {
            n1 = n1.next;
            n2= n2.next;
        }

        return n2;
    }
}
