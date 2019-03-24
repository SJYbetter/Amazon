class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int len = nums.length;
        //last three numbers
        int max1 = nums[len-1] * nums[len-2] * nums[len-3];
        //first two number ans last number
        int max2 = nums[0] * nums[1] * nums[len-1];

        return Math.max(max1, max2);
    }
}
