class Solution {
    public int  ans(int []nums, int []dp, int start,int end){
        if(start>end)return 0;
        if(dp[start]!=-1)return dp[start];
        int pick=nums[start]+ans(nums,dp,start+2,end);
        int notpick=ans(nums,dp,start+1,end);
        return dp[start]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        int n=nums.length;
        int []dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        int case1=ans(nums,dp,0,n-2);
        Arrays.fill(dp,-1);
        int case2=ans(nums, dp, 1, n-1);
        return Math.max(case1,case2);
    }
}