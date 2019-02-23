/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReHashing {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable.length <=0 ) return hashTable;

        int size = hashTable.length;
        int newSize = 2 * size;
        ListNode[] ans = new ListNode[newSize];

        for (int i = 0; i < size; i++){
            while (hashTable[i] != null){
                //if you directly calculate -4 % 3 you will get -1.
                //You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
                int newIndex = (hashTable[i].val % newSize + newSize) % newSize;
                if (ans[newIndex] == null){
                    ans[newIndex] = new ListNode(hashTable[i].val);
                }else{
                    ListNode dummy = ans[newIndex];
                    while (dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }

        }
        return ans;


    }
};
