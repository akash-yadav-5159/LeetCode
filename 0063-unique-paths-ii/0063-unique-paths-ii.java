class Solution {
    public int ans(int [][]obstacleGrid,int[][]dp,int i, int j){
        if(dp[i][j]!=-1)return dp[i][j];
        if(i==obstacleGrid.length||j==obstacleGrid[0].length)return 0;
        if(obstacleGrid[i][j]==1)return 0;
        if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1)return 1;
        int firstright=ans(obstacleGrid,dp,i,j+1);
        int firstdown=ans(obstacleGrid,dp,i+1,j);
        return dp[i][j]=firstright+firstdown;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return ans(obstacleGrid,dp,0,0);
    }
}