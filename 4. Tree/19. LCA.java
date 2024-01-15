public TreeNode LCA=null;
public boolean helper(TreeNode root,TreeNode p,TreeNode q)
{
    if(root==null)
    {
        return false;
    }
    
    boolean self=(root==p || root==q)?true:false;
    
    boolean left=helper(root.left,p,q);
    boolean right=helper(root.right,p,q);
    
    if((left&&right) || (left&&self) || (right&&self))
    {
        LCA=root;
    }
    
    return left||right||self;
}