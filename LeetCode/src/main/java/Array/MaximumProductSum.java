package Array;

public class MaximumProductSum {
	public static int maxPro(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int max = nums[0], min = nums[0], ans = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0) {
				max = Math.max(max * nums[i], nums[i]);
				min = Math.min(min * nums[i], nums[i]);
			}else {
				int oldMax = max;
				max = Math.max(min * nums[i], nums[i]);
				min = Math.max(oldMax * nums[i], nums[i]);
			}
			
			ans = Math.max(max, ans);
		}		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,-5, 0, 100,-2,200};
		int[] nums1 = new int[] {-2,0, -5};
		
		System.out.println(maxPro(nums));
		System.out.println(maxPro(nums1));
	}

}
