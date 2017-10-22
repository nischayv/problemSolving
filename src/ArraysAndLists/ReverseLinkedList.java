package ArraysAndLists;

public class ReverseLinkedList {

    class Node {
        int x;
        Node next;
    }

    private Node head;

    private void reverseLinkedList(Node n) {
        if (n == null) {
            return;
        }

        if (n.next == null) {
            this.head = n;
            return;
        }

        reverseLinkedList(n.next);
        n.next.next = n;
        n.next = null;
    }

    private Node reverseLinkedListIterative(Node head) {
        if (head == null) {
            return null;
        }

        Node currentNode = head;
        Node prevNode = null;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        head = prevNode;
        return head;
    }
}
