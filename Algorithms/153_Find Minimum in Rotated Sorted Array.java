class Solution {
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        System.out.println("pivot: " + pivot);
        if (pivot==-1)
        {
            return nums[0];
        }
        return nums[pivot];
    }
    
    private int findPivot(int[] nums)
    {
        int left=0,right=nums.length-1;
        while (left<right)
        {
            int mid = (left+right)/2;
            System.out.println("mid: " + mid + " left: " + left + " right: " + right);
            if (mid<right && nums[mid]>nums[mid+1])
            {
                return mid+1;
            }
            if (mid>left && nums[mid]<nums[mid-1])
            {
                return mid;
            }
            if (nums[mid]<nums[left])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }
    
}
