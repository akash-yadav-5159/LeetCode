class Solution {
    public int ans(String s, int start, int end,int[][]dp){
        if(dp[start][end]!=-1)return dp[start][end];
        if(start>end)return 0;
        if(start==end)return 1;
        if(s.charAt(start)==s.charAt(end)){
            return dp[start][end]=2+ans(s,start+1,end-1,dp);
        }
        return dp[start][end]=Math.max(ans(s,start+1,end,dp),ans(s,start,end-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int dp[][]=new int[s.length()+1][s.length()+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return ans(s,0,s.length()-1,dp);
    }
}