package OA;

public class VMWareOA {

    public static int teamFormation2(int[] skills, int k, int lower, int upper){
        int candiate = 0;
        for (int i: skills){
            if (i >= lower && i <= upper){
                candiate ++;
            }
        }

        if (candiate < k) return 0;
        int teamNum = 0;
        for (int i = k; i <= candiate; i ++){
            teamNum += helper(i, candiate);
        }
        return teamNum;
    }
    //return the number select k people from all people
    private static int helper(int k, int all){
        if (k == all) return 1;
        int ans = 1;
        for (int i = all; i > (all-k); i --){
            ans *= i;
        }
        for (int i = 1; i <= k; i ++){
            ans /= i;
        }
        System.out.println("k is" + k + "all is" + all + "ans is" + ans);
        return ans;
    }

    public static void main(String[] args){
        int[] skills = {12, 4, 6, 13, 5, 10};
        System.out.println(teamFormation2(skills, 3, 4, 10));
    }
}
