class Solution {
    //Solution O(n), SC-O(n)
    public int maxProfit(int[] arr) 
    {
        int obsp = -arr[0];
        int ossp = 0;
        int ocsp = 0;
        for(int i=0;i<arr.length;i++)
        {
            int nbsp=0;
            int nssp=0;
            int ncsp=0;

            // buy stock update 
            if(ocsp-arr[i]>obsp)
            {
               nbsp = ocsp-arr[i];
            }
            else
            {
               nbsp = obsp;
            }
            // sell stock update
            if(obsp+arr[i]>ossp)
            {
               nssp = obsp+arr[i];
            }
            else
            {
               nssp = ossp;
            }

            //cooldown state update
            if(ossp>ocsp)
            {
                ncsp = ossp;
            }
            else
            {
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        return ossp;
    }
}