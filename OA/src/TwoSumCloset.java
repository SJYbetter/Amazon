import java.util.Arrays;

public class TwoSumCloset {
	
    public int twoSumClosest(int[] nums, int target) {
        // corner case
        if(nums == null || nums.length < 2) return -1;
        Arrays.sort(nums);
         
        int left = 0, right = nums.length - 1;
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum <= target && target - sum < diff) {
                res[0] = nums[left];
                res[1] = nums[right];
            }
            if(sum < target) {
                //diff = Math.min(diff, target - sum);
                left++;
            }
            else
            {
                //diff = Math.min(diff, sum - target);
                right--;
            }
        }
        return res[0] + res[1];        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
