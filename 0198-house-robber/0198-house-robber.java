class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        // Base Cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        // dp[0] ki jagah prev2
        int prev2 = nums[0]; 
        
        // dp[1] ki jagah prev1
        int prev1 = Math.max(nums[0], nums[1]); 
        
        // Loop index 2 se shuru hoga
        for (int i = 2; i < n; i++) {
            // Naya answer pichle do answers se niklega
            int curr = Math.max(nums[i] + prev2, prev1);
            
            // Agle step ke liye variables ko aage shift kar do
            prev2 = prev1;
            prev1 = curr;
        }
        
        // Last mein answer prev1 mein store hoga
        return prev1;
    }
}