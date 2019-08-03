package String;//Input: ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]


class ReverseString {
    public void reverseString(char[] s) {
        // edge case
        if (s == null || s.length == 0) return;
        // using two pointers to track
        int start = 0, end = s.length-1;
        // in place to loop
        while (start + 1 <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }

//input 是一个string 而且有空格
public String reverseString(String s) {
    // write your code here
    if (s == null || "".equals(s)) return "";

    StringBuilder sb = new StringBuilder();

    for (int i = s.length()-1; i >= 0; i --){
        if (s.charAt(i) == ' ') continue;
        sb.append(s.charAt(i));
    }
    return sb.toString();
   }
}
