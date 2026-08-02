class Solution {
    public int fib(int n) {
        // Agar n 0 ya 1 hai, toh seedha n return kar do agar ye base condition nhi likhe to n=0 k liye out of bound dega, kyuki hum dp[1] ko access hi nhi kar paayenge
        if (n == 0 || n == 1) {
            return n;
        }
        
        // 1. DP array banayenge (size n+1 taaki n index exist kare)
        int[] dp = new int[n + 1];
        
        // 2. Base cases ko array mein manually daalenge
        dp[0] = 0;
        dp[1] = 1;
        
        // 3. Bottom-Up calculation: Loop 2 se shuru hoga n tak jayega
        for (int i = 2; i <= n; i++) {
            // Har naya answer pichle do answers ka sum hoga
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // 4. Loop khatam hone ke baad final answer dp[n] mein hoga
        return dp[n];
    }
}