public static TreeNode build(int In[],int low,int high)
{
    if(low>high)
    {
        return null;
    }
    
    int mid=(low+high)/2;
    
    TreeNode root=new TreeNode(In[mid]);
    
    root.left=build(In,low,mid-1);
    root.right=build(In,mid+1,high);
    
    return root;
}
public static TreeNode constructFromInOrder(int[] In) {
    return build(In,0,In.length-1);
}