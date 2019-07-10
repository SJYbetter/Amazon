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
class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode node1 = head.next = new ListNode(1);
        ListNode node2 = node1.next = new ListNode(2);
        ListNode node3 = node2.next = new ListNode(3);
        System.out.println(middleNode(head));

    }
}
