public static TreeNode build(int pre[],int psi,int pei,int In[],int isi,int iei)
{
     if(isi>iei)
     {
         return null;
     }
     
      // step-2 make Root node
     TreeNode root=new TreeNode(pre[psi]);
      //step-3 count idx;
     int idx=isi;
     while(pre[psi]!=In[idx])
     {
         idx++;
     }
     
     int non=idx-isi;
    
    root.left=build(pre,psi+1,psi+non,In,isi,idx-1);
    root.right=build(pre,psi+non+1,pei,In,idx+1,iei);
    
    return root;
      
      
}
public TreeNode buildTree(int[] pre, int[] In) {
    return build(pre,0,pre.length-1,In,0,In.length-1);
  
}