class Solution {
    public int ans(String s,String t, int i, int j,int[][]dp){
        if(dp[i][j]!=-1)return dp[i][j];
        if(j==t.length())return 1;
        if(i==s.length())return 0;
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=(ans(s,t,i+1,j+1,dp)+ans(s,t,i+1,j,dp));
        }else{
            return dp[i][j]=ans(s,t,i+1,j,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int [s.length()+1][t.length()+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return ans(s,t,0,0,dp);
    }
}