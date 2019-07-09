class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[]{};
        int[] ans = new int[nums1.length];
        int i, j , next;

        for (i = 0; i < nums1.length; i++){
            next = -1;

            for (j = 0; j < nums2.length; j++){
                if (nums2[j] != nums1[i]) continue;
                else{
                    for (int k = j+1; k < nums2.length; k++){
                        //find it
                        if (nums2[k] > nums1[i]){
                            next = nums2[k];
                            break;
                        }
                    }
                }
            }
            ans[i] = next;
        }
        return ans;
    }
}
