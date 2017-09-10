package ArraysAndLists;

public class ListIntersection {
    class Node {
        public int data;
        public Node next;
    }

    private static Node findIntersection (Node start1, Node start2) {
        if (start1 == null || start2 == null) {
            return null;
        }

        Node n1 = start1;
        Node n2 = start2;

        int size1 = 1;
        int size2 = 1;

        while (n1.next != null) {
            n1 = n1.next;
            size1++;
        }

        while (n2.next != null) {
            n2 = n2.next;
            size2++;
        }

        if (n1 != n2) {
            return null;
        }

        int diff = Math.abs(size2 - size1);

        Node longer = null;
        Node shorter = null;

        if (size2 > size1) {
            longer = start2;
            shorter = start1;
        } else {
            longer = start1;
            shorter = start2;
        }

        for (int i=0; i<diff; i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        return shorter;
    }

}
