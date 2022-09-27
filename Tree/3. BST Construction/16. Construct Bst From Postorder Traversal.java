public static int idx;
public static TreeNode build(int post[],int lr,int rr)
{
    //step-1
    if(idx<0 || post[idx]<lr || post[idx]>rr)
    {
        return null;
    }
    //step-2
    TreeNode root=new TreeNode(post[idx]);
    idx--;
    
    root.right=build(post,root.val,rr);
    root.left=build(post,lr,root.val);
    
    return root;
}
public static TreeNode bstFromPostorder(int[] post) {
    idx=post.length-1;
    int lr=-(int)1e9-1;
    int rr=(int)1e9+1;
    return build(post,lr,rr);
}
