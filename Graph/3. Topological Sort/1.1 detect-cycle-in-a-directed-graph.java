class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
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
}