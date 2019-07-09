package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//1。 去重复

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++){
            //去重这一步真的很重要！！！
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int target = nums[i] * -1;
            int m = i+1, n = nums.length-1;
            while (m < n){
                if (nums[m] + nums[n] == target){
                    ans.add(Arrays.asList(nums[i], nums[m], nums[n]));
                    //避免重复答案，只有当找到了这个答案，才需要去重
                    while (nums[m] == nums[m+1] && m < n) m ++;
                    while (nums[n] == nums[n-1] && m < n) n ++;
                    m ++;
                    n --;
                }else if (nums[m] + nums[n] < target) {
                    m ++;
                }else{
                    n --;
                }
            }

        }
        return ans;
    }

    public void main(String[] args){

    }


}
