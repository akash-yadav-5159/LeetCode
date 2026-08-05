class Solution {
    public int ans(int [][]grid,int [][]dp,int i, int j){
        if(i==grid.length||j==grid[0].length)return 80000;
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==grid.length-1&&j==grid[0].length-1)return grid[i][j];
        int firstRight=grid[i][j]+ans(grid,dp,i,j+1);
        int firstDown=grid[i][j]+ans(grid, dp, i+1,j);
        return dp[i][j]=Math.min(firstRight,firstDown);
    }
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length+1][grid[0].length];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return ans(grid,dp,0,0);
    }
}