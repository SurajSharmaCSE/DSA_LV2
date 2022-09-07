public static int fibo_rec(int n)
{
    if(n<=1)
    {
        return n;
    }
    // main logic
    int ans=fibo_rec(n-1)+fibo_rec(n-2);
    
    return ans;
}
//------------------------------
// Using DP - Memoization
public static int fibo_memo(int n,int dp[])
{
    if(n<=1)
    {
        return dp[n]=n;
    }
    // main logic
    int ans=fibo_rec(n-1)+fibo_rec(n-2);
    dp[n]=ans;
    return ans;
}
//------------------------------
// Using DP - Tabulation
 public static int fibo_Tab(int n,int dp[])
{
    if(n<=1)
    {
        return dp[n]=n;
    }
    // main logic
    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<=n;i++)
    {
        dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[n];
}