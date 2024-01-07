// Leetcode - Q516
// using Recursion
public static int lps(String s,int i,int j)
{
    //base case
    if(i>=j)
    {
       return (i==j)?1:0;
        
    }
    
    // main logic
    if(s.charAt(i)==s.charAt(j))
    {
        return lps(s,i+1,j-1)+2;
    }
    else
    {
        return Math.max(lps(s,i+1,j),lps(s,i,j-1));
    }
}

// Using Memoization - DP

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

        //Tabulation -> Gap Method
        public static int Tabulation(String s)
        {
        int n = s.length();
        int dp[][] = new int[n][n];

        for(int gap=0;gap<n;gap++)
        {
            for(int i=0,j=gap;j<n;i++,j++)
            {
                if(i>=j)
                {
                    dp[i][j] = (i==j)?1:0;
                }
                else if(s.charAt(i)==s.charAt(j))
                {
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];  
    }
    }