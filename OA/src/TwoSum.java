/*
Given an array of integers that is already sorted in ascending order,
find two numbers such that they add up to a specific target number.
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

*/


public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length-1;

    while (i < j){
        if (numbers[i] + numbers[j] == target) return new int[]{i+1,j+1};
        if (numbers[i] + numbers[j] < target) i++;
        if (numbers[i] + numbers[j] > target) j--;
    }
    return new int[]{};
}
