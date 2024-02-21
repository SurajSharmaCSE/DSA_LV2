class Solution{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static int Approch_BruteApproch(int a, int b)
    {
        int ans = a^b;
        int count=0;
        while(ans>0)
        {
            if((ans&1)==1)
            {
                count++;
            }
            ans>>=1;
        }
        return count; 
    }
    // Using Kernighans Algorithm 
    public static int Approch_2_Optimal(int a, int b)
    {
        int n = a^b;
        int count=0;
        
        while(n!=0)
        {
            int rsbm = ~(n&(-n));
            count++;
            n=n&rsbm;
        }
        return count;
    }
    
    public static int countBitsFlip(int a, int b)
    {
        
        // return Approch_BruteApproch(a,b);
        return Approch_2_Optimal(a,b);
        
    }
    
    
}