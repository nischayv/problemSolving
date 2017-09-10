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

    ListNode getCycleStart (ListNode start) {
        if (start == null) {
            return null;
        }

        ListNode n1 = start;
        ListNode n2 = start;

        while (n2 != null && n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
            if (n1 == n2) {
                break;
            }
        }

        if (n2 == null || n2.next == null) {
            return null;
        }

        n1 = start;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}
