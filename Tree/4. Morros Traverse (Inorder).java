 /* Morro's order traversal use i.e not use any type of extra space*/
 public List<Integer> inorderTraversal(TreeNode root) 
 {
     ArrayList<Integer> ans=new ArrayList<>();
     //step-1
     TreeNode curr=root;  
     
     //step 2
     while(curr!=null)
     {
         //cheking curr.left!=null then create temp
      if(curr.left!=null)
       {
             TreeNode temp=curr.left;
         
         //step-3
         while(temp.right!=null && temp.right!=curr)
         {
             temp=temp.right;
         }
         if(temp.right==null) // means links note present then make link
         {
             temp.right=curr;
             curr=curr.left;
         }
         else  // make ans and remove the link
         { 
             // Links already present
             ans.add(curr.val);
             temp.right=null;
             curr=curr.right;
         }
      }
     else
     {
         ans.add(curr.val);
         curr=curr.right;
     }
   }
   
   return ans;
 }

