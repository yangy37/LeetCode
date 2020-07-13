class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < S.length()) {
            int l = getRepeatedLen(S, i);
            if (l >= 3) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                cur.add(i + l - 1);
                res.add(cur);
            }
            i = i + l;
        }
        return res;        
    }
	
    private int getRepeatedLen(String s, int i) {
        int res = 1;
        i++;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                res++;
            } else {
                return res;
            }
            i++;
        }
        return res;
    }
}