
class Solution{
    // using Recursion ------------------------------------------------
    // public static boolean helper_rec(int arr[],int idx,int curr_sum,int sum)
    // {
    //     // base case
    //     if(curr_sum>sum)
    //     {
    //         return false;
    //     }
    //     if(idx==arr.length-1)
    //     {
    //         if(curr_sum==sum)
    //         {
    //             return true;
    //         }
    //         else
    //         {
    //             return false;
    //         }
    //     }
        
    //     // main logic 
    //     //pick
    //   boolean include=helper_rec(arr,idx+1,curr_sum+arr[idx],sum);
    //   // not pick
    //   boolean execluse=helper_rec(arr,idx+1,curr_sum,sum);
       
    //   return include||execluse;
    // }
    
    // using Memoization ------------------------------------------------------
     public static int helper_memo(int arr[],int idx,int curr_sum,int sum,int dp[][])
    {
        // base case
         if(idx>arr.length-1)
         {
             return 0;
         }
        if(curr_sum>sum)
        {
            return 0;
        }
        if(dp[idx][curr_sum]!=-1)
        {
            return dp[idx][curr_sum];
        }
        if(idx==arr.length-1)
        {
            if(curr_sum==sum)
            {
                return dp[idx][curr_sum]=1;
            }
            else
            {
                return dp[idx][curr_sum]=0;
            }
        }
        
        
        
        // main logic 
        //pick
       int include=helper_memo(arr,idx+1,curr_sum+arr[idx],sum,dp);
       // not pick
       int execluse=helper_memo(arr,idx+1,curr_sum,sum,dp);
       
       if(include==1 || execluse==1)
       {
           dp[idx][curr_sum]=1;
       }
       else
       {
           
       dp[idx][curr_sum]=0;
       }
       return dp[idx][curr_sum];
    }
    
    // Tabulation -------------------------------------------------
    // public static boolean helper(int N,int arr[])
    // {
    //     int sum=0;
    //     for(int i=0;i<N;i++)
    //     {
    //         sum+=arr[i];
    //     }
    //     if(sum%2!=0)
    //     {
    //         return false;
    //     }
    //     else
    //     {
    //         sum/=2;
    //         boolean dp[][]=new boolean[N+1][sum+1];
       
    //         // fill first row with false
    //         for(int j=0;j<=sum;j++)
    //           {
    //           dp[0][j]=false;
    //           }
    //          // fill first row with true
    //          for(int i=0;i<=N;i++)
    //          {
    //           dp[i][0]=true;
    //          }
       
    //         // main logic 
    //       for(int i=1;i<=N;i++)
    //         {
    //           for(int j=1;j<=sum;j++)
    //          {
    //           if(arr[i-1]<=j)
    //           {
    //               dp[i][j]=(dp[i-1][j-arr[i-1]] || dp[i-1][j]);
    //           }
    //           else
    //           {
    //               dp[i][j]=dp[i-1][j];
    //           }
    //          }
    //         }
    //      return dp[N][sum];
    //     }
    // }
    
    
    
    static int equalPartition(int n, int arr[])
    {
        // code here
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        if(sum%2!=0)
        {
            return 0;
        }
        else
       {
        sum/=2;
        int dp[][]=new int[n+1][sum+1];
        for(int a[]:dp)
        {
            Arrays.fill(a,-1);
        }
        int ans=helper_memo(arr,0,0,sum,dp);
        if(ans==1)
        {
            return 1;
        }
        else
        {
            return 0;
        }
       }
       
    }
}