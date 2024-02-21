class Solution {
    /*
      Approch:
      1. make trie using give all word list 
      2. make longest prefix 
     */
    class Node 
    {
        Node childs[] = new Node[26];
        String str;
    }
    public void insert(Node root, String word)
    {
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            if(root.childs[ch-'a']==null)
            {
                root.childs[ch-'a'] = new Node();
            }
            root = root.childs[ch-'a'];
        }
        root.str = word;
    }
    public void dfs(Node root)
    {
        for(Node child:root.childs)
        {
            if(child !=null && child.str!=null)
            {
                if(child.str.length()>ans.length())
                {
                    ans = child.str;
                }
                dfs(child);
            }
        }
    }
    String ans ="";
    public String longestWord(String[] words) 
    {
        Node root = new Node();
        for(String s:words)
        {
            insert(root,s);
        }
        dfs(root);
        return ans;
    }
}