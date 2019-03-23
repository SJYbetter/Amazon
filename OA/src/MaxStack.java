public class MaxStack{

    Stack<Integer> stack;    //[1,3,1,4,2]
    Stack<Integer> maxstack; //[1,3,3,4,4]
    public MaxStack(){
        stack = new Stack<>();
        maxstack = new Stack<>();
    }

    public void push(int x){
        pushHelper(x);
    }

    private void pushHelper(int x){
        int tempMax = maxstack.isEmpty() ? Integer.MIN_VALUE : maxstack.peek();
        if (x > tempMax){
            tempMax = x;
        }
        stack.push(x);
        maxstack.push(tempMax);
    }

    public int pop(){
        maxstack.pop();
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int popMax(){
        int max = maxstack.peek();
        Stack<Integer> temp = new Stack<>();
        while (stack.peek != max){
            temp.push(stack.pop());
            maxstack.pop();
        }
        //find the max in Stack
        stack.pop();
        maxstack.pop();
        while (!temp.isEmpty()){
            int x = temp.pop();
            pushHelper(x);
        }
        return max;
    }
    public int peekMax(){
        return maxstack.peek();
    }
}
