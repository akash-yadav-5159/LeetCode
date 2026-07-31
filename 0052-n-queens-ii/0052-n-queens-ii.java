class Solution {
    static int count=0;
    void nqueens(int board[][],int row){
        if(row==board.length){
            count++;
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=1;
                nqueens(board,row+1);
                board[row][col]=0;
            }
        }
    }
    boolean isSafe(int [][]board,int row,int col){
        for(int i= row-1;i>=0;i-- ){
            if(board[i][col]==1){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j<board[0].length;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
    public int totalNQueens(int n) {
        count=0;
        int board[][]=new int[n][n];
        for(int i=0;i<board.length;i++){
            Arrays.fill(board[i],0);
        }
        nqueens(board,0);
        return count;
    }
}