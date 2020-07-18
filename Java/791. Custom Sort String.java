class Solution {
    class Pair {
        char first;
        int second;
        Pair(char a, int i) {
            this.first = a;
            this.second = i;
        }
    }
    
    public String customSortString(String S, String T) {
        int rank[] = new int[26];
        Arrays.fill(rank, Integer.MAX_VALUE);
        int i = 0;
        for(char s : S.toCharArray()) {
            rank[s - 'a'] = i++;
        }
        
        
        Pair[] arrT = new Pair[T.length()];
        i = 0;
        for(char t : T.toCharArray()) {
            arrT[i++] = new Pair(t, rank[t - 'a']);
        }
        
        Arrays.sort(arrT, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.second - b.second;
            }
        });
        
        String ans = "";
        for(i=0; i<T.length(); i++) {
            ans += arrT[i].first;
        }
        return ans;
    }
}