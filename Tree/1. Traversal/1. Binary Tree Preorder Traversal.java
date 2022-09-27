package Traversal;
// recursive code
/*
     public static void helper(TreeNode root,List<Integer> ans)
    {
        if(root==null)
        {
            return;
        }
        ans.add(root.val);
        helper(root.left,ans);
        helper(root.right,ans);
        
    }
*/

 // iterative 
 public List<Integer> preorderTraversal(TreeNode root)
 {
      List <Integer> ans=new ArrayList<>();
        if (root == null)
        {
           return ans;     
        }
       
        
        // step - 1 Create a Stack
        Stack<TreeNode> st=new Stack<>();
        //step - 3 push first element in stack i.e root note
        st.push(root);
        
        while(st.size()>0)
        {
            TreeNode topNode=st.pop();
            ans.add(topNode.val);
            
            
            if(topNode.right!=null)
            {
                st.push(topNode.right);
            }
            if(topNode.left!=null)
            {
                st.push(topNode.left);
            }
        }
        
        return ans;
 }   