

/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order.
    /*DFS Code---------------*/
    
    // static void dfs(int node, boolean visited[], Stack<Integer>st, ArrayList<ArrayList<Integer>> adj)
    // {
    //     visited[node]=true;
    //     for(Integer e:adj.get(node))
    //     {
    //         if(visited[e]==false)
    //         {
    //             dfs(e,visited,st,adj);
    //         }
    //     }
    //     st.push(node);
    // }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
            // add your code here
            //  this code is part of DFS 
            
            //     boolean visited[] = new boolean[V];
            //     Stack<Integer> st = new Stack<>();
            
            //     for(int i=0;i<V;i++)
            //     {
            //         if(visited[i]==false)
            //         {
            //             visited[i]=true;
            //             dfs(i,visited,st,adj);
            //         }
            //     }
            
            //     int ans[]=new int[V];
            //     int i=0;
            //     while(st.size()>0)
            //     {
            //         ans[i]=st.pop();
            //         i++;
            //     }
            //     return ans;
            // }
    
        /*-- BFS -------*/
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
         
         //step-4 Apply Noram BFS
         int ans[] = new int[V];
         int i=0;
         while(q.size()>0)
         {
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
    
         return ans;
    }
}