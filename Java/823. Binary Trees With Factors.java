class Solution {
    private static final long MOD = (long) 1e9 + 7;
    
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        Map<Integer, Long> dp = new HashMap<>();

        long answer = 0;
        for (int num : A) {
            dfs(dp, A, num);
            answer = (answer + dp.get(num)) % MOD;
        }
        
        return (int) answer;
    }
    
    private long dfs(Map<Integer, Long> dp, int[] A, int cur) {
        if (cur < 0) {
            return 0;
        }
        
        if (cur == 1) {
            return 1;
        }
        
        if (dp.containsKey(cur)) {
            return dp.get(cur);
        }
        
        long answer = 0;
        for (int num : A) {
            if (cur % num == 0) {
                int quotient = cur / num;
                
                if (quotient == 1) {
                    answer = (answer + 1) % MOD;
                } else if (Arrays.binarySearch(A, quotient) >= 0) {
                    answer = (answer + dfs(dp, A, quotient) * dfs(dp, A, num)) % MOD;
                }
            }
        }
        
        dp.put(cur, answer);
        return answer;
    }
}