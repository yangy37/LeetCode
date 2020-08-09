class Solution {
    public boolean canPlaceFlowers(int[] fs, int n) {
        int prev = -2, m = fs.length;  //assume we plant flowers at -2 index spot;
        for (int i = 0; i < m; i++) {
            if (fs[i] == 1) {
                n -= Math.max(0, (i - prev) / 2 - 1);
                prev = i;
            }
        }
        return n - Math.max(0, (m + 1 - prev) / 2 - 1) <= 0;  //assume we plant flowers at n + 1 index spot;
    }
}