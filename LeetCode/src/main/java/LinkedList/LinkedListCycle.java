package LinkedList;


import DS.ListNode;

import java.util.HashSet;
import java.util.Set;

class LinkedListCycle {
    //using set to do
    public boolean hasCycle(ListNode head) {
        // edge case
        if (head == null) return false;
        // to check repeat again or not
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp);
        
        while (temp.next != null){
            if (set.contains(temp.next)) return true;
            temp = temp.next;
            set.add(temp);
        }
        return false;
    }

    public boolean hasCycle1(ListNode head){
        //no cycle
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
