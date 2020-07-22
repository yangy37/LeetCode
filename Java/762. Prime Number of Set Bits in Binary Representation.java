class Solution {
   public int countPrimeSetBits(int L, int R) {
        boolean [] primes = new boolean[]{false, false, true, true, false, true, false, true, false, false , false, true, false, true, false, false, false, true, false, true, false};
        int count = 0;
        for(int i = L; i <= R; i++) {
            if (primes[countBits(i)]) count++;
        }
        return count;
    }
    
    private int countBits(int n) {
        int count = 0;
        for(int i = n; i > 0; i >>= 1)
            count += i & 1;
        return count;
    }
}