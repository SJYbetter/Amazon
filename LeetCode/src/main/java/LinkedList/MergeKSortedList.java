package LinkedList;

import DS.ListNode;

import java.util.PriorityQueue;


 // R.T O(N * log K)   space complexity: O(K)

 //solution: using a size ok K head put all heads into the heap, and get the top element, then put
class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists);
    }

    private ListNode helper(ListNode[] lists){

        if (lists == null || lists.length == 0) return null;
        //min heap size of K
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length , (l1, l2) -> l1.val - l2.val);

        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        //put all head into the heap, because all heads are smallest number in its corresponding LinkedList
        for (ListNode l : lists){
            if (l != null) {
                pq.offer(l);
            }
        }

        while (!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;

            if (temp.next != null){
                pq.add(temp.next);
            }
        }
        return ans.next;
    }
}
