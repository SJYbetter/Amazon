package String;
/*
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
*/

public class WildcardMatching {
    static boolean[][] memo;
    static boolean[][] visited;
    public static boolean isMatch(String s, String p) {
        if (p == null || "".equals(p)) return false;
        int m = s.length(), n = p.length();
        memo = new boolean[m][n];
        visited = new boolean[m][n];
        return helper(s, 0, p, 0);
    }

    private static boolean helper(String s, int sIndex, String p, int pIndex){
        if (sIndex == s.length()){
            return isAllStar(p, pIndex);
        }
        if (pIndex == p.length()){
            return s.length() == sIndex;
        }

        if (visited[sIndex][pIndex]){
            return memo[sIndex][pIndex];
        }


        char charS = s.charAt(sIndex);
        char charP = p.charAt(pIndex);
        boolean match = false;
        if (charP == '*'){
            match = helper(s, sIndex, p, pIndex+1) || helper(s, sIndex+1, p, pIndex);
        }else{
            match = isOneCharMatch(charS, charP) && helper(s, sIndex+1, p, pIndex+1);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private static boolean isAllStar(String p, int pIndex){
        for (int i = pIndex; i < p.length(); i ++){
            if (p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }

    private static boolean isOneCharMatch(char s, char p){
        return p == '?' || s == p;
    }

    public static void main(String[] args){
        System.out.println(isMatch("a", "*"));
    }
}
