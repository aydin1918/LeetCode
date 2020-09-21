/*
* Runtime: 18 ms, faster than 33.50% of Java online submissions for Permutation in String.
* Memory Usage: 39.4 MB, less than 85.51% of Java online submissions for Permutation in String.
*
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap();

        for (int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        HashMap<Character, Integer> window = new HashMap();
        int start = 0, len=0;

        for (int i=0; i<s2.length(); i++){
            char c = s2.charAt(i);
            len++;
            if (i<s1.length()-1){
                window.put(c, window.getOrDefault(c, 0)+1);
            }
            else {
                window.put(c, window.getOrDefault(c, 0)+1);
                
                if (window.size() == map.size()){
                //if (len == s1.length()){
                    //System.out.println("here: " + len + " " + s1.length());
                    
                    boolean allContains = true;
                    for (Map.Entry<Character, Integer> el : window.entrySet()){
                        if (map.containsKey(el.getKey())){
                            if (el.getValue() < map.get(el.getKey())){
                                allContains = false;
                                break;
                            }
                        }
                        else {
                            allContains = false;
                            break;
                        }
                    }
                    if (allContains) return true;
                }

                char charAtStart = s2.charAt(start);
                if (!window.containsKey(charAtStart)) {
                    start++;
                    len--;
                    continue;
                }
                if (window.get(charAtStart)>1) {
                    window.put(charAtStart, window.get(charAtStart)-1);
                }
                else {
                    window.remove(charAtStart);
                }
                start++;
                len--;
            }
        }


        return false;
    }
}
