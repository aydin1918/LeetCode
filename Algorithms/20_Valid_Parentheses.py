class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        obj = Solution()
        return obj.Call2(s)
        
    def Call2(self, string):
        if len(string) % 2 == 1:
            return False
        stack = []
        left = ("(", "[", "{")
        right = (")", "]", "}")


        for i in string:

            if i in left:
                stack.append(i)
            else:
                if not stack:
                    return False
                k = stack.pop()
                if right.index(i) != left.index(k):
                    #print('right: ', right.index(i),' left: ',left.index(k))
                    return False
                
        if len(stack)>1:
            return False        
        return True  
