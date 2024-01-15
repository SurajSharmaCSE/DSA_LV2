class Solution 
{
    // Approch1 - Using Brute Approch - or Recursion 
      public static int firstIndex(int[] arr, int idx, int x)
      {
        // base canodition
        if(idx==arr.length)
        {
            return -1;
        }

        if(x==arr[idx])
        {
            return idx;
        }
        else
        {
        // faith
        return firstIndex(arr,idx+1,x);

        }

     }
    
    public static int lastIndex(int[] arr, int idx, int x)
    {
       
       //Base Condition
       if(idx==arr.length)
       {
           return -1;
       }
       // faith
       int f1=lastIndex(arr,idx+1,x);
      // My Work
       if(f1==-1)
       {
           if(arr[idx]==x)
           {
               return idx;
           }
           else
           {
               return -1;
           }
       }
       return f1;
    }

    // Approch-2 : Using BInary Search
    public int FindPostion_First(int arr[], int x)
    {
        int idx =-1, low = 0, high=arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==x)
            {
                idx = mid;
                high = mid-1;
            }
            else if(arr[mid]>x)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return idx;
    }

    public int FindPostion_Last(int arr[], int x)
    {
        int idx =-1, low = 0, high=arr.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;

            if(arr[mid]==x)
            {
                idx = mid;
                low = mid+1;
            }
            else if(arr[mid]>x)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return idx;
    }

    public int[] searchRange(int[] nums, int target) 
    {
        int ans[] = new int[2];
        ans[0] = FindPostion_First(nums,target);
        ans[1] = FindPostion_Last(nums, target);

        return ans;
    }
}