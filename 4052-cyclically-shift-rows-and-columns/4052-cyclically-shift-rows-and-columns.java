class Solution {
    public void reverseRow(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void reverseColumn(int[][] grid, int col, int i, int j) {
        while (i < j) {
            int temp = grid[i][col];
            grid[i][col] = grid[j][col];
            grid[j][col] = temp;
            i++;
            j--;
        }
    }
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < n; i++) {
            int k = rowShift[i] % n;
            reverseRow(grid[i], 0, k - 1);
            reverseRow(grid[i], k, n - 1);
            reverseRow(grid[i], 0, n - 1);
        }
        for (int col = 0; col < n; col++) {
            int k = colShift[col] % n;
            reverseColumn(grid, col, 0, k - 1);
            reverseColumn(grid, col, k, n - 1);
            reverseColumn(grid, col, 0, n - 1);
        }
        return grid;
    }
}