package ArraysAndLists;

public class AddNumbers {
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
        Node(){}
    }

    public static void main(String args[]) {

    }

    Node addTwoLists(Node first, Node second) {
        Node n1 = first;
        Node n2 = second;
        int num1 = 0;
        int num2 = 0;
        while (n1 != null) {
            num1 += num1*10 + n1.data;
            n1 = n1.next;

        }
        while (n2 != null) {
            num2 += num2*10 + n2.data;
            n2 = n2.next;
        }

        int num3 = num1 + num2;

        if (num3 == 0) {
            return new Node(0);
        }
        Node temp = null;
        while(num3 != 0) {
            int last = num3 % 10;
            Node n = new Node(last);
            n.next = temp;
            temp = n;
            num3 /= 10;
        }
        return temp;
    }
}
