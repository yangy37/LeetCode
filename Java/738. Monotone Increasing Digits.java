class Solution {
   public int monotoneIncreasingDigits(int N) {
        int res = 0;
        int digit = 0;
        int max = 9;

        while(N > 0)
        {
            int cur = N % 10;
            N /= 10;
            if(cur <= max)
            {
                res += cur * Math.pow(10, digit);
                max = cur;
            }
            else
            {
                res = (int)(cur * Math.pow(10, digit) - 1);
                max = cur - 1;
            }
            digit++;
        }

        return res;
    }
}