package OA.VMwareOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildSubSequence {
    private static List<String> buildSubsequences(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return ans;
        }
        build(s, 0, "", ans);
        Collections.sort(ans);
        return ans;
    }

    private static void build(String s, int i, String acc, List<String> ans) {
        if (!acc.isEmpty()) {ans.add(acc);}
        for (int j = i; j < s.length(); j++) {
            build(s, j + 1, acc + s.charAt(j), ans);
        }
    }

    public static void main(String[] args){
        List<String> subsequences = buildSubsequences("xyz");
        for (String word: subsequences){
            System.out.println(word);
        }
    }

}
