package OA.AirbnbOA;

public class candyDistribute {
    public static int candyNumber(int[] candies, int n){
        if (candies == null || candies.length == 0) return 0;

        int maxCandy = 0;
        for (int candy: candies){
            maxCandy = Math.max(candy, maxCandy);
        }

        int i = 1, j = maxCandy;
        while (i + 1 < j){
            int mid = i + (j - i)/2;
            if (getHours(candies, mid) <= n){
                //System.out.println(getHours(candies, mid));
                j = mid;
            }else{
                i = mid;
            }
        }

        if (getHours(candies, i) <= n) return i;
        if (getHours(candies, j) <= n) return j;
        return 0;
    }

    private static int getHours(int[] candies, int onceEatNumber){
        int hours = 0;
        for (int candy: candies){
            hours += candy / onceEatNumber;
            if (candy % onceEatNumber != 0){
                hours ++;
            }
        }
        return hours;
    }

    public static void main(String[] args){
        int[] cand = {4,9,11,17};
        System.out.println(candyNumber(cand, 8));
    }
}
