package DP;
//you could remove cookie 1 or 3 at one time
//if n = 5 return the number of ways you could remove them uni
public class RemoveCookie {
    //using recursion
    public static int removeChocolate(int n){
        if (n == 1) return 1;
        if (n == 3) return 1;
        return removeChocolate(n-1) + removeChocolate(n-3);
    }
    //remove
    public static int removeChocolate1(int n){
        int ans = 0;
        if (n <= 1) return n;
        dfs(ans, n);
        return ans;
    }


    private static void dfs(int count, int remainNumber){
        if (remainNumber == 0) return;


    }
}
