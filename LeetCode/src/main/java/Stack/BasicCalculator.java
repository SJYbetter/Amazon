import java.util.Stack;

// 3 + 2 * 2 //All intermediate results will be in the range of [-2147483648, 2147483647].
public class BasicCalculator {
    public static int calculate(String s) {
    if (s == null || s.length() == 0) return 0;
    int len = s.length();
    //store previous results
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    boolean numberSeen = false;
    
    for(int i = 0;i < len; i ++){
    	//change char to num "18"
        if(Character.isDigit(s.charAt(i))){
            num = num * 10 + s.charAt(i)-'0';   
            numberSeen = true;
        }
        //not digit, not letter, not empty space
        if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) && !Character.isLetter(s.charAt(i)) || i==len-1){
        	if (numberSeen == false) {
        		throw new IllegalArgumentException("invalid expression");
        	}
            if(sign=='-'){
                stack.push(-num);
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                if (num == 0){
                	throw new ArithmeticException("divider cannot be zero");
                }
                stack.push(stack.pop()/num);
            }
            //update sign for next operation
            sign = s.charAt(i);            
            //reset the num
            num = 0;
            numberSeen = false;
        }
       
    }

    int sum = 0;
    for(int i:stack){
        sum += i;
    }
    return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "  1  + 128 +  100 ";
       System.out.println("ans:" + calculate(s));
	}

}
