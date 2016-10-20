/**
 * Created by Nischay on 10/19/2016.
 */
public class q3 {

    public static void main(String args[]) {


    }

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
