class Solution {
    public int maxProfit(int k, int[] prices) 
    {
        return Memoization(k,prices);
    }
    public int Memoization(int k, int prices[])
    {
        int n = prices.length;
        int dp[][] = new int[k+1][n];
        for(int i =1; i <= k; i++){
            for(int j = 1; j< prices.length; j++){
                
                int not_sell = dp[i][j-1];
                int sell    = 0;
                for(int m =0; m<j; m++){
                    sell = Math.max(sell,  (prices[j] - prices[m]) + dp[i-1][m] );
                }
                dp[i][j] = Math.max(sell, not_sell); 
            }
        }
    
        return dp[k][prices.length-1];
    }
}