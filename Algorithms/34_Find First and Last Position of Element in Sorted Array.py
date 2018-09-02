class Solution:
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        
        call = Solution()
        return call.searchRange(nums, target)
    
    def searchRange(self, nums, target):
        result = []
        length = len(nums)

        start = 0
        end = length
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target and (mid == 0 or nums[mid - 1] != target):
                result.append(mid)
                break
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid
        if not result:
            return [-1, -1]

        end = length
        while start < end:
            mid = (start + end) // 2
            if nums[mid] == target and (mid == length - 1 or nums[mid + 1] != target):
                result.append(mid)
                break
            if nums[mid] <= target:
                start = mid + 1
            else:
                end = mid

        return result
    
        
    def SearchNear(self, array, idx, target, list, direct, len_array):
        # list.append(idx+1)
        if array[idx] == target:
            list.append(idx)
            #print('list_index:',list)

        if idx + direct < len_array and idx + direct > 0:
            if array[idx + direct] == target:
                self.SearchNear(array, idx + direct, target, list, direct, len_array)
        return list
        return list
        
    def RangeSearch(self, array, target):
        # first find digit
        len_array = len(array)
        list = []
        place_idx = self.BinarySearch(array, 0, len(array), target)
        #print('place_idx: ', place_idx)
        if place_idx == -1:
            return [-1, -1]
        
        if place_idx == 0:
            place_idx = 1

        if len_array > 1:
           list = self.SearchNear(array, place_idx - 1, target, list, 1, len_array)
           list = self.SearchNear(array, place_idx - 1, target, list, -1, len_array)
        elif len_array == 1:
            list.append(place_idx-1)            
        else:
           list = self.SearchNear(array, place_idx, target, list, 1, len_array)
        # print(list)
        min1 = list[0]
        max1 = list[0]
        if len(list) >2:
            max1 = max(list)
            min1 = min(list)
            list = []
            list.append(min1)
            list.append(max1)
        elif len(list)<2:
            max1 = max(list)
            list = []
            list.append(max1)
            list.append(max1)

        return list
    
    
    def BinarySearch(self, array, low, high, key):
        if high < low:
            return -1

        if low >= len(array):
            return -1

        mid = int((low + high) / 2)

        if key == array[mid]:
            #print('here: ', mid)
            return mid

        if array[mid] < key:
            return self.BinarySearch(array, mid + 1, high, key)

        return self.BinarySearch(array, low, mid - 1, key) 
