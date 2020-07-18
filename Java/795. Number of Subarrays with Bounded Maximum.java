class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int[] dp = new int[A.length];
        dp[0] = (A[0] <= R && A[0] >= L) ? 1 : 0;
        int atom = A[0] < L ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            int t = A[i];
            if (t < L) {
                dp[i] = dp[i - 1];
                atom++;
            } else if (t <= R) {
                dp[i] = dp[i - 1] + 1 + atom;
                atom = 0;
            } else
                atom = 0;
        }
        int ans = 0;
        for (int t : dp) {
            ans += t;
        }
        return ans;
    }
}