class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solveSuduku(board);
    }
    
    public boolean solveSuduku(char[][] board)
    {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(!isColumnSafe(board, i, j) || 
                   !isRowSafe(board, i, j) ||
                   !isSubBoxSafe(board, i, j) ) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    // check sub-box
    public boolean isSubBoxSafe(char[][] board, int i, int j)
    {
        char val = board[i][j];
        if (val == '.') return true;
        int ii=i-i%3, jj = j-j%3;
        
        for (int i1=0; i1<3; i1++){
            for (int j1=0; j1<3; j1++){
                if (ii + i1 != i && jj+j1!=j && board[ii+i1][jj+j1] == val){
                    return false;
                }
            }
        }
        return true;
    }
    
    // check column
    public boolean isColumnSafe(char[][] board, int i, int j)
    {
        char val = board[i][j];
        if (val == '.') return true;
        for (int k = 0; k<9; k++){
            if (k != j && board[i][k] == val){
                return false;
            }
        }
        return true;
    }
    
    // check row
    public boolean isRowSafe(char[][] board, int i, int j )
    {
        char val = board[i][j];
        if (val == '.') return true;
        for (int k = 0; k<9; k++){
            if (i!=k && board[k][j] == val){
                return false;
            }
        }
        return true;
    }
}
