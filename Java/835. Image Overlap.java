class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int maxOverlap = 0;
        Set<Point> set = new HashSet<>();
        for(int i = -N+1; i < N; i++){
            for(int j = -N+1; j < N; j++){
                int count = 0;
                for(int x = 0; x < N; x++){
                    for(int y=0; y < N; y++){
                        int dx = x + i;
                        int dy = y + j;
                        if(dx < N && dx >= 0 && dy < N && dy >= 0  && B[dx][dy] + A[x][y] == 2) {
                            count++;
                        }
                        
                    }
                }
                
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        
        return maxOverlap;
    }
}