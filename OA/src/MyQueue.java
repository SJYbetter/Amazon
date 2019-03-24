/*
利用2个stack实现一个queue
注意empty（）方法
*/

class MyQueue {

    private Stack<Integer> stack1, stack2;


    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.push(x);
    }

    private void moveTo(){
        while (!stack2.empty()){
            stack1.push(stack2.peek());
            stack2.pop();
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.empty() == true){
            this.moveTo();
        }
        return stack1.pop();

    }

    /** Get the front element. */
    public int peek() {
        if (stack1.empty()){
            this.moveTo();
        }
        return stack1.peek();

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.size() == 0 && stack2.size() == 0;

    }
}


//using an ArrayList to implement a queue
public class MyQueue1{
    private int pointer;
    private List<Integer> list;

    public MyQueue1{
        pointer = 0;
        list = new ArrayList();
    }

    public void push(int x){
        list.add(x);
    }

    public void poll(){
        list.remove(list.get(list.size()-1));
    }

    public void top(){

    }
}
