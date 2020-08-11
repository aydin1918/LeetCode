class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        HashMap<Character, Deque<char[]>> map = new HashMap();
        for (char c='a'; c<='z'; c++){
            map.put(c, new LinkedList());
        }
        
        for (int i=0; i<words.length; i++){
            //if (map.containsKey(words[i].charAt(0))) {
                map.get(words[i].charAt(0)).add(words[i].toCharArray());
            //}
            
        }
        
        //System.out.println(map);
        
        for (char c : S.toCharArray()){
            //if (map.containsKey(c)){
                int sizeQueue = map.get(c).size();
                
                for (int i=0; i<sizeQueue; i++){
                    char[] extractWord = map.get(c).removeFirst();
                    if (extractWord.length == 1) ans++;
                    else {
                        //if (map.containsKey(extractWord[1])) {
                            map.get(extractWord[1]).add(Arrays.copyOfRange(extractWord, 1, extractWord.length));
                        //}
                    }
                }
            //}
        }
        
        return ans;
    }
}
