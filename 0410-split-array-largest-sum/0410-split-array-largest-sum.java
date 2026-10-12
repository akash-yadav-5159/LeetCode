class Solution {
    public boolean canSplit(int nums[], int mid, int k){
        int count=1;
        int sum=0;
        for(int ele:nums){
            sum+=ele;
            if(sum>mid){
                count++;
                sum=ele;
                if(count>k)return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for(int ele:nums){
            start=Math.max(ele,start);
            end+=(ele);
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(canSplit(nums,mid,k)){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
}