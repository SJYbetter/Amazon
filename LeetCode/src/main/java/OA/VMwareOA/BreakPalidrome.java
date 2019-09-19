package OA.VMwareOA;

public class BreakPalidrome {
    public static String breakPalindrom(String s){
        //只要检查一半就可以了
        if (s == null || "".equals(s)) return "IMPOSSIBLE";
        StringBuilder sb = new StringBuilder(s);
        int i;
        for (i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != 'a'){
                sb.setCharAt(i, 'a');
                break;
            }
        }
        if (i == s.length()/2){
            return "IMPOSSIBLE";
        }
        return sb.toString();
    }
}
