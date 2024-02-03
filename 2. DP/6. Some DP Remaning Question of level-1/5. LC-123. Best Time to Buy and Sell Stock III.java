class Solution {
    /*
    Approch:-1 More Understandable -  time complexity is O(n * k) and the space complexity is O(n * k).
    Dry Run - https://www.youtube.com/watch?v=0STXF9IXhnA
     */
    public int Memoization(int i, int buyOrSell, int prices[],int k, HashMap<String,Integer> map)
    {
        if(i>=prices.length || k==0){return 0;}

        String key = i + "Suraj" + buyOrSell + "Sharma" +k;
        if(map.containsKey(key)){ return map.get(key); }

        int x =0;
        if(buyOrSell==0)
        {
            int buy = Memoization(i+1,1,prices,k,map) - prices[i];
            int noBuy = Memoization(i+1,0,prices,k,map);
            x = Math.max(buy,noBuy);
        }
        else
        {
            int sell = Memoization(i+1,0,prices,k-1,map) + prices[i];
            int noSell = Memoization(i+1,1,prices,k,map);
            x = Math.max(sell, noSell);
        }
        map.put(key,x);
        return x;
        
    }
    /*
     */
    /*
     Approch in copy ipad
     */
    public int MySolution(int arr[])
    {
       int n = arr.length;

       // for left to right =  Approch of question buy sell 1 
       int mpist;   // max profit if solf today(mpisf)
       int leastsf = arr[0];  // least so far
       int dpLeft[] = new int[n];

       for(int i=1;i<n;i++)
       {
          if(arr[i]<leastsf)
          {
              leastsf = arr[i];
          }

          mpist = arr[i]-leastsf;
          if(mpist>dpLeft[i-1])
          {
              dpLeft[i] = mpist;
          }
          else
          {
              dpLeft[i] = dpLeft[i-1];
          }
         
       }

       // for right to left =  Approch of question buy sell 1 
       int mpibt=0; // max profit if bough today
       int maxat=arr[n-1]; // max ans today
       int dpRight[] = new int[n];

       for(int i=n-2;i>=0;i--)
       {
           if(arr[i]>maxat)
           {
              maxat = arr[i]; 
           }

           mpibt = maxat-arr[i];
           if(mpibt>dpRight[i+1])
           {
               dpRight[i] = mpibt;
           }
           else
           {
               dpRight[i] = dpRight[i+1];
           }
       }

       int ans = 0;
       for(int i=0;i<n;i++)
       {
           if(dpLeft[i]+dpRight[i]>ans)
           {
               ans = dpLeft[i]+dpRight[i];
           }
       }
       return ans;

    }
    public int maxProfit(int[] prices) 
    {
        // Approch-1 Code 

        // int k = 2; // given by question
        // HashMap<String, Integer> map = new HashMap<>();
        // return Memoization(0,0,prices,k,map);

        // Approch-2 Code
        return MySolution(prices);
    }
}