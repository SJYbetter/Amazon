/*
Input: ["2", "1", "+", "3", "*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9
*/

public class EvaluateReversePolishNotation{
    public static int evlRPN(String[] tokens){
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int a, b;

        for (String s : tokens){
            if (s == "+"){
                stack.push(stack.poll() + stack.poll());
            }
            if (s == "*"){
                stack.push(stack.poll() * stack.poll());
            }

            if (s == "/"){
                a = stack.poll();
                b = stack.poll();
                stack.push(b/a);
            }

            if (s == '-'){
                a = stack.poll();
                b = stack.poll();
                stack.push(b - a);
            }
            else{
                //change to int data type
                stack.push(Integer.parseInt(s));
            }

        }

        return stack.peek();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String tokens = new String[]{"1", "2", "*"};
        System.out.println(evlRPN(tokens));

    }
}