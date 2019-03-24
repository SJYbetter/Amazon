/*
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/


class Solution {
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
}
