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
    public int maxDistance(int[][] grid) 
    {
        //1
        LinkedList<pair> Q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    Q.addLast(new pair(i,j));
                }
            }
        }
        if(Q.size()==0 || Q.size()==grid.length*grid[0].length)  // mean sabhi 1 or o hai
        {
            return -1;
        }
        //2
        int level=-1;
        while(Q.size()>0)
        {
            level++;
            int size = Q.size();
            while(size-->0)
            {
                //rm*wa
                pair p = Q.removeFirst();
                //  cal for 4 neibar
                for(int d[]:dir)
                {
                   int rowdash = p.row+d[0];
                   int coldash = p.col+d[1];

                   if(rowdash<0 || rowdash>=grid.length || coldash<0 || coldash>=grid[0].length || grid[rowdash][coldash]==1)
                   {
                       continue;
                   }
                   Q.add(new pair(rowdash,coldash));
                   grid[rowdash][coldash] = 1;
                }
            }
        }
        return level;

    }
}