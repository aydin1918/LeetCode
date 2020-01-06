class Solution {
    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();
        int len = s.length()-1;

        for (int i=len; i>=0; i--)
        {
            if (s.charAt(i) == '#' && i>=2)
            {
                builder.append((char)(Integer.parseInt(s.substring(i-2, i)) + 96));
                //System.out.println(i + " # " + s.substring(i-2, i));
                i = i- 2;
                continue;
            }
            if (s.charAt(i) != '#' )
            {
                builder.append((char)(Integer.parseInt(s.substring(i, i+1)) + 96));
                //System.out.println( i + " i test: " + s.substring(i, i+1)  );
            }
        }
        return builder.reverse().toString();
    }
}
