class Solution{
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) 
    {
        //Complete the function
        long ans = 0;
        
        for(int i=0;i<arr.length;i++)
        {
            ans^=(2*arr[i]);
        }
        return ans;
    }  
}
