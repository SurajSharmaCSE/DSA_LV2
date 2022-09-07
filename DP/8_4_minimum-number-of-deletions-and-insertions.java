// using tabulation 


class Solution
{
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
    
    
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int n=str1.length();
	    int m=str2.length();
	    
	    int ans=lcs_tab(str1,str2);
	    int res=n-ans+m-ans;
	    return res;
	    
	} 
}