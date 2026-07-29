class Solution {
    public void helper(List<List<Integer>> ans, List<Integer> path, int index, int[] nums) {
        ans.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue; 
            }
            path.add(nums[i]);
            helper(ans, path, i + 1, nums);    
            path.remove(path.size() - 1);   
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
}