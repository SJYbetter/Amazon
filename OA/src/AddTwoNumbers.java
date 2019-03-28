class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //edge case
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ans = new ListNode(0);
        ListNode d = ans;
        int sum = 0;

        while (c1 != null || c2 != null) {
            sum /= 10;
            //check c1 is null add to sum
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            //check the same position digit is null or not, then add to sum
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            // new the next digit and add the val to it due to larger than 10
            d.next = new ListNode(sum % 10);
            d = d.next;
        }//end while

        //check the last digit
        if (sum / 10 == 1){
            d.next = new ListNode(1);
        }

        return ans.next;
    }
}
