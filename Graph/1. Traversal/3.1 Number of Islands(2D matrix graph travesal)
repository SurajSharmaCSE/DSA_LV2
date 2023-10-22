class Solution {
    public void getComponent(int i,int j, boolean visited[][], char grid[][])
    {
        //base case
        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == '0' || visited[i][j]== true )
        {
            return;
        }
         visited[i][j]=true;
        //main logic
        getComponent(i-1,j,visited,grid);
        getComponent(i,j+1,visited,grid);
        getComponent(i,j-1,visited,grid);
        getComponent(i+1,j,visited,grid);
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        boolean visited [][] = new boolean[n][m];

        //run for find all component 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1' && visited[i][j]==false)
                {
                    getComponent(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
}