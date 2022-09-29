//iterative
 public int search(int[] nums, int tar) {
    int low=0;
    int high=nums.length-1;
  while(low<=high)
   {
     int mid=(low+high)/2;
     if(nums[mid]==tar)
     {
        return mid;
     }
    else if(nums[mid]>tar)
     {
        high=mid-1;
     }
     else
     {
        low=mid+1;
     }
  }
  
    return -1;
}