class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        char[][] board = new char[n][n];
        
        for (int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        
        //for (int newCol=0; newCol<n; newCol++){
            //board[0][newCol] = 'Q';
            dfs(res, board, n, 0);
            //board[0][newCol] = '.';
        //}
        
        //System.out.println(res);
        
        return res;
    }
    
    private void dfs(List<List<String>> res, char[][] board, int n, int row){
        if (n == row) {
            List<String> temp = new ArrayList();
            for (int i=0; i<n; i++){
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        
        for (int newCol=0; newCol<n; newCol++){
            
            if (isValid(board, row, newCol, n)) {
                board[row][newCol] = 'Q';
                dfs(res, board, n, row+1);
                board[row][newCol] = '.';
            }
            //System.out.println("temp: " + temp);
        }
    }
    
    private boolean isValid(char[][] board, int row, int col, int n){
        
        // down-right or up-left
        for (int i=row, j=col; i>=0 && j>=0; i--,j-- ){
            if (board[i][j] == 'Q') return false;
        }
        
        // down or up check
        for (int i=row; i>=0; i--){
            if (board[i][col] == 'Q') return false;
        }
        
        // up-right or down-left
        for (int i=row, j=col; i>=0 && j<n; i--,j++ ){
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
}
