class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        if (nums.length == 1) return nums[0];
        
        return Math.max(helper(nums, 0, nums.length-1), helper(nums, 1, nums.length));
        
    }
    
    public int helper(int[] nums, int beginIndex, int k)
    {
        int[] dp = new int [k];
        
        if (beginIndex == k) return nums[beginIndex]; 
        if (nums.length == 2) return Math.max(nums[0],nums[1]); 
        
        dp[beginIndex] = nums[beginIndex];
        dp[beginIndex+1] = Math.max(nums[beginIndex+1],dp[beginIndex]);
        
        for (int i=beginIndex+2; i<k; i++)
        {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]); 
        }
        
        return  dp[k-1];
    }
}
