public class 7. left view {
    
}    // public static void helper(Node node,int lv,ArrayList<Integer> ans)
    // {
    //     if(node==null)
    //     {
    //         return;
    //     }
        
    //     if(lv==ans.size())
    //     {
    //         ans.add(node.data);
    //     }
    //     helper(node.left,lv+1,ans);
    //     helper(node.right,lv+1,ans);
     
    // }
    // //Function to return list containing elements of left view of binary tree.
    // ArrayList<Integer> leftView(Node root)
    // {
    //   // Your code here
    //   ArrayList<Integer> ans=new ArrayList<>();
    //   helper(root,0,ans);
      
    //   return ans;
      
       
    // }
    
    /* Approch - by Pepcoding dsa class*/
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        
        Queue<Node> Q=new ArrayDeque<>();
        Q.add(root);
        
        while(Q.size()>0)
        {
            int sz=Q.size();
            for(int i=0;i<sz;i++)
            {
                Node node=Q.remove();
                if(i==0)
                {
                    ans.add(node.data);
                }
                
                // add node left and right in Q
                if(node.left!=null)
                {
                    Q.add(node.left);
                }
                if(node.right!=null)
                {
                    Q.add(node.right);
                }
            }
        }
        return ans;
    }
