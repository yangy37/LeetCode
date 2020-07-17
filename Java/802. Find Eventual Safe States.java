class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 0 for unvisited (WHITE)
        // 1 for curently visiting children (GRAY)
        // 2 is visited (BLACK)
        int[] visited = new int[graph.length];
        ArrayList<Integer> allNodesWithNoLoops = new ArrayList<>();
        
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, visited))
                allNodesWithNoLoops.add(i);
                
        }
        
        return allNodesWithNoLoops;
    }
    
    private boolean dfs(int idx, int[][] graph, int[] visited) {
        if (visited[idx] > 0)
            return visited[idx] == 2;
        
        visited[idx] = 1;
        for (int child : graph[idx]) {
            if (visited[child] == 0) {
                if(!dfs(child, graph, visited))
                    return false;
            } else if (visited[child] == 1) {
                return false;
            }
        }
        visited[idx] = 2;
        return true;
    }
}