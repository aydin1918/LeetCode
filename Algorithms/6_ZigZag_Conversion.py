class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        zigzag = ""
        
        if numRows == 0 or numRows == 1:
            return s


        for i in range(0,numRows):
            for j in range(i, len(s), numRows + (numRows - 2)):
                zigzag += s[j]
                if 0 < i < numRows - 1 and j + (numRows + (numRows - 2)) - 2 * i < len(s):
                    zigzag += s[j + (numRows + (numRows - 2)) - 2 * i]
        return zigzag            
        
