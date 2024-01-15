class Solution {
    class pair
    {
        int node;
        int parent;
          
          pair(int node,int parent)
          {
              this.node=node;
              this.parent=parent;
          }
    }
    
    // DFS code
    public boolean dfs(int node,int par,boolean visited[], ArrayList<ArrayList<Integer>> adj)
    {
        visited[node]=true;
        for(Integer edge:adj.get(node))
        {
            if(visited[edge]==false)
            {
                if(dfs(edge,node,visited,adj)==true)
                {
                    return true;
                }
            }
            else if(edge!=par)
            {
                return true;
            }
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        //BFS Code---------------------------------------
        
        // boolean visited[] = new boolean[V];
        
        // //this outer loop for multiple graph component 
        // for(int i=0;i<V;i++)
        // {
        //   if(visited[i]==false)
        //   {
        //     Queue<pair> q= new LinkedList<>();
        //     q.add(new pair(i,-1));
        //     visited[i]=true;
            
        //     while(q.size()>0)
        //     {
        //         int node=q.peek().node;
        //         int pare=q.peek().parent;
                
        //         q.remove();
                
        //         //add this nbr
        //         for(Integer edge:adj.get(node))
        //         {
        //             if(visited[edge]==false)
        //             {
        //                 visited[edge]=true;
        //                 q.add(new pair(edge,node));
        //             }
        //             else if(pare!=edge)
        //             {
        //               return true;
        //             }
        //         }
        //     }
        //   }
        // }
        // return false;
        
        /* DFS CODE ----------------------  */
        
        boolean visited[] = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                if(dfs(i,-1,visited,adj)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }