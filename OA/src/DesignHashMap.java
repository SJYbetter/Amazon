import java.util.Arrays;

class ListNode {
    int key, val;
    ListNode next;

    ListNode(int key, int val) {
            this.key = key;
            this.val = val;
    }
}

class MyHashMap {
       final ListNode[] nodes = new ListNode[10000];

       public void put(int key, int value) {
            int i = hashFunction(key);
           //add a new (key, value) pair
            if (nodes[i] == null){
                nodes[i] = new ListNode(-1, -1);
            }


            ListNode prev = find(nodes[i], key);
            if (prev.next == null){
                prev.next = new ListNode(key, value);
            }

            else {
                prev.next.val = value;
            }
       }
        public int get(int key) {
            int i = hashFunction(key);
            if (nodes[i] == null) return -1;

            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = hashFunction(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        private int hashFunction(int key) {
            return Integer.hashCode(key) % nodes.length;
        }

        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }
}


//using an array to design
class MyHashMap1 {
    private int [] map;
    /** Initialize your data structure here. */
    public MyHashMap1() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int code = hashCode(key);
        map[code] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int code = hashCode(key);
        return map[code];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int code = hashCode(key);
        map[code] = -1;
    }

    private int hashFunction(int key) {
        return Integer.hashCode(key) % map.length;
    }
}
