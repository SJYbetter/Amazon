
public class maximumSubarray {
	//dp solution
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		
		for (int i = 0; i < nums.length; i ++) {
			dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
			max = Math.max(dp[i], max);		
		}
		return max;
	}
	//prefix sum
	public static int maxSubarray_2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int[] prefixSum = new int[nums.length+1];
		prefixSum[0] = 0;
		
		for (int i = 1; i <= nums.length; i++) {
			prefixSum[i] = prefixSum[i-1] + nums[i-1];
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < prefixSum.length; i++) {
			for (int j = i + 1; j < prefixSum.length; j ++) {
				int diff = prefixSum[j] - prefixSum[i];
				max = Math.max(diff, max);
			}
		}
		return max;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
