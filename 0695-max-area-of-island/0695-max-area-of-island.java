class Solution {
    public int dfs(int i, int j, int grid[][]){
        grid[i][j]=0;
        int  count=1;
        if(i!=0&&grid[i-1][j]==1){
            count+=dfs(i-1,j,grid);
        }
        if(i!=grid.length-1&&grid[i+1][j]==1){
            count+=dfs(i+1,j,grid);
        }
        if(j!=0&&grid[i][j-1]==1){
            count+=dfs(i,j-1,grid);
        }
        if(j!=grid[0].length-1&&grid[i][j+1]==1){
            count+=dfs(i,j+1,grid);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=Math.max(count,dfs(i,j,grid));
                }
            }
        }
        return count;
    }
}