class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxZeros = 0;
        int firstZeros = -1;
        int lastZeros = -1;
        int i = 0;
        int l = seats.length;
        while (i < l) {
            if (seats[i] == 0) {
                int cur = getRepeatedZeros(seats, i);
                if (i == 0) {
                    firstZeros = cur;
                } else if (i + cur == l) {
                    lastZeros = cur;
                }
                maxZeros = Math.max(maxZeros, cur);
                i += cur;
            } else {
                i++;
            }
        }
        
        return Math.max(Math.max(firstZeros, lastZeros), maxZeros / 2 + maxZeros % 2);
    }
    
    private int getRepeatedZeros(int[] arr, int i) {
        int cnt = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                cnt++;
            } else {
                return cnt;
            }
            i++;
        }
        return cnt;
    }
}