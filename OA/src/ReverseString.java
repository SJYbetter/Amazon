//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]


class Solution {
    public void reverseString(char[] s) {
        // edge case
        if (s == null || s.length == 0) return;
        // using two pointers to track
        int start = 0, end = s.length-1;
        // in place to loop
        while (start + 1 <= end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }

        return;
    }
}
