package ArraysAndLists;

/**
 * Facebook Code Lab - Floyd's cycle finding algorithm
 */
public class LinkedListCycle {

    class ListNode {
        ListNode next;
    }

    public ListNode detectCycle(ListNode a) {
        if(a == null || a.next == null) {
            return null;
        }

        ListNode fast = a;
        ListNode slow = a;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // Start at head and meeting point and converge to start of cycle
                slow = a;
                while(slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }

        return null;
    }
}
