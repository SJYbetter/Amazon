import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OA{
//返回substring有k个不同的char的个数，无论长度的限制
public static int countkDist(String str, int k){
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
            if(cnt == k) set.add(str.substring(left, right + 1));
        }
    }
    return set.size();
}


//return the count of substring of length K and exactly K distinct characters.
public static int KDistincKSize(String stringIn, int K){
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


//k长度 刚刚好k-1个不同的字符的子串
public List<String> subStringK1(String s, int k){
    if (s == null || "".equals(s) || k > 26) return new ArrayList<>();
    //key is the character, value is corresponding frequency
    Map<Character, Integer> lookup = new HashMap<Character, Integer>();
    //answer by using set to avoid depulicate
    List<String> answer = new ArrayList<>();

    for(int i = 0; i+k < s.length(); i++){
        String item = s.substring(i, i+k);
        int duplicateCount = 0;
        lookup.clear();
        for(char temp : item.toCharArray()){
            lookup.put(temp, lookup.getOrDefault(temp, 0)+1);
            if(lookup.getOrDefault(temp, 0) > 1){
                duplicateCount++;
                }
        }
        //check duplicate character
        if(duplicateCount == 1){
            answer.add(item);
            i += 1;
        }
     }
     return answer;
}

}



