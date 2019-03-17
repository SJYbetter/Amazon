public class Solution{
    public int lastZero(int[] nums){
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length -1;
        while (left + 1 < right){
            int mid = (left + right)/2;
            if (nums[mid] == 1) right = mid-1;
            else (nums[mid] == 0) left = mid;
        }
        return left;
    }
}
