public int dia=0;
public int diameter(TreeNode node)
{
     //base case
    if(node==null)
    {
        return -1;
    }
    
    int lh=diameter(node.left);
    int rh=diameter(node.right);
    
    dia=Math.max(dia,lh+rh+2);
    
    return Math.max(lh,rh)+1;
    
}