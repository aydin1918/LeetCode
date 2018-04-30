class Solution:
    
    resultList = []
    
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        if (len(nums)==0):
            return self.resultList
        
        for i in range(0,len(nums)-2):
            j = i + 1
            k = j + 1
            while j<len(nums)-1 and k<len(nums):
                if nums[i]+nums[j]+nums[k] == 0:
                    result = []
                    result.append(nums[i])
                    result.append(nums[j])
                    result.append(nums[k])
                    self.resultList.append(result)
                    #print(array[i]+array[j]+array[k])
                j += 1
                k += 1                   
        return self.resultList         
