import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSumLessTarget {

	public static int[] twoSumLessTarget(int[] nums, int target) {
		int[] answer = new int[2];
		if (nums == null || nums.length == 0) return answer;
		// sort first then we could decide to move left pointer or right pointer
		Arrays.sort(nums);
		//use two pointers to go through this array
		int left = 0, right = nums.length-1;
		int distance = Integer.MAX_VALUE;
		while (left < right){
			int current = nums[left] + nums[right];
			//cureent_diff is to calculate the distance between target and the sum of two pointers
			int cureent_diff = target - current;
			//less than the target so make sure
			if (cureent_diff  < distance && cureent_diff >= 0){
				//update  distance and answer
				distance = cureent_diff ;
				answer[0] = nums[left];
				answer[1] = nums[right];
			}
			if (current < target) left ++;
			else right --;
		}
		return answer;
	}



    //找到2个array里最接近的pair
	public static int[] twoSumLessTarget2(int[] nums1, int[] nums2, int target){
		int[] answer = new int[2];
		if (nums1 == null || nums2 == null) return answer;
		int len1 = nums1.length, len2 = nums2.length;
		int p1 = 0, p2 = len2-1;
		int DIFF = Integer.MAX_VALUE;

		while (p1 < len1 && p2 >=0){
			int cur_sum = nums1[p1] + nums2[p2];
			int cur_diff = target - cur_sum;
			if (cur_diff < DIFF && cur_diff >= 0){
				DIFF = cur_diff;
				answer[0] = nums1[p1];
				answer[1] = nums2[p2];
			}
			if (cur_sum < target) p1 ++;
			else p2 --;
		}
		return answer;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {1,2,3,9,3,5,9,10};
        int[] ans = twoSumLessTarget(arr, 7);
        for (Integer i: ans) {
        	System.out.println(i);
        }
	}

}
