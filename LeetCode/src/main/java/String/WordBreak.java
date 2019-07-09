import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        //edge case
        if (s == null || "".equals(s)) return false;
        //change to dict easy for search
        Set<String> dict = new HashSet<String>(wordDict);
        
        boolean[] check = new boolean[s.length()+1];
        check[0] = true;
        
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                String remain = s.substring(j, i);
                if (check[j] && dict.contains(remain)){
                    check[i] = true;
                    break;
                }
            }
        }
        return check[s.length()];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
