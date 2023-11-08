class Solution {
    public boolean BruteApproch(int n) 
    {
       if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
    public boolean UsingBits(int n)
    {
        int count =0;
        while(n!=0)
        {
           int rsbm = ~(n&(-n));
           count++;
           n=n&rsbm;
        }
        if(count==1){return true;}
        return false;

    }
    public boolean isPowerOfTwo(int n) 
    {
        // return BruteApproch(n);
        return UsingBits(n);
        
    }
}