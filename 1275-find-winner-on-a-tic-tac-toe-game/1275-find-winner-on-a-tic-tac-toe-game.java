class Solution {
    public String tictactoe(int[][] moves) {
        int[][] board = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            board[r][c] = (i % 2 == 0) ? 1 : 2;
        }
        int[][] win = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };
        for (int[] p : win) {
            int a = board[p[0] / 3][p[0] % 3];
            int b = board[p[1] / 3][p[1] % 3];
            int c = board[p[2] / 3][p[2] % 3];
            if (a != 0 && a == b && b == c)
                return a == 1 ? "A" : "B";
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}