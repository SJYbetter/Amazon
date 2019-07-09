package Array;

import java.util.HashMap;
import java.util.Map;

public class MiniWindowSubstring {
    public static String minWindow(String s, String t) {   
        //egde case
        if(s == null || t == null || "".equals(s) || "".equals(t)) return "";        
        // use map to track: for each distinct char in t, // key is the char, value is frequency       
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){            
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);            
        }

        // left: the starting index of result String
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        //count is to check valid t
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                //avoid count invalid character, aa count 2, but we meet another a later, the times is -1, but we don't need it
                if(map.get(cur) >= 0){
                    count ++;
                }//start move left pointer
                while(count == t.length()){
                    char temp = s.charAt(left);
                    //update the minLeft 
                    if(i - left + 1 < minLen){
                        minLeft = left;
                        minLen = i - left + 1;
                    }
                    //when move left, we need to avoid valid character be moved, 
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp) + 1);
                        if(map.get(temp) > 0){
                            count --;
                        }
                    }
                    left ++;
                }//end while
            }//end if, not contain target char get continue move
        }
        if(minLen > s.length()) return "";
        return s.substring(minLeft , minLen + minLeft);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "ADOBECODEBANC", T = "ABC";
		System.out.print(minWindow(S,T));

	}

}
