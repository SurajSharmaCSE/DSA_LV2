public static TreeNode helper(int post[], int psi,int pei,int in[],int isi,int iei)
{
    if(isi>iei)
    {
        return null;
    }
    
    TreeNode root=new TreeNode(post[pei]);
    int idx=isi;
    
    while(post[pei]!=in[idx])
    {
        idx++;
    }
    int non=idx-isi;
    
    root.left=helper(post,psi,psi+non-1,in,isi,idx-1);
    root.right=helper(post,psi+non,pei-1,in,idx+1,iei);
    
    return root;
}
public TreeNode buildTree(int[] in, int[] post) {
    
    return helper(post,0,post.length-1,in,0,in.length-1);
    
}