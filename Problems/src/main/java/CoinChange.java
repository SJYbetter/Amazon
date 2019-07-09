import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private static int helper(int[] coins, int rem, int[] count) {
        // rem: remaining coins after the last step;
        // count[rem]: minimum number of coins to sum up to rem

        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (count[rem - 1] != 0) return count[rem - 1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    //  Bottom up helper O(S*n) O(S)
    public static int coinChangeBU(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(dayOfWeek(2019));

    }

    }
}
