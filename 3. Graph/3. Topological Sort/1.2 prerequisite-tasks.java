class Solution {
    public boolean isPossible(int V, int P, int[][] prerequisites) {
        // Your Code goes here

        // COnvert given 2D array into ArrayList<ArrayList<Integer>> adj -> like graph
        // for (int i = 0; i < V; i++) {
        //     adjList.add(new ArrayList<>());
        // }

        // // Populate the adjacency list based on prerequisites
        // for (int i = 0; i < prerequisites.length; i++) {
        //     // Get the first course (prerequisite) and the second course from the pair
        //     int courseA = prerequisites[i][0];
        //     int courseB = prerequisites[i][1];

        //     // Add courseB to the list of courses that can be taken after courseA
        //     adjList.get(courseA).add(courseB);
        // }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        }

        /* Below code is cycle detect using toplogical sort code */

        /*-- BFS  ans using topological sort-------*/
        Queue<Integer> q = new LinkedList<>();

        // step-1 find Indegree
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (Integer e : adj.get(i)) {
                indegree[e]++;
            }
        }

        // step-2 add Nodes in Queue Whose Indegree is zero alreday
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)

            {
                q.add(i);
            }
        }
        int count = 0;
        // step-4 Apply Noram BFS
        int ans[] = new int[V];
        int i = 0;
        while (q.size() > 0) {
            count++;
            // 1
            int node = q.remove();
            // 2
            ans[i] = node;
            i++;
            // 3 reduce the indegree
            for (Integer e : adj.get(node)) {
                indegree[e]--;
                if (indegree[e] == 0) {
                    q.add(e);
                }
            }
        }
        if (count == V) {
            return true;
        } else {
            return false;
        }
    }

}