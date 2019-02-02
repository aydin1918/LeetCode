class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum=0, left = 0, count = Integer.MAX_VALUE;
        
        for (int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            while (sum>=s)
            {
                count = Math.min(count, i-left+1);
                sum -= nums[left++];
            }
        }
        
        return (count == Integer.MAX_VALUE) ? 0 : count;
    }
    
    
}
