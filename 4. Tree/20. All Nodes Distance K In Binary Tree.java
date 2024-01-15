public static void KLevelDown(TreeNode root,int k,TreeNode blocker,ArrayList<Integer> ans)
{
    if(root==null || k<0 || root==blocker)
    {
        return;
    }
    if(k==0)
    {
        ans.add(root.val);
        return;
    }
    
    KLevelDown(root.left,k-1,blocker,ans);
    KLevelDown(root.right,k-1,blocker,ans);
    
    
}


//--------------------main logic --------------------------
public static int nodeToRoot(TreeNode root,int target,int k,ArrayList<Integer> ans)
  {
      if(root==null)
      {
          return -1;
      }
      if(root.val==target)
      {
          KLevelDown(root,k,null,ans);
          return 1;
      }
      
      int ld=nodeToRoot(root.left,target,k,ans);
      if(ld!=-1)
      {
           KLevelDown(root,k-ld,root.left,ans);
           return ld+1;
      }
      int rd=nodeToRoot(root.right,target,k,ans);
      if(rd!=-1)
      {
          KLevelDown(root,k-rd,root.right,ans);
          return rd+1;
      }
      
      return -1;
      
  }
