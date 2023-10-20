class Solution {
     
     /* Code 2: using DFS  */
     public boolean DFS_Check(int node, int color[], int graph[][])
     {
         if(color[node]==-1)
         {
             color[node] = 1;
         }
         //run for this node edges recursivly
         for(Integer edge: graph[node])
         {
             if(color[edge] == -1)
             {
                 color[edge] = 1 - color[node];   // this line of code use for coloring opposite color of adjcent ndoe
                 if(DFS_Check(edge,color,graph)==false)
                 {
                     return false;
                 }
             }
             else
             {
                 if(color[edge]==color[node])
                 {
                    return false;
                 }
             }
         }
         return true;
     }

     /* BFS Code */
     public boolean BFS_Check(int node, int color[], int graph[][])
     {
         Queue<Integer> q = new LinkedList<>();
         color[node] = 1;
         q.add(node);

            while(q.size()>0)
            {
                int curr_node = q.remove();
                for(Integer edge: graph[curr_node])
                {
                    if(color[edge]==-1)
                    {
                        color[edge] = 1-color[curr_node];
                        q.add(edge);
                    }
                    else if(color[edge]==color[curr_node])
                    {
                        return false;
                    }
                }
            }
        
        return true;
     }
     public boolean isBipartite(int[][] graph) 
     {
        
        int n = graph.length;

        /* this cod epart of DFS */
        
        // int visited[] = new int[n];
        // Arrays.fill(visited,-1);

        //this loop for multiple graph component
        // for(int i=0;i<n;i++)
        // {
        //     if(visited[i]==-1)
        //     {
        //         if(DFS_Check(i,visited,graph)==false)
        //         {
        //             return false;
        //         }
        //     }
        // }
        // return true;

      /* this code is part of BFS */ 
        int color[] = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
           if(color[i]==-1)
           {
               if(BFS_Check(i,color,graph)==false)
               {
                   return false;
               }
           }
        }
        return true;
     }
}