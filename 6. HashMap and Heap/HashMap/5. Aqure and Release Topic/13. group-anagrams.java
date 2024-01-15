class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<HashMap<Character,Integer>,List<String>> ans=new HashMap<>();
        
            for(int i=0;i<strs.length;i++)
            {
                HashMap<Character,Integer> map=new HashMap<>();
                for(int j=0;j<strs[i].length();j++)
                {
                    char ch=strs[i].charAt(j);
                    
                    map.put(ch,map.getOrDefault(ch,0)+1);
                }
                if(ans.containsKey(map)==true)
                {
                    List<String> list=ans.get(map);
                    list.add(strs[i]);
                }
                else
                {
                    List<String>list=new ArrayList<>();
                    list.add(strs[i]);
                    ans.put(map,list);
                }
            }
        
          List<List<String>>res=new ArrayList<>();
          for(List<String>list:ans.values())
          {
              res.add(list);
          }
        return res;
    }
}