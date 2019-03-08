/*
Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

*/
//using two pointers, one from the left, and another from the right
public int[] twoSum_sorted(int[] numbers, int target) {
    int i = 0, j = numbers.length-1;

    while (i < j){
        if (numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};
        if (numbers[i] + numbers[j] < target) i++;
        if (numbers[i] + numbers[j] > target) j--;
    }
    return new int[]{};
}

//R.T O(n^2) using two pointers
public int[] twoSum_unsorted(int[] nums, int target){
    if (nums == null || nums.length == 0) return new int[]{};

    for (int i = 0; i < nums.length-1; i++){
        for (int j = i+1; j < nums.length; j++){
            if (nums[i] + nums[j] == target) return new int[]{i,j};
        }
    }
    return new int[]{};
}

//R.T O(N), space complexity is O(N)
public int[] twoSum_unsorted1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) return new int[]{};

        for (int i = 0; i< nums.length; i++){
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target - nums[i], i);
            }
        }
        return new int[]{};
    }
