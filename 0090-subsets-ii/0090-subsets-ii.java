class Solution {
    public void helper(List<List<Integer>>list,List<Integer>list2,int index, int[]nums){
        if(index==nums.length){
            if(!list.contains(list2)){
                list.add(new ArrayList<>(list2));
            }
            return;
        }
        list2.add(nums[index]);
        helper(list,list2,index+1,nums);
        list2.removeLast();
        helper(list,list2,index+1,nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        Arrays.sort(nums);
        List<Integer>list2=new ArrayList<>();
        helper(list,list2,0,nums);
        return list;
    }
}