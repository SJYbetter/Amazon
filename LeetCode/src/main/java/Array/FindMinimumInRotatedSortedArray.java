
public class FindMinimumInRotatedSortedArray {
	//binary search 
	public static int findMin(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		int left = 0, right = nums.length-1;
		
		while (left < right) {
			int mid = left + (right - left)/2;
			if (nums[mid] < nums[right]) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {5,6,1,2,3,4};
		int[] num1 = new int[] {};
		System.out.println(findMin(num));
		System.out.println(findMin(num1));

	}

}
