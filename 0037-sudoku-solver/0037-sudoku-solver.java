class Solution {
    public boolean isSafe(char[][]board,int row, int col,char digit){
        for(int i=0;i<9;i++){
            if(board[row][i]==digit)return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][col]==digit)return false;
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==digit)return false;
            }
        }
        return true;
    }
    public boolean solver(char[][]board,int row,int col){
        if(row==board.length){
            return true;
        }
        int nextrow=row;
        int nextcol=col+1;
        if(nextcol==9){
            nextrow+=1;
            nextcol=0;
        }
        if(board[row][col]!='.'){
            return solver(board,nextrow,nextcol);
        }
        for(char digit='1';digit<='9';digit++){
            if(isSafe(board,row,col,digit)){
                board[row][col]=digit;
                if(solver(board,nextrow,nextcol)){
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
}