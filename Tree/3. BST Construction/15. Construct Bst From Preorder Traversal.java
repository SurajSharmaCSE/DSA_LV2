public static int idx=0;
public static TreeNode build(int pre[],int n,int lr,int rr)
{
    //step-1
    if(idx==n || pre[idx]<lr || pre[idx]>rr)
    {
        return null;
    }
    //step-2
    TreeNode root=new TreeNode(pre[idx]);
    idx++;
    
    root.left=build(pre,n,lr,root.val);
    root.right=build(pre,n,root.val,rr);
    
    return root;
}
public static TreeNode bstFromPreorder(int[] pre) {
    int n=pre.length;
    int lr=-(int)1e9-1;
    int rr=(int)1e9+1;
    return build(pre,n,lr,rr);
}