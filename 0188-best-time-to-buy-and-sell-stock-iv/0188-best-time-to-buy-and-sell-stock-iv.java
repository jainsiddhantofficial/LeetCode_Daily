class Solution {
    public int maxProfit(int kn, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][kn+1];
        
        for(int idx=prices.length-1;idx>=0;idx--)
        {
            for(int can_buy=0;can_buy<2;can_buy++)
            {
                for(int k=1;k<=kn;k++)
                {
                    if(can_buy==1)
                    {
                        int not_buy = dp[idx+1][1][k];
                        int  buy= dp[idx+1][0][k] - prices[idx];
                        dp[idx][can_buy][k] = Math.max(buy,not_buy);
                    }
                    else
                    {
                        int sell = dp[idx+1][1][k-1] + prices[idx];
                        int not_sell = dp[idx+1][0][k];
                        dp[idx][can_buy][k] = Math.max(sell,not_sell);
                    }

                }
            }
        }
         return dp[0][1][kn];
    }

}