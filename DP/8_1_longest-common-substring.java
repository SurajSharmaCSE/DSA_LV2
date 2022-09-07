// using Tabulation - dp -------------------------------------------------------------
int longestCommonSubstr(String t1, String t2, int n, int m){
    // code here
    //  int n =t1.length();
    // int m=t2.length();
    
    int dp[][]=new int[n+1][m+1];
    
    for(int a[]:dp)
    {
        Arrays.fill(a,-1);
    }
    int ans=0;
   for(int i=0;i<=n;i++)
   {
       for(int j=0;j<=m;j++)
       {
           if(i==0 || j==0)
           {
               dp[i][j]=0;
           }
           else if( t1.charAt(i-1)==t2.charAt(j-1))
           {
               dp[i][j]=dp[i-1][j-1]+1;
               ans=Math.max(ans,dp[i][j]);
           }
           else
           {
               dp[i][j]=0;
           }
               
       }
   }

  return ans; 
}
    