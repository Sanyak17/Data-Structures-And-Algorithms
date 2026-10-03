class Solution 
{
    static int rl;
    static int cl;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public int islandPerimeter(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        boolean[][] visited=new boolean[rl][cl];
        int ans=0;
        for(int i=0;i<rl;i++)
        {
            for(int j=0;j<cl;j++)
            {
                if(visited[i][j]==false&& grid[i][j]==1)
                ans=peri(i,j,grid,visited);
            }
        }
        return ans;

    }
    public static int peri(int r,int c,int[][] grid,boolean[][] visited)
    {
        int perim=0;
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]==0)
        return 1;
        if(visited[r][c]==true)
        return 0;
        visited[r][c]=true;
        for(int i=0;i<4;i++)
        perim+=peri(r+dr[i],c+dc[i],grid,visited);
        return perim;
    }
}