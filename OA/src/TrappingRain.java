public class Solution{

    //对于每一个位置i，存水的量=min(左边最大值，右边最大值) - h[i],
    //为什么求左边最大值和右边最大值？其实就是找每个点两边的墙，只有墙中间的部分能存水【这种思路是求每个点i的纵向存水量】
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
