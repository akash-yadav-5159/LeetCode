class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int totalElements = m * n;
        k = k % totalElements;
        int start = (totalElements - k) % totalElements; 
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < totalElements; i++) {
            int index = (start + i) % totalElements;
            int r = index / n;
            int c = index % n;
            temp.add(grid[r][c]); 
            if (temp.size() == n) {
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return ans;
    }
}