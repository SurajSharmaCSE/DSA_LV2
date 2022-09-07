
    class Solution{
    
       public static Boolean helper(int N,int arr[],int sum)
       {
           Boolean dp[][]=new Boolean[N+1][sum+1];
           
           // fill first row with false
           for(int j=0;j<=sum;j++)
           {
               dp[0][j]=false;
           }
           // fill first row with true
           for(int i=0;i<=N;i++)
           {
               dp[i][0]=true;
           }
           
           // main logic 
           for(int i=1;i<=N;i++)
           {
               for(int j=1;j<=sum;j++)
               {
                   if(arr[i-1]<=j)
                   {
                       dp[i][j]=(dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                   }
                   else
                   {
                       dp[i][j]=dp[i-1][j];
                   }
               }
           }
           return dp[N][sum];
       }
    
        static Boolean isSubsetSum(int N, int arr[], int sum){
            // code here
            Boolean ans=helper(N,arr,sum);
            return ans;
        }
    }