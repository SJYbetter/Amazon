public class Solution{

    //this solution is very time consuming
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            //one char is also a valid answer
            ans ++;
            for (int j = i+1; j < s.length(); j++){
                if (check(s.substring(i,j+1)) == true) ans++;
            }
        }
        return ans;
    }


    private boolean check(String s){
        int left = 0, right = s.length()-1;
        //if (s.length == 1) return true;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

//
    public int countSubstrings_dp(String s){
        int n = str.length();
        int ans = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {

            for (int j = 0; j <= i; ++j) {

                dp[j][i] = ( (str.charAt (j) == str.charAt (i)) && (i - j <= 2 || dp[j + 1][i - 1] == 1)) ? 1 : 0;
                ans += dp[j][i];
    }
}
return ans;
    }
}
