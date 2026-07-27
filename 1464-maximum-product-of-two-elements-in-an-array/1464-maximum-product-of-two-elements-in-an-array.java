class Solution {
    public int maxProduct(int[] nums) {
        int x=Integer.MIN_VALUE;
        int y=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>x){
                y=x;
                x=nums[i];
            }else if(nums[i]>y){
                y=nums[i];
            }
        }
        return (x-1)*(y-1);
    }
}