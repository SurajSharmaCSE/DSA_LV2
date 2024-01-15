import java.io.*;
import java.util.*;

public class Main{
     public static int Catalan_Num(int n,int dp[])
    {
        //base case
        if(n==0)
        {
            return dp[n]=1;
        }
        
        // main logic
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=Catalan_Num(i,dp)*Catalan_Num(n-i-1,dp);
        }
        return dp[n]=ans;
    }

public static void main(String[] args) throws Exception {
    // write your code here
     Scanner scn=new Scanner(System.in);
    int n=scn.nextInt();
    int dp[]=new int[n+1];
    Arrays.fill(dp,-1);
    int ans=Catalan_Num(n,dp);
    System.out.println(ans);
 }

}