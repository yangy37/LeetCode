class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        List<Integer> []al = new ArrayList[26];
        for(int i=0;i<26;i++){
            al[i] = new ArrayList();
        }
        for(int i=0;i<S.length();i++){
            al[S.charAt(i) - 'a'].add(i);
        }
first:    for(int i=0;i<words.length;i++){
            int key = 0;
            for(int j=0;j<words[i].length();j++){
                int ind = Collections.binarySearch(al[words[i].charAt(j) - 'a'], key);
                if(ind >= 0){
                    key ++;
                }else{
                    ind += 1;
                    ind *= -1;
                    if(ind >= al[words[i].charAt(j) - 'a'].size()){
                        continue first ;
                    }
                    key = al[words[i].charAt(j) - 'a'].get(ind) + 1;
                }
            }
            ans ++;
        }
        return ans;
    }
}