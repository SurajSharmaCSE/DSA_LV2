class Solution {
    // Approch- - 1 [TC- O(n2), SC- O(1)]
    public int leftmaxFun(int arr[], int idx)
    {
        int leftmax = arr[idx];
        for(int i=idx-1;i>=0;i--)
        {
            if(arr[i]>leftmax)
            {
                leftmax = arr[i];
            }
        }
        return leftmax;
    }
    public int rightmaxFun(int arr[], int idx)
    {
        int rightmax = arr[idx];
        for(int i=idx+1;i<arr.length;i++)
        {
            if(arr[i]>rightmax)
            {
                rightmax = arr[i];
            }
        }
        return rightmax;
    }
    public int BruteApproch(int arr[])
    {
       int ans = 0;
       for(int i=0;i<arr.length;i++)
       {
           int leftmax = leftmaxFun(arr,i);
           int rightmax = rightmaxFun(arr,i);

           int min = Math.min(leftmax,rightmax);
           if(min>0)
           {
             ans+=min-arr[i];
           }
       }
       return ans;
    }

    //Approch - 2 [TC- O(n), SC- O(n)]
    public int MySolution2(int arr[])
    {
        int n=arr.length;
        int preMax[]=new int[n];
        int suffMax[]=new int[n];
        //prefix fill
        preMax[0]=arr[0];
        for(int i=1;i<n;i++)
        {
           preMax[i]=Math.max(preMax[i-1],arr[i]);
        } 
        // suffMax fill
        suffMax[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suffMax[i]=Math.max(arr[i],suffMax[i+1]);
        }

        int ans=0;
        for(int i=0;i<n;i++)
        {
            int min=Math.min(preMax[i],suffMax[i]);
            ans+=min-arr[i];
        }
        return ans;

    }

    //Approch - 3 [TC- O(n), SC- O(1)]
    public int MySolution3(int arr[])
    {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;

        int ans=0;

        while(left<right)
        {
            if(arr[left]<=arr[right])
            {
                if(leftMax<=arr[left])
                {
                    leftMax=arr[left];
                }
                else
                {
                   ans+=leftMax-arr[left];
                }
              left++;
            }
            else
            {
                if(rightMax<=arr[right])
                {
                    rightMax=arr[right];
                }
                else
                {
                    ans+=rightMax-arr[right];
                }
              right--;
            }
        }
        return ans;
    }
    public int trap(int[] height) {
        // int ans = BruteApproch(height);
        // int ans=MySolution2(height);
        int ans=MySolution3(height);
        return ans;
    }
}