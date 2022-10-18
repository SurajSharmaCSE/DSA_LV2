class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Apply Sliding window Approch
        
        int sum=0;
        int MaxSum=0;
        
        //step-1
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
        }
        MaxSum=sum;
        
        //step-2
        for(int i=k;i<nums.length;i++)
        {
            sum+=nums[i];
            sum-=nums[i-k];
            
            MaxSum=Math.max(MaxSum,sum);
        }
        
        return (double)MaxSum/k;
        
    }
}