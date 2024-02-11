class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        
        // Step-1
        Stack<Integer> st = new Stack<>();
        boolean visited1 [] = new boolean[V];
        for(int i=0;i<V;i++)  // might be there is multiple graph So we are using this loop
        {
            if(visited1[i]==false)
            {
                dfs1(i,adj,st,visited1);
            }
        }
        
        //step-2 make a new graph
        ArrayList<ArrayList<Integer>> newadj = new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            newadj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> nbr = adj.get(i);
            for(int e:nbr)
            {
                newadj.get(e).add(i);
            }
        }
        
        // step-3 - call dfs and make and
        int ans =0;
        boolean visited2 [] = new boolean[V];
        while(st.size()>0)
        {
            int s = st.pop();
            if(visited2[s]==false)
            {
                dfs2(s,newadj,visited2);
                ans++;
            }
        }
        
        return ans;
    }
    
    public void dfs1(int src,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st, boolean visited1[])
    {
        visited1[src] = true;
        for(int nbr:adj.get(src))
        {
            if(visited1[nbr]==false)
            {
                dfs1(nbr,adj,st,visited1);
            }
        }
        st.push(src);
    }
    
    public void dfs2(int src,ArrayList<ArrayList<Integer>> adj, boolean visited2[])
    {
        visited2[src] = true;
        for(int nbr:adj.get(src))
        {
            if(visited2[nbr]==false)
            {
                dfs2(nbr,adj,visited2);
            }
        }
    }
}