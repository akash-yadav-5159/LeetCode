class Solution {
    public int ans(String text1, String text2,int first,int second,int dp[][]){
        if(dp[first][second]!=-1)return dp[first][second];
        if(first>=text1.length())return 0;
        if(second>=text2.length())return 0;
        if(text1.charAt(first)==text2.charAt(second)){
            return  dp[first][second]=(1+ans(text1,text2,first+1,second+1,dp));
        }else{
            int skip1= ans(text1,text2,first,second+1,dp);
            int skip2=ans(text1,text2,first+1,second,dp);
            return  dp[first][second]=Math.max(skip1,skip2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()+1][text2.length()+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return ans(text1,text2,0,0,dp);
    }
}