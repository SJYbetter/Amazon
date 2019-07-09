/*
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/


class Solution {
    public void mergeSort(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) return;

        int i = m-1, j = n-1, idx = m+n-1;

        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[idx--] = nums1[i--];
            }else{
                nums1[idx--] = nums2[j--];
            }
        }
        // nums1 has remaining numbers which need to merge
        while (i >= 0){
            nums1[idx--] = nums1[i--];
        }
        // nums2 has remianing numbers which need to merge
        while (j >= 0){
            nums1[idx--] = nums2[j--];
        }

    }
}
