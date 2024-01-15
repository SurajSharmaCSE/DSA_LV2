
class Solution{
     // recursive method ---------------------------------
    // static int knapSack(int n, int W, int val[], int wt[])
    // {
    //     //base case
    //     if(n==0 || W==0)
    //     {
    //         return 0;
    //     }
    //     // code here
    //     if(W>=wt[n-1])
    //     {
    //         // item pick
    //         int include=knapSack(n,W-wt[n-1],val,wt)+val[n-1];
    //         // item note pick
    //         int exclude=knapSack(n-1,W,val,wt);
            
    //         return Math.max(include,exclude);
    //     }
    //     else
    //     {
    //         return knapSack(n-1,W,val,wt);
    //     }
    // }
    
    // memoization-----------------------------------------
    
    //  static int knapSack_memo(int n, int W, int val[], int wt[],int dp[][])
    // {
    //     //base case
    //     if(n==0 || W==0)
    //     {
    //         return dp[n][W]=0;
    //     }
    //     if(dp[n][W]!=-1)
    //     {
    //         return dp[n][W];
    //     }
    //     // code here
    //     if(W>=wt[n-1])
    //     {
    //         // item pick
    //         int include=knapSack_memo(n,W-wt[n-1],val,wt,dp)+val[n-1];
    //         // item note pick
    //         int exclude=knapSack_memo(n-1,W,val,wt,dp);
            
    //         return dp[n][W]=Math.max(include,exclude);
    //     }
    //     else
    //     {
    //         return dp[n][W]=knapSack_memo(n-1,W,val,wt,dp);
    //     }
        
    // }
    
   //------------------------------------------------------------
   
   // Tabulation
   static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[N+1][W+1];
        for(int a[]:dp)
        {
            Arrays.fill(a,0);
        }
        
       
       for(int i=1;i<=N;i++)
       {
           for(int j=1;j<=W;j++)
           {
               if(j>=wt[i-1])
               {
                   int include= dp[i][j-wt[i-1]]+val[i-1];
                   int exclude=dp[i-1][j];
                   dp[i][j]=Math.max(include,exclude);
               }
               else
               {
                   dp[i][j]=dp[i-1][j];
               }
           }
       }
       return dp[N][W];
    }

    
}