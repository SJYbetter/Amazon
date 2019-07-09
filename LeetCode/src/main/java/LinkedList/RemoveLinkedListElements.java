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


//Input:  1->2->6->3->4->5->6, val = 6
//Output: 1->2->3->4->5
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode node1 = head.next = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        System.out.println(removeElements(head, 3));
        
    }
}
