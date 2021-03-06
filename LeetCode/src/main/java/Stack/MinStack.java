package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;

    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        helper(number);
    }

    private void helper(int x){
        int tempMin = minstack.isEmpty() ? Integer.MAX_VALUE : minstack.peek();
        if (x < tempMin){
            tempMin  = x;
        }
        stack.push(x);
        minstack.push(tempMin);
    }


    public int pop() {
        // write your code here
        minstack.pop();
        return stack.pop();
    }


    public int min() {
        // write your code here
        return minstack.peek();
        //find mini
    }
}

//利用一个ArrayList
class MinStack1 {

    private List<Integer> array;
    /** initialize your data structure here. */
    public MinStack1() {
        array = new ArrayList<>();
    }
    public void push(int x) {
        array.add(x);
    }

    public void pop() {
        array.remove(array.size()-1);
    }

    public int top() {
        return array.get(array.size()-1);
    }

    public int getMin() {
        return Collections.min(array);
    }
}
