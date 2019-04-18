public class ReverseLinkedList{
    //iterative method
    public ListNode reverseNode1(ListNode head){
        return helper(head);
    }

    private ListNode helper(ListNode node){
        if (node == null) return null;
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    //recursion method
    public ListNode reverseNode2(ListNode head){
        
    }







}
