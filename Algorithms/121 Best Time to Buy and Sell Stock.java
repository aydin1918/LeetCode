class Solution {
    public int maxProfit(int[] prices) {
        
        if (prices.length == 0)
        {
            return 0;
        }
        
        int[] dp = new int[prices.length+1];
        int min = prices[0], min_i = 0, max =0;
        
        for (int i=0; i<prices.length; i++)
        {
            /*if (i==0)
            {
                dp[i]=prices[i];
                continue;
            }*/
            
            if (prices[i] < min)
            {
                if (prices.length -1 == i) continue;
                min = prices[i];
                min_i = i;
            }
            
            /*if (dp[i]-min >0 && dp[i+1] > dp[i]-min)
            {
                
            }*/
            
            dp[i] = prices[i] - min;
            System.out.println(dp[i]);
        }
        
        for (int j=0; j<dp.length; j++)
        {
            System.out.println("dp: " + dp[j]);

            if (dp[j]> max)
            {
                max = dp[j];
            }
        }
        
        return max;
    }
}
