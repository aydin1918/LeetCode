class Solution {
    public int coinChange(int[] coins, int amount) {
         //Arrays.sort(coins);
         int countMin = 0, i=coins.length-1, temp=coins.length-1;
         int[] count = new int[amount+1];
         //Arrays.fill(count,Integer.MAX_VALUE);
         return coinChangeUtil(coins, amount, count);
    }
    
    private int coinChangeUtil(int[] coins, int amount, int[] count)
    {      
        
        if (amount == 0)
        {
            return 0;
        }
        if (amount<0)
        {
            return -1;
        }
        //System.out.println("amount: " + amount  + " sum: //" + count[amount]);
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins)
        {
            int temp = coinChangeUtil(coins, amount-coin,  count);
            if (temp>=0 && min>temp)
            {
                min = 1 + temp;
            }
        }
        count[amount-1]= (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount-1];
    }
   
}
