class Solution {
    static int rl;
    static int cl;
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    public int maxAreaOfIsland(int[][] grid) {
        rl=grid.length;
        cl=grid[0].length;
        int max=0;
        boolean[][] visited=new boolean[rl][cl];
        int count=0;
        for(int i=0;i<rl;i++)
        {
            for(int j=0;j<cl;j++)
            {
                if (grid[i][j] == 1 && visited[i][j]==false)
                {
                count=dfs(i,j,grid,visited);
                 max=Math.max(max,count);
                }
            }
        }
        return max;     
    }
    public static int dfs(int r,int c,int[][] grid,boolean[][] visited)
    {
        if(r<0||c<0||r>=rl||c>=cl||grid[r][c]==0)
        return 0;
        if(visited[r][c]==true)
        return 0;
        visited[r][c] = true;
        int count=1;
        for(int i=0;i<4;i++)
        count+=dfs(r+dr[i],c+dc[i],grid,visited);
        return count;
    }
}