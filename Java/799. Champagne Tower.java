class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        float[] row = new float[1];
        row[0] = poured;
        for (int i = 0; i < query_row; i++) {
            float[] nextRow = new float[row.length + 1];
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 1) {
                    float overflow = (row[j] - 1) / 2;
                    nextRow[j] += overflow;
                    nextRow[j + 1] += overflow;
                }
            }
            row = nextRow;
        }
        
        return Math.min(1, row[query_glass]);
    }
}