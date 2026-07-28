class Solution {
    public void helper(List<List<Integer>>list,List<Integer>list2,int index, int[]nums){
        if(index==nums.length){
            list.add(new ArrayList<>(list2));
            return;
        }
        list2.add(nums[index]);
        helper(list,list2,index+1,nums);
        list2.removeLast();
        int i=index+1;
        while(i<nums.length&&nums[i]==nums[i-1]){
            i++;
        }
        helper(list,list2,i,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>list2=new ArrayList<>();
        helper(list,list2,0,nums);
        return list;
    }
}