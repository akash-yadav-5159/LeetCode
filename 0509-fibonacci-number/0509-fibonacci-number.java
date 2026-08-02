class Solution {
    public int recu(int n,int []dp){
        if(dp[n]!=-1){
            return dp[n];
        }
        if(n==0||n==1){
            dp[n]=n;
            return n;
        }
        return dp[n]=(recu(n-1,dp)+recu(n-2,dp));
    }
    public int fib(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return recu(n,dp);
    }
}