class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                if( dfs(board, i, j , word,  0)) return true;
            }
        }

        return false;
    }
    
    
    private static boolean dfs(char[][] board, int i, int j, String word, int posWord)
    {
        if (posWord == word.length()) return true;

        if (i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != word.charAt(posWord))              return false;

        board[i][j] = '*';

        boolean result = dfs(board, i+1, j, word, posWord + 1) ||
        dfs(board, i-1, j, word, posWord + 1) ||
        dfs(board, i, j+1, word, posWord + 1) ||
        dfs(board, i, j-1, word, posWord + 1) ;

        board[i][j] = word.charAt(posWord);

        return result;
    }
    
}
