package Misc;

/**
 * Program to delete a node from a list
 */
public class DeleteNode {

    public class LinkedListNode {
        int val;
        LinkedListNode next;
    }

    static LinkedListNode removeNodes(LinkedListNode list, int x) {
        LinkedListNode temp = list;
        LinkedListNode previous = null;
        while (temp != null) {
            if (temp.val > x) {
                if (temp == list) {
                    list = list.next;
                } else {
                    previous.next = temp.next;
                }
            } else {
                previous = temp;
            }
            temp = temp.next;
        }
        return list;
    }

}
