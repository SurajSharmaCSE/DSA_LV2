
    class Solution 
    {  
        // Recursive approach - give TLE
        public static int helper_Rec(int W, int wt[], int val[], int n)
        {
            //base case
            if(W==0 || n==0)
            {
                return 0;
            }
            // main logic 
            if(W>=wt[n-1])
            {
                int include=helper_Rec(W-wt[n-1],wt,val,n-1)+val[n-1];
                int exclude=helper_Rec(W,wt,val,n-1);
                
                return Math.max(include,exclude);
            }
            else
            {
                return helper_Rec(W,wt,val,n-1);
            }
            
        }
       
       // Memoization 
        public static int helper_Memo(int W, int wt[], int val[], int n,int dp[][])
        {
            //base case
            if(W==0 || n==0)
            {
                return dp[n][W]=0;
            }
            if(dp[n][W]!=-1)
            {
                return dp[n][W];
            }
            // main logic 
            if(W>=wt[n-1])
            {
                int include=helper_Memo(W-wt[n-1],wt,val,n-1,dp)+val[n-1];
                int exclude=helper_Memo(W,wt,val,n-1,dp);
                
                return dp[n][W]=Math.max(include,exclude);
            }
            else
            {
                return dp[n][W]=helper_Memo(W,wt,val,n-1,dp);
            }
            
        }
        
        public static int helper_tab(int W, int wt[], int val[], int n,int dp[][])
        {
            for(int i=0;i<=n;i++)
            {
                for(int j=0;j<=W;j++)
                {
                    if(i==0 || j==0)
                    {
                        dp[i][j]=0;
                    }
                    else if(j<=wt[i-1])
                    {
                        dp[i][j]=Math.max(dp[i-1][j-wt[i-1]]+val[i-1],dp[i-1][j]);
                    }
                    else 
                    {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
            return dp[n][W];
        }
        //Function to return max value that can be put in knapsack of capacity W.
        static int knapSack(int W, int wt[], int val[], int n) 
        { 
            int dp[][]=new int[n+1][W+1];
            for(int arr[]:dp)
            {
                Arrays.fill(arr,-1);
            }
             // your code here 
             int ans=helper_tab(W,wt,val,n,dp);
             return ans;
        } 
    }
    
    
    