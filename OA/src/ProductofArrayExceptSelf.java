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

        if (zeroNum > 1) return new int[nums.length];
        if (zeroNum == 0){
            for (int i = 0; i < nums.length; i++){
                nums[i] = product/nums[i];
            }
            return nums;
        }
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
}
