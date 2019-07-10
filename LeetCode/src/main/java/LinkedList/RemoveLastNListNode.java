package LinkedList;
import DS.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveLastNListNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy, quick = dummy;
        int i = 0;
        //find the quick position
        while (i < n){
            quick = quick.next;
            i ++;
        }
        //move at the same speed
        while (quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        //remove the last nth ListNode
        slow.next = slow.next.next;
        //return head
        return dummy.next;

    }
}
