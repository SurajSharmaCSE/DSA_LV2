class Solution {
    public int maxProfit(int[] arr, int fee) 
    {
        int obsp = -arr[0];
        int ossp = 0;

        for(int i=0;i<arr.length;i++)
        {
            int nbsp = 0;
            int nssp = 0;
            if(ossp-arr[i]> obsp)
            {
                 nbsp = ossp - arr[i];
            }
            else
            {
                nbsp = obsp;
            }

            if(obsp + arr[i] - fee > ossp)
            {
                nssp = obsp+arr[i]-fee;
            }
            else
            {
                nssp = ossp;
            }

            obsp =   nbsp;
            ossp = nssp;
        }
        return ossp;
    }
}