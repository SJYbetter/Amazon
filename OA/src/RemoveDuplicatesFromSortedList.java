//Input: 1->1->2->3->3
//Output: 1->2->3


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
}
