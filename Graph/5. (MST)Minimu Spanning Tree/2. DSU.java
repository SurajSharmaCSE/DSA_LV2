class Code {
    int par[];
    int size[]; // rank array

    public int findParent(int u) 
    {
        if (par[u] == u) 
        {
            return u;
        }
        par[u] = findParent(par[u]);
        return par[u];
    }
// main logic
    public void merge(int u, int v) 
    {
        //step-1 find parent u and v
        int p1 = findParent(u);
        int p2 = findParent(v);
        //step-2 , step-3 => find rank of u,v and attech larger rank parnt to smaller
        if (p1 != p2) {
            if (size[p1] > size[p2]) 
            {
                par[p2] = p1;
                size[p1] += size[p2];
            } else 
            {
                par[p1] = p2;
                size[p2] += size[p1];
            }
        }
    }

    // give
    public void DSU(int V, int[][] adj) 
    {
        par = new int[V];
        size = new int[V];  // rank

        for (int i = 0; i < V; i++) 
        {
            size[i] = 1; // Initialize size of each set to 1
            par[i] = i; // Initialize each element as its own parent initially
        }

        for (int edge[] : adj) 
        {
            int u = edge[1];
            int v = edge[2];

            int p1 = findParent(u);
            int p2 = findParent(v);

            if (p1 != p2) 
            {
                merge(p1, p2);
            }
        }
    }
}