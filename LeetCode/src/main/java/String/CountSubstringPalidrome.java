package String;

//import java.util.Set;
import java.util.HashSet;
import java.util.Set;

public class CountSubstringPalidrome {
    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return -1;
        int ans = 0;
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < s.length(); i++){
            //one char is also a valid answer
            ans ++;
            for (int j = i+1; j < s.length(); j++){
                String sub = s.substring(i,j+1);
                if (check(sub) && !set.contains(sub)) {
                    set.add(sub);
                    ans ++;
                }
            }
        }
        return ans;
    }
    private static boolean check(String s){
        int left = 0, right = s.length()-1;
        //if (s.length == 1) return true;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    //考虑如果substring(i,j)如果是回文串，那么str[i]和str[j]一定相同，
    //并且一定满足以下两个条件之一 1.substring(i+1,j-1)也是回文串
    //2.j-i<=2，即substring(i,j)长度<=2   那么我们就只需要顺着这个思路dp就行了，复杂度O(n^2)
    public static int countSubstrings_dp(String str){
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
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abbai";
        System.out.println(countSubstrings(s));
    }

}

