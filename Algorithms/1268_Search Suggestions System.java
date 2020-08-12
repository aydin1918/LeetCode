class Solution {
    
    private Trie root = null;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList();
        this.root = new Trie();
        Arrays.sort(products);
        buildTree(products);
        
        //System.out.println(this.root.children.get('m').list);
        Trie node = this.root;
        for (int i=0; i<searchWord.length(); i++){
            char c = searchWord.charAt(i);
            if (node.children[c-'a'] == null) {
                for (int j = ans.size(); j<searchWord.length(); j++){
                    ans.add(new ArrayList());
                }
                
                break;
                //continue;
            }
            //System.out.println("itteration: " + i + " " + node.children.get(c).list);
            //Collections.sort(node.children.get(c).list);
            node = node.children[c-'a'];
            ans.add(node.list.subList(0, Math.min(node.list.size(),3) ));
        }
        
        return ans;
    }
    
    private void buildTree(String[] products){
        for (String str : products){
            Trie node = this.root;
            
            for (int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new Trie();
                }
                
                node = node.children[c-'a'];
                node.list.add(str);
                
            }
            
        }
    }
    
    class Trie 
    {
        //boolean isEndOfWord;
        //HashMap<Character, Trie> children;
        Trie[] children;
        List<String> list;
        
        public Trie(){
            //this.isEndOfWord = false;
            //this.children = new HashMap();
            this.children = new Trie[26];
            this.list = new ArrayList();
        }
    }
}
