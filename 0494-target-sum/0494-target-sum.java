class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(Math.abs(target)>sum) return 0;
        Integer dp[][]=new Integer[nums.length+1][2*sum+1];
        // Shuruwat index 0 aur current sum 0 se karte hain
        return solve(nums, target, 0, 0,dp,sum);
    }
    
    private int solve(int[] nums, int target, int index, int currentSum,Integer dp[][],int sum) {
        // Base Case: Agar humne saare numbers process kar liye (array ke end par)
        if (index == nums.length) {
            if (currentSum == target) {
                return 1;  // Ek sahi combination mil gaya
            } else {
                return 0;  // Ye combination target nahi bana paya
            }
        }
        
        // Choice 1: Current number ke aage '+' lagao (add)
        int add = solve(nums, target, index + 1, currentSum + nums[index],dp,sum);
        
        // Choice 2: Current number ke aage '-' lagao (subtract)
        int subtract = solve(nums, target, index + 1, currentSum - nums[index],dp,sum);
        
        // Dono choices se milne wale total valid tariko ko add kar do
        return dp[index][currentSum+sum]=add + subtract;
    }
}