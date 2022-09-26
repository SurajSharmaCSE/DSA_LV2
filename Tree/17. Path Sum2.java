class Solution {
    public void helper(TreeNode root,int tar,List<Integer> subAns,List<List<Integer>> ans)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            if(tar==root.val)
            {
                List<Integer> temp=new ArrayList(subAns);
                temp.add(root.val);
                ans.add(temp);
                return;
            }
        }
        
        subAns.add(root.val);
        
        helper(root.left,tar-root.val,subAns,ans);
        helper(root.right,tar-root.val,subAns,ans);
        
        subAns.remove(subAns.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> subAns=new ArrayList<>();
        
        helper(root,targetSum,subAns,ans);
        
        return ans;
        
    }
}