package Array;

import java.util.Arrays;

public class TwoSumClosetToTarget{
    //最接近的值是输出
    public int twoSumClosetTarget(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;

        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        int DIF = Integer.MAX_VALUE;

        while (start < end){
            if (nums[start] + nums[end] < target){
                DIF = Math.min(DIF, target - nums[start] - nums[end]);
                start ++;
            }
            else if (nums[start] + nums[end] > target){
                DIF = Math.min(DIF, nums[start] + nums[end] - target);
                end --;
            }
            else return 0;
        }
        return DIF;
    }


    //返回有多少组pair相加大于target的
    public int twoSumGreaterTarget(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;
        int count = 0;

        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] > target){
                    // if we could find one larger than the larget, then the next part is must larger than the target
                    count += (nums.length - j);
                    break;// end the second for loop
                }
            }
        }
        return count;
    }


    //小于等于target的pair输出有多少对
    public int twoSumSmallerEqualTarget(int[] nums, int target) {
        // write your code here
        if (nums == null) return -1;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length-1; i++){
            for (int j = i+1; j < nums.length; j++){
                if (nums[i] + nums[j] <= target){
                    count ++;
                }
            }
        }
        return count;
    }

}
