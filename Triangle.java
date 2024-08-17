class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
          int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Initialize the dp table with the values of the last row
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }
        
        // Fill the dp table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        // The top element contains the minimum path sum
        return dp[0][0];
    }
}
