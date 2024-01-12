class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int ans=Integer.MAX_VALUE,left=0,right=0,sum=0,flag=0;
        
        while(right<nums.length)
        {
            sum+=nums[right];
            
            while(sum>=target)
            {
                flag=1;
                
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        if(flag==0)
        {
            return 0;
        }
        return ans;
        
        
    }
}