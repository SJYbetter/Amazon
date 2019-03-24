/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/


class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count ++;
            }else {
                set.add(s.charAt(i));
            }
        }
        //odd number
        if(set.size() > 0) count = count * 2 + 1;
        
        else count = count * 2;
        return count;
    }
}
