package Design;

public class DesignCircularQueue {
    private int front = 0, rear = -1;
    private int len = 0;
    private int capacity;
    private int[] arr;
    public DesignCircularQueue(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public boolean enQueue(int val){
        if (!isFull()){
            rear = (rear+1) % arr.length;
            arr[rear] = val;
            len ++;
            return true;

        }
        return false;
    }

    public boolean deQueue(){
        if (!isEmpty()){
            front = (front+1) % arr.length;
            len --;
            return true;
        }
        return false;

    }

    public boolean isFull(){
        return len == capacity;
    }

    public boolean isEmpty(){
        return len == 0;
    }

    public int getFront(){
        return isEmpty()? -1 : arr[front];
    }

    public int getRear(){
        return isFull()? -1 : arr[rear];
    }
}
