// Question link leetcode -https://leetcode.com/problems/decode-ways/
    // using recursion --------------
    public static int helper(String s,int idx)
    {
        //base case
        if(idx==s.length())
        {
            return 1;
        }
        
        // main logic
        char ch1=s.charAt(idx);
        if(ch1=='0')
        {
            return 0;
        }
        int count=0;
        count+=helper(s,idx+1);
        
        // stpe 2 
        if(idx<s.length()-1)  // or idx>2
        {
            char ch2=s.charAt(idx+1);
            int num=(ch1-'0')*10+(ch2-'0');
            if(num<=26)
            {
                count+=helper(s,idx+2);
            }

        }
        return count;
    }
    
//--------- memoization ------------------
     public static int helper(String s,int idx,int dp[])
    {
        //base case
        if(idx==s.length())
        {
            
            return dp[idx]=1;
        }
        if(dp[idx]!=-1)
        {
            return dp[idx];
        }
        
        // main logic
        char ch1=s.charAt(idx);
        if(ch1=='0')
        {
            return dp[idx]=0;
        }
        int count=0;
        count+=helper(s,idx+1,dp);
        
        // stpe 2 
        if(idx<s.length()-1)  // or idx>2
        {
            char ch2=s.charAt(idx+1);
            int num=(ch1-'0')*10+(ch2-'0');
            if(num<=26)
            {
                count+=helper(s,idx+2,dp);
            }

        }
        return dp[idx]=count;
    }
    

//---------Tabulation------------------------------------
    public static int helper_Tab(String s)
    {
        //base case
       if(s.length()==0)
       {
           return 0;
       }
       
       int n=s.length();
       int dp[]=new int[n+1];
          
        Arrays.fill(dp,-1);
        dp[n]=1;
          
        for(int i=n-1;i>=0;i--)
        {
            char ch1=s.charAt(i);
            
            if(ch1=='0')
            {
                dp[i]=0;
                continue;
            }
            int count=dp[i+1]; // consider single element
            
            
            if(i<s.length()-1)
            {
                char ch2=s.charAt(i+1);
                int num=(ch1-'0')*10+(ch2-'0');
                if(num<=26)
                {
                    count+=dp[i+2]; // consider 2 element
                }
            }
           
            dp[i]=count;
        }
          return dp[0];
          
    }