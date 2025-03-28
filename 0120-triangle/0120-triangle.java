class Solution {
    public int helper(int[][] dp, List<List<Integer>> tri, int i, int j, int m) {
        if (i >= m || j > i) return 0;
        if (i == m - 1) return tri.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];

        int left = helper(dp, tri, i + 1, j, m);
        int right = helper(dp, tri, i + 1, j + 1, m);

        dp[i][j] = tri.get(i).get(j) + Math.min(left, right);
        return dp[i][j];
    }

    public int minimumTotal(List<List<Integer>> tri) {
        int m = tri.size();
        int[][] dp = new int[m][m];

     
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(dp, tri, 0, 0, m);
    }
}