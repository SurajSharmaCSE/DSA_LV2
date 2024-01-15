
/* ------------------------- Start   dfs Code -------------------- */

/*Complete the function below*/

class Solution {
    public boolean dfs(int node, boolean vis1[],boolean vis2[], ArrayList<ArrayList<Integer>> adj)
    {
        vis1[node]=true;
        vis2[node]=true;
        
        for(Integer edge:adj.get(node))
        {
            if(vis1[edge]==false)
            {
                if(dfs(edge,vis1,vis2,adj)==true)
                {
                    return true;
                }
            }
            else if(vis2[edge]==true)
            {
                return true;
            }
        }
        vis2[node]=false;
        return false;
        
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis1[] = new boolean[V];
        boolean vis2[] = new boolean[V];
        
        for(int i=0;i<V;i++)
        {
            if(vis1[i]==false)
            {
                if(dfs(i,vis1,vis2,adj)==true)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
/* ------------------------- END   dfs Code -------------------- */


/* -------------------------Start bfs Code --------------------- */

// use alos kahn's algo for find cycle in directed graph 
 // Function to detect cycle in a directed graph.
public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) 
   {
        // code here
        /*-- BFS  ans using topological sort-------*/
         Queue<Integer> q = new LinkedList<>();
         
         //step-1 find Indegree
         int indegree[]=new int[V];
         for(int i=0;i<V;i++)
         {
             for(Integer e:adj.get(i))
             {
                 indegree[e]++;
             }
         }
         
         //step-2 add Nodes in Queue Whose Indegree is zero alreday 
         for(int i=0;i<V;i++)
         {
             if(indegree[i]==0)
             
             {
                 q.add(i);
             }
         }
         int count =0;
         //step-4 Apply Noram BFS
         int ans[] = new int[V];
         int i=0;
         while(q.size()>0)
         {
             count++ ;
             //1
             int node=q.remove();
             //2
             ans[i]=node;
             i++;
             //3 reduce the indegree
             for(Integer e: adj.get(node))
             {
                 indegree[e]--;
                 if(indegree[e]==0)
                 {
                     q.add(e);
                 }
             }
         }
         if(count==V)
         {
             return false;
         }
         else 
         {
             return true;
         }
        
    
    }

/*Complete the function below*/

class Solution {
 public boolean bfs(int node, boolean vis1[],boolean vis2[], ArrayList<ArrayList<Integer>> adj)
 {
    boolean[] vis1 = new boolean[n];
    boolean[] vis2 = new boolean[n];
    
    for (int i = 0; i < n; i++) {
        if (!vis1[i]) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(i);
            vis1[i] = true;
            
            while (!queue.isEmpty()) {
                int node = queue.remove();
                
                for (Integer edge : adj.get(node)) {
                    if (!vis1[edge]) {
                        queue.add(edge);
                        vis1[edge] = true;
                        vis2[edge] = true;
                    } else if (vis2[edge]) {
                        return true; // Cycle detected
                    }
                }
                
                vis2[node] = false;
            }
        }
    }
    
    return false; // No cycle found
 }
}