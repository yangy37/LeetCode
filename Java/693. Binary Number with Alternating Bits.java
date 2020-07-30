class Solution {
     public boolean hasAlternatingBits(int n) {
        int copy = n;
        boolean lastBitIs1 = (copy % 2) == 1; // if odd number last bit must be 1
        while (copy > 0) {
            copy >>= 1;
            int currBit = copy & 1;
            if (currBit == 1 && lastBitIs1) return false; // if curr bit is 1 and last bit is 1, return false
            else if (currBit == 0 && !lastBitIs1) return false; // if curr bit is 0 and list bit was 0, return false
            lastBitIs1 = !lastBitIs1; // checks passed, invert the last bit
        }
        return true;
    }
}