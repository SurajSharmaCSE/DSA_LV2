class Solution {
    // using recursion ---------------------------------------------------------
    public static int helper(String t1, String t2,int n,int m)
    {
        // base case
        if(n==0||m==0)
        {
            return 0;
        }
        
        
        if(t1.charAt(n-1)==t2.charAt(m-1))
        {
            return helper(t1,t2,n-1,m-1)+1;
        }
        else
        {
            return Math.max(helper(t1,t2,n-1,m),helper(t1,t2,n,m-1));
        }
    }
    
    // using dp - Memoization --------------------------------------------------
     public static int helper(String t1, String t2,int n,int m,int dp[][])
    {
        // base case
        if(n==0||m==0)
        {
            return dp[n][m]=0;
        }
        
        if(dp[n][m]!=-1)
        {
            return dp[n][m];
         }
        if(t1.charAt(n-1)==t2.charAt(m-1))
        {
            return dp[n][m]=helper(t1,t2,n-1,m-1,dp)+1;
        }
        else
        {
            return dp[n][m]=Math.max(helper(t1,t2,n-1,m,dp),helper(t1,t2,n,m-1,dp));
        }
    }
    
    
    
    // tabulation ---------------------------------------------------------------------------
    public int lcs_tab(String t1, String t2) 
    {
        int n=t1.length();
        int m=t2.length();
        
        int dp[][]=new int[n+1][m+1];
        
        // for(int a[]:dp)
        // {
        //     Arrays.fill(a,-1);
        // }
        
        // main logic ----------
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
                
                else if(t1.charAt(i-1)==t2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
       
    }
    
    // main function --------------------------------------------------------------
     public int longestCommonSubsequence(String t1, String t2) {
        
//         int n=t1.length();
//         int m=t2.length();
        
//         int dp[][]=new int[n+1][m+1];
        
//         for(int a[]:dp)
//         {
//             Arrays.fill(a,-1);
//         }
        
         int ans=lcs_tab(t1,t2);
        return ans;
        
    }
}