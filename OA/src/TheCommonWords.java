import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TheCommonWords {

	 public static String mostCommonWord(String paragraph, String[] banned) {
		    //edge case
			if (paragraph == null || "".equals(paragraph)) return ""; 


	        // use set to check the paragraph whether include the key word
	        Set<String> set = new HashSet<>(Arrays.asList(banned));
	        // use a map to store the word and it's frequency
	        Map<String, Integer> map = new HashMap<>();

	        // regex expression, replaceAll none words with empty string and split it
	        String[] words = paragraph.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");

	        for (String w : words){
	            if (set.contains(w)) continue;
	            map.put(w, map.getOrDefault(w, 0)+1);
	        }
	        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "I love you, and you love me? I really love love love";
		String[] ban = new String[] {"love"};
		System.out.print(mostCommonWord(p, ban));

	}

}
