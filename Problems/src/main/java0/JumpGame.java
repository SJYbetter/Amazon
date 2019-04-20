class Solution {

    //能不能跳到最后一个点
    public boolean canJump(int[] nums) {

        boolean[] check = new boolean[nums.length];
        check[0] = true;

        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                //can jump to index i
                if (check[j] == true && nums[j] + j >= i){
                    check[i] = true;
                }
            }
        }
        return check[nums.length-1];
    }


    //最少步数跳到最后一个点 Your goal is to reach the last index in the minimum number of jumps.
public int jump(int[] nums) {
    if (nums.length == 1) return 0;
    int count = 0;
    int i = 0;

    while (i + nums[i] < nums.length - 1) {
        int maxVal = 0;
        int maxValIndex = 0;
        for (int j = 1; j <= nums[i]; j++) {
            if (nums[j + i] + j > maxVal) {
                maxVal = nums[j + i] + j;
                maxValIndex = i + j;
            }
        }
        i = maxValIndex;
        count++;
    }
    return count + 1;
}
}
