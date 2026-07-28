class Solution {
    public void helper(List<List<Integer>>list,List<Integer>list2,int index, int nums[]){
        if(index==nums.length){
            list.add(new ArrayList<>(list2));
            return;
        }
        // include
        list2.add(nums[index]);
        helper(list,list2,index+1,nums);
        list2.removeLast();
        //exclude
        helper(list,list2,index+1,nums);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        helper(list,list2,0,nums);
        return list;
    }
}