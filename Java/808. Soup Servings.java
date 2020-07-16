class Solution {
     public double soupServings(int N) {
        int q = (N + 24) / 25;
        
        if (q >= 480) {
            return 1;
        }
        
        double[][]dp = new double[q + 1][q + 1];
        dp[q][q] = 1;
        
        for(int i = q; i > 0; i--) {
            for (int j = q; j > 0; j--) {
                dp[Math.max(i - 4, 0)][j] += 0.25 * dp[i][j];
                dp[Math.max(i - 3, 0)][Math.max(j - 1, 0)] += 0.25 * dp[i][j];
                dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] += 0.25 * dp[i][j];
                dp[Math.max(i - 1, 0)][Math.max(j - 3, 0)] += 0.25 * dp[i][j];
            }
        }
        
        double ans = 0;
        
        for(int i = 1; i <= q; i++) {
            ans += dp[0][i];
        }
        
        return ans + 0.5 * dp[0][0];
    }
}