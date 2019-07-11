package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNumber {
    public int[] nextGreaterNumber(int[] nums1, int[] nums2){
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        int[] ans = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            while (!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
    
}
