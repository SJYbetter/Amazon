package Array;

import java.util.PriorityQueue;


class KthLargestElementinAStream {
    private PriorityQueue<Integer> pq;
    int k = 0;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i : nums){
            this.add(i);
        }

    }

    public int add(int val) {
        if (pq.size() < k){
            pq.offer(val);
            return pq.peek();
        }
        if (pq.peek() < val){
            pq.poll();
            pq.offer(val);
            return pq.peek();
        }
        return pq.peek();
   }
}
