class Solution {
    public int ans(int[]nums, int dp[][], int idx,int end){
        if(idx==nums.length-1)return 1;
        if(end==nums.length)return 1;
        if(dp[idx][end]!=-1)return dp[idx][end];
        if(nums[end]>nums[idx]){
            return dp[idx][end]=Math.max(ans(nums,dp,idx,end+1),1+ans(nums,dp,end,end+1));
        }
        return dp[idx][end]=ans(nums,dp,idx,end+1);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0||n==1)return n;
        int dp[][]=new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int max=1;
        for(int i=0;i<n-1;i++){
            max=Math.max(max,ans(nums,dp,i,i+1));
        }
        return max;
    }
}