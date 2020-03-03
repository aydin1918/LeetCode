class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        
        for (int i=0; i<prices.length-1; i++){
            int diff = 0, temp = Integer.MAX_VALUE;
            for (int j=i+1; j<prices.length; j++){
                
                if (prices[i] < prices[j] && temp >= prices[j]){  // diff > prices[j]-prices[i]
                    temp = prices[j];
                    diff = Math.max(prices[j]-prices[i], diff);
                } else {  break;}
                //System.out.println(prices[i] + " " + prices[j] + " diff: " + diff + " sum: " + sum);
            }
            //System.out.println("round: " + prices[i] + " diff: " + diff + " sum: " + sum);
            sum += diff;
        }
        
        return sum;
    }
}
