class Solution {
    boolean check(char [][]board, String word,int row,int col,int index){
        if(index==word.length()){
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp=board[row][col];
        board[row][col]='*';
        if(check(board,word,row+1,col,index+1)||check(board,word,row-1,col,index+1)||check(board,word,row,col+1,index+1)||check(board,word,row,col-1,index+1)){
            return true;
        }
        board[row][col]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)&&check(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
}