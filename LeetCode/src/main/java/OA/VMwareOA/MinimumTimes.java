package OA.VMwareOA;

import java.util.Arrays;

public class MinimumTimes {
    public static int minTimes(double[] bags){
        if (bags == null || bags.length == 0) return 0;
        Arrays.sort(bags);
        int i= 0, j = 0;
        int count = 0, weight = 0;
        while (i < bags.length){
            j = i;
            weight = 0;
            while (j < bags.length && weight + bags[j] <= 3){
                j ++;
                weight += bags[j];
            }
            i = j;
            count ++;
        }
        return count;
    }
}
