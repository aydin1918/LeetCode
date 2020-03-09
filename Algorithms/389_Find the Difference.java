class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        char result = '0';
        
        for (int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if (map.containsKey(c)){
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c,1);
        }
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
               int curr = map.get(c);
                if (curr>1){
                    map.put(c, map.get(c)-1);
                } else {
                    map.remove(c);
                }
            }
        }
        
        for (char res : map.keySet()){
            result = res;
        }
        
        return result;
    }
}
