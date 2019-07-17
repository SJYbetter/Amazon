package String;/*Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

*/

class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if ( s == null || "".equals(s)) return false;

        int i = 0, j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)) break;
            i ++;
            j --;
        }
        return check(s,i) || check(s,j);
    }


    private boolean check(String s, int k){
        int i = 0, j = s.length()-1;
        while (i < j){
            //pass index k
            if (i == k) i ++;
            if (j == k) j --;
            if (s.charAt(i) != s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args){


    }
}
