public Solution{
    //iterative method
    public ListNode reverseNode1(TreeNode head){
        return helper(head);
    }

    private ListNode helper(TreeNode node){
        if (node == null) return null;
        ListNode prev = null;
        LIstNode cur = node;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }


    //recursion method
    public ListNode reverseNode2(TreeNode head){
        
    }







}
