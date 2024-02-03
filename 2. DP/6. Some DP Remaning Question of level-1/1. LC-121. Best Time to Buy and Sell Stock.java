class Solution {
    public int maxProfit(int[] prices) 
    {
        int lsf=Integer.MAX_VALUE, op = 0, pist = 0;
        // least so far(lsf), overall profit(op), profit if sold today(pist)

        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<lsf)
            {
                lsf = prices[i];
            }

            pist = prices[i] - lsf;
            if(pist>op)
            {
                op = pist;
            }
        }
        return op;
    }
}