class Solution {
    public int numJewelsInStones(String J, String S) {
        if(S==null||J==null) return 0;
        int[] arr = new int[58];
        for(int i=0;i<S.length();i++) {
            arr[S.charAt(i)-'A']++;
        }
        int res = 0;
        for(int i=0;i<J.length();i++) {
            res += arr[J.charAt(i)-'A'];
        }
        return res;
    }
}