class Solution {
    public int ans(int [][]dp,int m,int n,int cr,int cc){
        if(dp[cr][cc]!=-1)return dp[cr][cc];
        if(cr==m||cc==n)return 0;
        if(cr==m-1&&cc==n-1)return 1;
        int firstright=ans(dp,m,n,cr,cc+1);
        int firstdown=ans(dp,m,n,cr+1,cc);
        return dp[cr][cc]=firstright+firstdown;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return ans(dp,m,n,0,0);
    }
}