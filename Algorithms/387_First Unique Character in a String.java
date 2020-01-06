class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i=0; i<s.length(); i++)
        {
            if (!set.contains(s.charAt(i)))
            {
                map.put(s.charAt(i), i);
                set.add(s.charAt(i));
            }
            else
            {
                if (map.get(s.charAt(i)) != null) map.remove(s.charAt(i));
            }
        }

        //System.out.println(map);

        return (map.size() == 0) ? -1 : map.entrySet().iterator().next().getValue();
    }
}

/* Another solution */ 

class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++)
        {
            if (!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), 1);
            }
            else
            {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }

        for (int i=0; i<s.length(); i++)
        {
            if (map.get(s.charAt(i)) == 1)
            {
                return i;
            }
        }

        return -1;
    }
}
