class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(dungeon, 0, 0, memo);
    }
    private int solve(int[][] dungeon, int r, int c, int[][] memo) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        if (r >= m || c >= n) {
            return Integer.MAX_VALUE;
        }
        if (r == m - 1 && c == n - 1) {
            return Math.max(1, 1 - dungeon[r][c]);
        }
        if (memo[r][c] != -1) {
            return memo[r][c];
        }
        int right = solve(dungeon, r, c + 1, memo);
        int down = solve(dungeon, r + 1, c, memo);
        int minHealthOnExit = Math.min(right, down);
        int healthNeeded = Math.max(1, minHealthOnExit - dungeon[r][c]);
        memo[r][c] = healthNeeded;
        return healthNeeded;
    }
}