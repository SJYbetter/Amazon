package DFS;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || "".equals(digits)) return ans;
        String[] letters = new String[]{",", ",", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, ans, letters, 0, new StringBuilder());
        return ans;
    }

    private void dfs(String D, List<String> ans, String[] letters, int index, StringBuilder sb){
        if (sb.length() == D.length()){
            ans.add(sb.toString());
        }

        for (int i = index; i < D.length(); i++){
            String num = letters[D.charAt(i) - '0'];
            for (int k = 0; k < num.length(); k++){
                int len = sb.length();
                sb.append(num.charAt(k));
                dfs(D, ans, letters, i+1, sb);
                //stringbuilder de 固定用法
                sb.setLength(len);
            }
        }
    }

}
