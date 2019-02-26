public class TwoSumCloset{
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
                    count += (len - j);
                    break;// end the second for loop
                }
            }
        }
        return count;
    }







}
