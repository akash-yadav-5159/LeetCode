class Solution {
    public int ans(int[][]matrix, int dp[][], int i, int j){
        if(j<0||j>matrix[0].length-1)return 10000;
        if(dp[i][j]!=-101)return dp[i][j];
        if(i==matrix.length-1)return matrix[i][j];
        int direct=matrix[i][j]+ans(matrix, dp, i+1,j);
        int dl=matrix[i][j]+ans(matrix,dp,i+1,j-1);
        int dr=matrix[i][j]+ans(matrix,dp,i+1,j+1);
        return dp[i][j]=Math.min(direct,Math.min(dl,dr));
    }
    public int minFallingPathSum(int[][] matrix) {
        int dp[][]=new int[matrix.length+1][matrix.length+1];
        for(int row[]:dp){
            Arrays.fill(row,-101);
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            res=Math.min(res,ans(matrix,dp,0,i));
        }
        return res;
    }
}