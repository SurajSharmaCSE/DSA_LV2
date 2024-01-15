class Solution {
    static void DFS(int node,ArrayList<ArrayList<Integer>> adj,boolean visited[] )
    {
        visited[node] = true;
        
        for(Integer edg: adj.get(node))
        {
            if(visited[edg]==false)
            {
                DFS(edg,adj,visited);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        //Create own ArrayList Graph, from INput 
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<V;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i =0;i<adj.size();i++)
        {
            for(int j =0;j<adj.get(i).size();j++)
            {
                if(adj.get(i).get(j)==1)
                {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        //Main Logic here
        int count =0;
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i]==false)
            {
                count++;
                DFS(i,adjList,visited);
            }
        }
        
        return count;
    }
};