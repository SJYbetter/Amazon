public class Solution{
/*
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Not 7-1 = 6, as selling price needs to be larger than buying price.
*/

    public int maxProfit(int[] prices) {
        //edge case
        if (prices == null || prices.length == 0) return 0;

        int curMin = prices[0], profit = 0;
        for(int i = 1; i < prices.length; i++){
            //update the curMin from the frist day to ith day
            if (prices[i] < curMin){
                cur = prices[i];
            }
            //update the profit
            profit = Math.max(prices[i] - curMin, profit);
        }
        return profit;

    }
}
