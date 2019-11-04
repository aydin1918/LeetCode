public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        int[] result = new int[A.size()];
        int max = Integer.MIN_VALUE;
        Arrays.fill(result, 1);

        for (int i=1; i<A.size(); i++)
        {
            for (int j=0; j<i; j++)
            {
                if (A.get(i)>A.get(j) && result[i] < result[j] + 1)
                {
                    result[i] = result[j]+1;
                }
            }
        }
        
        for (int i=0; i<result.length; i++)
        {
            max = Math.max(max, result[i]);
        }
        
        return max;
        
    }
}
