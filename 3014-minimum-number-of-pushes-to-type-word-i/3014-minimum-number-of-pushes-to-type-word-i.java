class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int cost=0;
        for(int i=0;i<n;i++){
            cost=cost+i/8+1;
        }
        return cost;
    }
}