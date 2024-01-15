  //Iterative solution 
  public List<Integer> postorderTraversal(TreeNode root)
  {
      ArrayList<Integer> ans=new ArrayList<>();
      //base case
      if(root==null)
      {
          return ans;
      }
      Stack<TreeNode> st1=new Stack<>();
      Stack<TreeNode> st2=new Stack<>();
   
      
      st1.push(root);
      
      //
      while(st1.size()>0)
      {
          //
          TreeNode node=st1.pop();
          st2.push(node);
          
          if(node.left!=null)
          {
              st1.push(node.left);
          }
          if(node.right!=null)
          {
              st1.push(node.right);
          }
      }
      
      while(st2.size()!=0)
      {
          ans.add(st2.pop().val);
      }
      return ans;
  }
      