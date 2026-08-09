class Solution {
    public void fun(List<Integer> in, List<Integer> op,
                    List<List<Integer>> ans) {
        // Base condition
        if (in.size() == 0) {
            ans.add(new ArrayList<>(op));
            return;
        }
        for (int i = 0; i < in.size(); i++) {
            int k = in.get(i);
            op.add(k);          // choose
            in.remove(i);       // erase
            fun(in, op, ans);   // recursion
            in.add(i, k);       // insert back
            op.remove(op.size() - 1);  // backtrack
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> in = new ArrayList<>();
        for (int num : nums) {
            in.add(num);
        }
        List<Integer> op = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        fun(in, op, ans);
        return ans;
    }
}