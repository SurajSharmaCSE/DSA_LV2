

// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution 
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) 
    {
        // Write your code here
        int dist[] = new int[V];
        
        for(int i=0;i<V;i++)
        {
            dist[i]=100000000;
        }
        
       dist[S]=0;
      for(int i=1;i<=V-1;i++)
       {
        for(ArrayList<Integer> it: edges)
        {
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);
            
            if(dist[u]+w<dist[v])
            {
                dist[v]=dist[u]+w;
            }
        }
       }
       
       //check cycle exist or not 
       for(ArrayList<Integer> it: edges)
        {
            int u = it.get(0);
            int v = it.get(1);
            int w = it.get(2);
            
            if(dist[u]+w<dist[v])
            {
                int ans[]=new int[1];
                ans[0]=-1;
                return ans;
            }
        }
        
        return dist;
        
    }
}