/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

*/

public class{
    // return index
    public int firstUniqChar(String s){
        if (s == null || "".equals(s)) return 0;

        int[] charNum = int[26];

        for (char c : s.toCharArray()){
            charNum[c - 'a'] ++;
        }

        for (int i; i < s.length(); i++){
            if (s.charAt(i) == 1) return i;
        }
        return -1;
    }


    // return the char
    public char firstUniqChar(String str) {
        // Write your code here

        if (str == null || "".equals(str)) return (char) -1;

        char[] strArray = str.toCharArray();
        int[] times = new int[26];
        
        for (char c : strArray){
          times[c - 'a'] ++;
        }

        for (char c : strArray){
          if (times[c - 'a'] == 1) return c;
        }
        return (char) -1;
    }

}
