class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0, maxRes = -Double.MAX_VALUE;
        int count = 1;
        
        if (nums.length == 1) return nums[0];
        
        for (int i=0; i<nums.length; i++){
            max += nums[i];
            //System.out.println(max + " count: " +count);
            if (count == k){
                /*if (maxRes == 0) {
                    maxRes = max/k;
                }*/
                //System.out.println(max/k);
                maxRes = Math.max(maxRes, max/k);
                max += nums[i-count+1] * (-1);
                count--;
            }
            //else {
                count++;
            //}
        }
        
        return maxRes;
    }
}
