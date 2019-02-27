import java.util.Collections;
import java.util.List;

public class TwoSumLessTarget {

	public static int[] twoSumLessTarget(int[] nums, int target) {
		int[] answer = new int[2];
		if (nums == null || nums.length == 0) return answer;
		Arrays.sort(nums);
		int left = 0, right = nums.length-1;
		int distance = Integer.MAX_VALUE;
		while (left < right){
			int current = nums[left] + nums[right];
			int diff = target - current;
			if (diff < distance && diff >= 0){
				distance = diff;
				answer[0] = nums[left];
				answer[1] = nums[right];
			}
			if (current < target) left ++;
			else right -;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
