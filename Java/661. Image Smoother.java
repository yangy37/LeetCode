class Solution {
    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int[][] result = new int[n][m];
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                int cellsCount = 0;
                int whiteCells = 0;
                
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int new_y = y + dy;
                        int new_x = x + dx;
                        
                        if (new_y < 0 || new_y >= n)
                            continue;
                        
                        if (new_x < 0 || new_x >= m)
                            continue;
                        
                        cellsCount++;
                        whiteCells += M[new_y][new_x];
                    }
                }
                
                result[y][x] = whiteCells / cellsCount;
            }
        }
        
        return result;
    }
}