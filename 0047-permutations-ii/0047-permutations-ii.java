class Solution {
    public void permutation(int idx, int[]nums,List<List<Integer>>ans){
        if(idx==nums.length){
            List<Integer>ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        HashSet<Integer>set=new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i]))continue;
            set.add(nums[i]);
            swap(i,idx,nums);
            permutation(idx+1,nums,ans);
            swap(idx,i,nums);// backtracking
        }
    }
    public void swap(int i,int j,int[]nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        permutation(0,nums,ans);
        return ans;
    }
}