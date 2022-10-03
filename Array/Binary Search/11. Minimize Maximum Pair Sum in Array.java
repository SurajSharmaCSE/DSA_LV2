public int minPairSum(int[] nums) {
    int ans=Integer.MIN_VALUE;
    Arrays.sort(nums);
    
    int left=0;
    int right=nums.length-1;
    
    while(left<right)
    {
        int sum=nums[left]+nums[right];
        
        ans=Math.max(ans,sum);
        left++;
        right--;
    }
    
    return ans;
    
}