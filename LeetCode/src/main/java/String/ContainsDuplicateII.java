package String;

import java.util.HashSet;
import java.util.Set;

//Given an array of integers and an integer k, 
//find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
//and the absolute difference between i and j is at most k.


class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}
