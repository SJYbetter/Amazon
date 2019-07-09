public class Solution{

/*
using binary search
compare the first number with middle number, to decide the position of the breakpoint, if larger than middle number, the breakpoint is on the left side of middle, else on the right side of middle. Then using the binarySearch algorithm to do this.
*/
    public int searchRotatedArray(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;

        int s = 0, e = nums.length-1;
        while (s + 1 < e){
            int mid = s + (e-s)/2;
            if (nums[mid] == target) return mid;

            if (nums[s] < nums[mid]){
                if (nums[s] <= target && target <= nums[mid]) e = mid;
                else s = mid;
            }else{
                if (nums[mid] <= target && target <= nums[e]) s = mid;
                else e = mid;
            }
        }
        //end while loop check exit index s and e is target or not
        if (nums[s] == target) return s;
        if (nums[e] == target) return e;
        return -1;
    }
}
