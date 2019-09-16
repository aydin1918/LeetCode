class Solution {
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        int j = s.length();
        for (int i = s.length()-1; i>=0; i--)
        {
            if (s.charAt(i) == ' ') 
            {
                j = i;
            }
            else if (i==0 || s.charAt(i-1) == ' ')
            {
                if (reverse.length() != 0)
                {
                    reverse.append(' ');
                }
                reverse.append(s.substring(i,j));
            }
        }
        return reverse.toString();
    }
}
