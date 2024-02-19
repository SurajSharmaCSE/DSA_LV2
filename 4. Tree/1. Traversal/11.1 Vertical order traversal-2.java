/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair
    {
        TreeNode node;
        int hl;
         public pair(TreeNode node, int hl)
         {
             this.node = node;
             this.hl = hl;
         }
    }
    public void width(TreeNode root,int hl, int minMaxSize[])
    {
        if(root==null)
        {
            return;
        }
        minMaxSize[0] = Math.min(hl,minMaxSize[0]);
        minMaxSize[1] = Math.max(hl,minMaxSize[1]);

        width(root.left,hl-1,minMaxSize);
        width(root.right,hl+1,minMaxSize);

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //step1 find width if tree
        int minMaxSize[] = new int[2];
        width(root,0,minMaxSize);
        int len = minMaxSize[1] - minMaxSize[0] + 1;
        
        //step-2 Create Ans ArrayList<ArrayList<Integer>> and intiallize this
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<len;i++)
        {
            ans.add(new ArrayList<>());
        }

        //step-3 Create 2 Priority Queue 1-Parent Queue and 2-childQueue
        PriorityQueue<pair> parQueue = new PriorityQueue<>((a,b)->{
           return a.node.val - b.node.val;
        });
        PriorityQueue<pair> chilQueue = new PriorityQueue<>((a,b)->{
            return a.node.val - b.node.val;
        });

        //step-4 add first pair in parent Queue
        parQueue.add(new pair(root,Math.abs(minMaxSize[0])));

        //step-5
        while(parQueue.size()!=0)
        {
            int size = parQueue.size();
            while(size-- >0)
            {
                //1 remove one pair
                pair rp = parQueue.remove();
                TreeNode node = rp.node;
                int hl = rp.hl;

                //2 Add in and
                ans.get(hl).add(node.val);

                //3 if left and right child exist put in child Queue
                if(node.left!=null)
                {
                    chilQueue.add(new pair(node.left,hl-1));
                }
                if(node.right!=null)
                {
                    chilQueue.add(new pair(node.right,hl+1));
                }

            }
            //4 After parent Queue will be Empty then swap value child Queue ->into parent Queue
            PriorityQueue<pair> temp = parQueue;
            parQueue = chilQueue;
            chilQueue = temp;
        }

        return ans;
        
        
    }
}