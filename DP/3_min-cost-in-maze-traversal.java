import java.io.*;
import java.util.*;

public class Main {

    // recursive Approch - time limit eceet arror dega 
    public static int min_cost_maze_Rec(int arr[][],int sr,int sc)
    {
        // base case
        if(sr>arr.length-1 || sc> arr[0].length-1)
        {
            return 1011292;
        }
        if(sr==arr.length-1 && sc==arr.length-1)
        {
            return arr[sr][sc];
        }

        // main logic
        int ans1=min_cost_maze_Rec(arr,sr+1,sc);
        int ans2=min_cost_maze_Rec(arr,sr,sc+1);

        int min=Math.min(ans1,ans2)+arr[sr][sc];

        return min;

    } 

    // Memoization Approach

     public static int min_cost_maze_memo(int arr[][],int sr,int sc,int dp[][])
    {
        // base case
        if(sr==arr.length-1 && sc==arr[0].length-1)
        {
            
            return arr[sr][sc];
        }
        if(sr>=arr.length || sc>=arr[0].length)
        {
            return Integer.MAX_VALUE;
        }

        if(dp[sr][sc]!=-1)
        {
            return dp[sr][sc];
        }
        // main logic
        int min=Integer.MAX_VALUE;
        int ans1=min_cost_maze_memo(arr,sr+1,sc,dp);
        int ans2=min_cost_maze_memo(arr,sr,sc+1,dp);
        
        min=Math.min(ans1,ans2)+arr[sr][sc];
        
        return dp[sr][sc]=min;

    } 

    // DP - tabulation
    
     public static void min_cost_maze_Tab(int arr[][],int dp[][])
    {
        int n=arr.length;
        int m=arr[0].length;
        

        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(i==n-1 && j==m-1)
                {
                    dp[i][j]=arr[i][j];
                }
                else if(i==n-1)
                {
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if(j==m-1)
                {
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }
                else
                {
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int maze[][]=new int[n][m];
        int dp[][]=new int[n+1][m+1];
         // input maze value
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                maze[i][j]=scn.nextInt();
            }
        }

        // fil dp matrix with -1
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
               dp[i][j]=-1;

            }
        }

       

        // int ans=min_cost_maze_Rec(maze,0,0);
        min_cost_maze_Tab(maze,dp);
       
    }

}