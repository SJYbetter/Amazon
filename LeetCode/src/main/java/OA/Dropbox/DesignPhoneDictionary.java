package OA.Dropbox;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DesignPhoneDictionary {

    Queue<Integer> queue;
    Set<Integer> set;

    public DesignPhoneDictionary(int maxNumber){
        queue = new LinkedList<>();
        set = new HashSet<>();
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
        if (set.contains(num)) return false;
        return true;

    }


    public void release(int num){
        if (!set.contains(num)) return;
        set.remove(num);
        queue.offer(num);


    }


}
