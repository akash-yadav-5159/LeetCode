class Solution {
    int maxSide = 0; 
    public int ans(char[][] matrix, int i, int j, int[][] memo) {
        if(i < 0 || j < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int up = ans(matrix, i - 1, j, memo);
        int left = ans(matrix, i, j - 1, memo);
        int dig = ans(matrix, i - 1, j - 1, memo);
        int size = 0;
        if(matrix[i][j] == '1') {
            size = 1 + Math.min(up, Math.min(dig, left));
            maxSide = Math.max(size, maxSide);
        }
        memo[i][j] = size;
        return size; 
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        ans(matrix, rows - 1, cols - 1, memo);
        return maxSide * maxSide;
    }
}