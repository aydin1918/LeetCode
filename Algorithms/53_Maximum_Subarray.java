class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], sum =nums[0];
        for (int i=1; i<nums.length; i++)
        {
            sum = Math.max(nums[i],sum+nums[i]);
            //System.out.println("i: " + i +" sum: " + sum + " nums[i]: " + nums[i] );
            maxSum = Math.max(maxSum,sum);
            //sum= nums[i];
            //System.out.println("i: " + i +" maxSum: " + maxSum);

        }
        return maxSum;
    }
}53. Maximum Subarray
