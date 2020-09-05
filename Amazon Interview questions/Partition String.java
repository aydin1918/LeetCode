import java.util.*;

public class Solution {
    public static List<String> partitionString(String input) {
		List<String> ans = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<input.length(); i++){
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if (!window.containsKey(c)){
                window.put(c, map.get(c));
            }
            window.put(c, window.get(c)-1);
            if (window.get(c)==0)  window.remove(c);

            builder.append(c);

            if (window.keySet().size()==0){
                ans.add(builder.toString());
                builder = new StringBuilder();
            }
        }

        return ans;
    }
}
