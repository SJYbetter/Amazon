/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

[-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

*/
public class Solution{
    //输出最大值
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i-1] > 0? dp[i-1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    
    //easy to understand
    public int maxSubArray2(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        int maxEndHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++){
            maxEndHere = Math.max(maxEndHere+nums[i], nums[i]);
            maxSoFar = Math.max(maxEndHere, maxSoFar);
        }
        return maxSoFar;
    }

    //输出这个subarray
    public int[] maxSubArray1(int[] nums1){
        if (nums1 == null || nums1.length == 0) return new int[]{};

        int[] prefix = new int[nums1.length+1];
        prefix[0] = 0;
        for (int i = 1; i <= nums1.length; i++){
            prefix[i] = prefix[i-1] + nums1[i-1];
        }

        int small = Integer.MAX_VALUE, big = Integer.MIN_VALUE;
        for (int i = 0; i < prefix.length; i++){
            if (prefix[i] < small){
                small = i;
            }
            if (prefix[i] > big){
                big = i;
            }
        }

        if (small > big) return new int[]{};
        int[] ans = new int[big-small];
        for (int i = 0; i < big-small; i++){
            ans[i] = nums1[small++];
        }
        return ans;
    }




}
