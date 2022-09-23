public List<Integer> rightSideView(TreeNode root) {
        
    ArrayList<Integer> ans=new ArrayList<>();
    if(root==null)
    {
        return ans;
    }
    
    Queue<TreeNode> Q=new ArrayDeque<>();
    Q.add(root);
    
    while(Q.size()>0)
    {
        int sz=Q.size();
        for(int i=0;i<sz;i++)
        {
            TreeNode node=Q.remove();
            if(i==0)
            {
                ans.add(node.val);
            }
            
            // add node right and left in Q
            if(node.right!=null)
            {
                Q.add(node.right);
            }
            if(node.left!=null)
            {
                Q.add(node.left);
            }
            
           
        }
    }
    return ans;
    
}