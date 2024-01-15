
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        ArrayList<Integer>ans=new ArrayList<>();
        
        boolean visited[] = new boolean[V];
        
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visited[0]=true;
        
        while(q.size()>0)
        {
            Integer node=q.remove();
            ans.add(node);
            
            for(Integer edge:adj.get(node))
            {
                if(visited[edge]==false)
                {
                    q.add(edge);
                    visited[edge]=true;
                }
            }
        }
        
        return ans;
    }
}