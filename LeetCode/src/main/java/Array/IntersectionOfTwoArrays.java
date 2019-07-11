package Array;
/*
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/


import java.util.*;

class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};
        List<Integer> ans = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        // find all unique number in nums1
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        //find overlap, if find, remove this number from the set, else continue
        for(int j = 0; j < nums2.length; j++){
            if (set.contains(nums2[j])){
                ans.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // change the output data stucture
        int[] res = new int[ans.size()];
        int index = 0;
        for (Integer i : ans){
            res[index++] = i;
        }
        return res;
     }

//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2,2]


    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};


        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1){
            // key is the number, value is the frequency of this number in the list
            map.put(i , map.getOrDefault(i, 0) + 1);
        }
        // go throuth the array
        for (int j : nums2){
            if (map.containsKey(j)){
                if(map.get(j) > 0){
                     list.add(j);
                    // update the value of this number in list1
                     map.put(j,map.get(j)-1);
                }

            }
        }

        // convert the arraylist to list
        int[] ans = new int[list.size()];
        // i is the index
        int i = 0;
        for (int k : list){
            ans[i++] = k;
        }
        return ans;

    }
}
