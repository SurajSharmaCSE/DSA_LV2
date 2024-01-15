class GfG
{
    int BruteApprocach(int arr[], int n)
    {
        int ansL = 0;
        
        for(int i=0;i<arr.length;i++)
        {
            int sum=0;
            
            for(int j=i;j<arr.length;j++)
            {
                sum+=arr[j];
                
                if(sum==0)
                {
                    ansL = Math.max(ansL,j-i+1);
                }
            }
        }
        return ansL;
    }
    
    int OptimalApproach(int arr[], int n)
    {
        int ansL = 0;
        int i =-1;
        int sum = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(sum,i);
        
        while(i<arr.length-1)
        {
            i++;
            sum+=arr[i];
            
            if(map.containsKey(sum)==false)
            {
               map.put(sum,i); 
            }
            else
            {
                int currL = i-map.get(sum);
                if(currL>ansL)
                {
                    ansL=currL;
                }
            }
            
        }
        return ansL;
    }
    int maxLen(int arr[], int n)
    {
        // Your code here
        // return BruteApprocach(arr,n);
        return OptimalApproach(arr,n);
    }
}