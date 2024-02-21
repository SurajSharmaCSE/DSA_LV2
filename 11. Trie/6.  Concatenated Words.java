class Solution 
{
    public class Node
    {
        Node[] children=new Node[26];
        String s;
    }
    private Node root;
    private HashSet<String> set;
    public void insert(Node root,String word)
    {
        if(word.length()==0)
        {
            return;
        }
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(root.children[ch-'a']==null)
            {
                root.children[ch-'a']=new Node();
            }
            root=root.children[ch-'a'];
        }
        root.s=word;
    }
    public void matchCharacters(Node curr,Node nword)
    {
        if(curr.s!=null && nword.s!=null)
        {
            set.add(curr.s);
            return;
        }
        if(nword.s!=null){
            matchCharacters(curr,root);
        }
        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null && nword.children[i]!=null)
            {
                matchCharacters(curr.children[i],nword.children[i]);
            }
        }
    }
    public void dfsOnTrie(Node curr)
    {
        if(curr.s!=null){
            matchCharacters(curr,root);
        }
        for(int i=0;i<26;i++)
        {
            if(curr.children[i]!=null)
            {
                dfsOnTrie(curr.children[i]);
            }
        }
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) 
    {
        root=new Node();
        set=new HashSet<>();
        
        for(String word:words)
        {
            insert(root,word);
        }
        
        dfsOnTrie(root);
        List<String> ans=new ArrayList<>(set);
        return ans;
    }
}