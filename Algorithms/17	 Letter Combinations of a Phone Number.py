class Solution:
    
    digit_voc = {'2': ['a','b','c'],
                 '3': ['d','e','f'],
                 '4': ['g','h','i'],
                 '5': ['j','k','l'],
                 '6': ['m','n','o'],
                 '7': ['p','q','r','s'],
                 '8': ['t','u','v'],
                 '9': ['w','x','y','z']}
    
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        if len(digits) == 0:
            return []
        
        result = []
        l = Solution()
        l.Call2(digits,result)
        return result
        
    def Call2(self,str,result):
        #print(self.digit_voc[str[0]]+self.digit_voc[str[1:]])
        count = 0
        
        self.Call3(str,"", count, result, str)
        return result
        
    def Call3(self,str,letter, count, result, original_str):
        #print('len_str: ',len(original_str))
        if len(letter) == len(original_str): 
            result.append(letter)
            #print(result)
            #print('count: ',count)
            return result
        else:
            for j in self.digit_voc[str[0]]:
                self.Call3(str[1:], letter + j, count, result, original_str)    
                        
        return result                
