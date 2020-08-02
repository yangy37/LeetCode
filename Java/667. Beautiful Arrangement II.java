class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i = 0; i < k + 1; ++i) {
            res[i] = (i % 2 == 0) ? i / 2 + 1 : k + 1 - (i - 1) / 2;
        }
        for(int i = k + 1; i < n; ++i) {
            res[i] = i + 1;
        }
        return res;    
    }
}