package Array;

import java.util.PriorityQueue;

/*
Input: [3,2,1,5,6,4] and k = 2
Output: 5
 */
public class KthLargestElementInAnArray {
    //the first way to solve this problem is using pq
    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : nums) {
            pq.offer(i);
            //the size over k, just poll because the pq will help us to maintain the relationship
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
/*
    private static int findKthLargest2(int[] nums, int k){
        return quickSelect(nums, k, 0, nums.length);
    }

    private static int quickSelect(int[] nums, int k, int start, int end){

    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
    }

}

*/

