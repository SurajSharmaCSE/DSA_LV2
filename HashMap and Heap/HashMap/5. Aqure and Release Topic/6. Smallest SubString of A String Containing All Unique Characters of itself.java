class Solution {
    public int BruteApproch(String s,String t)
    {
        int minLen = Integer.MAX_VALUE;
        int k = t.length();
        
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+k;j<=s.length();j++)
            {
                String str = s.substring(i,j);
                if(ContaisAllChar(str,t)==true && str.length()<minLen)
                {
                    minLen = str.length();
                }
            }
        }
        return minLen;
    }
    public boolean ContaisAllChar(String str, String t)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:t.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(char ch:str.toCharArray())
        {
            if(map.containsKey(ch)==true)
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0)
                {
                    map.remove(ch);
                }
            }
        }
        
        return map.isEmpty();
    }
    
   //Acquire and release Approch
    public int Optimal_Approch(String s, String t)
    {
        String ans ="";
        //step-1
        HashMap<Character, Integer> map1 = new HashMap<>(); // for s string 
        HashMap<Character, Integer> map2 = new HashMap<>(); // for p string 

        //step-2 store character Freq of t string 
        for(int i=0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        //step-3 take two pointer i and j
        int i=-1, j=-1;
        int mcount = 0 ;  // match count
        int dmcount = t.length();  // desire match count
       
        while(true)
        {
            //this flage use for rxite this whule(true) loop
            boolean flag1 = false;
            boolean flag2 = false;
            //aquire
            while(i<s.length()-1 && mcount<dmcount)
            {
               
               i++;
               char ch = s.charAt(i);
               map1.put(ch,map1.getOrDefault(ch,0)+1);

               if( map1.getOrDefault(ch,0) <= map2.getOrDefault(ch,0) )
               {
                   mcount++;
               }
               flag1 = true;
            }
            //save ans and release
            while(j<i && mcount==dmcount)
            {
                
                //save ans
                String str = s.substring(j+1,i+1);
                if(ans.length()==0 || str.length()<ans.length())
                {
                    ans = str;
                }
                j++;
                char ch = s.charAt(j);
                //check if current character freq 1 hai to complted remove kar de hashmap se
                if(map1.get(ch)==1)
                {
                    map1.remove(ch);
                }
                else
                {
                    map1.put(ch,map1.get(ch)-1);
                }

                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
                {
                    mcount--;
                }
                flag2 = true;
            }

            if(flag1==false && flag2==false)
            {
                break;
            }

        }

        return ans.length();
    }
    public int findSubString( String str) {
        // Your code goes here
        HashSet<Character> set = new HashSet<>();
        for(char ch: str.toCharArray())
        {
            set.add(ch);
        }
        
        String t = "";
        for(char ch :set)
        {
           t+=ch; 
        }
        
        // return BruteApproch(str,t);
        return Optimal_Approch(str,t);
    }
}