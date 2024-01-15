class Solution {
    public int Brute_Approch(int nums[], int k)
    {
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            for(int j=i;j<nums.length;j++)
            {
                if(nums[j]==0){count++;}
                if(count>k){break;}

                ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }

    public int Optimal_Solution(int[] arr, int k) 
    {
        int ans=0;
        int j=-1;
        int count=0;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==0)
            {
                count++;
            }
            
            while(count>k)
            {
                j++;
                if(arr[j]==0)
                {
                    count--;
                }
            }
            int len=i-j;
            if(len>ans)
            {
                ans=len;
            }
        }
        return ans;
    }
    public int longestOnes(int[] nums, int k) 
    {
    //   return Brute_Approch(nums,k);
      return Optimal_Solution(nums,k);
    }
}