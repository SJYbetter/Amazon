import java.util.Stack;

/*
Time complexity : O(n), N is the length of the given string..

Space complexity : O(n). The size of stack can go up to n.

*/



class LongestValidParentheses {
/* Instead of finding every possible string and checking its validity, we can make use of stack while scanning the given string to check if the string scanned so far is valid, and also the length of the longest valid string. In order to do so, we start by pushing -1 onto the stack.
For every ‘(’ encountered, we push its index onto the stack.
For every ‘)’ encountered, we pop the topmost element and subtract the current element's index from the top element of the stack, which gives the length of the currently encountered valid string of parentheses. If while popping the element, the stack becomes empty, we push the current element's index onto the stack. In this way, we keep on calculating the lengths of the valid substrings, and return the length of the longest valid string at the end.
*/
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

//R.T O(N), Space O(1)
public int longestValidParentheses1(String s) {
    //scan from left to right
    int left = 0, right = 0, maxlength = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            left++;
        } else {
            right++;
        }
        //balance, update the maxlength
        if (left == right) {
            maxlength = Math.max(maxlength, 2 * right);
            //only check the ')'
        } else if (right >= left) {
            left = right = 0;
        }
    }

    //scan from right to left
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '(') {
            left++;
        } else {
            right++;
        }
        if (left == right) {
            maxlength = Math.max(maxlength, 2 * left);

        }
        //only check the '('
        else if (left >= right) {
            left = right = 0;
        }
    }
    return maxlength;
   }
}
