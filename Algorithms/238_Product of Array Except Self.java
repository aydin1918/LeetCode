class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arrayLeft = new int[nums.length];
        int[] arrayRight = new int[nums.length];
        int[] result = new int[nums.length];

        for (int i=0; i<nums.length; i++)
        {
            if (i==0)
            {
                arrayLeft[0] = 1;
            }
            else
            {
                arrayLeft[i] = arrayLeft[i-1] * nums[i-1];
            }
        }

        for (int i=nums.length-1; i>=0; i--)
        {
            if (nums.length-1 == i)
            {
                arrayRight[nums.length-1] = 1;
            }
            else
            {
                arrayRight[i] = arrayRight[i+1] * nums[i+1];
            }
        }

        for (int i=0; i<nums.length; i++)
        {
            result[i] = arrayLeft[i] * arrayRight[i];
        }
        
        return result;
    }
}
