class Solution {
    public int removeDuplicates(int[] nums) {
        int len=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[len]=nums[i+1];
                len++;
            }
        }
        return len;
    }
}