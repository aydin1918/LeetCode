class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int array_len = nums.length;
        int j,k=array_len-1;
        int min_value = Integer.MAX_VALUE;
        int sum =0, diff = 0;
        int result =0;
        //java.util.ArrayList<Integer> result = new java.util.ArrayList<Integer>();


        Arrays.sort(nums);

        for (int i=0; i<array_len-1; i++)
        {
            if (i==0 || nums[i]>nums[i-1])
            {
                j = i + 1;
                k = array_len -1;
                while (j<k)
                {
                    sum = nums[i] + nums[j] + nums[k];
                    //System.out.println("result: " + array[i] + "="+ array[j] + "="+  array[k] + " sum: " + sum);
                    diff = Math.abs(sum - target);

                    if (diff == 0)
                    {
                        //return sum;
                    }
                    if (min_value > diff)
                    {
                        min_value = diff;
                        result = sum;
                    }

                    if (sum <= target)
                    {
                        j++;
                    }
                    else
                    {
                        k--;
                    }
                }
            }
        }
        
        return result;
     
    }
}
