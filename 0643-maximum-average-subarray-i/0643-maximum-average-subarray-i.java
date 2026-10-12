class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double max=sum;
        int start=0;
        for(int i=k;i<nums.length;i++){
            sum=sum-nums[start++]+nums[i];
            max=Math.max(max,sum);
        }
        return max/k;
    }
}