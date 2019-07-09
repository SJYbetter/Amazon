package LinkedList;
import DS.ListNode;
/*
input: 1 -> 2 - > 3 - > 4
output: 2 -> 1 -> 4 -> 3
 */

public class SwapNode {
    public static ListNode swapnode(ListNode head){
        if (head == null) return null;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cur = dumy;

        while (cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode sec = cur.next.next;
            first.next = sec.next;
            sec.next = first;
            cur.next = sec;
            cur = cur.next.next;
        }
        return dumy.next;
    }

    public static void main(String[] args){

    }
}
