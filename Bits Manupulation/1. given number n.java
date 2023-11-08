/* 
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    int mask1=1<<i;
    int mask2=~(1<<j);
    int mask3=(1<<k);
    int mask4=(1<<m);
    
    int ans1=n|mask1;
    int ans2=n&mask2;
    int ans3=n^mask3;
    int ans4=n&mask4;
    
    System.out.println(ans1);
    System.out.println(ans2);
    System.out.println(ans3);
    System.out.println(ans4==0?"false":"true");
    
    
    
    //write your code here
  }

}