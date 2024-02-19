class Solution
{
    static class pair
    {
        Node node;
        int hl;
        
        public pair(Node node, int hl)
        {
            this.node = node;
            this.hl = hl;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        
        //step1 make all data structure
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        LinkedList<pair> q = new LinkedList<>();
        int min =0, max = 0 ;
        
        //put first pair
        q.addLast(new pair(root,0));
        
        while(q.size()!=0)
        {
          int size = q.size();
          while(size-- >0)
          { 
            //1 remove pair
            pair curr_pair = q.removeFirst();
            Node curr_node = curr_pair.node;
            int curr_hl = curr_pair.hl;
            
            min = Math.min(min,curr_hl);
            max = Math.max(max,curr_hl);
            
            //2 check in hashMap
            if(map.containsKey(curr_hl)==true)
            {
                map.get(curr_hl).add(curr_pair.node.data);
            }
            else
            {
                map.put(curr_hl,new ArrayList<>());
                map.get(curr_hl).add(curr_pair.node.data);
            }
            
            //3 check if left and right children exit then put in quueu
            if(curr_node.left!=null)
            {
                q.addLast(new pair(curr_node.left,curr_hl-1));
            }
            if(curr_node.right!=null)
            {
                q.addLast(new pair(curr_node.right,curr_hl+1));
            }
          }
        }
        
        //make ans
        
        
         // Construct the finalAns list in the correct order
        for (int i = min; i <= max; i++) 
        {
            ans.add(map.get(i));
        }
    
        // Flatten the ans list to a single ArrayList
        ArrayList<Integer> finalAns = new ArrayList<>();
        for (List<Integer> list : ans) {
            finalAns.addAll(list);
        }
        
        return finalAns;
    }
}