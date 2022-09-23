// Recursive Code
    
//     public static void helper(TreeNode root,List<Integer> ans)
//     {
//         if(root==null)
//         {
//             return;
//         }
//         helper(root.left,ans);
//         ans.add(root.val);
//         helper(root.right,ans);
        
//     }
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<Integer>();
//         helper(root, ans);
        
//         return ans;
        
        
        
//     }
    
    // Iterativ
//         public List<Integer> inorderTraversal(TreeNode root) 
//         {
//             List<Integer> ans=new ArrayList<>();
//             Stack<TreeNode> st=new Stack<>();
            
//             TreeNode curr=root;
            
//             while(curr!=null || st.size()>0)
//             {
//                 while(curr!=null)
//                 {
//                     st.push(curr);
//                     curr=curr.left;
//                 }
//                 // mak ans;
//                 curr=st.pop();
//                 ans.add(curr.val);
//                 curr=curr.right;
                
//             }
//              return ans;
//         }
    
    //iterative by pepcoding
    public List<Integer> inorderTraversal(TreeNode root) 
    {
      Stack<TreeNode>st=new Stack<>();
      ArrayList<Integer> ans=new ArrayList<>();
      
      while(true)
      {
          if(root!=null)
          {
              st.push(root);
              root=root.left;
          }
          else
          {
              if(st.size()==0)
              {
                  break;
              }
              root=st.pop();
              ans.add(root.val);
              root=root.right;
          }
      }
      return ans;
    } 
  