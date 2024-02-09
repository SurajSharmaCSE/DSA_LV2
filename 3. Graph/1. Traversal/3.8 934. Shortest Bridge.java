class Solution {
    class pair
    {
        int row;
        int col;

        pair(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
     int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) 
    {
        //1 
        int n = grid.length, m=grid[0].length;
        LinkedList<pair> Q = new LinkedList<>();
        boolean visited[][] = new boolean[n][m];

        //2
        boolean flag = false;
        for(int i=0;i<n && flag==false;i++)
        {
            for(int j=0;j<m && flag==false ;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(i,j,grid,visited,Q);
                    flag = true;
                }
            }
        }

        //3
        int level=0;
        while(Q.size()>0)
        {
            int sz = Q.size();
            while(sz-->0)
            {
                //rm*wa*
                pair p = Q.removeFirst();
                for(int d[]:dir)
                {
                    int rowdash = p.row+d[0];
                    int coldash = p.col+d[1];
                    if(rowdash<0 || coldash<0 || rowdash>=grid.length  || coldash>=grid[0].length || visited[rowdash][coldash]==true)
                    {
                        continue;
                    }
                    if(grid[rowdash][coldash]==1)
                    {
                        return level;
                    }
                    visited[rowdash][coldash]=true;
                    Q.addLast(new pair(rowdash,coldash));
                    
                }
            }
            level++;
        }
        return -1;
        
    }

    public void dfs(int i, int j, int grid[][] ,boolean visited[][], LinkedList<pair> Q)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length ||  visited[i][j]==true || grid[i][j]==0 )
        {
            return;
        }
        visited[i][j] = true;
        Q.add(new pair(i,j));

        dfs(i+1,j,grid,visited,Q);
        dfs(i,j+1,grid,visited,Q);
        dfs(i-1,j,grid,visited,Q);
        dfs(i,j-1,grid,visited,Q);
    }
}