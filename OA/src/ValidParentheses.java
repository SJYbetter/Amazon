public class ValidParentheses {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
       if (s == null || "".equals(s)) return true;
       if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            //previous is valid part
            if (stack.isEmpty()){
                stack.push(helper(s.charAt(i)));
            }
            //find one pair which is valid
            else if (stack.peek() == s.charAt(i)){
                stack.pop();
            }
            //keep moving
            else{
                stack.push(helper(s.charAt(i)));
            }

        }
        //if it's valid, must be an empty stack
        return stack.size() == 0;
    }
    private char helper(Character c){
        switch (c){
            case '[' : c = ']'; break;
            case '{' : c = '}'; break;
            case '(' : c = ')'; break;
        }
        return c;
    }
}
