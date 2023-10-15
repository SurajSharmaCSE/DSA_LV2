
//User function template for JAVA

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        // code here
    //base case
    if(s1.length()!=s2.length())
    {
        return false;
    }
    HashMap<Character,Integer>map=new HashMap<>();
    
    for(int i=0;i<s1.length();i++)
    {
        char ch=s1.charAt(i);
        map.put(ch,map.getOrDefault(ch,0)+1);
    }
    
    for(int i=0;i<s2.length();i++)
    {
        char ch=s2.charAt(i);
        if(map.getOrDefault(ch,0)>0)
        {
            map.put(ch,map.get(ch)-1);
        }
    }
    
    int count=0;
    for(char ch:map.keySet())
    {
        count+=map.get(ch);
    }
    
    
    if(count>k)
    {
        return false;
    }
    else
    {
        return true;
    }
    
    }
}