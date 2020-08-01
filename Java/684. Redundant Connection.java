class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length+1);
        for(int[] edge : edges) {
            boolean result = uf.union(edge[0], edge[1]);
            if(result) {
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[] {0, 0};
        
    }
    
    class UnionFind{
        
        int[] parent;
        
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0;i<parent.length;i++){
                parent[i] = i;
            }
        }
        
        public int find(int n){
            while(parent[n]!=n){
                n = parent[n];
            }
            return n;
        }
        
        public boolean union(int x, int y){
            x = find(x);
            y = find(y);
            if(x!=y){
                parent[x] = y;
                return false;
            }
            return true;
        }
        
    }
}