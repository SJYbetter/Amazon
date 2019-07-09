package Array;

public class MergeSort {

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
	public int[] mergeSort(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		int[] ans = new int[len1 + len2];
		int i = 0, j = 0, index = 0;
		while (i <= len1 && j <= len2) {
			if (nums1[i] < nums2[j]) {
				ans[index] = nums1[i];
				index ++;
				i ++;
			}else {
				ans[index] = nums2[j];
				index ++;
				j ++;
			}
		}
		while (i <= len1) {
			ans[index ++] = nums1[i ++];
		}
		while (j <= len2) {
			ans[index ++] = nums2[j ++];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
