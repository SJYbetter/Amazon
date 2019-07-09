package Array;

public class QuickSort {
	    public static void sortIntegers(int[] A) {	        
	        if( A.length == 0 || A == null){
	            return;
	        }
	        quicksort(A, 0, A.length - 1);
	    }
	    
	    private static void quicksort(int[] nums, int start, int end){
	        if( start >= end){
	            return;
	        }        
	        int i = start, j = end;
	        int pivot = nums[(i+j)/2];
	        while(i<=j){
	            while(i<=j && nums[i] < pivot){
	                i++;
	            }
	            while(i<=j && nums[j] > pivot){
	                j--;
	            }
	            if( i <= j){
	                int temp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = temp;
	                i++;
	                j--;
	            }
	        }
	        quicksort(nums,start,j);
	        quicksort(nums,i, end);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,2,5,88,10};
		sortIntegers(a);
		for (int i : a) {
			System.out.println(i);
		}		
	}

}
