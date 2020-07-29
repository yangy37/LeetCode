class Solution {
    public int countBinarySubstrings(String s) {
        int zero = 0;
        int one = 0;
        int ans = 0;
        for(int l = 0, r = 0; r < s.length(); r++) {
            int val = s.charAt(r) - '0';
            if(r > 0 && s.charAt(r - 1) - '0' != val && zero > 0 && one > 0) {
                ans += Math.min(one, zero);
                while(zero > 0 && one > 0) {
                    int preV = s.charAt(l++) - '0';
                    if(preV == 1)   one--;
                    else    zero --;
                }
            }
            if(val == 1)    one++;
            else    zero++;
        }
        return ans + Math.min(zero, one);
    }
}