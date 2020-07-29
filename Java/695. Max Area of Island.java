class Solution {
    private int max;
    private int cnt;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        cnt = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    find(grid, i, j);
                    max = Math.max(max, cnt);
                    cnt = 0;
                }
            }
        }
        return max;
    }
    
    private int find(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) {
            return 0;
        }        
        cnt++;
        grid[x][y] = 0;
        return find(grid, x - 1, y) + find(grid, x + 1, y) + find(grid, x, y - 1) + find(grid, x, y + 1) + 1;
    }
}