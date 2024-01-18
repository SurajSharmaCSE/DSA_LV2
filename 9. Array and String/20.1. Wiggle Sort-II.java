class Solution {
    /*
Approch:
1. Sort the given Array and make an ans array ans[]
2. take two pointer i=1, j=n-1 
3. while(i<n)
   {
       ans[i] = arr[j]
       i+=2;
       j--
   }
   3.1 when complete the i travese then again point i = 0 
   while(i<n)
   {
       ans[i] = arr[j];
       i+=2;
       j--;
   }
4. in last fill ans to original array and return this 
*/

public void Approch(int arr[])
{
    //	1. Sort the given Array and make an ans array ans[]
    Arrays.sort(arr);
    int n = arr.length;
    int ans[] = new int[n]; 

    //2. take two pointer i=1, j=n-1
    int i=1, j= n-1;
    //step-3
    while(i<n)
    {
        ans[i] = arr[j];
        i+=2;
        j--;
    }
    i=0;
    while(i<n)
    {
        ans[i] = arr[j];
        i+=2;
        j--;
    }
    //4. in last fill ans to original array and return this 
    for(int k=0;k<n;k++)
    {
        arr[k] = ans[k];
    }

}
public void wiggleSort(int[] nums) 
{
   Approch(nums);  
}

}