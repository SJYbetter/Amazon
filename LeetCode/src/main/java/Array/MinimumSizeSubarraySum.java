package Array;
//都是正数！
public class MinimumSizeSubarraySum {
    //O(n2)
    public int miniSizeSubarraySum(int[] nums, int k){
        if (nums == null || nums.length == 0) return 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++){
                sum += nums[j];
                if (sum >= k){
                    minLen = Math.min(j - i + 1, minLen);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }

    public int minSizeSubarraySum2(int[] nums, int k){
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0;
        int ans = 0;
        for (; i < nums.length; i++){
            while (j < nums.length){
                sum += nums[j];
                if (sum < k) j ++;
                else{
                    ans = Math.min(ans, j-i+1);
                    break;
                }
            }

        }
        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}
