import java.util.Arrays;

class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        //int ans;
        int diff = nums[0] + nums[1] + nums[nums.length-1];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
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
