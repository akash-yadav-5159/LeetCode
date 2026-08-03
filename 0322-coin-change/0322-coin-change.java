class Solution {
    public int ans(int[] coins, int[] dp, int amount) {
        if (amount < 0) return -1; 
        if (amount == 0) return 0;   
        
        // Agar value 0 nahi hai, matlab ya toh valid answer hai ya -1 (impossible) hai
        if (dp[amount] != 0) return dp[amount]; 
        
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int rem = ans(coins, dp, amount - coin);
            if (rem >= 0 && rem < min) {
                min = 1 + rem;
            }
        }
        
        // Seedha -1 save karo agar combination nahi mila
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
    
    public int coinChange(int[] coins, int amount) {
        // Default array mein sab 0 hote hain
        int[] dp = new int[amount + 1]; 
        return ans(coins, dp, amount);
    }
}