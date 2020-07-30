class Solution {
    Map<String, Double> memo;
    int[][] directions = {{-2,1},{-2,-1},{-1,2},{1,2},{2,1},{2,-1},{-1,-2},{1,-2}};
    public double knightProbability(int N, int K, int r, int c) {
        memo = new HashMap<>();
        return knightProbabilityUtil(N, K, r, c);
    }
    
    public double knightProbabilityUtil(int N, int K, int row, int col){
        if(row < 0 || row >= N || col < 0 || col >= N){
            return 0;
        }        
        if(K == 0){
            return 1;
        }
        
        String key = row + "|" + col + "|" + K;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        double probability = 0;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];            
            probability += 0.125 * knightProbabilityUtil(N, K - 1, newRow, newCol);            
        }
        memo.put(key, probability);
        return probability;
    }
}