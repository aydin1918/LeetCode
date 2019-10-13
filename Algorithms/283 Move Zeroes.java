class Solution {
    public void moveZeroes(int[] nums) {
        
        int endWindow = nums.length-1, zero = 0, k =0;

        for (int i=0; i<=endWindow; i++)
        {
            if (nums[i]!=0)
            {
                nums[k++] = nums[i];
            }
        }

        for (int i=k; i<=endWindow; i++)
        {
            nums[i] = 0;
        }
        
    }
}
