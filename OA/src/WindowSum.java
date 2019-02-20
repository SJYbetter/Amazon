
public class WindowSum {
	/*定义sum数组，长度为nums.length - k + 1
	先计算出前 k 个元素之和
	然后循环遍历数组减去头部元素加上尾部元素

	*/	
	public static int[] winSum(int[] nums, int k) {
		if (nums == null || nums.length < k || k == 0) return new int[0];
		int[] sums = new int[nums.length-k+1];
		
		for (int i = 0; i < k; i++) {
			sums[0] += nums[i];
		}
		
		for (int j = 1; j < sums.length; j++) {
			sums[j] = sums[j-1] - nums[j-1] + nums[j+k-1];
		}
		return sums;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,7,8,5};
		System.out.println(winSum(nums, 3));

    }
}
