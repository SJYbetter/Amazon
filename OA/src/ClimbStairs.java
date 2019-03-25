class Solution {
    public int climbStairs(int n) {
        //edge case
        if (n == 1) return 1;
        if (n == 2) return 2;
        //dp[i] indicate how many possible ways to reach ith stairs
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        //n => sum (n-1  ||  n-2)
        
        for (int i = 3; i < n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
