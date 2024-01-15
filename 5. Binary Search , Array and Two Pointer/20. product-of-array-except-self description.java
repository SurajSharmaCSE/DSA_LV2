class Solution {
    public int[] Brute_Approch(int[] arr)
    {
        int n = arr.length;
        int ans[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int num = 1;
            for(int j=0;j<n;j++)
            {
                if(j==i){continue;}
                num*=arr[j];
            }
            ans[i] = num;
        }
        return ans;
    }
   
   /*Video Explain - https://www.youtube.com/watch?v=UBkpyXgx0g0 */
    public int[] optimalSolution(int arr[])
    {
        //step1 -  make right product Array
        int n = arr.length;
        int rightProduct[] = new int[n];
        int var=1;
        for(int i=n-1;i>=0;i--)
        {
            var*=arr[i];
            rightProduct[i] = var; 
        }

        //step-2 take a lp varibale and maintain left product and fill ans
        int prod=1;
        int ans[] = new int[n];
        for(int i=0;i<n-1;i++)
        {
            int left = prod;
            int right = rightProduct[i+1];

            ans[i] = left*right;

            prod*= arr[i];
        }
        ans[n-1] = prod;
        return ans;
    }


    
    public int[] productExceptSelf(int[] nums) 
    {
        // return Brute_Approch(nums);
        return optimalSolution(nums);
        
    }

}