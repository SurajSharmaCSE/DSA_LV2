//{ Driver Code Starts
//Initial Template for Java

// gfg problems



class Solution
{
    // memoization -
    // public static long helper(int n,int dp[])
    // {
    //     long mod=122343;
    //     // base case
    //     if(n==0)
    //     {
    //         return dp[n]=1;
    //     }
    //     if(dp[n]!=-1)
    //     {
    //         return dp[n];
    //     }
    //     long single=helper(n-1,dp);
    //     long pair=n>=2?helper(n-2,dp)*(n-1):0;
        
    //     return dp[n]=(single+pair%mod)mod;
    // }
    
    // tabulation
   long mod=1000000007;
   public long helperTab(int n,long dp[])
   {
        if(n==0)
       {
           return dp[n]=1;
       }
       if(dp[n]!=-1)
       {
           return dp[n];
       }
       
      long single=helperTab(n-1,dp);
      
      long pairUp=n-2>=0?helperTab(n-2,dp)*(n-1):0;
      
      return dp[n]=(single+pairUp%mod)%mod;
   }
   
   public long countFriendsPairings(int n) 
    { 
      long dp[]=new long[n+1];
      Arrays.fill(dp,-1);
      return helperTab(n,dp);
    } 
}
 