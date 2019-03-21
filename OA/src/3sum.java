class Solution {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) return ans;
            //sort first then we could decide move the pointers
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++){
                //avoid the repeat number
                if (i == 0 || i > 0 && nums[i-1] != nums[i]){
                    int start = i+1;
                    int end = nums.length-1;
                    int target = nums[i] * -1;
                    while (start < end){
                        if (nums[start] + nums[end] == target){
                            ans.add(Arrays.asList(nums[i], nums[start], nums[end]));

                            while (start < end && nums[start] == nums[start+1]){
                                start ++;
                            }
                            while (start < end && nums[end] == nums[end-1]){
                                end --;
                            }
                            start ++;
                            end --;
                        }
                        //move start point
                        else if (nums[start] + nums[end] < target){
                            start ++;
                        }else{
                            end --;
                        }


                    }
                }

            }
            return ans;


        }
    }
}
