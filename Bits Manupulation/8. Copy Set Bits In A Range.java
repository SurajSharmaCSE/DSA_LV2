class Solution{
    static int setSetBit(int x, int y, int l, int r)
    {
        // code here
        int mask = y&(((1<<(r-l+1))-1)<<(l-1));
        int ans = x|mask;
        
        return ans;
    }
}