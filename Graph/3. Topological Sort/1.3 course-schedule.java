class Solution
{
    static int[] findOrder(int V, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        
        // COnvert given 2D array into ArrayList<ArrayList<Integer>> adj -> like graph 
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++)
        {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
            
        }
        
      /*Below code is cycle detect using toplogical sort code */
      
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
             return ans;
         }
         else 
         {
             int arr[]={};
             return arr;
         }
    }
}