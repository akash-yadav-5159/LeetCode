class Solution {
    public int ans(int nums[],int [] dp, int idx){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        dp[idx]=Math.max(nums[idx]+ans(nums,dp,idx+2),ans(nums,dp,idx+1));
        return dp[idx];
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return ans(nums,dp,0);
    }
}