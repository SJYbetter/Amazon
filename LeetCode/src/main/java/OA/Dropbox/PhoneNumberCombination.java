package OA.Dropbox;
/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.
 */

import DS.Trie;

import java.util.*;

public class PhoneNumberCombination {
    Trie root = new Trie();

    public static List<String> letterCombinations(String digits, Set<String> dictionary) {
        List<String> ans = new ArrayList<>();
        if (digits == null || "".equals(digits)) return ans;
        String[] letters = new String[]{",", ",", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, ans, letters, 0, new StringBuilder(), dictionary);
        return ans;
    }

    private static void dfs(String D, List<String> ans, String[] map,
                            int index, StringBuilder sb, Set<String> dict){
        if (index > D.length()) return;
        if (sb.length() == D.length()){
            if (dict.contains(sb.toString())){
                ans.add(sb.toString());
            }
            return;
        }
        for (int i = index; i < D.length(); i++){
            char c = D.charAt(i);
            for (char k : map[c - '0'].toCharArray()){
                int len = sb.length();
                sb.append(k);
                dfs(D, ans, map, i+1, sb, dict);
                sb.setLength(len);
            }
        }
    }


    public static void main(String[] args){
        Set<String> set = new HashSet<>(Arrays.asList("aa","ba", "bavv"));
        List<String> ans = letterCombinations("22", set);
        for (String s: ans){
            System.out.println(s);
        }
    }
}
