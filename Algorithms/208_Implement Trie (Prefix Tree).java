class Trie {
    private TrieNode root = null;
    
    class TrieNode
    {
        boolean isEndOfWord;
        HashMap<Character, TrieNode> children;

        public TrieNode()
        {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = this.root;

        for (int i=0; i<word.length(); i++)
        {
            //HashMap<Character, TrieNode> child = node.children;
            char c = word.charAt(i);
            /*if (!node.children.containsKey(c))
            {
                node.children.put(c, new TrieNode());
            }*/
            
            node.children.putIfAbsent(c, new TrieNode());

            if (i == word.length() - 1) node.children.get(c).isEndOfWord = true;
            node = node.children.get(c);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = this.root;
        //HashMap<Character, TrieNode> children = node.children;

        for (int i=0; i<word.length(); i++)
        {
            if (!node.children.containsKey(word.charAt(i))) return false;
            node = node.children.get(word.charAt(i));
            //node.children = node;
        }

        return true && node.isEndOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = this.root;
        //HashMap<Character, TrieNode> children = node.children;

        for (int i=0; i<prefix.length(); i++)
        {
            if (!node.children.containsKey(prefix.charAt(i))) return false;
            node = node.children.get(prefix.charAt(i));
            //children = node.children;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
