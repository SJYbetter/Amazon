/*
利用2个stack实现一个queue
注意empty（）方法
*/

public class MyQueue{
        //注意类型
        private Stack<Integer> s1, s2;

        public MyQueue{
                s1 = new Stack<Integer>();
                s2 = new Stack<Integer>();
        }
        //取stack的最底下元素，要先把一个stack的元素移动到另外一个stack
        private void moveTo(){
                while (!s2.empty()){
                        s1.push(s2.peek());
                        s2.pop();
                }
        }
        public void push(int x){
                s2.push(x);
        }

        public int pop(int x){
                while (s1.empty() == true){
                        this.moveTo();
                }
                return s1.pop();

        }

        public int top(){
                while (s1.empty() == true){
                        this.moveTo();
                }
                return s1.peek();
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
