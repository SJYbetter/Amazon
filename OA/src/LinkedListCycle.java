public class Solution {
    public boolean hasCycle(ListNode head) {
        // edge case
        if (head == null) return false;

        // to check repeat again or not
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp);
        while (temp.next != null){
            if (set.contains(temp.next)) return true;
            temp = temp.next;
            set.add(temp);
        }
        return false;
    }
}
