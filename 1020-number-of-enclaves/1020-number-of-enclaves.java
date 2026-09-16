class Solution {
    public void dfs(int i, int j, int [][]grid,int [][]direction){
        grid[i][j]=0;
        for(int k=0;k<direction.length;k++){
            int r=i+direction[k][0];
            int c=j+direction[k][1];
            if(r>=0&&r<grid.length&&c>=0&&c<grid[0].length&&grid[r][c]==1){
                dfs(r,c,grid,direction);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int direction[][]={{-1,0},{1,0},{0,-1},{0,1}};
        int land=0;
        int sr=0,sc=0,er=grid.length-1,ec=grid[0].length-1;
        while(sc<=ec){
            if(grid[0][sc]==1){
                dfs(0,sc,grid,direction);
            }
            sc++;
        }
        sc=0;
        while(sc<=ec){
            if(grid[er][sc]==1){
                dfs(er,sc,grid,direction);
            }
            sc++;
        }
        while(sr<=er){
            if(grid[sr][0]==1){
                dfs(sr,0,grid,direction);
            }
            sr++;
        }
        sr=0;
        while(sr<=er){
            if(grid[sr][ec]==1){
                dfs(sr,ec,grid,direction);
            }
            sr++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    land++;
                }
            }
        }
        return land;
    }
}