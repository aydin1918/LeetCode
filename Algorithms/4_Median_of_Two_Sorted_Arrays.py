class Solution:
    
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l = []
        x = len(nums1)
        y = len(nums2)
        for i in range(x):
            l.append(nums1[i])
            
        for i in range(y):
            l.append(nums2[i])    
            
        n = x + y
        if n < 1:
            return None
        if n % 2 == 1:
            return sorted(l)[n//2]
        else:
            return sum(sorted(l)[n//2-1:n//2+1])/2.0
