class Solution {
    public int maxProfit(int[] prices) {
        final int n = prices.length;
        final int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return usingSpaceOptimization(prices, n);
    }

    private int usingRecurssion(final int[] prices, final int n, final int idx, final boolean buy,
            final int transaction) {
        if (transaction == 0 || idx >= n) return 0;

        if (buy) {
            return Math.max(-prices[idx] + usingRecurssion(prices, n, idx + 1, false, transaction),
                            usingRecurssion(prices, n, idx + 1, true, transaction));
        } else {
            return Math.max(prices[idx] + usingRecurssion(prices, n, idx + 1, true, transaction - 1),
                            usingRecurssion(prices, n, idx + 1, false, transaction));
        }
    }

    private int usingMemorization(final int[] prices, final int n, final int idx, final int buy, final int transaction,
            final int[][][] dp) {
        if (transaction == 0 || idx >= n) return 0;

        if (dp[idx][buy][transaction] != -1) return dp[idx][buy][transaction];

        if (buy == 1) {
            dp[idx][buy][transaction] = Math.max(
                -prices[idx] + usingMemorization(prices, n, idx + 1, 0, transaction, dp),
                usingMemorization(prices, n, idx + 1, 1, transaction, dp));
        } else {
            dp[idx][buy][transaction] = Math.max(
                prices[idx] + usingMemorization(prices, n, idx + 1, 1, transaction - 1, dp),
                usingMemorization(prices, n, idx + 1, 0, transaction, dp));
        }

        return dp[idx][buy][transaction];
    }

    private int usingTabulation(final int[] prices, final int n) {
        final int[][][] dp = new int[n + 1][2][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int transaction = 1; transaction <= 2; transaction++) {
                    if (buy == 1) {
                        dp[idx][buy][transaction] = Math.max(
                            -prices[idx] + dp[idx + 1][0][transaction],
                            dp[idx + 1][1][transaction]);
                    } else {
                        dp[idx][buy][transaction] = Math.max(
                            prices[idx] + dp[idx + 1][1][transaction - 1],
                            dp[idx + 1][0][transaction]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    private int usingSpaceOptimization(final int[] prices, final int n) {
        int[][] prev = new int[2][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int transaction = 1; transaction <= 2; transaction++) {
                    if (buy == 1) {
                        curr[buy][transaction] = Math.max(
                            -prices[idx] + prev[0][transaction],
                            prev[1][transaction]);
                    } else {
                        curr[buy][transaction] = Math.max(
                            prices[idx] + prev[1][transaction - 1],
                            prev[0][transaction]);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][2];
    }

    // Optimized greedy-like approach
    private int maxProfit(final int[] prices, final int n) {
        int firstCost = prices[0];
        int secondCost = prices[0];

        int firstProfit = 0;
        int secondProfit = 0;

        for (int i = 0; i < n; i++) {
            int price = prices[i];
            firstCost = Math.min(firstCost, price);
            firstProfit = Math.max(firstProfit, price - firstCost);

            secondCost = Math.min(secondCost, price - firstProfit);
            secondProfit = Math.max(secondProfit, price - secondCost);
        }

        return secondProfit;
    }
}