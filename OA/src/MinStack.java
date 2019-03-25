public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
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


    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minstack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minstack.peek();
        //find mini
    }
}
