    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                dfs(i,adj,visited,st);
            }
        }
        
       return st.pop();  // 
    }
    
    public void dfs(int src, ArrayList<ArrayList<Integer>>adj,boolean visited[],Stack<Integer> st)
    {
        visited[src] = true;
        
        for(int e:adj.get(src))
        {
            if(visited[e]==false)
            {
                dfs(e,adj,visited,st);
            }
        }
        
        st.push(src);
    }