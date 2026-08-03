class Solution {
    public boolean ans(String s,List<String> wordDict,Boolean [] dp,int idx){
        if(idx==s.length())return dp[idx]=true;
        if(dp[idx]!=null)return dp[idx];
        for(int end=idx+1;end<=s.length();end++){
            if(wordDict.contains(s.substring(idx,end))&&ans(s,wordDict,dp,end)){
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[]=new Boolean[s.length()+1];
        return ans(s,wordDict,dp,0);
    }
}