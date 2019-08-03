package String;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {
    public static List<String> restoreIP(String s){
        List<String> ans = new ArrayList<>();
        if (s.length() > 12) return ans;
        dfs(ans, s, new StringBuilder(), 0, 0);
        return ans;
    }

    private static void dfs(List<String> ans, String s, StringBuilder sb, int ipIndex, int sIndex){
        if (ipIndex > 4) return;
        if (sIndex == s.length() && ipIndex == 4){
            sb.setLength(sb.length()-1);
            ans.add(sb.toString());
            return;
        }
        int len = sb.length();
        for (int i = 0; i < 3; i++){
            if (len + i < s.length()){
                String subString = sb.substring(sIndex, sIndex+i+1);
                if (isValid(subString)){
                    sb.append(subString);
                    sb.append('.');
                    dfs(ans, s, sb, ipIndex+1, sIndex+i+1);
                    sb.setLength(len);
                }
            }
        }

    }

    private static boolean isValid(String s){
        if (s.charAt(0) == '0'){
            return s.equals("0");
        }
        int number = Integer.parseInt(s);
        return number > 0 && number <= 255;
    }

    public static void main(String[] args){
        String s = "25525511135";
        List<String> ans = restoreIP(s);
        System.out.println(ans);
    }
}
