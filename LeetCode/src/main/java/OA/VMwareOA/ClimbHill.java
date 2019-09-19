package OA.VMwareOA;

import java.util.Arrays;
import java.util.Map;

public class ClimbHill {

    public static int climbHill(int[] slope){
        if (slope == null || slope.length == 0) return 0;
        int[] reverse = slope.clone();
        int i = 0, j = slope.length-1;
        while (i < j){
            int temp = reverse[i];
            reverse[i] = reverse[j];
            reverse[j] = temp;
            i ++;
            j --;
        }

        int nonDescending = climbHillHelper(slope);

        int nonIncreasing = climbHillHelper(reverse);
        System.out.println(nonDescending);
        System.out.println(nonIncreasing);
        return Math.min(nonDescending, nonIncreasing);
    }

    public static int climbHillHelper(int[] slope){
        int len = slope.length;
        int[][] dp = new int[len+1][len+1];
        int[] slope1 = slope.clone();
        Arrays.sort(slope1);
        dp[1][1] = Math.abs(slope[0] - slope1[0]);

        for (int i = 1; i < len+1; i++){
            if (i > 1){
                dp[1][i] = Math.min(dp[1][i-1], Math.abs(slope[0] - slope1[i-1]));
            }
        }

        for (int j = 1; j < len+1; j++){
            if (j > 1){
                dp[j][1] = dp[j-1][1] + Math.abs(slope[j-1] - slope1[0]);
            }
        }

        for (int k = 2; k < len+1; k ++){
            for (int m = 2; m < len+1; m++){
                dp[k][m] = Math.min(dp[k][m-1], dp[k-1][m] + Math.abs(slope[k-1] - slope1[m-1]));
            }
        }
        return dp[len][len];

    }

    public static void main(String[] args){
        int[] test = {6, 9, 8, 7, 2, 3, 3};
        int ans = climbHill(test);
        System.out.println(ans);
    }


}
