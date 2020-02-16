static public int substrDistinctK(String s, int k)
    {
        int start=0, end=0, unique=0, maxStart=0, maxWindowLen=0;
        //int[] arr = new int[256];
        HashMap<Character, Integer> map = new HashMap<>();
        //Arrays.fill(arr, 0);

        for (int i=0; i<s.length(); i++){
            /*if (arr[s.charAt(i)-'a'] == 0){
                unique++;
            }*/
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else {
                map.put(s.charAt(i), 1);
            }


            if (map.size() <= k) {
                maxWindowLen = Math.max(maxWindowLen, i - start + 1);
            }
            else {
                while (map.size()>k) {
                    char l = s.charAt(start);
                    int count = map.get(l);
                    if (count == 1){
                        map.remove(l);
                    }
                    else {
                        map.put(l, map.get(l)-1);
                    }
                    start++;
                }
            }
        }

        //if (unique < k) return -1;
        //Arrays.fill(arr, 0);
        //map.clear();

        // Put first element in window
        //arr[s.charAt(0)-'a']++;
        //map.put(s.charAt(0),1);
/*
        for (int i=1; i<s.length(); i++){
            //arr[s.charAt(i)-'a']++;
            int temp = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i), ++temp);
            end++;
            // if total count of unique elements more than K
            // delete them from window
            while(!checkIfOver(map, k)){
                //arr[s.charAt(start)-'a']--;
                int temp2 = map.getOrDefault(s.charAt(i),0);
                if (temp2 < 0) {
                    temp2 = 0;
                    map.remove(s.charAt(i));
                } else {
                    temp2--;
                    map.put(s.charAt(i), temp2);
                }

                start++;
            }

            maxWindowLen = Math.max(maxWindowLen, end - start + 1 );
            System.out.println("maxWindow: " + maxWindowLen + " end: " + end + " start: " + start);
        }
            */
        return maxWindowLen;
    }


    public static boolean checkIfOver(HashMap<Character, Integer> map, int k)
    {
        int count = 0;
        for (Integer i : map.values()){
            if (i > 0){
                count++;
            }
        }
        /*for (int i=0; i<map.size(); i++){
            if (map.containsValue())
        }
        for (int i=0; i<26; i++){
            if (arr[i] > 0){
                count++;
            }
        }*/
        return k>= count;
    }
