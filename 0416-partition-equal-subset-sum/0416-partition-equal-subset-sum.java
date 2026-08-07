class Solution {
    public boolean ans(int []nums,  Boolean dp[][],int sum, int idx){
        if(idx>=nums.length||sum<0)return false;
        if(dp[idx][sum]!=null)return dp[idx][sum];
        if(sum==0)return true;
        boolean include=ans(nums,dp,sum-nums[idx],idx+1);
        boolean exclude=ans(nums,dp,sum,idx+1);
        return dp[idx][sum]=include||exclude;
    }
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int ele:nums){
            sum+=ele;
        }
        if(sum%2!=0)return false;
        sum/=2;
        Boolean dp[][]=new Boolean[nums.length+1][sum+1];
        return ans(nums,dp,sum,0);

    }
}