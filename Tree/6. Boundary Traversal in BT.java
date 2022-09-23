import java.util.ArrayList;

public class Solution {
    public static boolean IsLeaf(TreeNode node)
    {
        if(node.left==null && node.right==null)
        {
            return true;
        }
        return false;
    }
    public static void leftBD(TreeNode root,ArrayList<Integer> res)
    {
        TreeNode curr=root.left;
        while(curr!=null)
        {
            if(IsLeaf(curr)==false)
            {
                res.add(curr.data);
            }
            if(curr.left!=null)
            {
                curr=curr.left;
            }
            else
            {
                curr=curr.right;
            }
        }
        
    }
    
    public static void rightBD(TreeNode root,ArrayList<Integer> res)
    {  
        TreeNode curr=root.right;
        ArrayList<Integer>temp=new ArrayList<>();
        while(curr!=null)
        {
            if(IsLeaf(curr)==false)
            {
                temp.add(curr.data);
            }
            if(curr.right!=null)
            {
                curr=curr.right;
            }
            else
            {
                curr=curr.left;
            }
        }
        for(int i=temp.size()-1;i>=0;--i)
        {
            res.add(temp.get(i));
        }
    }
    
    public static void leafNode(TreeNode root,ArrayList<Integer> res)
    {
        if(IsLeaf(root)==true)
        {
            res.add(root.data);
            return;
        }
        if(root.left!=null)
        {
            leafNode(root.left,res);
        }
        if(root.right!=null)
        {
           leafNode(root.right,res);
        }
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		// Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        if(IsLeaf(root)==false)
        {
            ans.add(root.data);
        }
        leftBD(root,ans);
        leafNode(root,ans);
        rightBD(root,ans);
        
        
        return ans;
        
	}
}