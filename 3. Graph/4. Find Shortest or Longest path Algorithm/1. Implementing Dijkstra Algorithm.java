class Solution
{
    static class pair
    {
        int dist;
        int node;
    
       public pair(int dist, int node)
        {
         this.dist=dist;
         this.node=node;
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        Queue<pair> q = new LinkedList<>();
        int distance[] = new int[V];   // it's our ans array
        
        //initialize all index value with large value
        for(int i=0;i<V;i++)
        {
            distance[i]=Integer.MAX_VALUE;
        }
        
        distance[S]=0;
        q.add(new pair(0,S));
        
        while(q.size()>0)
        {
            // 1 remove one pair from Queue
            int dist=q.peek().dist;
            int node=q.peek().node;
            
            q.remove();
            
            //2 compare distance and 
            for(ArrayList<Integer> i:adj.get(node))
            {
                int nbr =  i.get(0);
                int nbr_dist = i.get(1);

                if(nbr_dist+dist<distance[nbr])
                {
                    distance[nbr]=nbr_dis+dist;
                    q.add(new pair(nbr_dis+dist , nbr));
                }
            }
            
        }
        return distance;
    }
}

