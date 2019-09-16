class Solution {
    public String reverseWords(String s) {
        
        char[] c = s.toCharArray();
        
        for (int i=0,j=0; j<=c.length; j++)
		{
			if (j == c.length || c[j] == ' ')
			{
				reverse(c, i, j);
				i = j+1;
			}
		}
        return new String(c);
    }
    
    private static char[] reverse(char[] s, int beginIndex, int endIndex)
	{
		for (int i=0; i<(endIndex - beginIndex)/2; i++)
		{
			char temp = s[beginIndex + i];
			s[beginIndex + i] = s[endIndex - i - 1];
			s[endIndex - i - 1] = temp;
		}
		return s;
	}
}
