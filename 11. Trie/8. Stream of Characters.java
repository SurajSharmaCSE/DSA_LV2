class StreamChecker {
    class Node
    {
        Node childs[] = new Node[26];
        boolean isEnd = false;
    }
    
    private final Node root;
    private final StringBuilder sb;
    public StreamChecker(String[] words) 
    {
        root = new Node();
        sb = new StringBuilder();
        for(String s:words)
        {
            Node curr = root;
            for(int i=s.length()-1;i>=0;i--)
            {
                char ch = s.charAt(i);
                if(curr.childs[ch-'a']==null)
                {
                    curr.childs[ch-'a'] = new Node();
                }
                curr = curr.childs[ch-'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public boolean query(char letter) 
    {
        sb.append(letter);
        Node curr = root;

        for(int i=sb.length()-1;i>=0;i--)
        {
            char ch = sb.charAt(i);

            curr = curr.childs[ch-'a'];
            if(curr==null){return false;}
            if(curr.isEnd){return true;}
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */