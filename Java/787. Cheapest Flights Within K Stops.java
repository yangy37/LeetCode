class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(flights==null || flights.length == 0) {
            return 0;
        }
        
        int[][] graph = new int[n][n];
        
        for(int i=0; i<flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            graph[source][dest] = flights[i][2];
        }
        
        int[][] dp = new int[n][K+2];
        
        int minCost = getMinCost(graph, src, dst, K+1, n, dp);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
    
    private int getMinCost(int[][] graph, int src, int dest, int k, int n, int[][] dp) {
        if(src == dest) {
            return 0;
        } else if(k==1 && graph[src][dest] != 0) {
            return graph[src][dest];
        } else if(k<=0) {
            return Integer.MAX_VALUE;
        }
        
        if(dp[src][k] !=0) {
            return dp[src][k];
        }
        
        int minRes = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(i!=src && graph[src][i] != 0) {
                int sub = getMinCost(graph, i, dest, k-1, n, dp);
                
                if(sub != Integer.MAX_VALUE) {
                    minRes = Math.min(minRes, sub + graph[src][i]);
                }
            }
        }
        
        dp[src][k] = minRes;
        return minRes;
    }
}