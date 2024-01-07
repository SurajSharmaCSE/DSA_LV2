// Using REcursion --------
    public static boolean Sum_Set_Rec(int arr[],int idx,int target)
    {
        //base case
        if(idx==arr.length-1)
        {
            if(target==0)
            {
             return true;
            }
            else
            {
                return false;
            }
        }
        

        // yes ki call - pick an element
        boolean ans1=Sum_SetDP(arr,idx+1,target-arr[idx]);

        // no ki call - not pick an element
        boolean ans2=Sum_SetDP(arr,idx+1,target);

        return ans1||ans2;
      
      
    }

//----------- Using Memoization

class Solution{
    
     public static int  Sum_Set_memo(int arr[],int idx,int target,int dp[][])
     {
         // Base case
        if (idx == arr.length) 
        {
            if (target == 0) 
            {
                return 1;
            } else 
            {
                return 0;
            }
        }

        if (target < 0) 
        {
            return 0;
        }

        if (dp[idx][target] != -1) 
        {
            return dp[idx][target];
        }

        // Consider the current element in the subset
        int ans1 = Sum_Set_memo(arr, idx + 1, target - arr[idx], dp);

        // Skip the current element in the subset
        int ans2 = Sum_Set_memo(arr, idx + 1, target, dp);

        if (ans1 == 1 || ans2 == 1) 
        {
            dp[idx][target] = 1;
        } else 
        {
            dp[idx][target] = 0;
        }
        return dp[idx][target];
      
    }

    static Boolean isSubsetSum(int n, int arr[], int sum){
         int dp[][] = new int[n + 1][sum + 1];

        // Initialize the memoization table
        for (int i = 0; i <= n; i++) 
        {
            for (int j = 0; j <= sum; j++) 
            {
                dp[i][j] = -1;
            }
        }

        int ans = Sum_Set_memo(arr, 0, sum, dp);
        return ans == 1;
        
    }
}
    
      
      

//-------Tabulation---------------------

    public static void tss_tab(int a[],int tar)
    {
        int n=a.length;
        boolean dp[][]=new boolean[n+1][tar+1];

        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=tar;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else
                {
                    if(dp[i-1][j]==true)
                    {
                        //for exclude
                        dp[i][j]=true;
                    }
                    else
                    {
                        // for include
                        int currVal=a[i-1];
                        int tarInd=j-currVal;
                        if(tarInd>=0 && dp[i-1][tarInd]==true)
                        {
                            dp[i][j]=true;
                        }
                    }
                }
            }
        }
        System.out.println(dp[n][tar]);
    }
