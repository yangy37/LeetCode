class Solution{
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a1,a2) -> a1[0]-a2[0]);
        
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        int max = 1;
        
        for(int j = 1 ; j < pairs.length ; j++)
        {
            for(int i = 0 ; i < j ; i++)
            {
                if(pairs[i][1] < pairs[j][0])
                {
                    dp[j] = Math.max(dp[j],dp[i]+1);
                    max = Math.max(max,dp[j]);
                }
            }
        }
        return max;
    }
}