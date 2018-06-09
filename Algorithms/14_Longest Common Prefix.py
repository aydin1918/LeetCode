class Solution:
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        
        if len(strs) == 0:
            return ""
        
        obj = Solution()
        return obj.longestCommonPrefix(strs)
        
    def longestCommonPrefix(self, strs):
        if not strs:
            return ""
        first = strs[0]
        for i in range(0,len(first)):
            for str in strs:
                if len(str) <= i or first[i] != str[i]:
                    return first[0:i]
        return first        
