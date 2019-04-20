import java.util.Arrays;

class FindTheDuplicateNumber {
	
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
