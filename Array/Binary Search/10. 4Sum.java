public List<List<Integer>> fourSum(int[] arr, int target) {
    List<List<Integer>> ans=new ArrayList<>();
        //base case
        if(arr.length<4)
        {
            return ans;
        }
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length-3;i++)
        {
            for(int j=i+1;j<arr.length-2;j++)
            {
                int left=j+1;
                int right=arr.length-1;
                double sum=(double)target-arr[i]-arr[j];
                
                while(left<right)
                {
                    int sum1=arr[left]+arr[right];
                    if(sum==sum1)
                    {
                       List<Integer>subAns=new ArrayList<>();
                       subAns.add(arr[i]);
                       subAns.add(arr[j]);
                       subAns.add(arr[left]);
                       subAns.add(arr[right]); 
                        
                       ans.add(subAns);
                       
                        //duplicacy handale
                       while(left<right && arr[left]==arr[left+1])
                       {
                           left++;
                       }
                       while(left<right && arr[right]==arr[right-1])
                       {
                           right--;
                       }
                      left++;
                      right--;
                     }
                    else if(sum>sum1){left++;}
                    else{right--;}
                 }
                
                while(j<arr.length-2 && arr[j]==arr[j+1])
                {
                    j++;
                }
            }
            
            while(i<arr.length-3 && arr[i]==arr[i+1])
             {
               i++;
             }
        }
        
        return ans;
    }