class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        boolean[] seen = new boolean[2001];
        boolean[] same = new boolean[2001];
        for(int i=0;i<fronts.length;i++) {
            seen[backs[i]] =true;
            seen[fronts[i]] = true;
            if(backs[i] == fronts[i]) {
				same[backs[i]]=true;
			}
        }
        for(int k=1;k<=2000; k++) {
            if(seen[k] && !same[k]) return k;
		}
        return 0;
    }
}