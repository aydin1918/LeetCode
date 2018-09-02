class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result_main = new ArrayList<List<Integer>>();

        int array_len = nums.length;
        int j = 1, k = 2, sum = 0;
        
        if(nums == null || nums.length<3)
        return result_main;

        Arrays.sort(nums);

        for (int i = 0; i < array_len - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
            j = i + 1;
            k = array_len - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> result = new ArrayList<Integer>();
                    //System.out.println("Yes: " + array[i] + "-" + array[j] + "-" + array[k]);
                    result.add(nums[i]);
                    result.add(nums[j]);
                    result.add(nums[k]);
                    result_main.add(result);
                    k--;
                    j++;
                    
                    while (j<k && nums[j]==nums[j-1])
                    {
                        j++;
                    }
                    while (j<k && nums[k]==nums[k+1])
                    {
                        k--;
                    }
                    
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
            }
        }
        return result_main;
        
    }
    
    public void Three_sum(int[] array)
    {
        int u = 0;
    }
}
