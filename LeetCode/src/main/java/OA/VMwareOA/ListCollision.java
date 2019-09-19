package OA.VMwareOA;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ListCollision {
    public static int listCollision(List<Integer> nums){
        if (nums == null || nums.size() == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b-a));
        for (int num: nums){
            maxHeap.offer(num);
        }

        while (maxHeap.size() > 1){
            int big = maxHeap.poll();
            int small = maxHeap.poll();
            if (big != small){
                maxHeap.offer(big - small);
            }
            System.out.println(big + " " + small);
        }
        if (maxHeap.size() == 0) return 0;
        return maxHeap.peek();

    }


    public static void main(String[] args){
        int[] test = {10,10,5,10,2,1};
        //List<Integer> ans = test.asList();
        //int peek = listCollision(test);

    }

}
