public static void main(String[] args)
{
		System.out.println(reverseWords("word1 word2 word3".toCharArray()));
}

private static char[] reverseWords(char[] s)
	{
		reverse(s, 0, s.length);
		for (int i=0,j=0; j<=s.length; j++)
		{
			if (j == s.length || s[j] == ' ')
			{
				reverse(s, i, j);
				i = j+1;
			}
		}
		return s;
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
