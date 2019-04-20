/*
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
*/

class Solution{
    public int longestSubstring(String s){
         if (s == null || "".equals(s)) return 0;
         int len = s.length();
         Map<Character, Integer> map = new HashMap<>();
         int i = 0;
         int ans = 0;
         for (int j = 0; j < len; j++) {
             if(map.containsKey(s.charAt(j))){
                 //update the i
                 i = Math.max(map.get(s.charAt(j)) , i);
                 //i = j;
             }
             //update the answer
             ans = Math.max(ans, j - i + 1);
             //update map
             map.put(s.charAt(j) , j + 1);
         }
         return ans;
    }



    public int longestSubstring1(String s){
        if (s == null || "".equals(s)) return 0;

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }else{
                //contains which means we need remove from i poniters
                set.remove(s.charAt(i));
                i ++;
            }

        }
        return max;
    }
}
