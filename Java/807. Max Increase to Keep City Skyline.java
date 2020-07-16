class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] updown = new int[grid[0].length];
        int[] rl = new int[grid.length];
        for(int i = 0 ; i < grid.length; i++)
        {
            
            for ( int j =0 ; j< grid[0].length; j++){
                rl[i]=Math.max(rl[i],grid[i][j]);
                updown[j]=Math.max(updown[j],grid[i][j]);
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < grid.length; i++)
        {
            for ( int j =0 ; j< grid[0].length; j++){
                    cnt +=   Math.min(updown[j],rl[i]) - grid[i][j];   
            }
        }
        return cnt;
    }
}