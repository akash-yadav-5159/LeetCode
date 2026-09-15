class Solution {
    public void dfs(int i, int j, char grid[][], boolean vis[][]){
        vis[i][j]=true;
        if(i!=0&&grid[i-1][j]=='1'&&!vis[i-1][j]){
            dfs(i-1,j,grid,vis);
        }
        if(i!=grid.length-1&&grid[i+1][j]=='1'&&!vis[i+1][j]){
            dfs(i+1,j,grid,vis);
        }
        if(j!=0&&grid[i][j-1]=='1'&&!vis[i][j-1]){
            dfs(i,j-1,grid,vis);
        }
        if(j!=grid[0].length-1&&grid[i][j+1]=='1'&&!vis[i][j+1]){
            dfs(i,j+1,grid,vis);
        }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        boolean vis[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    dfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
}

