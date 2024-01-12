class Solution 
{
  public int Approch_1(int[] num)    // TC - O(nlogn) , SC - O(1)
  {
      if (num.length == 1) 
          {
            return num[0];
          }

          Arrays.sort(num);
          return num[num.length / 2];
  }
  public int Approch_2(int[] num)        // TC - O(n) , SC - O(n)
  {
      int ans = 0;
    /*
     step1:
      1. Use HashMap and store these frequcy count
      2. travese on map ans check which key freq>n/2 then print this value 
     */
     return ans;
  }
  //optimal solution
  public int Approch_3(int[] num)   // pairing Maethos  TC - O(n), SC - O(1) 
  { 
    //   step1. Find potential element 
      int val = num[0];
      int count = 1;
      for(int i=1;i<num.length;i++)
      {
          if(num[i] == val)
          {
              count++;
          }
          else
          {
              count--;
          }
          if(count==0)
          {
              val = num[i];
              count = 1;
          }
      }
    //step2. check it mejority elemnt or not 
      int temp_count = 0;
      int n = num.length;
      for(int i=0;i<num.length;i++)
      {
          if(num[i] == val)
          {
              temp_count++;
          }
      }

      if(temp_count>n/2)
      {
          return val;
      }
     
      return -1;
  }
  public int majorityElement(int[] num) 
  {
      int ans1 = Approch_1(num);
      int ans3 = Approch_3(num);
      return ans3;
  }
    
}