class Solution {
    public int ans(int[]map,int dp[], int idx){
        if(idx>=map.length){
            return 0;
        }if(dp[idx]!=-1)return dp[idx];
        return dp[idx]=Math.max(map[idx]+ans(map,dp,idx+2),ans(map,dp,idx+1));
    }
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int map[]=new int[max+1];
        for(int num:nums){
            map[num]+=num;
        }
        int dp[]=new int[map.length+1];
        Arrays.fill(dp,-1);
        return ans(map,dp,0);
    }
}