// Using Recursion -------------------
    public static int CS_Rec(int n)
    {
        // base case
        if(n<0)
        {
            return 0;
        }
        if(n==0)
        {
            return 1;
        }

        // main logic
        int ans=CS_Rec(n-1)+CS_Rec(n-2)+CS_Rec(n-3);

        return ans;
    }

// Using DP - memoization
    // MEMOIZATION METHOD i.e dp
    public static int CS_Memo(int n,int dp[])
    {
        // base case
        if(n<0)
        {
            return 0;
        }
        if(n==0)
        {
           dp[n]=1;
            return 1;
        }
        if(dp[n]>-1)
        {
            return dp[n];
        }

        // main logic
        int ans=CS_Memo(n-1,dp)+CS_Memo(n-2,dp)+CS_Memo(n-3,dp);
        dp[n]=ans;
        return ans;
    }

    // DP - Using Tabulation
    
    public static int CS_tab(int n,int dp[])
    {
        // main logic
        dp[0]=1;
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                dp[i]=dp[i-1];
            }
            else if(i==2)
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
            else
            {
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
            }
        }
        return dp[n];
       
    }




//     public static void main(String[] args) throws Exception {
//         // write your code here
//         Scanner scn=new Scanner(System.in);
//         int n=scn.nextInt();
//         // use for dp
//         int dp[]=new int[n+1];
//          Arrays.fill(dp, -1);

//         // int ans=CS_Rec(n);
//         // int ans=CS_Memo(n,dp);
//         int ans=CS_tab(n,dp);
//         System.out.println(ans);

//     }

// }