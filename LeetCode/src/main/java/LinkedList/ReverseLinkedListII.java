package LinkedList;
/*
Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/


import DS.ListNode;

public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n){
        if (m == n && n == 1) return head;
        ListNode ans = new ListNode(0);
        ans.next = head;

        ListNode tail1 = ans;
        int i = 0;
        while (i < m){
            head = head.next;
            tail1 = tail1.next;
            i ++;
        }

        ListNode tail2 = head;
        head = head.next;
        i ++;
        while (i < n){
            tail2.next = head.next;
            //insert head after tail1
            head.next = tail1.next;
            tail1.next = head;
            head = tail2.next;
            i ++;
        }
        return ans.next;
    }

}


