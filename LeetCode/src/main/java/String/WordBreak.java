package String;

import java.util.Set;

public class WordBreak {
    //R.T O(n^2) where n is the length of string s
    //DP
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here

        if (s == null || "".equals(s)) return true;
        boolean[] bs = new boolean[s.length() + 1];
        bs[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (bs[j] && dict.contains(s.substring(j, i))) {
                    bs[i] = true;
                    break;
                }
            }
        }
        return bs[s.length()];
    }
}
