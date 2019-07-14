package Array;

import java.util.Random;

public class RandomPickIndex {
    Random random = new Random();

    public int randomPickIndex(int[] nums, int target){
        int ans = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != target) continue;
            if (random.nextInt(++ count) == 0){
                ans = i;
            }
        }
        return ans;
    }
}
//
