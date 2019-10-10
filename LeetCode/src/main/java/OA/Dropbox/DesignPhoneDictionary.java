package OA.Dropbox;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
// Time: O(1) Space: O(n)
public class DesignPhoneDictionary {

    Queue<Integer> queue;
    Set<Integer> set;
    final int maxNumber;

    public DesignPhoneDictionary(int maxNumber){
        this.maxNumber = maxNumber;
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
        for (int i = 0; i < maxNumber; i ++){
            queue.offer(i);
        }
    }

    public int get(){
        if (queue.isEmpty()) return -1;
        int num = queue.poll();
        set.add(num);
        return num;

    }

    public boolean check(int num){
        if (num < 0 || num >= maxNumber) return false;
        //this number is already used
        if (set.contains(num)) return false;
        return true;
    }


    public void release(int num){
        if (!set.contains(num)) return;
        set.remove(num);
        queue.offer(num);
    }


}
