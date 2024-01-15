//----------------------main logic ------------------------

public static int maxTime=0;
  public static void burnNode(TreeNode root,int time,TreeNode blocker)
  {
      if(root==null || root==blocker)
      {
          return;
      }
      
      maxTime=Math.max(maxTime,time);
      
      burnNode(root.left,time+1,blocker);
      burnNode(root.right,time+1,blocker);
  }

//----------------------------previous similar code -------------
public static int helper(TreeNode root,int fireNode)
  {
      if(root==null)
      {
          return -1;
      }
      if(root.val==fireNode)
      {
          burnNode(root,0,null);
          return 1;
      }
      
      int ld=helper(root.left,fireNode);
      if(ld!=-1)
      {
          burnNode(root,ld,root.left);
          return ld+1;
      }
      int rd=helper(root.right,fireNode);
      if(rd!=-1)
      {
          burnNode(root,rd,root.right);
          return rd+1;
      }
      
      return -1;

  }