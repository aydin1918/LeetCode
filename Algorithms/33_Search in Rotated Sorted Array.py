class Solution:
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        
        return self.FindNumber(nums,target)
        
        
    def FindNumber(self,array,number):
        #print(self.binarySearch(array, 0,len(array),number ))
        pivot = self.FindPivot(array, 0, len(array)-1)

        if pivot == -1:
            return self.binarySearch(array, 0, len(array)-1, number)

        if array[pivot] == number:
            return pivot
        if array[0] <= number:
            return self.binarySearch(array,0,pivot-1, number)
        return self.binarySearch(array,pivot+1,len(array)-1, number)



    def FindPivot(self, array, low, high):
        if high < low:
            return -1
        if high == low:
            return low
        mid = int((low + high)/2)

        if array[mid] > array[mid+1] and mid < high:
            return mid
        if array[mid] < array[mid] and mid > low:
            return (mid-1)
        if array[low]>array[mid]:
            return self.FindPivot(array,low, mid-1)
        return self.FindPivot(array,mid+1, high)

    # Standard Binary Search function*/
    def binarySearch(self,arr, low, high, key):
        
        if high < low:
            return -1

        # low + (high - low)/2;
        mid = int((low + high) / 2)

        if key == arr[mid]:
            return mid
        if key > arr[mid]:
            return self.binarySearch(arr, (mid + 1), high,
                                key);
        return self.binarySearch(arr, low, (mid - 1), key)    
