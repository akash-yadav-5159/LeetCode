import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Tumhara favourite 2D DP array: [amount + 1][coins.length + 1]
        int[][] dp = new int[amount + 1][coins.length + 1];
        
        // DP ko -1 se initialize kar do
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // 0th index se shuru karenge
        int ans = solve(coins, amount, 0, dp);
        
        // Agar answer 1e9 (ek bahut bada number) ke barabar ya usse bada hai, 
        // matlab target banana possible hi nahi hua
        if (ans >= (int)1e9) {
            return -1;
        }
        
        return ans;
    }
    
    private int solve(int[] coins, int amount, int index, int[][] dp) {
        // Base Case 1: Agar amount 0 mil gaya, matlab ab aur 0 coins chahiye
        if (amount == 0) {
            return 0; 
        }
        
        // Base Case 2: Agar saare coins check kar liye ya amount negative ho gaya
        if (index == coins.length || amount < 0) {
            return (int)1e9; // Ek invalid/bada number bhejo, taaki Math.min isko ignore kar de
        }
        
        // Memoization check
        if (dp[amount][index] != -1) {
            return dp[amount][index];
        }
        
        // Choice 1: Current coin ko PICK karo (agar amount allow kare)
        int pick = (int)1e9;
        if (coins[index] <= amount) {
            // MAGIC YAHAN HAI: 
            // 1. '+ 1' kiya kyunki humne ek coin le liya.
            // 2. 'index' same rakha kyunki infinite supply hai, hum ise wapas le sakte hain.
            pick = 1 + solve(coins, amount - coins[index], index, dp);
        }
        
        // Choice 2: Current coin ko SKIP karo aur aage badho
        // Coin nahi liya, isliye +1 nahi kiya, aur index + 1 karke aage badh gaye.
        int skip = solve(coins, amount, index + 1, dp);
        
        // Dono choices mein se jisme sabse kam coins lage (minimum), usko save karo
        dp[amount][index] = Math.min(pick, skip);
        
        return dp[amount][index];
    }
}