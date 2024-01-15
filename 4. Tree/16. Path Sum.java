public boolean hasPathSum(TreeNode root, int targetSum) {
    if(root==null)
    {
        return false;
    }
    
    if(root.left==null && root.right==null)
    {
        if(targetSum==root.val)
        {
            return true;
        }
    }
    
    boolean leftside=hasPathSum(root.left,targetSum-root.val);
    boolean rightside=hasPathSum(root.right,targetSum-root.val);
    
    return leftside||rightside;
    
    
}
