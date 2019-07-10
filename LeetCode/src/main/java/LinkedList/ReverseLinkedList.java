package LinkedList;

import DS.ListNode;
// 1 -> 2 -> 3 -> 4

public class ReverseLinkedList{
    //iterative method
    public ListNode reverseNode(ListNode head) {

        if (head == null) return null;
        ListNode prev = null;
        while (head != null){
            //in order to update the head
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}










