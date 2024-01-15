import java.io.*;
import java.util.*;

public class Main{
    //using recursion
    
    // public static int Catalan_Num(int n)
    // {
    //     //base case
    //     if(n==0)
    //     {
    //         return 1;
    //     }
        
    //     // main logic
    //     int ans=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         ans+=Catalan_Num(i)*Catalan_Num(n-i-1);
    //     }
    //     return ans;
    // }
    
    //using memoization
    
    // public static int Catalan_Num(int n,int dp[])
    // {
    //     //base case
    //     if(n==0)
    //     {
    //         return dp[n]=1;
    //     }
        
    //     // main logic
    //     int ans=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         ans+=Catalan_Num(i,dp)*Catalan_Num(n-i-1,dp);
    //     }
    //     return dp[n]=ans;
    // }
    
    //using tabulation
    
    public static void Catalan_Num(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        //logic
        for(int i=2;i<=n;i++)
        {
            for(int j=0;j<i;j++)
            {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        System.out.println(dp[n]);
    }
public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    // int dp[]=new int[n+1];
    // Arrays.fill(dp,-1);
    // int ans=Catalan_Num(n,dp);
    // System.out.println(ans);
    
    // use for tabulation function
    Catalan_Num(n);
 }

}