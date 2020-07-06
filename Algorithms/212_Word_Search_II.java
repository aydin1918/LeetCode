class Solution {
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie root = new Trie();
        
        for (String str : words) {
            Trie node = root;
            for (int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                
                node.children.putIfAbsent(c, new Trie());
                node = node.children.get(c);
            }
            node.word = str;
        }
        
        HashSet<String> ans = new HashSet();
        
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                dfs(board, i, j, ans, root);
            }
        }
        
        return new ArrayList(ans);
    }
    
    private void dfs(char[][] board, int i, int j, HashSet<String> ans, Trie root)
    {
        if (i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '*') return;
        char c = board[i][j];
        
        if (!root.children.containsKey(c)) return;
        
        root = root.children.get(c);
        
        if (root.word != null ){
            ans.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '*';
        
        dfs(board, i+1, j, ans, root);
        dfs(board, i, j+1, ans, root);
        dfs(board, i-1, j, ans, root);
        dfs(board, i, j-1, ans, root);
        
        board[i][j] = c;
    }
    
    class Trie {
        HashMap<Character, Trie> children;
        String word;
        
        public Trie(){
            this.children = new HashMap();
        }
    }
}
