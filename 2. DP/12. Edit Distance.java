// leetcode
class Solution {
    // using recursion
//     public static int helper(String s1,String s2,int i,int j)
//     {
//         if(i==0)
//         {
//             return j;
//         }
//         if(j==0)
//         {
//             return i;
//         }
        
//         //main log
//         if(s1.charAt(i-1)==s2.charAt(j-1))
//         {
//             return helper(s1,s2,i-1,j-1);
//         }
//         else
//         {
//             int Insert=helper(s1,s2,i,j-1);
//             int delete=helper(s1,s2,i-1,j);
//             int replace=helper(s1,s2,i-1,j-1);
            
//             int ans=Math.min(Insert,Math.min(delete,replace));
//             return ans+1;
//         }
//     }
    
    // using memoization
//      public static int helper(String s1,String s2,int i,int j,int dp[][])
//     {
//         if(i==0)
//         {
//             return dp[i][j]=j;
//         }
//         if(j==0)
//         {
//             return dp[i][j]=i;
//         }
//         if(dp[i][j]!=-1)
//         {
//             return dp[i][j];
//         }
        
//         //main log
//         if(s1.charAt(i-1)==s2.charAt(j-1))
//         {
//             return dp[i][j]=helper(s1,s2,i-1,j-1,dp);
//         }
//         else
//         {
//             int Insert=helper(s1,s2,i,j-1,dp);
//             int delete=helper(s1,s2,i-1,j,dp);
//             int replace=helper(s1,s2,i-1,j-1,dp);
            
//             int ans=Math.min(Insert,Math.min(delete,replace));
//             return dp[i][j]=ans+1;
//         }
//     }
    
    // using tabulation
    public static int helper(String s1,String s2)
    {
        int l1=s1.length();
        int l2=s2.length();
        
        int dp[][]=new int[l1+1][l2+1];
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }
        
        // fill first row and first colum with 1...n
        for(int i=0;i<=l1;i++){dp[i][0]=i;}
        for(int j=0;j<=l2;j++){dp[0][j]=j;}
        
        // main logic
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]; // jo diagonal par hai use dale
                }
                else
                {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[l1][l2];
    }
    public int minDistance(String word1, String word2) {
        
//         int i=word1.length();
//         int j=word2.length();
        
//         int dp[][]=new int[i+1][j+1];
//         for(int arr[]:dp)
//         {
//             Arrays.fill(arr,-1);
//         }
//         int ans=helper(word1,word2,i,j,dp);
        int ans=helper(word1,word2);
        return ans;
        
    }
}