class Solution {
    public int ans(int[]nums, int dp[], int idx){
        if(dp[idx]!=-1)return dp[idx];
        int max=1;
        for(int i=idx;i<nums.length;i++){
            if(nums[i]>nums[idx]){
                int len=1+ans(nums,dp,i);
                max=Math.max(max,len);
            }
        }
        return dp[idx]=max;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0||n==1)return n;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int max=1;
        for(int i=0;i<n;i++){
            max=Math.max(max,ans(nums,dp,i));
        }
        return max;
    }
}