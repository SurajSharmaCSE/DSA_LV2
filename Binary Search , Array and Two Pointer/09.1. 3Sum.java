public List<List<Integer>> threeSum(int[] nums) 
{
   List<List<Integer>>ans=new ArrayList<>();
    
    if(nums.length<3)
    {
        return ans;
    }
    
    Arrays.sort(nums);
    
    for(int i=0;i<nums.length-2;i++)
    {
        int left=i+1;
        int right=nums.length-1;
       while(left<right) 
       {
        int sum=nums[i]+nums[left]+nums[right];
        
        if(sum==0)
        {
            List<Integer>subAns=new ArrayList<>();
            
            subAns.add(nums[i]);
            subAns.add(nums[left]);
            subAns.add(nums[right]);
            
            ans.add(subAns);
            
            //dublicacy handle
            while(left<right && nums[left]==nums[left+1])
            {
                left++;
            }
            while(left<right && nums[right]==nums[right-1])
            {
                right--;
            }
            
            right--;
            left++;
        }
        else if(sum>0)
        {
            right--;
        }
        else
        {
            left++;
        }
    }
    while(i<nums.length-2 && nums[i]==nums[i+1])
        {
            i++;
        }
 }
    return ans;
}