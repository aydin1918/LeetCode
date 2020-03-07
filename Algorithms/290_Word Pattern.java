class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        HashMap<String, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        
        if (pattern.length() != array.length) return false;

        for (int i=0; i<pattern.length(); i++){
            if (!map.containsKey(array[i])){
                map.put(array[i], pattern.charAt(i));
            }
            set.add(pattern.charAt(i));
        }

        //System.out.println(map ) ;

        for (int i=0; i<array.length; i++){
            if (!map.get(array[i]).equals(pattern.charAt(i))) {
                return false;
            }
        }
        
        if (map.size() != set.size() ) return false;

        return true;
    }
}
