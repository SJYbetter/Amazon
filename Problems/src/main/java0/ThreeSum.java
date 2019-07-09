import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
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

