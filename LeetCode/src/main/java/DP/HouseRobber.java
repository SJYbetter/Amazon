package DP;

public class HouseRobber {
    private static int houseRobber(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums.length == 1 ? nums[0]:0;
        }

        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length+1; i ++){
            //stolen i or not
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int[] a = new int[]{2,7,9,3,1};
        System.out.println(houseRobber(a));

    }
}
