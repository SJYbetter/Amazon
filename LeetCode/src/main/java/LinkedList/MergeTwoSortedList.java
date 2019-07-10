package LinkedList;

import DS.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode ans = new ListNode(0);
        ListNode lastNode = ans;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            //update the lastNode
            lastNode = lastNode.next;
        }
        //l1 remaining
        if (l1 != null) {
            lastNode.next = l1;
        } else {
            lastNode.next = l2;
        }

        return ans.next;
    }
}
