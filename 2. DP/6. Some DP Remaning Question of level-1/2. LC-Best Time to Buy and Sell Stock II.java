class Solution {
    public int maxProfit(int[] prices) 
    {
        // Approch:- https://www.youtube.com/watch?v=HWJ9kIPpzXs&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=31
        int sd = 0;  // sell date(sd)
        int bd = 0;  // buy date(bd)
        int profit = 0;

        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
            {
                sd++;
            }
            else
            {
                profit+=prices[sd]-prices[bd];
                sd = bd = i;
            }
        }
        profit+=prices[sd]-prices[bd];
        return profit;
    }
}