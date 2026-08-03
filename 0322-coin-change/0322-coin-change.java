class Solution {
    public int ans(int coins[],int []dp,int amount){
        if(amount<0)return -1;
        if(amount==0)return 0;
        if(dp[amount]!=-1)return dp[amount];
        int min=Integer.MAX_VALUE;
        for(int sum:coins){
            int rem=ans(coins,dp,amount-sum);
            if(rem>=0&&rem<min){
                min=1+rem;
            }
        }
        dp[amount]=(min==Integer.MAX_VALUE)?-2:min;
        return (dp[amount]==-2)?-1:dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        return ans(coins,dp,amount);
    }
}