class TwoSum{
	public int[] twoSum(int[] nums, int target){
		if (nums == null || nums.length <= 1) return new int[]{};
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length-1;
		int ans = 0;
		while (i < j){
			int sum = nums[i]+ nums[j];
			if (sum < target){
				i++;
			} else if (sum > target){
				j--;
			} else {
				ans++;
				i++;
				j--;
				while (i < j && nums[i] == nums[i-1]){
					i++;
				}
				while (i < j && nums[j] == nums[j+1]){
					j--;
				}
			}
		}
		return ans;
	}
}