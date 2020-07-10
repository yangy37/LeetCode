class Solution {
    int count=0;
    public int numMagicSquaresInside(int[][] grid) {
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                if(check(i,j,grid))count++;
            }
        }return count;
        
    }
    private boolean check(int i, int j, int[][] grid) {
        int[] temp = new int[10];
         for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (grid[k][l] < 1 || grid[k][l] > 9 || temp[grid[k][l]] > 0) {
                    return false;
                }
                temp[grid[k][l]] = 1;
            }
        }
        return grid[i][j]+grid[i+1][j]+grid[i+2][j]==15 &&
                grid[i][j]+grid[i][j+1]+grid[i][j+2]==15 &&
                grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]==15 &&
                grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]==15 &&
                grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]==15 &&
                grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]==15 &&
                grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]==15 &&
                grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j]==15;
    }
}
