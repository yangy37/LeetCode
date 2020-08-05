class Solution {
    public String predictPartyVictory(String senate) {
        // Greedy + Simulation
        char[] sen = senate.toCharArray();
        int count = 0;
        char cur = sen[0];
        while(true) {
            for(int i = 0; i < sen.length; i++) {
                if(sen[i] == '0') continue;
                if(cur == sen[i]) count ++;
                else {
                    count --;
                    if(count < 0) {
                        count = 1;
                        cur = sen[i];
                    } else {
                        sen[i] = '0';
                    }
                }
            }
            // check whether only R left or D left
            int r = 0, d = 0;
            for(int i = 0; i < sen.length; i ++) {
                if(sen[i] == 'R') r ++;
                if(sen[i] == 'D') d ++;
            }
            if(r == 0) return "Dire";
            else if(d == 0) return "Radiant";
        }
    }
}