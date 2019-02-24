/*Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
Input: [9,6,4,2,3,5,7,0,1]
Output: 8


*/



class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] check = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++){
            check[nums[i]] = 1;
        }
        for (int j = 0; j < nums.length+1; j++){
            if (check[j] == 0) return j;
        }
        return -1;
    }
}
