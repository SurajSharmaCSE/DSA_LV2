// Using memoization
/*
 1. find lcs
 2. n=str.length
 3. n-lcs;
 */

 // longest common subsequance ---------------------------
 public static int lps(String s,int i,int j,int dp[][])
 {
     //base case
     if(i>=j)
     {
        return dp[i][j]=(i==j)?1:0;
         
     }
     if(dp[i][j]!=0)
     {
         return dp[i][j];   
     }
     
     // main logic
     if(s.charAt(i)==s.charAt(j))
     {
         return dp[i][j]=lps(s,i+1,j-1,dp)+2;
     }
     else
     {
         return dp[i][j]=Math.max(lps(s,i+1,j,dp),lps(s,i,j-1,dp));
     }
 }
 
// main function 
 int minDeletions(String s, int n)
 {
     // code here
      int i=0;
     int j=s.length()-1;
     // int n=s.length();
     
     int dp[][]=new int[n+1][n+1];
     for(int a[]:dp)
     {
         Arrays.fill(a,0);
     }
     
     
     int ans=lps(s,i,j,dp);
     return n-ans; // main logic focus only here
 }