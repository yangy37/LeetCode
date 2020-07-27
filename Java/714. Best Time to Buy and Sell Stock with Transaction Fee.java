class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n == 0) return 0;
        int dp_0 = 0;
        int dp_1 = -prices[0]-fee;
        for(int i=1;i<n;i++){
            dp_0 = Math.max(dp_0,dp_1+prices[i]);
            dp_1 = Math.max(dp_1,dp_0-prices[i]-fee);
        }
        return dp_0;
    }
}