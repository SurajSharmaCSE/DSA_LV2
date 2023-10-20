class Solution
{
    static class pair
    {
        int node;
        int wt;
         public pair(int node, int wt)
         {
             this.node = node;
             this.wt = wt;
         }
    }
    
    public static int  Prims_Algo_MST(int V, int E, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> x.wt-y.wt);
        boolean [] visited = new boolean[V];
        int sum=0;
        
        pq.add(new pair(0,0));
        
        while(pq.size()>0)
        {
            //1 remove a pair
            int node = pq.peek().node;
            int wt = pq.peek().wt;
            pq.remove();
            //2 check visited or not
             
            if (visited[node] == true) continue;
            // add it to the mst
            visited[node] = true;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (visited[adjNode] == false) {
                    pq.add(new pair(adjNode,edW));
                }
            }
          
        }
       return sum;
    }
	static int spanningTree(int V, int E, int edges[][])
	{
	   ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
       
        for (int i = 0; i < V; i++) 
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < E; i++) 
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }
       
       int ans = Prims_Algo_MST(V,E,adj);
       return ans;
	}
}