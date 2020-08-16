private static void substr(String str, int k) {
        HashSet<String> ans = new HashSet<>();
        HashSet<Character> window = new HashSet<>();

        for (int start=0, end=0; end<str.length(); end++){
            while (window.contains(str.charAt(end))){
                window.remove(str.charAt(start++));
            }

            window.add(str.charAt(end));

            if (window.size() == k) {
                ans.add(str.substring(start, end+1));
                window.remove(str.charAt(start++));
            }
        }

        System.out.println(ans);
    }
