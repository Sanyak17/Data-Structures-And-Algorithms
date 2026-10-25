class Solution 
{
    static int rl;
    static int cl;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public int closedIsland(int[][] grid)
    {
       rl=grid.length; 
       cl=grid[0].length;
       boolean[] [] visited=new boolean[rl][cl];
       for(int i=0;i<rl;i++)
       {
        for(int j=0;j<cl;j++)
        {
            if(i==0||j==0||i==rl-1||j==cl-1)
                {
                    if(grid[i][j]==0&& !visited[i][j])
                dfs(i, j, visited, grid);
            }
        }
       }
       int components=0;
       for(int i=0;i<rl;i++)
       {
        for(int j=0;j<cl;j++)
        {

            if(visited[i][j]==false&&grid[i][j]==0)
        {
            dfs(i,j,visited,grid);
            components++;
        }
        }
       }
       return components;

    }
    public static void dfs(int r,int c,boolean[][] visited,int[][] grid)
    {
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]==1)
        return ;
        if(visited[r][c]==true)
        return;
        visited[r][c]=true;
        for(int i=0;i<4;i++)
        {
            dfs(r+dr[i],c+dc[i],visited,grid);
        }
    }
}