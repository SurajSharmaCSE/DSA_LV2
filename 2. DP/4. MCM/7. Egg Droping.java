class Solution {
    public int Recursion_Code(int e, int f)   // time limit exceed
    {
        //base case
        if(f==0 || f==1){return f;}
        if(e==1){return f;}

        int mn = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++)
        {
            int temp = 1+Math.max(Recursion_Code(e-1,k-1),Recursion_Code(e,f-k));
            mn = Math.min(mn,temp);
        }

        return mn;
    }
    public int Memoization(int e, int f,int dp[][])   
    {
        //base case
        if(f==0 || f==1){return f;}
        if(e==1){return f;}
        
        if(dp[e][f]!=-1)
        {
            return dp[e][f];
        }
        int mn = Integer.MAX_VALUE;
        for(int k=1;k<=f;k++)
        {
            int temp = 1+Math.max(Memoization(e-1,k-1,dp),Memoization(e,f-k,dp));
            mn = Math.min(mn,temp);
        }

        return dp[e][f] = mn;
    }
    public int Tabulation(int e, int f)
    {
        int dp[][] = new int[e+1][f+1];

        for(int i=1;i<=e;i++)
        {
          for(int j=1;j<=f;j++)
          {
              if(i==1)
              {
                  dp[i][j] = j;
              }
              else if(j==1)
              {
                  dp[i][j] = 1;
              }
              else
              {
                  int min = Integer.MAX_VALUE;
                  for(int mj=j-1, pj=0; mj>=0;mj--,pj++)
                  {
                      int v1=dp[i][mj];  // egg servives
                      int v2=dp[i-1][pj]; // egg break
                      int val = Math.max(v1,v2);
                      min = Math.min(val,min);

                  }
                  dp[i][j] = min+1;
              }
          }
        }
        return dp[e][f];
    }
    public int superEggDrop(int e, int f) 
    {
        // return Recursion_Code(e,f);
        // /* memoization */
        // int dp[][] = new int[e+1][f+1];
        // for(int a[]:dp)
        // {
        //     Arrays.fill(a,-1);
        // }
        // return Memoization(e,f,dp);

        return Tabulation(e,f);
        
    }
}