import java.math.BigInteger;
import java.util.EmptyStackException;
import java.util.Stack;
public class EvalRPN {	
	/*The Reverse Polish Notation is a stack of operations, thus, I decided to use Stack to solve this problem.
	 *  We add every token as an integer in the stack, unless it's an operation. 
	 *  In that case, I pop two elements from the stack and then save the result back to it. 
	 *  After all operations are done through, the remaining element in the stack will be the result.
	 */
	private static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;       
        int a,b;
      //check if there is at least two numbers can be popped out from the stack
		Stack<Integer> stack = new Stack<Integer>();
		try {
			for (String s : tokens) {
				if(s.equals("+")) {
					stack.push(stack.pop() + stack.pop());
				}
				else if(s.equals("/")) {
					b = stack.pop();
					a = stack.pop();
					//divide by zero
					//b == BigInteger.ZERO;
				    if (b == 0) {
				    	throw new ArithmeticException("divider cannot be zero");
				    }
					stack.push(a / b);
				}
				else if(s.equals("*")) {
					//stack over flow 
					stack.push(stack.pop() * stack.pop());
				}
				else if(s.equals("-")) {
					b = stack.pop();
					a = stack.pop();
					stack.push(a - b);
				}
				else {
	                //change data type
					stack.push(Integer.parseInt(s));
				}
			}
			return stack.pop();	
		}catch(EmptyStackException e) {
			System.err.println("invalid expression");
		}catch(ArithmeticException e) {
			System.err.println("divider cannot be zero");
		}catch(NumberFormatException e) {
			System.err.println("invalid expression");
		}
		return Integer.MAX_VALUE;
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] tokens = {"2", "5", "+", "3", "*"};
		System.out.print(evalRPN(tokens));

	}

}
