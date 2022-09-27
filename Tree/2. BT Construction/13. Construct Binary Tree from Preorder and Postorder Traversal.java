public static TreeNode helper(int pre[],int psi,int pei,int post[],int ppsi,int ppei)
{
    if(psi>pei)
    {
        return null;
    }
    
    TreeNode root=new TreeNode(pre[psi]);
    if(psi==pei)
    {
        return root;
    }
    int idx=ppsi;
    while(pre[psi+1]!=post[idx])
    {
        idx++;
    }
    
    int non=idx-ppsi+1;
    
    root.left=helper(pre,psi+1,psi+non,post,ppsi,idx);
    root.right=helper(pre,psi+non+1,pei,post,idx+1,ppei-1);
    
    return root;
}
public TreeNode constructFromPrePost(int[] pre, int[] post) {
    
   return helper(pre,0,pre.length-1,post,0,post.length-1);
    
}