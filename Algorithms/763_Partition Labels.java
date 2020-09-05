/*
* Runtime: 3 ms, faster than 90.38% of Java online submissions for Partition Labels.
* Memory Usage: 38.2 MB, less than 69.66% of Java online submissions for Partition Labels.
*
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList();
        int[] map = new int[26];
        
        for (int i=0; i<S.length(); i++) map[S.charAt(i)-'a'] = i;
        
        int start = 0, last=0;
        
        for (int i=0; i<S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if (last == i){
                ans.add(i-start+1);
                start = i + 1;
            }
        }
        
        
        return ans;
    }
}

/*
* Runtime: 5 ms, faster than 54.97% of Java online submissions for Partition Labels.
* Memory Usage: 39.5 MB, less than 47.07% of Java online submissions for Partition Labels.
*
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i=0; i<S.length(); i++) map.put(S.charAt(i), i);
        
        int start = 0, last=0;
        
        for (int i=0; i<S.length(); i++){
            last = Math.max(last, map.get(S.charAt(i)));
            if (last == i){
                ans.add(i-start+1);
                start = i + 1;
            }
        }
        
        
        return ans;
    }
}

/*
* Runtime: 11 ms, faster than 16.24% of Java online submissions for Partition Labels.
* Memory Usage: 38.4 MB, less than 62.89% of Java online submissions for Partition Labels.
*
*/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList();
        HashMap<Character, Integer> map = new HashMap();
        
        for (int i=0; i<S.length(); i++) map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
        
        HashMap<Character, Integer> window = new HashMap();
        int start = 0;
        
        for (int i=0; i<S.length(); i++){
            char c = S.charAt(i);
            if (!window.containsKey(c)){
                window.put(c, map.get(c));
            }
            window.put(c, window.get(c)-1);
            if (window.get(c) == 0){
                window.remove(c);
            }
            if (window.keySet().size()==0){
                ans.add(i-start+1);
                start = i+1;
            }
        }
        
        
        return ans;
    }
}
