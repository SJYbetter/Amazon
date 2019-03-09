/*
Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
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
}
