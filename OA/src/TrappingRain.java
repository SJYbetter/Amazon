public class Solution{
    public int trapRain(int[] A){
        int a = 0;
        int b = A.length-1;
        //
        int maxWater = 0;
        int leftmax = 0;
        int rightmax = 0;
        while(a <= b){
            leftmax = Math.max(leftmax, A[a]);
            rightmax = Math.max(rightmax, A[b]);
            if(leftmax < rightmax){
                // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored, decide by leftMax
                maxWater += (leftmax - A[a]);
                a ++;
            }
            else{
                //decide by the right max
                maxWater += (rightmax-A[b]);
                b --;
            }
        }
        return maxWater;
    }



}
