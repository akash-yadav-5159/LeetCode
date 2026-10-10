class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int minSum=Integer.MAX_VALUE;
        int currMax=0;
        int currMin=0;
        for(int num:nums){
            currMax=Math.max(num,currMax+num);
            maxSum=Math.max(currMax,maxSum);
            currMin=Math.min(num,currMin+num);
            minSum=Math.min(currMin,minSum);
        }
        int ans=Math.max(maxSum,Math.abs(minSum));
        return ans;
    }
}