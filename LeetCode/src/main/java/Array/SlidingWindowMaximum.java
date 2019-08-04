package Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    /*
    At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means
    If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array
    Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i,
    then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.
    As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]

    */
    //by using dequeue

    public static int[] slidingWindowMaximum(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                ans[index ++] = nums[q.peek()];
            }
        }
        return ans;
    }
    //The straightforward solution is to iterate over all sliding windows and find a maximum for each window.
    // There are N - k + 1 sliding windows and there are k elements in each window,
    // that results in a quite bad time complexity \mathcal{O}(N k)O(Nk).
    public static int[] slidingWindowMaximum_normal(int[] nums, int k){
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int[] output = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i ++){
            int max = Integer.MIN_VALUE;
            for (int j = i; i < i + k; j ++){
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }

        return output;

    }



}



