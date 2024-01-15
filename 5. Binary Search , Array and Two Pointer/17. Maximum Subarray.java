class Solution {
    public int maxSubArray(int[] nums) {
        int ans=0;
        int finalAns=Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            ans=Math.max(ans+nums[i],nums[i]);
            
            finalAns=Math.max(finalAns,ans);
        }
        
        return finalAns;
        
    }
}