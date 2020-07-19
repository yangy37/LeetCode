class Solution {
    int color[];
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0;i < n;i++) {
            if(color[i] == -1) {
                if(!dfs(graph, i, 0)) return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int[][] graph, int i, int c) {
        color[i] = c;
        
        for(int x : graph[i]) {
            if(color[x] == -1 && !dfs(graph, x, 1 - c)) return false;
            if(color[x] != 1 - c) return false;
        }
        return true;
    }
}
