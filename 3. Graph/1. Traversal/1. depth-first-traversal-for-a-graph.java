class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node,boolean[] visited, ArrayList<ArrayList<Integer>> graph, ArrayList<Integer>ans)
    {
       visited[node]=true;
       ans.add(node);
       
       //call on Node naibar
       for(Integer edges:graph.get(node))
       {
           if(visited[edges]==false)
           {
               dfs(edges,visited,graph,ans);
           }
       }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        boolean visited[]=new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                dfs(i,visited,adj,ans);
            }
        }
        return ans;
    }
    
}