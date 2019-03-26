class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int product = 1, zeroIndex = 0, zeroNum = 0;
        //first loop to track zero number and product
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                zeroNum ++;
                zeroIndex = i;
            }else{
                product *= nums[i];
            }
        }
        //case 1, more than two zeros
        if (zeroNum > 1) return new int[nums.length];
        //case 2, no zeros
        if (zeroNum == 0){
            for (int i = 0; i < nums.length; i++){
                nums[i] = product/nums[i];
            }
            return nums;
        }
        //case 3, only one zero
        if (zeroNum == 1){
            int pro = 1;
            for (int i = 0; i < zeroIndex; i++){
                pro *= nums[i];
                nums[i] = 0;

            }
            for (int j = zeroIndex+1; j < nums.length; j++){
                pro *= nums[j];
                nums[j] = 0; // cannot set 0 first, should set the product first
            }
            nums[zeroIndex] = pro;
            return nums;
        }
        return new int[0];
    }

//dp solution
public int[] productExceptSelf1(int[] nums) {

    int[] result = new int[nums.length];
    for (int i = 0, tmp = 1; i < nums.length; i++) {
        result[i] = tmp;
        tmp *= nums[i];
    }
    for (int i = nums.length - 1, tmp = 1; i >= 0; i--) {
        result[i] *= tmp;
        tmp *= nums[i];
    }
    return result;
}
}
