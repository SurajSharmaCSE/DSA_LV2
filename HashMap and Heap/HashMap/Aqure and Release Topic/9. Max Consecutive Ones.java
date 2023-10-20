class Solution {
    // approch 1
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int max=0;
        //step-1
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                count++;
            }
            else
            {
                count=0;
            }
            
            // step-2
            if(count>max)
            {
                max++;
            }
            
        }
        return max;
        
    }

    
      //aproch -2
     public int findMaxConsecutiveOnes(int[] nums) 
     {
         
         int maxLen=0;
         int count=0;
         
         for(int i=0;i<nums.length;i++)
         {
             if(nums[i]==1)
             {
                 count++;
             }
             else
             {
                 if(count>maxLen)
                 {
                     maxLen=count;
                     
                 }
                 count=0;
             }
         }
         
         if(count>maxLen)
         {
             maxLen=count;
         }
         return maxLen;
     }
}