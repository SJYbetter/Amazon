/*input: [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]


*/

public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: rotate the array to the right by k steps
     */
    public int[] rotate(int[] nums, int k) {
        // Write your code here
        // avoid the k maybe larger than the length of nums
        int K = k % nums.length;
        reverse(nums, 0, nums.length - K-1);
        reverse(nums, nums.length - K, nums.length-1);
        reverse(nums, 0, nums.length-1);
        return nums;
    }

    private void reverse(int[] nums, int s, int e){
        while (s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}
