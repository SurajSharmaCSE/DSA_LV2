//leetcode 96

class Solution {
    public static int Catalan_Num(int n)
   {
       int dp[]=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       
       //logic
       for(int i=2;i<=n;i++)
       {
           for(int j=0;j<i;j++)
           {
               dp[i]+=dp[j]*dp[i-j-1];
           }
       }
       return dp[n];
    }
   public int numTrees(int n) {
       
       int ans=Catalan_Num(n);
       return ans;
   }
}