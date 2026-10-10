class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int buy=prices[0];
        for(int ele:prices){
            if(buy>ele){
                buy=ele;
            }else{
                profit=Math.max(profit,ele-buy);
            }
        }
        return profit;
    }
}