class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int lines = 1;
        int letters = 0;

        for(char ch: S.toCharArray()) {
            int w = widths[ch - 'a'];
            if(letters + w > 100){
                letters = w;
                lines += 1;
            }else{
               letters +=  w; 
            }

        }
        return new int[]{lines,letters};
    }
}