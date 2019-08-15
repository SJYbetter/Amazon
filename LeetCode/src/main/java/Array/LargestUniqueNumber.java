package Array;
//giving an unsorted array to find the largest number in
public class LargestUniqueNumber {
    //using bucket sort
    public int findLargestUniqueNumber(int[] A){
        if (A == null || A.length == 0) return -1;
        if (A.length == 1) return A[0];

        int[] bucketSort = new int[1001];
        for (int i : A){
            bucketSort[i] ++;
        }

        for (int i = 1000; i >= 0; i--){
            if (bucketSort[i] == 1) return i;
        }
        return -1;

    }
}
