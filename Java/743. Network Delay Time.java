class Solution {
       public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] graph = new List[N+1];
        for(int i=1;i<=N;i++)
            graph[i]=new ArrayList<>();
        for(int[] time : times)
            graph[time[0]].add(new int[]{time[1],time[2]});
        return djikstra(graph,N,K);
    }
    public int djikstra(List<int[]>[] graph, int n, int k){
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        TreeSet<Integer> q = new TreeSet<>((a,b) -> dist[a]!=dist[b]?dist[a]-dist[b]:a-b);//Sotring indices instead of distance, also when distances are same we compare based on index, it allows more than one vertex to have same distance.
        for(int i=1;i<=n;i++)
            q.add(i);
        int res=0;
        while(!q.isEmpty()){
            int u = q.pollFirst();
            res=Math.max(res,dist[u]);
            for(int[] vertex : graph[u]){
                int v = vertex[0];
                int w = vertex[1];
                if(dist[v]>dist[u]+w){
                    q.remove(v);//removing and reinserting to ensure elements in treeset remain sorted
                    dist[v]=dist[u]+w;
                    q.add(v);
                }
            }

        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
