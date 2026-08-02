class Solution {
    public int ans(int[]dp, int n){
        if(dp[n]!=-1)return dp[n];
        if(n==2||n==1){
            return dp[n]=n;
        }
        int single=ans(dp,n-1);
        int doubles=ans(dp,n-2);
        dp[n]=single+doubles;
        return dp[n];
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return ans(dp,n);
    }
}