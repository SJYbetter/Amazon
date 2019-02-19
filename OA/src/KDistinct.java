import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDistinct {
	
	
    public int countkDist(String str, int k){
        //corner case
        if(str == null || str.length() < k || k > 26) return 0;
        // HashSet to avoid duplicate substring, HashMap to store chars in tmp string
        Set<String> set = new HashSet<>();

        for(int left = 0; left < str.length() - k + 1; left++) {
            Map<Character, Integer> chars = new HashMap<>();
            int cnt = 0;
            for(int right = left; right < str.length(); right++) {
                char add = str.charAt(right);
                if(!chars.containsKey(add)) {
                    cnt++;
                }
                chars.put(add, chars.getOrDefault(add, 0) + 1);
                if(cnt == k)
                    set.add(str.substring(left, right + 1));
            }
        }
        return set.size();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
