class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grids = new int[N][N];
        for(int[] grid : grids){
            Arrays.fill(grid, 1);
        }
        
        for(int[] mine : mines){
            grids[mine[0]][mine[1]] = 0;
        }
        
        int max = 0;
        for(int i = 0; i < grids.length; i++){
            for(int j = 0; j < grids[i].length; j++){
                if(grids[i][j] == 1){
                    int localMax = ((i == 0 || j == 0 || i == grids.length - 1 || j == grids[i].length - 1) ? 1 : checkLargestPlusSignUtility(grids, i, j));
                    max = Math.max(max, localMax);
                }
            }
        }
        return max;
    }
    
    public int checkLargestPlusSignUtility(int[][] grids, int i, int j){
        int left = 0, right = 0, up = 0, down = 0;        
        //moving down
        int row = i + 1;
        while(row < grids.length && grids[row++][j] != 0){
            down++;
        }        
        //moving up
        row = i - 1;
        while(row >= 0 && grids[row--][j] != 0){
            up++;
        }        
        //moving right
        int col = j + 1;
        while(col < grids[i].length && grids[i][col++] != 0){
            right++;
        }       
        //moving left
        col = j - 1;
        while(col >= 0 && grids[i][col--] != 0){
            left++;
        }
        
        return Math.min(down, Math.min(up, Math.min(left, right))) + 1;
    }               
}