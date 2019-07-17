package Design;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }
    private void addNode(DLinkedNode node){
        node.pre = head;
        node.next = head.next;

        head.next = node;
        head.next.pre = node;
    }
    private void removeNode(DLinkedNode node){
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail(){
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        this.moveToHead(node);
        return node.value;
        }


    public void put(int key, int value) {
        DLinkedNode newNode = cache.get(key);
        newNode.key = key;
        newNode.value = value;
        this.cache.put(key, newNode);
        ++count;
        if (count > capacity){
            DLinkedNode tail = this.popTail();
            this.cache.remove(tail.key);
            --count;
        }else{
            newNode.value = value;
            newNode.key = key;
        }
    }
}
/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
