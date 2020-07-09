class Solution {
    public String pushDominoes(String dom) {
        char[] c = dom.toCharArray();
        char[] s = dom.toCharArray();
        char prev = '.';
        int p = -1;
        for(int i = 0;i < s.length;i++){
            if(s[i] == '.') continue;
            int j = i - 1, k = p + 1;
            if(s[i] == 'L'){
                if(p == -1) while(j >= 0) c[j--] = 'L';
                else if(prev == 'L') while(j > p) c[j--] = 'L';
                else{
                    while(k < j){
                        c[k++] = 'R';
                        c[j--] = 'L';
                    }
                }
            }
            if(s[i] == 'R')
                if(prev == 'R') while(k < i) c[k++] = 'R';
            prev = s[i]; p = i;
        }
        if(prev == 'R') while(++p < c.length) c[p] = 'R';
        return new String(c);
    }
}