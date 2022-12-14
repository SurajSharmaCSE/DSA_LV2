class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new ArrayList<>();
        
        if(p.length()>s.length())
        {
            return ans;
        }
        
        int s_freq[]=new int[26];
        int p_freq[]=new int[26];
        
        int left=0;
        int right=0;
        
        while(right<p.length())
        {
            s_freq[s.charAt(right)-'a']++;
            p_freq[p.charAt(right)-'a']++;
            
            right++;
        }
        right--;
        
        while(right<s.length())
        {
            if(Arrays.equals(p_freq,s_freq))
            {
                ans.add(left);
            }
            right++;
            
            if(right!=s.length())
            {
                s_freq[s.charAt(right)-'a']++;
            }
            
            s_freq[s.charAt(left)-'a']--;
            left++;
        }
        return ans;
        
    }
}