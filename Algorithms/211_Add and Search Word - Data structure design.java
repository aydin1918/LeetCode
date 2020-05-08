class WordDictionary {

    private Trie root;

    class Trie
    {
        private HashMap<Character, Trie> children;
        private boolean isEndOfWord;
        public Trie()
        {
            this.children = new HashMap();
            this.isEndOfWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie node = this.root;
        for (int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            node.children.putIfAbsent(c, new Trie());
            if (i == word.length() - 1) node.children.get(c).isEndOfWord = true;
            node = node.children.get(c);
        }

    }

    public boolean search(String word)
    {
        Trie current = this.root;
        return searchWord(word, current, 0);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    private boolean searchWord(String word, Trie current, int start) {
        if (current == null) return false;

        for (int i=start; i<word.length(); i++){
            Trie prev = current;
            char c = word.charAt(i);

            if (c == '.'){
                for (Map.Entry<Character, Trie> el : current.children.entrySet()){

                    if (current == null) return false;
                    prev = current;
                    current = current.children.get(el.getKey());

                    boolean result = searchWord( word, current, i+1);

                    if (!result){
                        current = prev;
                        continue;
                    }
                    else {
                        return true;
                    }
                }
                return false;
            }
            else {

                if (!current.children.containsKey(c)){
                    return false;
                }
                current = current.children.get(c);
            }
        }

        return current.isEndOfWord ;
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
