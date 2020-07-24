class Solution {
     public int[] dailyTemperatures(int[] T) {
        int[] dp = new int[T.length];
        dp[T.length - 1] = 0;
        
        for (int i = dp.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < dp.length && T[j] <= T[i]) {
                if (dp[j] == 0) break;
                j += dp[j];
            }
            if (T[j] > T[i]) dp[i] = j - i;
        }
        return dp;
    }
}