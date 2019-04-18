import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //R.T O(N*N)
  
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            //edge case
            if (nums == null || nums.length == 0) return ans;
            //sort first then we could decide move the pointers
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++){
                //avoid the repeat number
                if (i == 0 || i > 0 && nums[i-1] != nums[i]){
                    int target = nums[i] * -1;
                    //two pointers
                    int start = i+1;
                    int end = nums.length-1;
                    while (start < end){
                        //case 1, find the target
                        if (nums[start] + nums[end] == target){
                            ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                            //check repeat start pointers
                            while (start < end && nums[start] == nums[start+1]){
                                start ++;
                            }
                            //check repeat of end pointer
                            while (start < end && nums[end] == nums[end-1]){
                                end --;
                            }
                            //update two pointers
                            start ++;
                            end --;
                        }
                        // case 2 : move start pointer
                        else if (nums[start] + nums[end] < target){
                            start ++;
                        }else{
                            //case 3: move end pointer
                            end --;
                        }
                    }
                }
            }
            return ans;
        }
    }



class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        //int ans;
        int diff = nums[0] + nums[1] + nums[nums.length-1];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++){
            //if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int cur = nums[i] + nums[l] + nums[r];
                if (Math.abs(cur - target) < Math.abs(diff - target)){
                    diff = cur;
                }
                if (cur == target){
                    return target;
                }
                if (cur < target){
                    l ++;
                }else{
                    r --;
                }
            }
        }
        return diff;
    }
}
