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


//return the count of substring of length K and exactly K distinct characters.
	public int KDistincKSize(Stirng stringIn, int K){
		if (stringIn == null || "".equals(stringIn) || K<=0) return 0;

		Set<String> set = new HashSet<>();
        Set<Character> charSet = new HashSet<>();
        int j = 0;
        int len = stringIn.length();
        for (int i = 0; i <= len - K; i++) {
            while (j < len && charSet.size() < K) {
                char c = stringIn.charAt(j);
                if (charSet.contains(c)) {
                    break;
                }else{
					charSet.add(c);
	                j ++;
				}
                if (charSet.size() == K) {
                    set.add(stringIn.substring(i, j));
                }
            }
            charSet.remove(stringIn.charAt(i));
        }
        return set.size();
	}
}
