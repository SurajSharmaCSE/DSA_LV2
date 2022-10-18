public static int solution(String str) {
    // write your code here
    int ans=0;
    int i=-1,j=-1;
    
    HashMap<Character,Integer>map=new HashMap<>();
    
    while(true)
    {
        boolean flag1=false;
        boolean flag2=false;
        
        //aquire
        while(i<str.length()-1)
        {
            i++;
            flag1=true;
            char ch=str.charAt(i);
            
            map.put(ch,map.getOrDefault(ch,0)+1);
            
            if(map.get(ch)==2)
            {
                break;
            }
            else
            {
                ans+=(i-j);
            }
        }
        //release
        while(j<i)
        {
            j++;
            flag2=true;
            char ch=str.charAt(j);
            map.put(ch,map.get(ch)-1);
            
            if(map.get(ch)==1)
            {
                ans+=(i-j);
                break;
            }
        }
        if(flag1==false && flag2==false)
        {
            break;
        }
    }
    return ans;
}