public class Search{
    public int binarySearch(int[] nums, int target){
        //edge case
        if (nums == null || nums.length == 0) return -1;
        int start = 0, end = nums.length-1;
        while (start + 1 < end){
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) start = mid+1;
            else end = mid-1;
        }

        if (nums[start] == target) return start;
        if (nums[end] == target) return end;

        return -1;
    }


    public void quickSort(int[] nums, int start, int end){
        if (start >= end) return;
        int left = start, right = end;
        int pivot = nums[(left+right)/2];
        while (left <= right){
            while (left <= right && pivot > nums[left]) left++;
            while (left <= right && pivot < nums[right]) right--;

            if (left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            quickSort(nums, start, right);
            quickSort(nums, left, end);
        }

    }
}
