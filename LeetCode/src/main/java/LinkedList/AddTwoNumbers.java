package LinkedList;

import DS.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode n1, ListNode n2){
        if (n1 == null || n2 == null){
            return n1 == null ? n2 : n1;
        }

        int sum = 0;
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        while (n1 != null || n2 != null){
            if (n1 != null){
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null){
                sum += n2.val;
                n2 = n2.next;
            }
            dummy.next = new ListNode(sum%10);
            sum /= 10;
            dummy = dummy.next;
        }
        //don't forget to update the last node
        if (sum != 0){
            dummy.next = new ListNode(1);
        }
        return ans.next;
    }
}
